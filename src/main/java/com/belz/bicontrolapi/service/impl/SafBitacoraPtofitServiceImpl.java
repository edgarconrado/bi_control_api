package com.belz.bicontrolapi.service.impl;

import com.belz.bicontrolapi.dto.SafBitacoraPtofitDto;
import com.belz.bicontrolapi.mapper.SafBitacoraPtofitMapper;
import com.belz.bicontrolapi.repository.SafBitacoraPtofitRepository;
import com.belz.bicontrolapi.service.ISafBitacoraPtofitService;
import com.belz.bicontrolapi.service.ServiceUtil;
import com.belz.bicontrolapi.util.PageModel;
import com.belz.bicontrolapi.util.ConvertType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SafBitacoraPtofitServiceImpl extends ServiceUtil implements ISafBitacoraPtofitService {

    @Autowired
    private SafBitacoraPtofitRepository repository;

    @Autowired
    private SafBitacoraPtofitMapper mapper;
    
    @Autowired
    private ConvertType convert;
    
    @Override
    public Page<SafBitacoraPtofitDto> getAll(Integer pageSize, Integer pageNumber) {

        Page<Map<String, String>> bitacoraPtofitData = repository.findAllBitacoraPtofit(getPageable(new PageModel(pageNumber, pageSize, "id")));

        List<SafBitacoraPtofitDto> listInfo = bitacoraPtofitData.getContent().stream()
                .map(item -> new SafBitacoraPtofitDto(
                        item.get("id"),
                        convert.parseInteger(item.get("cantidad")),
                        item.get("concepto"),
                        item.get("conceptocomp"),
                        item.get("conceptocontable"),
                        item.get("cuenta"),
                        item.get("cuentacontpaq"),
                        convert.parseDate(item.get("fecha")),
                        item.get("forma"),
                        item.get("hora"),
                        item.get("id_bitacota"),
                        item.get("id_caseta"),
                        item.get("id_cuenta_contable"),
                        item.get("id_origen"),
                        item.get("id_proveedor"),
                        item.get("id_viaje"),
                        convert.parseDouble(item.get("importe")),
                        convert.parseDouble(item.get("importe_abono")),
                        convert.parseDouble(item.get("importe_gasto")),
                        convert.parseDouble(item.get("importe_operador")),
                        convert.parseDouble(item.get("importe_unitario")),
                        convert.parseDouble(item.get("iva")),
                        item.get("main_table"),
                        item.get("prefijo"),
                        item.get("proveedor"),
                        item.get("ref"),
                        item.get("referencia"),
                        convert.parseInteger(item.get("retencion")),
                        convert.parseInteger(item.get("tasa_iva")),
                        convert.parseInteger(item.get("tasa_ret")),
                        item.get("tipo"),
                        convert.parseDouble(item.get("total")),
                        item.get("transferencia"),
                        item.get("uuid"),
                        item.get("viaje"),
                        convert.parseDate(item.get("zz_fecha_creo")),
                        convert.parseDate(item.get("zz_fecha_modifico")),
                        item.get("zz_hora_creo"),
                        item.get("zz_hora_modifico"),
                        item.get("zz_quien_creo"),
                        item.get("zz_quien_modifico"),
                        item.get("viaje_completo")
                        )).collect(Collectors.toList());

        return new PageImpl<>(listInfo, bitacoraPtofitData.getPageable(), bitacoraPtofitData.getTotalElements());
    }
}
