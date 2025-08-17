package org.spring.rest.service;

import org.spring.rest.entity.Course;
import org.spring.rest.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> all(){
        return courseRepository.findAll();
    }
    public Course byId(UUID id) {
        return courseRepository.findById(id).get();
    }
    public Course delete(UUID id){
        Course course = byId(id);
        courseRepository.deleteById(id);
        return course;
    }
    public Course update(Course newCourseData, UUID id) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setName(newCourseData.getName());
                    course.setLifecycle(newCourseData.getLifecycle());
                    course.setCost(newCourseData.getCost());
                    course.setIsActive(newCourseData.getIsActive());
                    return courseRepository.save(course);
                })
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }
    public Course create(Course course){
        return courseRepository.save(course);
    }
}
