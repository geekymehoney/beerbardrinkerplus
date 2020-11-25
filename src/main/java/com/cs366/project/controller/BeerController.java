package com.cs366.project.controller;
import com.cs366.project.repository.BillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beer")
public class BeerController {


    @Autowired
    BillsRepository billsRepository;

    @GetMapping("/getTop5BarByBeerList")
    public ResponseEntity<List<String>> getTop5BarByBeerList(@RequestParam String beerName) {
        List<String> barList = billsRepository.getTop5BarByBeerList(beerName);
        return ResponseEntity.status(HttpStatus.OK).body(barList);
    }

    @GetMapping("/getAllDrinkerOfBiggestConsumers")
    public ResponseEntity<List<String>> getAllDrinkerOfBiggestConsumers(@RequestParam String beerName) {
        List<String> drinkerList = billsRepository.getAllDrinkerOfBiggestConsumers(beerName);
        return ResponseEntity.status(HttpStatus.OK).body(drinkerList);
    }

}

