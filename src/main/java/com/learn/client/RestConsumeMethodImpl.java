package com.learn.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class RestConsumeMethodImpl {
	public static void apiCall(int i){
		try {
		// create HTTP Client
		RequestConfig.Builder requestBuilder = RequestConfig.custom();
	//	requestBuilder.setConnectTimeout(2000);
	//	requestBuilder.setConnectionRequestTimeout(2000);
	//	requestBuilder.setSocketTimeout(2000);     // default value could be infinite even in case of browser .. time is in milli second

		HttpClientBuilder builder = HttpClientBuilder.create();     
		builder.setDefaultRequestConfig(requestBuilder.build());
		HttpClient httpClient = builder.build();
	
     // Create new getRequest with below mentioned URL
       // System.out.println("create url");
       //HttpGet getRequest = new HttpGet("http://localhost:8080/munsiji-service/rest/myapp/holdreqthread");
       //HttpGet getRequest = new HttpGet("http://localhost:8080/munsiji-service/rest/myapp/holdreqthreadinfite");
	   // HttpGet getRequest = new HttpGet("http://localhost:8080/AsysnchServletApi/myservlet");
		HttpGet getRequest = new HttpGet("http://localhost:8080/AsysnchServletApi/myasyncservlet");
	
    // Add additional header to getRequest which accepts application/xml data
       getRequest.addHeader("accept", "application/xml");
       
    // Execute your request and catch response
       //System.out.println("making api call");
       HttpResponse response = httpClient.execute(getRequest);
       System.out.println("print response object:"+response);
	// Check for HTTP response code: 200 = success
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}
 
			// Get-Capture Complete application/xml body response
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		String output;
		System.out.println("============Output:============");
 
			// Simply iterate through XML response and show on console.
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
	  } catch (Exception e) {
		e.printStackTrace();
	  }
	}

}
