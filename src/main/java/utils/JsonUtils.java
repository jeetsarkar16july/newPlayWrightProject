package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	public static String convertToJson(Object obj) {
	        try {	     
	        	ObjectMapper objectMapper = new ObjectMapper();
	            return objectMapper.writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to convert object to JSON", e);
	        }
	    }
	 
	 
	 public static <T> T convertJsonToObject(String json, Class<T> clazz) {
	        try {
	        	ObjectMapper objectMapper = new ObjectMapper();
	            return objectMapper.readValue(json, clazz);
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to convert JSON to object", e);
	        }
	    }
	 

}
