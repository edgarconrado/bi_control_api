package com.belz.bicontrolapi.controller;

import com.belz.bicontrolapi.dto.SafViajesDto;
import com.belz.bicontrolapi.service.ISafViajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/viajes")
public class SafViajesController {

    @Autowired
    ISafViajesService service;

    @GetMapping(value = "/getViajes", produces = "application/json")
    public ResponseEntity<Page<SafViajesDto>> getViajes(
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "0") Integer pageNumber){
        return new ResponseEntity<>(service.getAll(pageSize, pageNumber), HttpStatus.OK);
    }
}
