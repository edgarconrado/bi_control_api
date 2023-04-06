package com.belz.bicontrol.controller;

import com.belz.bicontrol.entity.SafUnidades;
import com.belz.bicontrol.filterModel.SafUnidadesFilter;
import com.belz.bicontrol.service.ISafUnidadesService;
import com.belz.bicontrol.service.impl.SafUnidadesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@Api
@RestController
@RequestMapping("/v1/api/safUnidades")
public class SafUnidadesController {

    private static final Logger logger = Logger.getLogger(String.valueOf(SafUnidadesController.class));

    String classname = String.valueOf(SafUnidadesController.class);

    @Autowired
    ISafUnidadesService iunidadesService;

    @Autowired
    SafUnidadesService unidadesService;

    @PostMapping(value = "")
    public ResponseEntity<Page<SafUnidades>> unidades(@RequestBody SafUnidadesFilter jsonUnidadesFilter) {
        return new ResponseEntity<>(unidadesService.getUnidades(jsonUnidadesFilter.getUnidadesPage(),
                jsonUnidadesFilter.getUnidadesSearchCriteria()), HttpStatus.OK);
    }
}
