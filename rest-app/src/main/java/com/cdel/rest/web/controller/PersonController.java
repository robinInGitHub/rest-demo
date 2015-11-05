package com.cdel.rest.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdel.rest.web.entity.Person;
import com.cdel.rest.web.service.PersonService;
import com.cdel.rest.web.util.JersyClient;
import com.cdel.rest.web.util.RunningTime;

/**
 * @ClassName: PersonController
 * @Description: TODO(人员管理控制类)
 * @author yangzhenping
 * @date 2015年11月3日 下午4:24:31
 *
 */ 
@Controller
@RequestMapping("/person")
public class PersonController {

	Logger logger = Logger.getLogger(PersonController.class);
	
	@Autowired
	private Person person;
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String addView(Model model){
		return "add";
	}
	
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String updateView(Integer id, Model model){
		Person person = personService.get(id);
		model.addAttribute("person", person);
		return "update";
	}
	
	@RequestMapping(value = "/{id}.do", method = RequestMethod.GET)
	public String getPerson(@PathVariable Integer id, Model model){
		Person person = personService.get(id);
		model.addAttribute("person", person);
		return "person";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)	
	public String getAll(Model model){
		RunningTime runningTime = new RunningTime();
		JersyClient client = new JersyClient();
		List<Person> persons = new ArrayList<Person>();
		persons = (List<Person>)client.getList("persons/json", null, null, null).get("data");
		model.addAttribute("persons", persons);
		logger.info("Running Time:" + runningTime.getTime());
		return "list";
	}
	
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String add(String name, Integer age, Model model){
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		JersyClient client = new JersyClient();
		client.savePerson("persons", person, null, null);
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String update(Person person, Model model){
		if(person != null){
			JersyClient client = new JersyClient();
			client.updatePerson("persons", person, null, null);
		}
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String delete(Integer id, Model model){
		JersyClient client = new JersyClient();
		client.deletePerson("persons", id, null, null);
		return "redirect:list.do";
	}
}
