package com.cs366.project.repository;

import com.cs366.project.model.Drinkers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DrinkerRepository extends CrudRepository<Drinkers, String> {
    @Query(value = "SELECT * FROM drinkers where name =:name", nativeQuery = true)
    Optional<Drinkers> findByName(@Param("name") String name);
}
