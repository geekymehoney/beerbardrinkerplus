package com.cs366.project.controller;

import com.cs366.project.model.Bars;
import com.cs366.project.model.Beers;
import com.cs366.project.model.responsemodel.BusiestPeriodResponse;
import com.cs366.project.repository.BarRepository;
import com.cs366.project.repository.BillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bar")
public class BarController {

    @Autowired
    BillsRepository billsRepository;

    @Autowired
    BarRepository barRepository;

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

    @GetMapping("/getBusiestPeriodOfDayPerWeek")
    public ResponseEntity<List<BusiestPeriodResponse>> getBusiestPeriodOfDayPerWeek(@RequestParam String barName){
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


    @GetMapping("/getManufactureSellsMostPopular")
    public ResponseEntity<String> getManufactureSellsMostPopular(@RequestParam String barName) {
        String beer = billsRepository.getMostPopularBeer(barName);
        String manufactor = billsRepository.getMostBeerSellsManufactor(beer);
        String []arr = manufactor.split(",");
        if(arr.length > 1){
            String ss = "{ name: "+arr[1]+"}";
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(ss);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/updateBar")
    public ResponseEntity<String> updateBar(@RequestBody Bars bars){
         barRepository.save(bars);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
