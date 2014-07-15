package com.stz.aws.beanstalk.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

/**
 * @author rbortoloto
 *
 */
@Configuration
public class SpringConfig {

	/**
	 * @return
	 * @throws Exception
	 */
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		//MongoClient mongoClient = new MongoClient();
		
		return new SimpleMongoDbFactory(new MongoClient(), "hellodb");
	}

	/**
	 * @return
	 * @throws Exception
	 */
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {

		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

		return mongoTemplate;

	}

}
