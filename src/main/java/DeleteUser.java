import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;

public class DeleteUser {
	
	public void delete() throws JSONException, ParseException, IOException {
		
		RefreshToken token = new RefreshToken();
		String accessToken ="Bearer " + token.refresh();
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpDelete delete = new HttpDelete("https://api.box.com/2.0/users/480544805");
		
		delete.addHeader("Content-Type", "application/json");
		delete.addHeader("Authorization", accessToken);
		
		HttpResponse response = client.execute(delete);
		   //print body and response code:
		  // System.out.println("Get entity: "+ EntityUtils.toString(response.getEntity()) );
		   System.out.println("Response Code : "+ response.getStatusLine().getStatusCode());
	}

}
