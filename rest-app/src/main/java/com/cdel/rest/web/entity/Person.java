package com.cdel.rest.web.entity;

import org.springframework.stereotype.Component;

/**
 * @ClassName: Person
 * @Description: TODO(entity person as database person)
 * @author yangzhenping
 * @date 2015年11月2日 下午7:45:32
 *
 */
@Component
public class Person {
	
	private Integer id;
	
	private String name;
	
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
