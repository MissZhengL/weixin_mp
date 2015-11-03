package cn.hofan.ols.system.contract;

import cn.hofan.weixin.contract.ISendallService;

import com.bj58.spat.gaea.client.GaeaInit;
import com.bj58.spat.gaea.client.proxy.builder.ProxyFactory;

import org.junit.Test;

public class WeiXinTest {

	final String url = "tcp://weixin/ISendallService";
//	final String url1 = "tcp://weixin/IAccessTokenService";
	static {
		GaeaInit.init("src/test/resources/gaea.config");
	}
	private ISendallService service = ProxyFactory.create(ISendallService.class, url);
//	private IAccessTokenService service1 = ProxyFactory.create(IAccessTokenService.class, url1);

	@Test
	public void sendallservicetest() throws Exception{
		boolean sendallByGroup = service.sendallByGroup(101);
		if (sendallByGroup) {
			System.out.println("success");
		}else {
			System.out.println("failed");
		}
	}
//	@Test
//	public void getaccesstokentest() throws Exception{
//		boolean result = service1.requestAccessTokenFromTecent();
//		if (result) {
//			System.out.println("success");
//		}else {
//			System.out.println("failed");
//		}
//	}


}
