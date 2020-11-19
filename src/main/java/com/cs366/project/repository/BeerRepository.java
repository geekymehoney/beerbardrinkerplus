package com.cs366.project.repository;

import com.cs366.project.model.Beer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends CrudRepository<Beer, String> {
}
