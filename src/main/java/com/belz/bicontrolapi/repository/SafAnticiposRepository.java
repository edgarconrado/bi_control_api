package com.belz.bicontrolapi.repository;

import com.belz.bicontrolapi.entity.SafAnticipos;
import com.belz.bicontrolapi.filterModel.SafAnticiposSearchCriteria;
import com.belz.bicontrolapi.service.ServiceUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface SafAnticiposRepository extends JpaRepository<SafAnticipos, String>, CommonViewRepository<SafAnticipos, SafAnticiposSearchCriteria> {

    @Query(value =
            "SELECT " +
                    "id, banco, bitacora, concepto, conceptocuenta, destino, ebanco, ecuentabancaria, equipo, esucursal, fecha, folio, idbitacora, idcuentabancariae, idcuentabancariap, idcuentacontable, iddepositobanco, idempresa, idpersonal, idviaje, importe, importeletra, motivo, origen, pbanco, cuentabancaria, portador, razonsocial, referencia, rfc, status, tipo, tracto, transferencia, viaje\n" +
            "FROM " +

                    "mx.saf_anticipos",
            countQuery = "SELECT COUNT(1) " +
                    "FROM mx.saf_anticipos ",
            nativeQuery = true)
    Page<Map<String, String>> findAllAnticipos(Pageable pageable);
}
