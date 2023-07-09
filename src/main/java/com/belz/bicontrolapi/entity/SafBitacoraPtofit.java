package com.belz.bicontrolapi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity(name = "saf_bitacora-ptofit")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class SafBitacoraPtofit {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "Concepto")
    private String concepto;

    @Column(name = "ConceptoComp")
    private String  concepto_comp;

    @Column(name = "ConceptoContable")
    private String concepto_contable;

    @Column(name = "Cuenta")
    private String cuenta;

    @Column(name = "CuentaContpaq")
    private String cuenta_contpaq;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "Forma")
    private String forma;

    @Column(name = "Hora")
    private String hora;

    @Column(name = "idBitacora")
    private String id_bitacota;

    @Column(name = "idCaseta")
    private String id_caseta;

    @Column(name = "idCuentaContable")
    private String id_cuenta_contable;

    @Column(name = "idOrigen")
    private String id_origen;

    @Column(name = "idProveedor")
    private String id_proveedor;

    @Column(name = "idViaje")
    private String id_viaje;

    @Column(name = "Importe")
    private Double importe;

    @Column(name = "ImporteAbono")
    private Double importe_abono;

    @Column(name = "ImporteGasto")
    private Double importe_gasto;

    @Column(name = "ImporteOperador")
    private Double importe_operador;

    @Column(name = "ImporteUnitario")
    private Double importe_unitario;

    @Column(name = "Iva")
    private Double iva;

    @Column(name = "MainTable")
    private String main_table;

    @Column(name = "Prefijo")
    private String prefijo;

    @Column(name = "Proveedor")
    private String proveedor;

    @Column(name = "Ref")
    private String ref;

    @Column(name = "Referencia")
    private String referencia;

    @Column(name = "Retencion")
    private Integer retencion;
    @Column(name = "TasaIva")
    private Integer tasa_iva;

    @Column(name = "TasaRet")
    private Integer tasa_ret;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "Total")
    private Double total;

    @Column(name = "Transferencia")
    private String transferencia;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "Viaje")
    private String viaje;

    @Column(name = "ZzFechaCreo")
    private Date zz_fecha_creo;

    @Column(name = "ZzFechaModifico")
    private Date zz_fecha_modifico;

    @Column(name = "ZzHoraCreo")
    private String zz_hora_creo;

    @Column(name = "ZzHoraModifico")
    private String zz_hora_modifico;

    @Column(name = "ZzQuienCreo")
    private String zz_quien_creo;

    @Column(name = "ZzQuienModifico")
    private String zz_quien_modifico;

    @Column(name = "viajeCompleto")
    private String viaje_completo;

}
