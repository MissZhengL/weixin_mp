package cn.hofan.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class ProxyLocator {
	private static Map<Class<?>, Object> beanCache = new ConcurrentHashMap<Class<?>, Object>();
	
	/**
	 * 根据接口获得service对象
	 * @param <T>
	 * @param clazz service接口
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T get(Class<T> clazz) {
		Object o = beanCache.get(clazz);
		if(o != null){
			return (T)o;
		}
		synchronized (beanCache) {
			o = beanCache.get(clazz);
			if(o != null){
				return (T)o;
			}
			try {
				if(clazz.isInterface()){
					@SuppressWarnings("rawtypes")
					List<Class> classList = getAllClassByInterface(clazz);
					if(classList != null){
						if(classList.size() == 1){
							Object obj = classList.get(0).newInstance();
//							AOPInvocationHandler handler = new AOPInvocationHandler();
//							o = handler.bind(obj);
							o = obj;
							beanCache.put(clazz, o);
						}else if(classList.size() > 1){
							Class<?> cls1 = classList.get(0);
							for(int i=1; i<classList.size(); i++){
								Class<?> clsi = classList.get(i);
								if(!((cls1.getName()).equals(clsi.getName()))){
									throw new Exception("interface has more classes....");
								}
							}
							Object obj = cls1.newInstance();
//							AOPInvocationHandler handler = new AOPInvocationHandler();
//							o = handler.bind(obj);
							o = obj;
							beanCache.put(clazz, o);
						}else{
							throw new Exception("interface has more classes. size:"+classList.size());
						}
					}else{
						throw new Exception("interface is not class.");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return (T)o;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static List<Class> getAllClassByInterface(Class c) {

		// 给一个接口，返回这个接口的所有实现类
		List<Class> returnClassList = new ArrayList<Class>();// 返回结果
		// 如果不是�??个接口，则不做处�??
		if (c.isInterface()) {
			String packageName = c.getPackage().getName();// 获得当前包名
			try {
				List<Class> allClass = getClasses(packageName);// 获得当前包下以及包下的所有类
				for (int i = 0; i < allClass.size(); i++) {
					if (c.isAssignableFrom(allClass.get(i))) {// 判断是不是一个接�??
						if (!c.equals(allClass.get(i))) {// 本身加不进去
							returnClassList.add(allClass.get(i));

						}
					}
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return returnClassList;

	}

	// 从一个包中查找出�??有类,在jar包中不能查找
	@SuppressWarnings("rawtypes")
	private static List<Class> getClasses(String packageName)
			throws IOException, ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class> classes = new ArrayList<Class>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return classes;
	}

	@SuppressWarnings("rawtypes")
	private static List<Class> findClasses(File directory, String packageName)
			throws ClassNotFoundException {
		List<Class> classes = new ArrayList<Class>();
		if (!directory.exists()) {
			return findClassesInJar(directory.getPath(),packageName);
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file,
						packageName + '.' + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				classes.add(Class.forName(packageName
						+ "."
						+ file.getName().substring(0,
								file.getName().length() - 6)));
			}
		}
		return classes;
	}
	
	@SuppressWarnings("rawtypes")
	private static List<Class> findClassesInJar(String file, String packageName) throws ClassNotFoundException{
		List<Class> classes = new ArrayList<Class>();
		file = file.replace("%20", " "); 
		String jarFile = "";
		jarFile = file.substring(file.indexOf(":"+File.separator)+1,file.lastIndexOf("!"));
		List<JarEntry> list = null;
		try { 
			list = Collections.list(new JarFile(jarFile).entries());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		List<String> fullNames = new ArrayList<String>();
		for (JarEntry e : list) {
			String n = e.getName();
			if (n.startsWith(packageName.replace('.', '/'))&&n.endsWith(".class")) {
				n = n.substring(0, n.length() - 6);
				fullNames.add(n.replace('/', '.'));
			}
		}
		int classCount = fullNames.size();
		String[] classNames = fullNames.toArray(new String[classCount]);
		for(String className : classNames){
			classes.add(Class.forName(className));
		}
		return classes;
	}

}
