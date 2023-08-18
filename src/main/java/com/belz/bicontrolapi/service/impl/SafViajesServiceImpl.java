package com.belz.bicontrolapi.service.impl;

import com.belz.bicontrolapi.dto.SafViajesDto;
import com.belz.bicontrolapi.mapper.SafViajesMapper;
import com.belz.bicontrolapi.repository.SafViajesRepository;
import com.belz.bicontrolapi.service.ISafViajesService;
import com.belz.bicontrolapi.service.ServiceUtil;
import com.belz.bicontrolapi.util.ConvertType;
import com.belz.bicontrolapi.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SafViajesServiceImpl extends ServiceUtil implements ISafViajesService {
    
    @Autowired
    private SafViajesRepository repository;
    
    @Autowired
    private SafViajesMapper mapper;
    
    @Autowired
    private ConvertType convert;
    
    @Override
    public Page<SafViajesDto> getAll(Integer pageSize, Integer pageNumber) {
        Page<Map<String, String>> viajesData = repository.findAllViajes(getPageable(new PageModel(pageNumber, pageSize, "id")));
        List<SafViajesDto> listInfo = viajesData.getContent().stream()
                .map(item -> new SafViajesDto(
                     item.get("id"),
                     item.get("bitacora"),
                     item.get("contenedores"),
                     item.get("destino"),
                     convert.parseDate(item.get("fDespacho")),
                     convert.parseDate(item.get("fEntrada")),
                     convert.parseDate(item.get("fPlanta")),
                     convert.parseDate(item.get("fRetorno")),
                     convert.parseDate(item.get("fSalidaViaje")),
                     convert.parseDate(item.get("fTermino")),
                     item.get("hEntrada"),
                     item.get("hPlanta"),
                     item.get("hRetorno"),
                     item.get("hSalidaViaje"),
                     item.get("hTermino"),
                     item.get("idBitacora"),
                     item.get("idEquipoM"),
                     item.get("idEquipoU"),
                     item.get("idOrdenCarga"),
                     item.get("idPersonal"),
                     item.get("idProveedor"),
                     item.get("idRutaDV"),
                     item.get("idRutaOD"),
                     item.get("idTipoViaje"),
                     item.get("idViaje"),
                     convert.parseDouble(item.get("importe")),
                     convert.parseInteger(item.get("kilometrosVia")),
                     convert.parseInteger(item.get("kmSalida")),
                     item.get("nombreOperador"),
                     item.get("notas"),
                     convert.parseInteger(item.get("nTipo")),
                     item.get("numeroUnidad"),
                     item.get("numeroUnidadU"),
                     item.get("origen"),
                     item.get("placas"),
                     item.get("planta"),
                     item.get("proveedor"),
                     convert.parseInteger(item.get("solicitud")),
                     item.get("status"),
                     item.get("tipo"),
                     item.get("tipoEquipo"),
                     item.get("vacio"),
                     item.get("viaDV"),
                     convert.parseInteger(item.get("viaje")),
                     item.get("viaOD"),
                     convert.parseDate(item.get("fTerminoOk"))
                )).collect(Collectors.toList());
        return null;
    }
}
