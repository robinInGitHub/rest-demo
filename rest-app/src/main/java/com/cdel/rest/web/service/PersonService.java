package com.cdel.rest.web.service;

import java.util.List;

import com.cdel.rest.web.entity.Person;

public interface PersonService {
	public Person get(Integer id);

	public List<Person> getAll();
}
