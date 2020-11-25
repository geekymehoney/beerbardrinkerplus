package com.cs366.project.repository;

import com.cs366.project.model.Drinkers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkerRepository extends CrudRepository<Drinkers, String> {
}
