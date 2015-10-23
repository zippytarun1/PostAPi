package MockServerService.PostApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;


public class FeatureMapAPI {



     
	public String postapiadapter(String apiurl,String postdata) {
		String returnhttpheader=null;
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(apiurl);
		//	postRequest.addHeader("accept", "application/json");
			postRequest.addHeader("authToken","snapdealpushenginea995e2f9-6cba-46e7-8b08-a7ffb67ca95d20150416163318");
			postRequest.addHeader("system_name","snapdealpushengine");
			//postRequest.addHeader("Accept-Encoding","gzip");
			StringEntity input = new StringEntity(postdata);
			input.setContentType("application/json");
			postRequest.setEntity(input);
			HttpResponse response = httpClient.execute(postRequest);
			returnhttpheader=response.toString();
			
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String output;
			int lastIndex = apiurl.lastIndexOf("/");
			int prevIndex = apiurl.lastIndexOf("/", lastIndex - 1);
			String laststringa = apiurl.substring(prevIndex + 1, lastIndex).trim();
			
			while ((output = br.readLine()) != null) {
			  
				Saveobject s1 = new Saveobject();
				s1.saveobjecttofile(output, laststringa);

			}
		
			httpClient.getConnectionManager().shutdown();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnhttpheader;

	}

}