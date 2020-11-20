package com.cs366.project.repository;

import com.cs366.project.model.Beer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BeerRepository extends CrudRepository<Beer, String> {
    @Query(value="SELECT manf FROM beer WHERE name IN (:list) limit 10",  nativeQuery = true)
    List<String> getManufactureSellsMostPopular(@Param("list") List<String> list);

}
