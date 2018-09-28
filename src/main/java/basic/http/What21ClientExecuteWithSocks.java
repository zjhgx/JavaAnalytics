/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 * 
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package basic.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
 
public class What21ClientExecuteWithSocks {
 
    public static void main(String[] args) throws Exception {
        // ConnectionSocketFactory注册
        Registry<ConnectionSocketFactory> reg = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("http", new MyConnectionSocketFactory()).register("https", new MySSLConnectionSocketFactory(SSLContexts.createSystemDefault())).build();
        // HTTP客户端连接管理池
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(reg);
        CloseableHttpClient httpclient = HttpClients.custom()
                    .setConnectionManager(connManager)
                    .build();
        try {
            // socks代理地址
            InetSocketAddress socksaddr = new InetSocketAddress("127.0.0.1", 1080);
            HttpClientContext context = HttpClientContext.create();
            context.setAttribute("socks.address", socksaddr);
             
            // 请求目标
//            HttpHost target = new HttpHost("www.google.com", 80, "https");
//            HttpGet request = new HttpGet("/");
            System.out.println("----------------------------------------");
//            System.out.println("执行请求 ：" + request.getRequestLine());
//            System.out.println("通过代理： " + socksaddr);
//            System.out.println("执行目录： " + target);
//            System.out.println("----------------------------------------");
            HttpGet httpget = new HttpGet("https://graph.accountkit.com/v1.3/me/?access_token=EMAWfQVSUiR01GzZBjvpri0mFYF1iCNjroOV2kOaNVhFGIkkBKCJFsLczDbhXWnZCiqZA5XC6sglHu8XsEK5Hvbk4NXwwwUznj8QA2pHMtwZDZD&appsecret_proof=0967a174c035d7740c2e911f26c9f68e406880535f693072d9900c98d54209e2");
//            CloseableHttpResponse response = httpclient.execute(target, request, context);
            CloseableHttpResponse response = httpclient.execute(httpget, context);
            try {
                HttpEntity entity = response.getEntity();
                System.out.println("----------------------------------------");
                System.out.println("返回响应：" + response.getStatusLine());
                System.out.println("响应内容：" + EntityUtils.toString(entity));
                System.out.println("----------------------------------------");
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
 
    static class MyConnectionSocketFactory implements ConnectionSocketFactory {
 
        @Override
        public Socket createSocket(final HttpContext context) throws IOException {
            InetSocketAddress socksaddr = (InetSocketAddress) context.getAttribute("socks.address");
            // socket代理
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, socksaddr);
            return new Socket(proxy);
        }
 
        @Override
        public Socket connectSocket(
                final int connectTimeout,
                final Socket socket,
                final HttpHost host,
                final InetSocketAddress remoteAddress,
                final InetSocketAddress localAddress,
                final HttpContext context) throws IOException, ConnectTimeoutException {
            Socket sock;
            if (socket != null) {
                sock = socket;
            } else {
                sock = createSocket(context);
            }
            if (localAddress != null) {
                sock.bind(localAddress);
            }
            try {
                sock.connect(remoteAddress, connectTimeout);
            } catch (SocketTimeoutException ex) {
                throw new ConnectTimeoutException(ex, host, remoteAddress.getAddress());
            }
            return sock;
        }
 
    }
    
    static class MySSLConnectionSocketFactory extends SSLConnectionSocketFactory {
    	 
        public MySSLConnectionSocketFactory(final SSLContext sslContext) {
         
            super(sslContext, ALLOW_ALL_HOSTNAME_VERIFIER);
        }
 
        @Override
        public Socket createSocket(final HttpContext context) throws IOException {
            InetSocketAddress socksaddr = (InetSocketAddress) context.getAttribute("socks.address");
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, socksaddr);
            return new Socket(proxy);
        }
 
        @Override
        public Socket connectSocket(int connectTimeout, Socket socket, HttpHost host, InetSocketAddress remoteAddress,
                                    InetSocketAddress localAddress, HttpContext context) throws IOException {
            // Convert address to unresolved
            InetSocketAddress unresolvedRemote = InetSocketAddress
                    .createUnresolved(host.getHostName(), remoteAddress.getPort());
            return super.connectSocket(connectTimeout, socket, host, unresolvedRemote, localAddress, context);
        }
    }    
 
}