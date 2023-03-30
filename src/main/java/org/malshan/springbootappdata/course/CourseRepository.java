package org.malshan.springbootappdata.course;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

// An interface which holds the methods to handle the CRUD operations
// Somewhat of a data service like TopicService class
// CrudRepository already has a general methods necessary to handle CRUD operations
// Here, you only need to enter custom methods
public interface CourseRepository extends CrudRepository<Course, String> {

    // TODO: This is somewhat of a magic. Learn more.
    public List<Course> findByTopicId(String topicId);
}
