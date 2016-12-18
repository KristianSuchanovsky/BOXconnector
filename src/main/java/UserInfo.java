import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;

public class UserInfo {
	
	
	
	public void getInfo() throws JSONException, ParseException, IOException{
		
		RefreshToken token = new RefreshToken();
		String accessToken ="Bearer " + token.refresh();
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet("https://api.box.com/2.0/users?filter_term=Stannis");
		
		 //add headers:
		  get.addHeader("Content-Type", "application/json");
		  get.addHeader("Authorization", accessToken);
		  
		  try {
		   //create response:
		   HttpResponse response = client.execute(get);
		   //print body and response code:
		   System.out.println("Get entity: "+ EntityUtils.toString(response.getEntity()) );
		   System.out.println("Response Code : "+ response.getStatusLine().getStatusCode());
		  
		  
		  } catch (ClientProtocolException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
	}

}
