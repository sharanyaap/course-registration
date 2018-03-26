package com.tfsc.intuit.registration.repository;

import com.tfsc.intuit.registration.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by sharanya.p on 3/24/2018.
 */
@RepositoryRestResource(exported = false)
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
