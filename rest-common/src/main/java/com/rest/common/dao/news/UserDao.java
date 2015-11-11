package com.rest.common.dao.news;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.rest.common.dao.Dao;
import com.rest.common.entity.User;

public interface UserDao extends Dao<User, Long>, UserDetailsService
{

	User findByName(String name);

}