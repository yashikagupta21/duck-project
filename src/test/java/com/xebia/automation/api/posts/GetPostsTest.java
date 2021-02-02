package com.xebia.automation.api.posts;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xebia.automation.api.pojo.Posts;

public class GetPostsTest {
	/*
	 * Create the client object similar to opening postman, you cannot see
	 * launching postman, it happens internally,- headless
	 */

	HttpClient httpClient = HttpClientBuilder.create().build();

	@Test
	public void getPostsTest() throws ClientProtocolException, IOException {

		// create the request here it's GET since we are retrieving
		HttpGet getRequest = new HttpGet("https://jsonplaceholder.typicode.com/posts/58");

		//  setting the content type, here we are setting to json format
		getRequest.addHeader("accept", "application/json");

		// Execute the request and get the response, same as send which gives
				// response and we are storing the response
				HttpResponse response = httpClient.execute(getRequest);
				
				// get the status code from response
				int statuscode = response.getStatusLine().getStatusCode();
				System.out.println("Status code is  " + statuscode);
				
				// Validate the status
				Assert.assertTrue(statuscode == 200, "Posts retrival failed");
				
				// Parse the response and validate
				String responseContent = EntityUtils.toString(response.getEntity());
				System.out.println("Response content is " +responseContent);
				
				//Create the Object mapper 
				ObjectMapper objectMapper = new ObjectMapper();
				
				// Load the resource/pojo with the values
				Posts posts = objectMapper.readValue(responseContent, Posts.class);
				System.out.println("Id is: "+posts.getId());
				System.out.println("user id is: "+posts.getUserId());
				System.out.println("Title is: "+posts.getTitle());
				System.out.println("actual post is: "+posts.getBody());
				Assert.assertTrue(posts.getId()==58, "Id is not matching");
				Assert.assertTrue(posts.getUserId()==6, "User Id Mismatch");
			
				
					
	}
}
