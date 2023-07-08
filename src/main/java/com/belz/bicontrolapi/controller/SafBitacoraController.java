package com.belz.bicontrolapi.controller;

import com.belz.bicontrolapi.entity.SafBitacora;
import com.belz.bicontrolapi.filterModel.safBitacora.SafBitacoraFilter;
import com.belz.bicontrolapi.service.impl.SafBitacoraService;
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
@RequestMapping("v1/api/bitacora")
public class SafBitacoraController {

    private static final Logger logger  = Logger.getLogger(String.valueOf(SafBitacoraController.class));

    String classname = String.valueOf(SafBitacoraController.class);

    @Autowired
    SafBitacoraService safBitacoraService;

    @PostMapping(value = "")
    public ResponseEntity<Page<SafBitacora>> bitacora(@RequestBody SafBitacoraFilter jsonBitacoraFilter) {
        return new ResponseEntity<>(safBitacoraService.getBitacora(jsonBitacoraFilter.getSafBitacoraPage(), jsonBitacoraFilter.getSafBitacoraSearchCriteria()),
                HttpStatus.OK);
    }

}
