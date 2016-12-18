import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class CreateUser {
	
	
	
	public void createUser() throws ClientProtocolException, IOException{
		
		RefreshToken token = new RefreshToken();
		String accessToken ="Bearer " + token.refresh();
		System.out.println(accessToken);
		
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("https://api.box.com/2.0/users");
		post.addHeader("Content-Type", "application/json");
		post.addHeader("Authorization", accessToken);
		
		JSONObject json = new JSONObject();
		json.put("login", "Rob9@gmail.com");
		json.put("name", "Tony Stark");
		
		System.out.println("JSON: "+json.toString());
		
		HttpEntity entity = new ByteArrayEntity(json.toString().getBytes());
		post.setEntity(entity);
        
        
        HttpResponse response = client.execute(post);
        
        //print body:
        System.out.println("Post entity: "+EntityUtils.toString(response.getEntity()) );
        //print response code:
        System.out.println("Responce code: " + response.getStatusLine().getStatusCode() );
		
		
	}
	
	

}
