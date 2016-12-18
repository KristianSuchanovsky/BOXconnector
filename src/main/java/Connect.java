import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jose4j.json.internal.json_simple.JSONObject;


public class Connect {
	
	private static final String DEVELOPER_TOKEN = "";
	
	
	
	
	public static void connect() throws ClientProtocolException, IOException {
		
		HttpClient client = HttpClientBuilder.create().build();
		
		
		
		HttpPost post = new HttpPost("https://account.box.com/api/oauth2/authorize");
		
		post.addHeader("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		json.put("response_type", "code");
		json.put("client_id", "4ig3tzk76msrvvvpradguxsxuz7lsuhr");
		json.put("redirect_uri", "http://127.0.0.1:17603");
		json.put("state", "KR1ST1AND3V3LOPER");
		json.put("box_login", "ksuchanovsky@gmail.com");
		
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
