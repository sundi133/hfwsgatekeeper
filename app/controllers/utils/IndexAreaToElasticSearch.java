package controllers.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

public class IndexAreaToElasticSearch {

	public static void main(String[] args) throws IOException {

		Document doc = Jsoup.connect("http://www.mapsofindia.com/pincode/india/karnataka/bangalore/").get();
		ElasticSearchIndex esi = new ElasticSearchIndex();
		
		for (Element table : doc.select("table[class=extrtable]")) {
			 for (Element row : table.select("tr:gt(2)")) {
		    	Elements tds = row.select("td:not([rowspan])");
		        System.out.println(tds.get(0).text() + "," + tds.get(1).text());
		        Location loc = new Location(
		        		tds.get(0).text().replace(" ", "%2f"),
		        		tds.get(1).text(), 
		        		tds.get(2).text(), 
		        		tds.get(3).text()
		        		);
		        Gson gson = new Gson();
		        String locJson = gson.toJson(loc);
		        System.out.println("locJson " + locJson);
		        //curl -XPOST https://ihscrydx:lujdwgoxxdpc03p7@spruce-7122461.us-east-1.bonsai.io/acme-production/test/hello -d '{"title":"Hello world"}'
		        //curl -XGET 'https://ihscrydx:lujdwgoxxdpc03p7@spruce-7122461.us-east-1.bonsai.io/places/_search?q=_type:bangal*&size=2'
		        
		        StringBuffer curl = new StringBuffer();
		        curl.append("https://ihscrydx:lujdwgoxxdpc03p7@spruce-7122461.us-east-1.bonsai.io/");
		        curl.append("places");
		        curl.append("/");
		        curl.append("bangalore");
		      
		        String jsonDoc = " -d  '" + locJson +"'";
		        
		        System.out.println("curl " + curl.toString());
		        System.out.println("curl response " + esi.post(curl.toString(),jsonDoc));
			 }
		}
		
	}

}
