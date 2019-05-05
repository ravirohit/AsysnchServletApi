package com.learn.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
// requestBuilder.setSocketTimeout(timeout); too. Please note that timeout should be milliseconds!
public class MultipleRestAPICall {
    static int a =0;
	public static void main(String[] args) {
		
	ExecutorService es = Executors.newFixedThreadPool(300);
	
	for(int i = 0;i < 100; i++){
		es.execute(() -> {
			RestConsumeMethodImpl.apiCall(a);
		});
	}
	es.shutdown();
		
	}
	
	
}
