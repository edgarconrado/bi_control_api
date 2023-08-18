package com.belz.bicontrolapi.controller;

import com.belz.bicontrolapi.dto.SafAnticiposDto;
import com.belz.bicontrolapi.service.ISafAnticiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/anticipos")
public class SafAnticiposController {

    @Autowired
    ISafAnticiposService service;

    @GetMapping(value = "/getAnticipos", produces = "application/json")
    public ResponseEntity<Page<SafAnticiposDto>> getAnticipos(
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "0") Integer pageNumber) {
        return new ResponseEntity<>(service.getAll(pageSize, pageNumber), HttpStatus.OK);

    }
}