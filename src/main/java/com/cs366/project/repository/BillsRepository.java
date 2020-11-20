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

    @Query(value = "SELECT drinker FROM bills WHERE bar =:name GROUP BY drinker ORDER BY SUM(total_price) DESC LIMIT 10", nativeQuery = true)
    List<String> getTopDrinkerByLargestSpenders(@Param("name")String name);

    @Query(value ="SELECT bill_id FROM bills where bar =:bar", nativeQuery = true)
    List<String> getBillIdByBar(@Param("bar")String bar);

    @Query(value ="SELECT bar FROM bills WHERE bill_id IN (:list) group by bar order by count(*) desc limit 5", nativeQuery = true)
    List<String> getTop5BarByBeerList(@Param("list") List<String> list);

    @Query(value = "SELECT drinker FROM bills WHERE bill_id IN (:list) group by drinker order by count(*) desc",nativeQuery = true)
    List<String> getAllDrinkerOfBiggestConsumers(@Param("list") List<String> list);
}
