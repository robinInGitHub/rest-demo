package com.cdel.rest.dao.read;

import java.util.List;

import com.cdel.rest.entity.Person;

public interface PersonReadMapper {
	
	public Person get(Integer id);
	
	public List<Person> getAll();
}
