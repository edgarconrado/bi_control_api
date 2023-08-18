package com.belz.bicontrolapi.repository;

import com.belz.bicontrolapi.entity.SafBitacoraPtofit;
import com.belz.bicontrolapi.filterModel.SafBitacoraPtofitSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Map;

public interface SafBitacoraPtofitRepository extends JpaRepository<SafBitacoraPtofit, String>, CommonViewRepository<SafBitacoraPtofit, SafBitacoraPtofitSearchCriteria> {

    @Query(value =
            "SELECT " +
                    "id, cantidad, concepto, conceptocomp, conceptocontable, cuenta, cuentacontpaq, fecha, forma, hora, idbitacora, idcaseta, idcuentacontable, idorigen, idproveedor, idviaje, importe, importeabono, importegasto, importeoperador, importeunitario, iva, maintable, prefijo, proveedor, \"ref\", referencia, retencion, tasaiva, tasaret, tipo, total, transferencia, uuid, viaje, zzfechacreo, zzfechamodifico, zzhoracreo, zzhoramodifico, zzquiencreo, zzquienmodifico, viajecompleto\n" +
            "FROM " +
                    "mx.saf_bitacora_ptofit",
            countQuery =
             "SELECT " +
                     "COUNT(1) " +
             "FROM " +
                     "mx.saf_bitacora_ptofit ",
            nativeQuery = true)
    Page<Map<String, String>> findAllBitacoraPtofit(
            Pageable pageable);
}
