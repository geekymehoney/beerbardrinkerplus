package com.cs366.project.controller;
import com.cs366.project.model.Beers;
import com.cs366.project.model.Drinkers;
import com.cs366.project.model.responsemodel.BillsResponse;
import com.cs366.project.model.responsemodel.SpendResponseModel;
import com.cs366.project.repository.BillsRepository;
import com.cs366.project.repository.DrinkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/drinker")
public class DrinkerController {

    @Autowired
    BillsRepository billsRepository;

    @Autowired
    DrinkerRepository drinkerRepository;

    @GetMapping("/getAllTransactions")
    public ResponseEntity< List<BillsResponse>> getAllTransactions(@RequestParam String drinkerName) {
       List<String> billIdList = billsRepository.getBillsByDrinkerOrderByDateTime(drinkerName);
        List<BillsResponse> billsResponseList = new ArrayList<>();
        billsResponseList = billIdList.stream().map(i->
                {
                    String []arr = i.split(",");
                    BillsResponse billsResponse = new BillsResponse();
                    if(arr.length >=9)
                    {
                        billsResponse.setBeers(arr[0]);
                        billsResponse.setBill_id(arr[1]);
                        billsResponse.setQuantity(Integer.parseInt(arr[2]));
                        billsResponse.setDate(arr[3]);
                        billsResponse.setDay(arr[4]);
                        billsResponse.setTime(arr[5]);
                        billsResponse.setTotal_price(new BigDecimal(arr[6]));
                        billsResponse.setBars(arr[7]);
                        billsResponse.setDrinkers(arr[8]);
                    }
                    return billsResponse;
                }

        ).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(billsResponseList);
    }

    @GetMapping("/getBeersOrderMost")
    public ResponseEntity< List<BillsResponse>> getBeersOrderMost(@RequestParam String drinkerName) {
        List<String> billList = billsRepository.getBillIdByDrinker(drinkerName);
        List<BillsResponse> billsResponseList = new ArrayList<>();
        billsResponseList = billList.stream().map(i->
                {
                    String []arr = i.split(",");
                    BillsResponse billsResponse = new BillsResponse();
                    if(arr.length >=9)
                    {
                        billsResponse.setBeers(arr[0]);
                        billsResponse.setBill_id(arr[1]);
                        billsResponse.setQuantity(Integer.parseInt(arr[2]));
                        billsResponse.setDate(arr[3]);
                        billsResponse.setDay(arr[4]);
                        billsResponse.setTime(arr[5]);
                        billsResponse.setTotal_price(new BigDecimal(arr[6]));
                        billsResponse.setBars(arr[7]);
                        billsResponse.setDrinkers(arr[8]);
                    }
                    return billsResponse;
                }

        ).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(billsResponseList);
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


    @PutMapping("/updateDrinker")
    public ResponseEntity<String> updateBar(@RequestParam String drinkerName, @RequestParam String columnName,
                                            @RequestParam String columnValue){
        Optional<Drinkers> drinkersOps = drinkerRepository.findByName(drinkerName);
        if(drinkersOps.isPresent()){
            Drinkers drinkers = drinkersOps.get();
        if(columnName.equals("name")){
            drinkers.setName(columnValue);
        }else if(columnName.equals("phone")){
            drinkers.setPhone(columnValue);
        }else {
            drinkers.setState(columnValue);
        }
        drinkerRepository.save(drinkers);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
