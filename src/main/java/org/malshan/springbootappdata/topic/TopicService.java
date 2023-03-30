package org.malshan.springbootappdata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Business Service class
// This is a Singleton (??) : A design pattern !
// In Singleton, there's only one instance of this class, and a global point of access is provided to the class.
// Spring creates an instance of this class, and it stores it in the memory.

@Service    // Stereotype annotation as a Service class
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        // Adds all items found, into the topics list.
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String Id) {
        return topicRepository.findOne(Id);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String Id) {
        topicRepository.save(topic);
        // 'save' works as both add and update.
        // We're sending a Topic instance, which already has the Id information.
        // So, if the Id doesn't exist, it adds. If it does, it updates.
    }

    public void deleteTopic(String Id) {
        topicRepository.delete(Id);
    }
}
