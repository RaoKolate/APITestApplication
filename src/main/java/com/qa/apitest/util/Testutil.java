package com.qa.apitest.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class Testutil
{ 
	public JSONObject responsejson;
	public String getValueByJpath(String Jpath)
	{
		Object obj = responsejson;
		for(String s: Jpath.split("/"))
		{
			if(!s.isEmpty())
			{
				if(!(s.contains("{")|| s.contains("}")))
				{
					obj =((JSONObject) obj).get(s);
					
				}
				else if((s.contains("{")|| s.contains("}")))
						{
						}
				
			}
		
		}
		return obj.toString();
	
		
	}

}
