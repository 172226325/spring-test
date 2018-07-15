/**
 * 
 */
package com.lesson.spring.web.support;


import com.github.tomakehurst.wiremock.client.WireMock;

/**
 * @author zhailiang
 *
 */
public class MockServer {
	
	public static void main(String[] args) {

        // Do some stuff
        WireMock.configureFor("127.0.0.1", 8080);  // 配置standalone的ip和端口，表示在该服务端模拟请求
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/book"))  //设置该服务端的请求路径
                .willReturn(WireMock.okJson("{\"name\":\"tom\"}")));  //设置该服务端在接收到请求路径为/book的请求时，返回的响应状态（okJson就是状态码200），以及返回的json字符串
		
		
	}

}
