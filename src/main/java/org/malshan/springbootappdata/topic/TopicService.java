package org.malshan.springbootappdata.topic;

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
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic(),    // TODO: Must handle the situation where there's a null object
            new Topic("1", "Spring Framework 1", "Spring Framework Description 1"),
            new Topic("2", "Spring Framework 2", "Spring Framework Description 2"),
            new Topic("3", "Spring Framework 3", "Spring Framework Description 3")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String Id) {
        Topic topic = topics.stream().filter(t -> t.getId().equals(Id)).findFirst().get();
        return topic;
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String Id) {
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId().equals(Id)) {
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String Id) {
        topics.removeIf(t -> t.getId().equals(Id));
    }
}
