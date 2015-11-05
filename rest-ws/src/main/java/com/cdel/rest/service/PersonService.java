package com.cdel.rest.service;

import java.util.List;

import com.cdel.rest.entity.Person;

public interface PersonService {
	
	public Person get(Integer id);

	public List<Person> getAll();

	public void create(Person person);

	public void update(Person person);

	public void delete(Integer id);
}
