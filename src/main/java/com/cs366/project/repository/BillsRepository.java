package com.cs366.project.repository;
import com.cs366.project.model.Beers;
import com.cs366.project.model.Bills;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface BillsRepository extends CrudRepository<Bills, Long> {

    @Query(value = "SELECT * FROM bills WHERE drinkers =:name GROUP BY bars ORDER BY date, time", nativeQuery = true)
    List<String> getBillsByDrinkerOrderByDateTime(@Param("name")String name);

    @Query(value = "SELECT * FROM bills where drinkers =:name", nativeQuery = true)
    List<String> getBillIdByDrinker(@Param("name") String name);

    @Query(value = "SELECT drinkers FROM bills WHERE bars =:name GROUP BY drinkers ORDER BY SUM(total_price) DESC LIMIT 10", nativeQuery = true)
    List<String> getTopDrinkerByLargestSpenders(@Param("name")String name);

    @Query(value ="SELECT beers FROM bills where bars =:bar group by beers order by count(quantity) desc limit 10", nativeQuery = true)
    List<String> getBillIdByBar(@Param("bar")String bar);

    @Query(value ="SELECT bars FROM bills WHERE beers =:beer group by bars order by count(*) desc limit 5", nativeQuery = true)
    List<String> getTop5BarByBeerList(@Param("beer") String  beer);

    @Query(value = "SELECT drinkers FROM bills WHERE beers =:beer group by drinkers order by count(*) desc limit 10",nativeQuery = true)
    List<String> getAllDrinkerOfBiggestConsumers(@Param("beer") String  beer);

    /*
    c) see a graph with his/her spending in different bars, per days of the week, and month.
     */
    @Query(value = "SELECT date, day, sum(total_price) as spending FROM bills where drinkers =:name group by day", nativeQuery = true)
    List<String> getSpendingPerDayOfWeek(@Param("name") String name);

    /*
    *
    * */
    @Query(value = "SELECT time, day, count(*) as recordCount FROM bills WHERE bars =:bar GROUP BY day ORDER BY recordCount DESC LIMIT 1", nativeQuery = true)
    List<String> getBusiestPeriodOfDayPerWeek(@Param("bar") String bar);

    @Query(value = "SELECT * FROM beers WHERE name =:beer", nativeQuery = true)
    String getMostBeerSellsManufactor(@Param("beer") String beer);

    @Query(value = "SELECT beers FROM bills WHERE bars =:bar GROUP BY day ORDER BY count(*) DESC LIMIT 1", nativeQuery = true)
    String getMostPopularBeer(@Param("bar") String bar);
}
