package com.belz.bicontrolapi.controller;

import com.belz.bicontrolapi.entity.SafUnidades;
import com.belz.bicontrolapi.filterModel.safUnidades.SafUnidadesFilter;
import com.belz.bicontrolapi.service.ISafUnidadesService;
import com.belz.bicontrolapi.service.impl.SafUnidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("v1/api/unidades")
public class SafUnidadesController {

    private static final Logger logger = Logger.getLogger(String.valueOf(SafUnidadesController.class));

    String classname = String.valueOf(SafUnidadesController.class);

    @Autowired
    ISafUnidadesService iSafUnidadesService;

    @Autowired
    SafUnidadesService safUnidadesService;

    @PostMapping(value = "")
    public ResponseEntity<Page<SafUnidades>> unidades(@RequestBody SafUnidadesFilter jsonUnidadesFilter) {
        return new ResponseEntity<>(safUnidadesService.getUnidades(jsonUnidadesFilter.getSafUnidadesPage(), jsonUnidadesFilter.getSafUnidadesSearchCriteria()),
                HttpStatus.OK);
    }
}
