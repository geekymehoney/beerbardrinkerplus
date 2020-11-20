package com.cs366.project.controller;
import com.cs366.project.model.SpendResponseModel;
import com.cs366.project.model.Transactions;
import com.cs366.project.repository.BillsRepository;
import com.cs366.project.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
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

    @GetMapping("/getSpendingPerDayOfWeek")
    public ResponseEntity<List<SpendResponseModel>> getSpendingPerDayOfWeek(@RequestParam String drinkerName) {
        List<String> spendingStrings = billsRepository.getSpendingPerDayOfWeek(drinkerName);
        List<SpendResponseModel> spendList = new ArrayList<>();
         spendList = spendingStrings.stream().map(i->
         {
             String []arr = i.split(",");
             SpendResponseModel spendResponseModel = new SpendResponseModel();
             if(arr.length >=2)
             { spendResponseModel.setDate(arr[0]);
               spendResponseModel.setDay(arr[1]);
               spendResponseModel.setSum(arr[2] != null ? Double.parseDouble(arr[2]) : null);
             }
             return spendResponseModel;
         }

        ).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(spendList);
    }
}
