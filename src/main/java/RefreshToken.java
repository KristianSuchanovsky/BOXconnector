
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



import org.apache.http.HttpResponse;
import org.apache.http.ParseException;

import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import org.apache.http.util.EntityUtils;

import org.json.JSONObject;



import org.json.JSONException;

public class RefreshToken {
	
	private String refreshToken = "p5YtV6pCUjBv339SWingXuNofH3gRV6wqJeMBY8nZGDfRN8qa1aLz4EhhzGfsEbr";
	private static final String clientID = "4ig3tzk76msrvvvpradguxsxuz7lsuhr";
	private static final String clientSecret = "L9SzKgeLU28jFzmmhYEAabqxEWTmcDT4";
	private static final String grantType = "refresh_token";
	private String accessToken = "";
	
	public String refresh() throws JSONException, ParseException, IOException {
		
		
		File newFile = new File("/home/kristian/Dokumenty/Praca/connector-box/Token");	
		if(!newFile.exists()){
			newFile.createNewFile();
		}
		
		
		FileReader file = new FileReader("/home/kristian/Dokumenty/Praca/connector-box/Token");
		BufferedReader reader = new BufferedReader(file);
		
		
		String fileRefreshToken = "";
		String line = reader.readLine();
		while (line != null){
			fileRefreshToken += line;
			line = reader.readLine();
		}
		reader.close();
		
		System.out.println(fileRefreshToken);
		
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("https://api.box.com/oauth2/token");
		post.addHeader("Content-Type", "application/json");
		StringBuilder sb = new StringBuilder();
		
		if (newFile.exists() && !fileRefreshToken.isEmpty()){
			
		sb.append("grant_type").append('=').append(grantType)
	      .append('&').append("refresh_token").append('=').append(fileRefreshToken)
	      .append('&').append("client_id").append('=').append(clientID)
	      .append('&').append("client_secret").append('=').append(clientSecret);
		}
		else {
			
			sb.append("grant_type").append('=').append(grantType)
		      .append('&').append("refresh_token").append('=').append(refreshToken)
		      .append('&').append("client_id").append('=').append(clientID)
		      .append('&').append("client_secret").append('=').append(clientSecret);
		}
			
	      
		post.setEntity(new StringEntity(sb.toString()));
        HttpResponse response = client.execute(post);
        
        try{
        JSONObject json = new JSONObject(EntityUtils.toString(response.getEntity()));
        refreshToken = (String) json.get("refresh_token");
        accessToken = (String) json.get("access_token");
        
        try{FileWriter fileW = new FileWriter(newFile);
			BufferedWriter buffW = new BufferedWriter(fileW);
			buffW.write((String) json.get("refresh_token"));
			buffW.close();
			System.out.println("File written");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
	
		
        System.out.println(refreshToken);
        System.out.println(accessToken);
        
       }catch (IOException e){
    	 throw new IOException("something is wrong");  
       }
		return accessToken;
       
	
	}
	
	}
