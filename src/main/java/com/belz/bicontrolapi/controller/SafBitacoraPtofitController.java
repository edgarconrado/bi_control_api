package com.belz.bicontrolapi.controller;

import com.belz.bicontrolapi.dto.SafBitacoraPtofitDto;
import com.belz.bicontrolapi.service.ISafBitacoraPtofitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/bitacoraPtofit")
public class SafBitacoraPtofitController {

    @Autowired
    ISafBitacoraPtofitService service;

    @GetMapping(value = "/getBitacoraPtofit", produces = "application/json")
    public ResponseEntity<Page<SafBitacoraPtofitDto>> getBitacoraPtofit(
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "0") Integer pageNumber) {
        return new ResponseEntity<>(service.getAll(pageSize, pageNumber), HttpStatus.OK);
    }
}
