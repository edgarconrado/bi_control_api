package com.belz.bicontrolapi.filterModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SafBitacoraPtofitSearchCriteria {
    private String id;
    private Integer cantidad;
    private String concepto;
    private String concepto_comp;
    private String concepto_contable;
    private String cuenta;
    private String cuenta_contpaq;
    private Date fecha;
    private String forma;
    private String hora;
    private String id_bitacota;
    private String id_caseta;
    private String id_cuenta_contable;
    private String id_origen;
    private String id_proveedor;
    private String id_viaje;
    private Double importe;
    private Double importe_abono;
    private Double importe_gasto;
    private Double importe_operador;
    private Double importe_unitario;
    private Double iva;
    private String main_table;
    private String prefijo;
    private String proveedor;
    private String ref;
    private String referencia;
    private Integer retencion;
    private Integer tasa_iva;
    private Integer tasa_ret;
    private String tipo;
    private Double total;
    private String transferencia;
    private String uuid;
    private String viaje;
    private Date zz_fecha_creo;
    private Date zz_fecha_modifico;
    private String zz_hora_creo;
    private String zz_hora_modifico;
    private String zz_quien_creo;
    private String zz_quien_modifico;
    private String viaje_completo;
}
