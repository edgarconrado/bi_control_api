package com.belz.bicontrolapi.repository;

import com.belz.bicontrolapi.entity.SafBitacora;
import com.belz.bicontrolapi.filterModel.SafBitacoraSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface SafBitacoraRepository extends JpaRepository<SafBitacora, String>, CommonViewRepository<SafBitacora, SafBitacoraSearchCriteria> {
    @Query(value =
            "SELECT " +
                    "id, bitacora, bitacoraf, idpersonal, nombreoperador, numerooperador, salariodiario, sueldobase, tipoequipo, status, fterminoviaje, anticipos, cierreanno, cierremes, conceptoconta, configuracion, cuentaoperador, dieselefectivo, factorrendimiento, gastoscomprobados, idequipo, liquidacion, nota, numerounidad, placas, porpagarletra, segmento, viajes, convenioseguro, formapagooperador, kmanetrior, kmfinal, kmrecoridos, kmsalida, lcombustible, ldiferencia, litroscargados, lkilometros, llitroscombustible, loverspeed1, loverspeed2, lpto, lralenti, lrendimeinto, lrevolucionesmax, lvelocidadmax, montodiario, montoimss, peso, pisasefectivo, semana, sueldo, sueldodiario, sueldooperador, termino, fecha, fsalida, cuentacontpaq, equipos, \"ref\", zzquiencreo, zzfechacreo, zzhoracreo\n" +
                    "FROM " +
                    "mx.saf_bitacora",
            countQuery =
                    "SELECT " +
                            "COUNT(1) " +
                            "FROM " +
                            "mx.saf_bitacora ",
            nativeQuery = true)
    Page<Map<String, String>> findAllBitacora(
            Pageable pageable);
}
