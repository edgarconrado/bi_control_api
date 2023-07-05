package com.belz.bicontrolapi.controller;

import com.belz.bicontrolapi.entity.SafAnticipos;
import com.belz.bicontrolapi.filterModel.safAnticipos.SafAnticiposFilter;
import com.belz.bicontrolapi.service.ISafAnticiposService;
import com.belz.bicontrolapi.service.ISafViajesService;
import com.belz.bicontrolapi.service.impl.SafAnticiposService;
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
@RequestMapping("v1/api/anticipos")
public class SafAnticiposController {

    private static final Logger logger = Logger.getLogger(String.valueOf(SafAnticiposController.class));

    String classname = String.valueOf(SafAnticiposController.class);

    @Autowired
    ISafAnticiposService iSafAnticiposService;

    @Autowired
    SafAnticiposService safAnticiposService;

    @PostMapping(value = "")
    public ResponseEntity<Page<SafAnticipos>> anticipos(@RequestBody SafAnticiposFilter jsonAnticiposFilter) {
        return new ResponseEntity<>(safAnticiposService.getAnticipos(jsonAnticiposFilter.getSafAnticiposPage(), jsonAnticiposFilter.getSafAnticiposSearchCriteria()),
                HttpStatus.OK);
    }
}