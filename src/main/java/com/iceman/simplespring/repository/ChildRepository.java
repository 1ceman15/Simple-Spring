package com.iceman.simplespring.repository;

import com.iceman.simplespring.entity.Child;
import com.iceman.simplespring.entity.ChildId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends JpaRepository<Child, ChildId> {
}
