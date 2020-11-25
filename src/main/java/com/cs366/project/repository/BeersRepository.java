package com.cs366.project.repository;

import com.cs366.project.model.Bars;
import com.cs366.project.model.Beers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeersRepository extends CrudRepository<Beers, String> {
}
