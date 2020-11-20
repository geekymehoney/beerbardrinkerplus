package com.cs366.project.controller;

import com.cs366.project.model.Transactions;
import com.cs366.project.repository.BeerRepository;
import com.cs366.project.repository.BillsRepository;
import com.cs366.project.repository.SellsRepository;
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
@RequestMapping("/bar")
public class BarController {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BillsRepository billsRepository;

    @Autowired
    SellsRepository sellsRepository;

    @Autowired
    BeerRepository beerRepository;

    @GetMapping("/getTopDrinkerByLargestSpenders")
    public ResponseEntity<List<String>> getTopDrinkerByLargestSpenders(@RequestParam String barName) {
      List<String> drinkerNameList = billsRepository.getTopDrinkerByLargestSpenders(barName);
        return ResponseEntity.status(HttpStatus.OK).body(drinkerNameList);
    }

    @GetMapping("/getTop10PopularBeer")
    public ResponseEntity<List<String>> getTop10PopularBeer(@RequestParam String barName) {
        List<String> billIdList = billsRepository.getBillIdByBar(barName);
        List<String> beerList = new ArrayList<>();
        if(billIdList!=null){
            beerList = transactionRepository.getTop10PopularBeer(billIdList);
        }
        return ResponseEntity.status(HttpStatus.OK).body(beerList);
    }

    @GetMapping("/getManufactureSellsMostPopular")
    public ResponseEntity<List<String>> getManufactureSellsMostPopular(@RequestParam String barName){
        List<String> beerList = sellsRepository.getMostPopular(barName);
        List<String> manufactureList = beerRepository.getManufactureSellsMostPopular(beerList);
        return ResponseEntity.status(HttpStatus.OK).body(manufactureList);
    }

}
