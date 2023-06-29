package com.belz.bicontrolapi.controller;

import com.belz.bicontrolapi.entity.SafViajes;
import com.belz.bicontrolapi.filterModel.safViajes.SafViajesFilter;
import com.belz.bicontrolapi.service.ISafViajesService;
import com.belz.bicontrolapi.service.impl.SafViajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("v1/api/viajes")
public class SafViajesController {

    private static final Logger logger  = Logger.getLogger(String.valueOf(SafViajesController.class));

    String classname = String.valueOf(SafViajesController.class);

    @Autowired
    ISafViajesService iSafViajesService;

    @Autowired
    SafViajesService safViajesService;

    @PostMapping(value = "")
    public ResponseEntity<Page<SafViajes>> viajes(@RequestBody SafViajesFilter jsonViajesFilter) {
        return new ResponseEntity<>(safViajesService.getViajes(jsonViajesFilter.getSafViajesPage(), jsonViajesFilter.getSafViajesSearchCriteria()),
                HttpStatus.OK);
    }
}
