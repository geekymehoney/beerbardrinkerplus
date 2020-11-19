package com.cs366.project.controller;

import com.cs366.project.model.Transactions;
import com.cs366.project.repository.BillsRepository;
import com.cs366.project.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/drinker")
public class DrinkerController {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BillsRepository billsRepository;

    @GetMapping("/getAllTransactions")
    public ResponseEntity<List<Transactions>> getAllTransactions(@RequestParam String drinkerName) {
       List<String> billIdList = billsRepository.getBillsByDrinkerOrderByDateTime(drinkerName);
        List<Transactions> transactionList = new ArrayList<>();
        if(billIdList!=null){
            transactionList = transactionRepository.findTransactionsByBill_idIn(billIdList);
       }
        return ResponseEntity.status(HttpStatus.OK).body(transactionList);
    }

    @GetMapping("/getBeersOrderMost")
    public ResponseEntity<List<Transactions>> getBeersOrderMost(@RequestParam String drinkerName) {
        List<String> billIdList = billsRepository.getBillIdByDrinker(drinkerName);
        List<Transactions> transactionList = new ArrayList<>();
        if(billIdList!=null){
            transactionList = transactionRepository.findTransactionsByBill_idIn(billIdList);
        }
        return ResponseEntity.status(HttpStatus.OK).body(transactionList);
    }



}
