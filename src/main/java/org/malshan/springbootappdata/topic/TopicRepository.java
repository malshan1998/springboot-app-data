package org.malshan.springbootappdata.topic;

import org.springframework.data.repository.CrudRepository;

// An interface which holds the methods to handle the CRUD operations
// Somewhat of a data service like TopicService class
// CrudRepository already has a general methods necessary to handle CRUD operations
// Here, you only need to enter custom methods
public interface TopicRepository extends CrudRepository<Topic, String> {
}
