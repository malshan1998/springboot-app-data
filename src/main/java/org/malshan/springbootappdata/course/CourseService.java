package org.malshan.springbootappdata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jta.atomikos.AtomikosProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Business Service class
// This is a Singleton (??) : A design pattern !
// In Singleton, there's only one instance of this class, and a global point of access is provided to the class.
// Spring creates an instance of this class, and it stores it in the memory.

@Service    // Stereotype annotation as a Service class
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        // Adds all items found, into the courses list.
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);
        return courses;
    }

    public Course getCourse(String Id) {
        return courseRepository.findOne(Id);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
        // 'save' works as both add and update.
        // We're sending a Course instance, which already has the Id information.
        // So, if the Id doesn't exist, it adds. If it does, it updates.
    }

    public void deleteCourse(String Id) {
        courseRepository.delete(Id);
    }
}
