package com.belz.bicontrolapi.service.impl;

import com.belz.bicontrolapi.dto.SafAnticiposDto;
import com.belz.bicontrolapi.mapper.SafAnticiposMapper;
import com.belz.bicontrolapi.repository.SafAnticiposRepository;
import com.belz.bicontrolapi.service.ISafAnticiposService;
import com.belz.bicontrolapi.service.ServiceUtil;
import com.belz.bicontrolapi.util.PageModel;
import com.belz.bicontrolapi.util.ConvertType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SafAnticiposServiceImpl extends ServiceUtil implements ISafAnticiposService {

    @Autowired
    private SafAnticiposRepository repository;

    @Autowired
    private SafAnticiposMapper mapper;

    @Autowired
    private Environment environment;

    @Autowired
    private ConvertType convert;

    @Override
    public Page<SafAnticiposDto> getAll(Integer pageSize, Integer pageNumber) {
        
        Page<Map<String, String>> anticiposData = repository.findAllAnticipos(getPageable(new PageModel(pageNumber, pageSize, "id")));

        List<SafAnticiposDto> listInfo = anticiposData.getContent().stream()
                .map(item -> new SafAnticiposDto(
                    item.get("id"),
                    item.get("banco"),
                    item.get("bitacora"),
                    item.get("concepto"),
                    item.get("conceptoCuenta"),
                    item.get("destino"),
                    item.get("eBanco"),
                    item.get("eCuentaBancaria"),
                    item.get("equipo"),
                    item.get("eSucursal"),
                    convert.parseDate(item.get("fecha")),
                    convert.parseInteger(item.get("folio")),
                    item.get("idBitacora"),
                    item.get("idCuentabancariaE"),
                    item.get("idCuentaBancariaP"),
                    item.get("idCuentaContable"),
                    item.get("idDepositoBanco"),
                    item.get("idEmpresa"),
                    item.get("idPersonal"),
                    item.get("idViaje"),
                    item.get("importe"),
                    item.get("importeLetra"),
                    item.get("motivo"),
                    item.get("origen"),
                    item.get("pBanco"),
                    item.get("CuentaBancaria"),
                    item.get("portador"),
                    item.get("razonSocial"),
                    item.get("referencia"),
                    item.get("rfc"),
                    item.get("status"),
                    item.get("tipo"),
                    item.get("tracto"),
                    item.get("Transferencia"),
                    convert.parseInteger(item.get("viaje"))
                    )).collect(Collectors.toList());
        return new PageImpl<>(listInfo, anticiposData.getPageable(), anticiposData.getTotalElements());
    }
}


