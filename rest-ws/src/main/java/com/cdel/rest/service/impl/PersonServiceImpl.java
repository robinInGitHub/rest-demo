package com.cdel.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdel.rest.dao.read.PersonReadMapper;
import com.cdel.rest.dao.write.PersonMapper;
import com.cdel.rest.entity.Person;
import com.cdel.rest.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonReadMapper personReadMapper;
	@Autowired
	private PersonMapper personMapper;
	
	@Override
	public Person get(Integer id) {
		return personReadMapper.get(id);
	}

	@Override
	public List<Person> getAll() {
		return personReadMapper.getAll();
	}

	@Override
	public void create(Person person) {
		personMapper.save(person);
	}

	@Override
	public void update(Person person) {
		personMapper.update(person);
	}

	@Override
	public void delete(Integer id) {
		personMapper.delete(id);
	}

}
