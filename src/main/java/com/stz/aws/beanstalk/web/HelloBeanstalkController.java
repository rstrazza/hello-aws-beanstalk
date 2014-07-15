package com.stz.aws.beanstalk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author rbortoloto
 *
 */
@Controller
@RequestMapping("/")
public class HelloBeanstalkController {

	@Autowired
	@Qualifier(value = "mongoTemplate")
	private MongoOperations mongoOperations;
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", mongoOperations.findAll(User.class));

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";
	}

	/**
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
	public String welcomeUser(@PathVariable String name, ModelMap model) {

		// query to search user
		Query searchUserQuery = new Query(Criteria.where("userName").is(name));
	 	
		User user = mongoOperations.findOne(searchUserQuery, User.class);
		if (user == null) {
			user = new User(name);
			mongoOperations.save(user);
		}
		
		model.addAttribute("message", user);
		return "index";
	}
	
}
