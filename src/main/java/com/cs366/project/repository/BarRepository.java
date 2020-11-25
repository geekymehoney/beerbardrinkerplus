package com.cs366.project.repository;

import com.cs366.project.model.Bills;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarRepository extends CrudRepository<Bills, String> {
}
