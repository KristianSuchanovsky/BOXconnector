import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateUser {
	
	public void update() throws JSONException, ParseException, IOException{
		
		RefreshToken token = new RefreshToken();
		String accessToken ="Bearer " + token.refresh();
		System.out.println(accessToken);
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPut put = new HttpPut("https://api.box.com/2.0/users/480629562");
		put.addHeader("Content-Type", "application/json");
		put.addHeader("Authorization", accessToken);
		
		JSONObject json = new JSONObject();
		json.put("name", "HODOR HODOR");
		
		System.out.println("JSON: "+json.toString());
		
		HttpEntity entity = new ByteArrayEntity(json.toString().getBytes());
		
		put.setEntity(entity);
		
		HttpResponse response = client.execute(put);
		
		 System.out.println("Post entity: "+EntityUtils.toString(response.getEntity()) );
	        //print response code:
	     System.out.println("Responce code: " + response.getStatusLine().getStatusCode() );
		
		
	}

}
