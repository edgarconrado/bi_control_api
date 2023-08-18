package com.belz.bicontrolapi.repository;

import com.belz.bicontrolapi.entity.SafViajes;
import com.belz.bicontrolapi.filterModel.SafViajesSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface SafViajesRepository extends JpaRepository<SafViajes, String>, CommonViewRepository<SafViajes, SafViajesSearchCriteria> {

    @Query(value =
            "SELECT " +
                    "id, bitacora, contenedores, destino, fdespacho, fentrada, fplanta, fretorno, fsalidaviaje, ftermino, hentrada, hplanta, hretorno, hsalidaviaje, htermino, idbitacora, idequipom, idequipou, idordencarga, idpersonal, idproveedor, idrutadv, idrutaod, idtipoviaje, idviaje, importe, kilometrosvia, kmsalida, nombreoperador, notas, ntipo, numerounidad, numerounidadu, origen, placas, planta, proveedor, solicitud, status, tipo, tipoequipo, vacio, viadv, viaje, viaod, ftermino_ok\n" +
                    "FROM " +
                    "mx.saf_viajes",
            countQuery =
                    "SELECT " +
                            "COUNT(1) " +
                            "FROM " +
                            "mx.saf_viajes ",
            nativeQuery = true)
    Page<Map<String, String>> findAllViajes(Pageable pageable);
}
