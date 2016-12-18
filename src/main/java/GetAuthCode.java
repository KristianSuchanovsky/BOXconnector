import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jose4j.json.internal.json_simple.JSONObject;

public class GetAuthCode {
	private final static String URL = "https://account.box.com/api/oauth2/authorize?response_type=code&client_id=4ig3tzk76msrvvvpradguxsxuz7lsuhr&redirect_uri=http://127.0.0.1&state=hocico2";
	
	public static void get() throws IOException{
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(URL);
		
		HttpResponse response = client.execute(get);
		 // print body and response code:
		   System.out.println("Get entity: "+ EntityUtils.toString(response.getEntity()) );
		   System.out.println("Response Code : "+ response.getStatusLine().getStatusCode());
		   
		 // curl https://api.box.com/oauth2/token -d 'grant_type=authorization_code&code=GadSHggM4Aa5hwxu6ZONouHSP1ZTcgau&client_secret=L9SzKgeLU28jFzmmhYEAabqxEWTmcDT4' -X POST
		//  curl https://api.box.com/oauth2/token -d 'grant_type=authorization_code&code=WS6gK0gosZm0bAHErIhIhRn9uf1N9XVK&client_id=4ig3tzk76msrvvvpradguxsxuz7lsuhr&client_secret=L9SzKgeLU28jFzmmhYEAabqxEWTmcDT4' -X POST

		
	}

}
