package com.cs366.project.controller;
import com.cs366.project.model.Bars;
import com.cs366.project.model.Beers;
import com.cs366.project.model.Drinkers;
import com.cs366.project.repository.BeersRepository;
import com.cs366.project.repository.BillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/beer")
public class BeerController {


    @Autowired
    BillsRepository billsRepository;

    @Autowired
    BeersRepository beersRepository;

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

    @PutMapping("/updateBeer")
    public ResponseEntity<String> updateBeer(@RequestParam String beerName, @RequestParam String columnName,
                                            @RequestParam String columnValue){
        Optional<Beers> beersOptional = beersRepository.findByName(beerName);
        if(beersOptional.isPresent()){
            Beers beers = beersOptional.get();
            if(columnName.equals("name")){
                beers.setName(columnValue);
            }else if(columnName.equals("manf")){
                beers.setManf(columnValue);
            }else {
                beers.setPrice(new BigDecimal(columnValue));
            }
            beersRepository.save(beers);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

