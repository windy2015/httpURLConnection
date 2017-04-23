package httpConnection;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/***
 * 利用jdk自带的HttpConnection发送http请求给服务器
 * @author landingbj
 *
 */
public class HttpURLConnectionTest {	

	public static void main(String[] args) throws Exception {
		
		String urlPath = "http://localhost:8080/httpConnection/http";
		
		String param = "param="+URLEncoder.encode("测试","UTF-8");
		System.out.println(param);
		
		URL url = new URL(urlPath);
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setUseCaches(false);
		conn.setRequestMethod("POST");
		
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Connection", "Keep-Alive");// 保持长连接
		conn.setRequestProperty("Charset", "UTF-8");
		
		conn.connect();
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		dos.writeBytes(param);
		
		dos.flush();
		dos.close();
		
		//��ȡhttp ״̬��
		int rescode = conn.getResponseCode();
		
		if(HttpURLConnection.HTTP_OK == rescode){
			StringBuffer sb = new StringBuffer();
			String line  = new String();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while((line = br.readLine())!=null){
				sb.append(line).append("\n");
			}
			System.out.println("response is"+sb.toString());
			br.close();
		}
		
	}

}
