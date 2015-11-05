package com.cdel.rest.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cdel.rest.web.dao.PersonMapper;
import com.cdel.rest.web.entity.Person;
import com.cdel.rest.web.service.PersonService;

@Service
public class PersonServiceimpl implements PersonService {
	
	private PersonMapper personMapper;

	@Override
	public Person get(Integer id) {
		return personMapper.get(id);
	}

	@Override
	public List<Person> getAll() {
		return personMapper.getAll();
	}

	public PersonMapper getPersonMapper() {
		return personMapper;
	}

	@Resource
	public void setPersonMapper(PersonMapper personMapper) {
		this.personMapper = personMapper;
	}
	
}
