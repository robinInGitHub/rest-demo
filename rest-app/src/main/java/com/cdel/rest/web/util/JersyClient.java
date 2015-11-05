package com.cdel.rest.web.util;

import java.io.ByteArrayInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONObject;

import com.cdel.rest.web.entity.Person;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * @ClassName: JersyClient
 * @Description: TODO(Jersey Client Encapsulation)
 * @author yangzhenping
 * @date 2015年11月4日 下午1:38:23
 *
 */ 
public class JersyClient {

	Logger logger = Logger.getLogger(JersyClient.class);
	
	private static String URI = "http://192.168.190.195:8083/resources/";
	
	private static Client client = Client.create();

	public void testHelloService() throws URISyntaxException {  
	      
	    URI u = new URI(URI);  
	    System.out.println(u);  
	    WebResource resource = client.resource(u);  
	    //get  
	    String result = resource.get(String.class);  
	    System.out.println(result);  
	      
	    //get param  
	    u = new URI("http://houfeng:8080/jerseyWebServiceTest/services/hello/sex");  
	    System.out.println(u);  
	    resource = client.resource(u);  
	    MultivaluedMapImpl params = new MultivaluedMapImpl();  
	    params.add("name", "houfeng");  
	    result = resource.queryParams(params).get(String.class);  
	    System.out.println(result);  
	      
	    u =new URI("http://houfeng:8080/jerseyWebServiceTest/services/hello/test_get");  
	    System.out.println(u);  
	    resource = client.resource(u);  
	    params = new MultivaluedMapImpl();  
	    params.add("name", "houfeng");  
	    result = resource.queryParams(params).get(String.class);  
	    System.out.println(result);  
	      
	    u =new URI("http://houfeng:8080/jerseyWebServiceTest/services/hello/test_get2");  
	    System.out.println(u);  
	    resource = client.resource(u);  
	    params = new MultivaluedMapImpl();  
	    params.add("name", "houfeng");  
	    result = resource.queryParams(params).get(String.class);  
	    System.out.println(result);  
	  
	      
	    u =new URI("http://houfeng:8080/jerseyWebServiceTest/services/hello/test_post1");  
	    System.out.println(u);  
	    resource = client.resource(u);  
	    params = new MultivaluedMapImpl();  
	    params.add("name", "houfeng");  
	    result = resource.type(MediaType.APPLICATION_FORM_URLENCODED).post(String.class,params);  
	    System.out.println(result);  
	      
	    u =new URI("http://houfeng:8080/jerseyWebServiceTest/services/hello/test_post2");  
	    System.out.println(u);  
	    resource = client.resource(u);  
	    params = new MultivaluedMapImpl();  
	    params.add("name", "houfeng");  
	    result = resource.queryParams(params).type(MediaType.APPLICATION_FORM_URLENCODED).post(String.class);  
	    System.out.println(result);  
	      
	    u =new URI("http://houfeng:8080/jerseyWebServiceTest/services/hello/test_post3");  
	    System.out.println(u);  
	    resource = client.resource(u);   
	    result = resource.entity("hello").post(String.class);  
	    System.out.println(result);  
	      
	    u =new URI("http://houfeng:8080/jerseyWebServiceTest/services/hello/test_post4");  
	    System.out.println(u);  
	    resource = client.resource(u);   
	    String buf = "inputstream content.";  
	    ByteArrayInputStream bais = new ByteArrayInputStream(buf.getBytes());  
	    result = resource.entity(bais).post(String.class);  
	    System.out.println(result);  
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getList(String uri, Map<String, Object> params, String version, String token){
		ObjectMapper mapper = new ObjectMapper();
		List<Person> persons = new ArrayList<Person>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		URI serverUri;
		try {
			serverUri = new URI(URI + uri);
			logger.info("URI=" + serverUri);
		    WebResource resource = client.resource(serverUri);  
		    //get  
		    String result = resource.get(String.class);  
		    logger.info("result=" + result);
		    JSONObject jsonObject = new JSONObject(result);
		    //resolve error code
		    String code = "success";
		    if(!jsonObject.has("code")){
		    	code = "E00001";
		    }else {
		    	code = (String)jsonObject.get("code");
			}		    
		    if("".equals(code)){
		    	code = "E10001";
		    }
		    //resolve object
		    persons = mapper.readValue(jsonObject.getString("person"), List.class);
		    
		    resultMap.put("code", code);
		    resultMap.put("data", persons);
		} catch (Exception e) {
			logger.error("Jersey Client Get List Error", e);
		}  
		return resultMap;
	}
	
	public void savePerson(String uri, Person person, String version, String token){
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		URI serverUri;
		try {
			serverUri = new URI(URI + uri);
			logger.info("URI=" + serverUri);
			WebResource resource = client.resource(serverUri);
			String params = mapper.writeValueAsString(person);
			logger.info("params=" + params);
		    //post
		    String result = resource.type(MediaType.APPLICATION_JSON).post(String.class, params.toString());
		    logger.info("result=" + result);
		    JSONObject jsonObject = new JSONObject(result);
		    //resolve error code
		    String code = "success";
		    if(!jsonObject.has("code")){
		    	code = "E00001";
		    }else {
		    	code = (String)jsonObject.get("code");
			}		    
		    if("".equals(code)){
		    	code = "E20001";
		    }
		    resultMap.put("code", code);
		} catch (Exception e) {
			logger.error("Jersey Client Get List Error", e);
		}
	}
}
