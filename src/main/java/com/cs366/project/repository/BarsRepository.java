package com.cs366.project.repository;

import com.cs366.project.model.Bars;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarsRepository extends CrudRepository<Bars, String> {
}
