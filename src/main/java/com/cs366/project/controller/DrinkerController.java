package com.cs366.project.controller;
import com.cs366.project.model.Bills;
import com.cs366.project.model.responsemodel.SpendResponseModel;
import com.cs366.project.repository.BillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/drinker")
public class DrinkerController {

    @Autowired
    BillsRepository billsRepository;

    @GetMapping("/getAllTransactions")
    public ResponseEntity< List<String>> getAllTransactions(@RequestParam String drinkerName) {
       List<String> billIdList = billsRepository.getBillsByDrinkerOrderByDateTime(drinkerName);
        return ResponseEntity.status(HttpStatus.OK).body(billIdList);
    }

    @GetMapping("/getBeersOrderMost")
    public ResponseEntity< List<String>> getBeersOrderMost(@RequestParam String drinkerName) {
        List<String> billIdList = billsRepository.getBillIdByDrinker(drinkerName);
        return ResponseEntity.status(HttpStatus.OK).body(billIdList);
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
