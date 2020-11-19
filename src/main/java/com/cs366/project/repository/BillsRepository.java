package com.cs366.project.repository;

import com.cs366.project.model.Bills;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BillsRepository extends CrudRepository<Bills, String> {

    @Query(value = "SELECT bill_id FROM bills WHERE drinker =:name GROUP BY bar ORDER BY date, time", nativeQuery = true)
    List<String> getBillsByDrinkerOrderByDateTime(@Param("name")String name);

    @Query(value = "SELECT bill_id FROM bills where drinker =:name", nativeQuery = true)
    List<String> getBillIdByDrinker(@Param("name") String name);

}
