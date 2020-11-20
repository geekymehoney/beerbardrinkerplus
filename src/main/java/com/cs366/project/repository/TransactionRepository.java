package com.cs366.project.repository;

import com.cs366.project.model.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transactions, String> {

    @Query(value = "SELECT * FROM transactions where bill_id IN (:list)", nativeQuery = true)
    List<Transactions> findTransactionsByBill_idIn(@Param("list") List<String> list);
    //see the top 10 beers which are the most popular
    @Query(value = "SELECT item FROM transactions where type = 'beer' and bill_id IN (:list) group by item order by count(quantity) desc limit 10", nativeQuery = true)
    List<String> getTop10PopularBeer(@Param("list")List<String> list);

    @Query(value = "SELECT bill_id FROM transactions WHERE item =:beer", nativeQuery = true)
    List<String> getBillIdlistByBeer(@Param("beer") String beer);

}
