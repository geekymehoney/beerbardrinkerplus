package com.cs366.project.repository;

import com.cs366.project.model.Bars;
import com.cs366.project.model.Bills;
import com.cs366.project.model.Drinkers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BarRepository extends CrudRepository<Bars, String> {
    @Query(value = "SELECT * FROM bars where name =:name", nativeQuery = true)
    Optional<Bars> findByName(@Param("name") String name);
}
