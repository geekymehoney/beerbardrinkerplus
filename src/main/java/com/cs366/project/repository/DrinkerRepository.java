package com.cs366.project.repository;

import com.cs366.project.model.Drinker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkerRepository extends CrudRepository<Drinker, String> {
}
