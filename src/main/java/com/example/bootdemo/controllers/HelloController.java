package com.example.bootdemo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	@Autowired PersonRepository repo;
	
	@RequestMapping("/find")
	public List<Person> findAll(){
		return (List<Person>) repo.findAll();
		//(List<Person>) repo.findAll()
		
	}
	
	@RequestMapping("/find/{id}")
	public Person findOne(@PathVariable long id){		
		return repo.findOne(id);
		//(List<Person>) repo.findAll()		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/insert")
	public List<Person> insert(@RequestBody Person person){		
		repo.save(person);
		return (List<Person>) repo.findAll();
		//(List<Person>) repo.findAll()		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
	public List<Person> update(@RequestBody Person person, @PathVariable long id){
		Person dbPerson = repo.findOne(id);
		dbPerson.setFirstName(person.getFirstName());
		dbPerson.setLastName(person.getLastName());
		
		repo.save(dbPerson);
		return (List<Person>) repo.findAll();
		//(List<Person>) repo.findAll()		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public List<Person> delete(@PathVariable long id){
		repo.delete(id);
		return (List<Person>) repo.findAll();
		//(List<Person>) repo.findAll()		
	}
	
	
	
}
