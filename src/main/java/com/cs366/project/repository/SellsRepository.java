package com.cs366.project.repository;

import com.cs366.project.model.SellsBeer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface SellsRepository extends CrudRepository<SellsBeer, String> {
    @Query(value = "SELECT beer FROM sellsbeer GROUP BY beer ORDER BY COUNT(beer) desc", nativeQuery = true)
    List<String> getMostPopular(@Param("beer") String beer);
}
