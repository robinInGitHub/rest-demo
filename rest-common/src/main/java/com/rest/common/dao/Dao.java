package com.rest.common.dao;

import java.util.List;

import com.rest.common.entity.Entity;

public interface Dao<T extends Entity, I>
{

	List<T> findAll();


	T find(I id);


	T save(T newsEntry);


	void delete(I id);

}