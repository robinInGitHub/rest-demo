package com.cdel.rest.resource;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdel.rest.entity.Person;
import com.cdel.rest.entity.PersonList;
import com.cdel.rest.service.PersonService;

/**
 * @ClassName: PersonResource
 * @Description: TODO(define URI)
 * @author yangzhenping
 * @date 2015年11月2日 下午8:02:09
 *
 */ 
@Path("/persons")
@Component
public class PersonResource {
	
	Logger logger = Logger.getLogger(PersonResource.class);
	@Autowired
	PersonService personService;
	
	@GET
	@Path("/xml")
	@Produces("application/xml")
	public PersonList getPersonsXml(){
		return new PersonList(personService.getAll());
	}
	
	@GET
	@Path("/json")
	@Produces("application/json")
	public PersonList getPersonsJson(){
		return new PersonList(personService.getAll());
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public void createPerson(Person person){
		try {
			personService.create(person);
		} catch (Exception e) {
			logger.error("Params Error", e);
		}
		System.out.println("yang");
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public void updatePerson(Person person){
		personService.update(person);
	}
	
	@DELETE
	@Produces("application/json")
	public void deletePerson(Integer id){
		personService.delete(id);
	}
}
