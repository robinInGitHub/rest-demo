package com.cdel.rest.dao.write;

import com.cdel.rest.entity.Person;

public interface PersonMapper {
	
	public void save(Person person);
	
	public void delete(Integer id);
	
	public void update(Person person);
	
}
