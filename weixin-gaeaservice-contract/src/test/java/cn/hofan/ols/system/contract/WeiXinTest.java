package cn.hofan.ols.system.contract;

import cn.hofan.weixin.contract.ISendallService;

import com.bj58.spat.gaea.client.GaeaInit;
import com.bj58.spat.gaea.client.proxy.builder.ProxyFactory;

import org.junit.Test;

public class WeiXinTest {

	final String url = "tcp://weixin/ISendallService";
	static {
		GaeaInit.init("src/test/resources/gaea.config");
	}
	private ISendallService service = ProxyFactory
			.create(ISendallService.class, url);

	@Test
	public void sendallservicetest() throws Exception{
		boolean sendallByGroup = service.sendallByGroup(2);
		if (sendallByGroup) {
			System.out.println("success");
		}else {
			System.out.println("failed");
		}
	}


}
