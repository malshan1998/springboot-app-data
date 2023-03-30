package org.malshan.springbootappdata.course;

import org.malshan.springbootappdata.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired      // Declaring the dependency of CourseService class
    private CourseService courseService;
    @RequestMapping("/topics/{Id}/courses")
    public List<Course> getAllCourses(@PathVariable String Id) {
        return courseService.getAllCourses(Id);
    }

    @RequestMapping("/topics/{topicId}/courses/{Id}")
    public Course getCourse(@PathVariable String Id){
        return courseService.getCourse(Id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{Id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String Id, @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{Id}")
    public void deleteCourse(@PathVariable String Id) {
        courseService.deleteCourse(Id);
    }
}
