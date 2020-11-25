package com.cs366.project.controller;

import com.cs366.project.model.responsemodel.BusiestPeriodResponse;
import com.cs366.project.repository.BillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bar")
public class BarController {

    @Autowired
    BillsRepository billsRepository;


    @GetMapping("/getTopDrinkerByLargestSpenders")
    public ResponseEntity<List<String>> getTopDrinkerByLargestSpenders(@RequestParam String barName) {
      List<String> drinkerNameList = billsRepository.getTopDrinkerByLargestSpenders(barName);
        return ResponseEntity.status(HttpStatus.OK).body(drinkerNameList);
    }

    @GetMapping("/getTop10PopularBeer")
    public ResponseEntity<List<String>> getTop10PopularBeer(@RequestParam String barName) {
        List<String> beerList = billsRepository.getBillIdByBar(barName);
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


    @GetMapping("/getBusiestPeriodOfDayPerWeek")
    public ResponseEntity<List<String>> getBusiestPeriodOfDayPerWeek(@RequestParam String barName) {
        List<String> drinkerList = billsRepository.getBusiestPeriodOfDayPerWeek(barName);
        return ResponseEntity.status(HttpStatus.OK).body(drinkerList);
    }

}
