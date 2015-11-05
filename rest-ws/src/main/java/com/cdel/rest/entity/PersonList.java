package com.cdel.rest.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "persons")
public class PersonList {
	
	private List<Person> persons;
	
	public PersonList() {}
	
	public PersonList(List<Person> persons) {
        this.persons = persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @XmlElement(name = "person")
    public List<Person> getPersons() {
        return this.persons;
    }
}
