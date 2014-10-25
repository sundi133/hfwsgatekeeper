package controllers.utils;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ElasticFetcher {

	public String response(String url, String name) {

		ElasticSearchIndex esi = new ElasticSearchIndex();
		String response = esi.curl(url);
		System.out.println("name " + name);
		Gson gson = new GsonBuilder().create();
		SearchHits sre = gson.fromJson(response, SearchHits.class);
		List<String> srlist = new ArrayList<String>();
		for (int i = 0; i < sre.hits.hits.length; i++) {
			//System.out.println(sre.hits.hits[i]._source.name);
			if(sre.hits.hits[i]._source.name.toLowerCase().contains(name.toLowerCase())){
				srlist.add(sre.hits.hits[i]._source.name+", "+ sre.hits.hits[i]._source.district+", "+ sre.hits.hits[i]._source.state +", " + sre.hits.hits[i]._source.pin);	
			}
		}
		Gson gsonresp = new Gson();
		System.out.println(gsonresp.toJson(srlist));
		return gsonresp.toJson(srlist);
	}

}
