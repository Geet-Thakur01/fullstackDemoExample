package com.custom_web_app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.custom_web_app.models.Topic;

@Service
public class TopicService {

//	static initialization of list component 
	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("101", "topic_one", "ratings 4 star"),
			new Topic("102", "topic_two", "ratings 5 star"), new Topic("103", "topic_three", "ratings 3 star"),
			new Topic("104", "topic_four", "ratings 1 star"), new Topic("105", "topic_five", "ratings 4 star")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		int itemcount = 0;
		for (Topic item : topics) {
			if (item.getId().equals(id)) {
				topics.set(itemcount, topic);
			}
			itemcount++;
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t-> t.getId().equals(id));		
	}
}
