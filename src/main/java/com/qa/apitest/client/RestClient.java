package com.qa.apitest.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


public class RestClient 
{
	// GET Method - it accept string arg like url .
	public CloseableHttpResponse GETCall(String url) throws ClientProtocolException, IOException 
	{ // first we need to create default client with help if HttpClient class and 
		//it return one closeableHttpsClient class object & CloseableHttpClient is abstract class.
	CloseableHttpClient closeablehttpclient	=HttpClients.createDefault();
	
	//we have another class HttpGET class
	
	  HttpGet httpget = new HttpGet(url);
	 CloseableHttpResponse closeablehttpresponse = closeablehttpclient.execute(httpget); // clicking on send button 
	 //like or hit the URL .
	//so closeablehttpresponse have there all response like state code , response body and Headers 
         return closeablehttpresponse;
	}
}
