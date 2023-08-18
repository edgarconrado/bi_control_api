package com.belz.bicontrolapi.service.impl;

import com.belz.bicontrolapi.dto.SafBitacoraDto;
import com.belz.bicontrolapi.mapper.SafBitacoraMapper;
import com.belz.bicontrolapi.repository.SafBitacoraRepository;
import com.belz.bicontrolapi.service.ISafBitacoraService;
import com.belz.bicontrolapi.service.ServiceUtil;
import com.belz.bicontrolapi.util.ConvertType;
import com.belz.bicontrolapi.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SafBitacoraServiceImpl extends ServiceUtil implements ISafBitacoraService {

    @Autowired
    private SafBitacoraRepository repository;

    @Autowired
    private SafBitacoraMapper mapper;

    @Autowired
    private ConvertType convert;

    @Override
    public Page<SafBitacoraDto> getAll(Integer pageSize, Integer pageNumber) {
        Page<Map<String, String>> bitacoraData = repository.findAllBitacora(getPageable(new PageModel(pageNumber, pageSize, "id")));
        List<SafBitacoraDto> listInfo = bitacoraData.getContent().stream()
                .map(item -> new SafBitacoraDto(
                        item.get("id"),
                        convert.parseInteger(item.get("bitacora")),
                        convert.parseInteger(item.get("bitacoraF")),
                        item.get("idPersonal"),
                        item.get("nombreOperador"),
                        item.get("numeroOperador"),
                        convert.parseDouble(item.get("salarioDiario")),
                        item.get("sueldoBase"),
                        item.get("tipoeEquipo"),
                        item.get("status"),
                        convert.parseDate(item.get("fTerminoViaje")),
                        item.get("anticipos"),
                        item.get("cierreAnno"),
                        item.get("cierreMes"),
                        item.get("conceptoConta"),
                        item.get("configuracion"),
                        item.get("cuentaOperador"),
                        item.get("dieselEfectivo"),
                        item.get("factorRendimiento"),
                        item.get("gastosComprobados"),
                        item.get("idEquipo"),
                        item.get("liquidacion"),
                        item.get("nota"),
                        item.get("numeroUnidad"),
                        item.get("placas"),
                        item.get("porPagarLetra"),
                        item.get("segmento"),
                        item.get("viajes;"),
                        convert.parseDouble(item.get("convenioSeguro")),
                        item.get("formaPagoOperador"),
                        convert.parseDouble(item.get("kmAnterior")),
                        convert.parseDouble(item.get("kmFinal")),
                        convert.parseDouble(item.get("kmRecorridos")),
                        convert.parseDouble(item.get("kmSalida")),
                        convert.parseDouble(item.get("lCombustible")),
                        convert.parseDouble(item.get("lDiferencia")),
                        convert.parseDouble(item.get("litrosCargados")),
                        convert.parseDouble(item.get("lKilometros")),
                        convert.parseDouble(item.get("lLitrosCombustible")),
                        convert.parseDouble(item.get("lOverSpeed1")),
                        convert.parseDouble(item.get("lOverSpeed2")),
                        convert.parseDouble(item.get("lpto")),
                        convert.parseDouble(item.get("lRalenti")),
                        convert.parseDouble(item.get("lRendimiento")),
                        convert.parseDouble(item.get("lRevolucionesMax")),
                        convert.parseDouble(item.get("lVolocidadMax")),
                        convert.parseDouble(item.get("montoDiario")),
                        convert.parseDouble(item.get("montoImss")),
                        convert.parseDouble(item.get("pero")),
                        convert.parseDouble(item.get("peroEfectivo")),
                        convert.parseDouble(item.get("semana")),
                        convert.parseDouble(item.get("sueldo")),
                        convert.parseDouble(item.get("sueldoDiario")),
                        item.get("sueldoOperador"),
                        convert.parseDouble(item.get("termino")),
                        convert.parseDate(item.get("fecha")),
                        item.get("fSalida"),
                        item.get("cuentaContpaq"),
                        item.get("equipos"),
                        item.get("ref"),
                        item.get("zzQuienCreo"),
                        convert.parseDate(item.get("zzFEchaCreo")),
                        item.get("zzHoraCreo")
                        )).collect(Collectors.toList());
        return new PageImpl<>(listInfo, bitacoraData.getPageable(), bitacoraData.getTotalElements());
    }
}
