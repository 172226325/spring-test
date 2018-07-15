package com.lesson.spring.web.support;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

/**
 * created by pwy on 2018/7/8
 */
public class MockServerStandalone {

    public static void main(String[] args) {

        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8080)); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();
        // Do some stuff
        //WireMock.reset();
        // Finish doing stuff
        //wireMockServer.stop();



    }


}
