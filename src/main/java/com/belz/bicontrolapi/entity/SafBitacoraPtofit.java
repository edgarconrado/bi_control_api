package com.belz.bicontrolapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
@Table(name = "saf_bitacora-ptofit")
@Entity
public class SafBitacoraPtofit {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "Concepto")
    private String concepto;

    @Column(name = "ConceptoComp")
    private String  conceptoComp;

    @Column(name = "ConceptoContable")
    private String conceptoContable;

    @Column(name = "Cuenta")
    private String cuenta;

    @Column(name = "CuentaContpaq")
    private String cuentaContpaq;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "Forma")
    private String forma;

    @Column(name = "Hora")
    private String hora;

    @Column(name = "idBitacora")
    private String idBitacota;

    @Column(name = "idCaseta")
    private String idCaseta;

    @Column(name = "idCuentaContable")
    private String idCuentaContable;

    @Column(name = "idOrigen")
    private String idOrigen;

    @Column(name = "idProveedor")
    private String idProveedor;

    @Column(name = "idViaje")
    private String idViaje;

    @Column(name = "Importe")
    private Double importe;

    @Column(name = "ImporteAbono")
    private Double importeAbono;

    @Column(name = "ImporteGasto")
    private Double importeGasto;

    @Column(name = "ImporteOperador")
    private Double importeOperador;

    @Column(name = "ImporteUnitario")
    private Double importeUnitario;

    @Column(name = "Iva")
    private Double iva;

    @Column(name = "MainTable")
    private String mainTable;

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
    private Integer tasaIva;

    @Column(name = "TasaRet")
    private Integer tasaRet;

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
    private Date zzFechaCreo;

    @Column(name = "ZzFechaModifico")
    private Date zzFechaModifico;

    @Column(name = "ZzHoraCreo")
    private String zzHoraCreo;

    @Column(name = "ZzHoraModifico")
    private String zzHoraModifico;

    @Column(name = "ZzQuienCreo")
    private String zzQuienCreo;

    @Column(name = "ZzQuienModifico")
    private String zzQuienModifico;

    @Column(name = "viajeCompleto")
    private String viajeCompleto;

}
