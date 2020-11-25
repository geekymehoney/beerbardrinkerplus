package com.cs366.project.repository;

import com.cs366.project.model.Bars;
import com.cs366.project.model.Beers;
import com.cs366.project.model.Drinkers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeersRepository extends CrudRepository<Beers, String> {
    @Query(value = "SELECT * FROM beers where name =:name", nativeQuery = true)
    Optional<Beers> findByName(@Param("name") String name);
}
