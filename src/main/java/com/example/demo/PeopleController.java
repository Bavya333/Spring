package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.mongodb.MongoWriteException;

@RestController
@RequestMapping("/people")
public class PeopleController {
	@Autowired
	MongoTemplate mongoOps;
	
	@RequestMapping(value = "/addperson", method = RequestMethod.GET)
	public String addPerson() {
		try {
			Person aperson = new Person(3, "Simon", 25);
			mongoOps.insert(aperson);
			return aperson.getName() + " added";
		}
		catch(MongoWriteException ex){
			return ex.getMessage();
		}
	}
	
	@RequestMapping(value = "/updateperson", method = RequestMethod.GET)
	public String updatePerson() {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(1));
			Update update = new Update();
			update.set("name", "Simon");
			update.set("age", 35);
			mongoOps.findAndModify(query, update, Person.class);
			return " modifided";
		}
		catch(MongoWriteException ex){
			return ex.getMessage();
		}
	}
	
	
	
}