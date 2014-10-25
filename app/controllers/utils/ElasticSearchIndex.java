package controllers.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class ElasticSearchIndex {

	public ElasticSearchIndex(){
	
	}
	
	public String curl(String curlStr) {
		StringBuffer response=new StringBuffer();
		try
		{
			Process p = Runtime.getRuntime().exec("curl " + curlStr);
			p.waitFor();	

			BufferedReader stdInput = new BufferedReader(new
					InputStreamReader(p.getInputStream()));

			
			String s = null; 
			
			while ((s = stdInput.readLine()) != null) {
				response.append(s);
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return response.toString();
	}
	
	public String post(String url, String data){
		StringBuffer response=new StringBuffer();

		 try {

			   
			    URL obj = new URL(url);
			    HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

			    conn.setRequestProperty("Content-Type", "application/json");
			    conn.setDoOutput(true);

			    conn.setRequestMethod("PUT");

			    OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
			    out.write(data);
			    out.close();
			    
			    } catch (Exception e) {
			    e.printStackTrace();
			    }
		return response.toString();
	}
}
