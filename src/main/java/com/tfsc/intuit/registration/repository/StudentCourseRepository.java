package com.tfsc.intuit.registration.repository;

import com.tfsc.intuit.registration.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by sharanya.p on 3/24/2018.
 */
@RepositoryRestResource(exported = false)
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
    List<StudentCourse> findByStudentId(Integer studentId);
}
