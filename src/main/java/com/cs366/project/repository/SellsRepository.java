package com.cs366.project.repository;

import com.cs366.project.model.Sells;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellsRepository extends CrudRepository<Sells, String> {
}
