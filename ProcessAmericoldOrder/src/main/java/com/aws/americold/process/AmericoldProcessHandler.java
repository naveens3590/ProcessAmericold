/**
* Class to process the americold data and format the string to a writable format
*
* @author Naveen Kumar
*/
package com.aws.americold.process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class AmericoldProcessHandler implements RequestHandler<Object, Object> { 
	

	public Object handleRequest(Object input, Context context) {
		System.out.println("AmericoldProcessHandler process data Start..."+input.toString());
		//String dataToprocess = input.toString().replaceAll("\\\\", "");
		List<String> americoldStringLst = new ArrayList<String>();
		if (null!=input.toString()) {
			String[] processString=input.toString().split("},");
			americoldStringLst=Arrays.asList(processString);
		}
		
		for (String string : americoldStringLst) {
			System.out.println(string.trim().replace("{", "").replace("}", "").replace("[", "").replace("]", ""));
			
		}
        System.out.println("AmericoldProcessHandler process data End..."+americoldStringLst);
		return americoldStringLst;
	}
}
