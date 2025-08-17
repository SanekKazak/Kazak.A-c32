package org.spring.rest.repository;

import org.spring.rest.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
}
