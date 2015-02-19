package de.goeuro.internship.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import de.goeuro.internship.model.Location;

public class LocationFinder {

	private static String ENDPOINT = "http://api.goeuro.com/api/v2/position/suggest/en/";

	public LocationFinder() {
	}

	public List<Location> findLocations(String input) {
		StringBuilder sb = new StringBuilder(ENDPOINT).append(input);
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(sb.toString());
		try {
			HttpResponse response = client.execute(httpGet);
			String entityResponse = getStringResponse(response);
			if(entityResponse.isEmpty())
				return new ArrayList<Location>();
			else{
				Gson gson = new Gson();
				return gson.fromJson(entityResponse, new TypeToken<ArrayList<Location>>(){}.getType());
			}
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<Location>();
		}

	}

	public String getStringResponse(HttpResponse response)
			throws IllegalStateException, IOException {
		InputStream inputStream = response.getEntity().getContent();
		BufferedReader streamReader = new BufferedReader(new InputStreamReader(
				inputStream));
		String content = "", line = null;
		while (null != (line = streamReader.readLine()))
			content += line;
		return content;
	}

}
