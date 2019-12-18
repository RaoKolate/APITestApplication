package com.qa.apitest.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.apitest.base.BaseTest;
import com.qa.apitest.client.RestClient;
import com.qa.apitest.util.Testutil;

public class GetAPITest extends BaseTest
{
	BaseTest basetest ;
	String Serviceurl;
	String apiurl;
	String url;
	RestClient restclient;
	CloseableHttpResponse closeablehttpresponse;
	Testutil testutil;
	
	@BeforeMethod
	public void setup() 
	{
		 basetest = new BaseTest();
		 Serviceurl = prop.getProperty("URL");
		 apiurl = prop.getProperty("serviceurl");
		
		 url =Serviceurl+apiurl ;
		
	
	}
	
	@Test
	public void getAPITest() throws ClientProtocolException, IOException
	{
		restclient = new RestClient();
		closeablehttpresponse =restclient.GETCall(url);
		
		
		// status code 
		 int statuscode = closeablehttpresponse.getStatusLine().getStatusCode();
		//getStatusCode() returns int values so will store into int .
		 System.out.println("Status code ==>  "+statuscode);
		 //put assestions 
		 
		 Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200,"status code is not 200");
		 //200 i am not expected harcoded .
		 
		 //response body
		 
		  // to get response body have - EntityUtils class and provide toString() method .
		 // it accept 2 para , 1 is - pass entity which present in closeableResponse & 2  is the default char set .
		String resposeString = EntityUtils.toString(closeablehttpresponse.getEntity(),"UTF-8");
		// defaultCharset is the any standard default char set 
		 // now toSring() return one string - store into resposeString - so it will retuns complete string but we need 
		// output in the form of JSON .
		//resposeString convert into JSON object using - class like -JSONObject
		
		JSONObject responsejson = new JSONObject(resposeString);
		System.out.println("Response JSON ==> "+responsejson);
		String s= testutil.getValueByJpath("per_page");
		System.out.println(s);
					
		// Header
		// getAllHeaders returns all headers and store into Header Array .
		Header[] httpheader =closeablehttpresponse.getAllHeaders();	
		// headers are in the form of key --> values pair so we can use HashMap.
		
		HashMap<String,String> allheaders  = new HashMap<String,String>();
			// iterate array and store into array .
		
		for(Header header :httpheader)
		{
			allheaders.put(header.getName(), header.getValue());
		}
		System.out.println("Header's are ==> "+allheaders);
		
		
	}
}
