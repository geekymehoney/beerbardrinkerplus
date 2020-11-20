package com.cs366.project.controller;

import com.cs366.project.model.BusiestPeriodResponse;
import com.cs366.project.model.SpendResponseModel;
import com.cs366.project.model.Transactions;
import com.cs366.project.repository.BeerRepository;
import com.cs366.project.repository.BillsRepository;
import com.cs366.project.repository.SellsRepository;
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
    public ResponseEntity<List<BusiestPeriodResponse>> getManufactureSellsMostPopular(@RequestParam String barName){
        List<String> beerList = billsRepository.getBusiestPeriodOfDayPerWeek(barName);
        List<BusiestPeriodResponse> busiestPeriodResponseList = beerList.stream().map(p->{
                String []arr = p.split(",");
                BusiestPeriodResponse busiestPeriodResponse = new BusiestPeriodResponse();
                if(arr.length >=2)
                { busiestPeriodResponse.setTime(arr[0]);
                    busiestPeriodResponse.setDay(arr[1]);
                    busiestPeriodResponse.setRecordCount(arr[2] != null ? Integer.parseInt(arr[2]) : null);
                }
                return busiestPeriodResponse;
            }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(busiestPeriodResponseList);
    }

}
