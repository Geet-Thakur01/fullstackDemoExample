package com.custom_web_app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.custom_web_app.models.Topic;

@RestController
public class TopicsController {

	@Autowired
	private TopicService topicservices;
	
	
	@RequestMapping("/")
	public String gohome() {
		return "welcome home";
	}
//	get all entities 
	@RequestMapping("/topics")
	public List<Topic> getTopics() {
		return topicservices.getAllTopics();
	}
//	get entity by ID 
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicservices.getTopic(id);
	}
//	add new entry
	@RequestMapping(value= "/topics",method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		topicservices.addTopic(topic);
	}
	
//	for change or update value
		@RequestMapping(value="/topics/{id}",method=RequestMethod.PUT)
	public void putTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicservices.updateTopic(topic,id);
	}
		
//		for delete the existing 
		@RequestMapping(value="topics/{id}",method=RequestMethod.DELETE)
		public void deleteTopic(@PathVariable String id) {
			topicservices.deleteTopic(id);
		}
	
}

