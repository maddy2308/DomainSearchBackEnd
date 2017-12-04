package com.zenefits.controllers;

import com.zenefits.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrieController {

    @Autowired
    private DomainService domainService;

    @GetMapping("/domain/{partial}")
    @CrossOrigin(origins = "http://localhost:4200")
    List<String> getTrie(@PathVariable("partial") String partial) {
        List<String> list = domainService.getTrie().autoCompleteSearch(partial);
        return list;
    }

}
