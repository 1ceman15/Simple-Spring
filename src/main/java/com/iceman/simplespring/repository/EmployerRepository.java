package com.iceman.simplespring.repository;

import com.iceman.simplespring.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer,String> {
}
