package com.cdel.rest.web.dao;

import java.util.List;

import com.cdel.rest.web.entity.Person;


public interface PersonMapper {

	public Person get(Integer id);
	
	public List<Person> getAll();
}
