package basic.taobao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class getCityByIp {

	public static void main(String[] args) {

		System.out.println(getIpArea("183.62.35.197"));
	}

//		String cityName = "";
//		HttpClient client = HttpClientBuilder.create().build();
//		HttpGet request = new HttpGet("http://ip.taobao.com/service/getIpInfo.php?ip=122.224.234.13");// 创建httpGet
////		request.addHeader("Content-Type", "application/x-www-form-urlencoded");
////		request.addHeader("Cache-Control", "no-cache");
////		request.addHeader("Postman-Token", "3c8c8994-9453-416b-8b8e-1818309631d9");
//		try {
//			HttpResponse response = client.execute(request);
//			int statusCode = response.getStatusLine().getStatusCode();
//			if (statusCode == HttpStatus.SC_OK) {
//				String strResult = EntityUtils.toString(response.getEntity());
//				try {
//					JSONObject jsonResult = JSON.parseObject(strResult);
//					System.out.println(JSON.toJSONString(jsonResult, true));
//					JSONObject dataJson = jsonResult.getJSONObject("data");
//					cityName = dataJson.getString("city");
//					System.out.println(JSON.toJSONString(jsonResult, true));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}

//		CloseableHttpClient httpClient = HttpClients.createDefault();
//		CloseableHttpResponse response = null;
//		InputStream is = null;
//
//		try {
//			HttpGet httpGet = null;
//
//			List<NameValuePair> params = new ArrayList<NameValuePair>();
//			NameValuePair pair = new BasicNameValuePair("ip", "117.136.42.86");
//			params.add(pair);
//			String str = EntityUtils.toString(new UrlEncodedFormEntity(params, "UTF-8"));
//			httpGet = new HttpGet("http://ip.taobao.com/service/getIpInfo.php" + "?" + str);
//			httpGet.addHeader("Content-Type", "text/html;charset=UTF-8");
//			httpGet.addHeader("Date", "Wed, 17 Oct 2018 08:26:54 GMT");
//			httpGet.addHeader("Transfer-Encoding", "chunked");
//			httpGet.addHeader("Vary", "Accept-Encoding");
//			httpGet.addHeader("Connection", "keep-alive");
//			httpGet.addHeader("Content-Encoding", "gzip");
//
//			response = httpClient.execute(httpGet);
//			HttpEntity entity = response.getEntity();
//			String result = EntityUtils.toString(entity);
//			System.out.println(result);
////		return result;
//		} catch (Exception e) {
//			e.printStackTrace();
////		throw new HjException(ResultCode.HTTP_EXCEPTION);
//		} finally {
//			if (is != null) {
//				try {
//					is.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if (response != null) {
//				try {
//					response.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if (httpClient != null) {
//				try {
//					httpClient.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}

	public static String getIpArea(String ip) {
		String path = "http://ip.taobao.com/service/getIpInfo.php?ip=" + ip;
		String inputline = "";
		String info = "";
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(10 * 1000);
			conn.setRequestMethod("GET");
			InputStreamReader inStream = new InputStreamReader(conn.getInputStream(), "UTF-8");
			BufferedReader buffer = new BufferedReader(inStream);
			while ((inputline = buffer.readLine()) != null) {
				info += inputline;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return info;
	}

}
