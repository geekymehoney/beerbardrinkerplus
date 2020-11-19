package com.cs366.project.repository;

import com.cs366.project.model.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transactions, String> {

    @Query(value = "SELECT * FROM transactions where bill_id IN (:list)", nativeQuery = true)
    List<Transactions> findTransactionsByBill_idIn(@Param("list") List<String> list);

}
