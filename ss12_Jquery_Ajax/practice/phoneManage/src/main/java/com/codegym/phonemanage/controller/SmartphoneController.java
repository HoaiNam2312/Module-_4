package com.codegym.phonemanage.controller;

import com.codegym.phonemanage.model.Smartphone;
import com.codegym.phonemanage.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/smartphone")
public class SmartphoneController {
    @Autowired
    ISmartphoneService smartphoneService;

    @GetMapping()
    public ResponseEntity<List<Smartphone>> showList() {
        List<Smartphone> smartphoneList = smartphoneService.findAll();
        if (smartphoneList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphoneList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Smartphone> saveSmartPhone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Smartphone smartphone = smartphoneService.findById(id);
        if (smartphone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.deleteById(id);
        return new ResponseEntity<>(smartphone, HttpStatus.OK);
    }

}
