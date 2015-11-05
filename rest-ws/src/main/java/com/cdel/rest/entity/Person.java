package com.cdel.rest.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @ClassName: Person
 * @Description: TODO(entity person as database person)
 * @author yangzhenping
 * @date 2015年11月2日 下午7:45:32
 *
 */
@XmlRootElement(name="person")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="person", propOrder = { "id", "name", "age" })
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
