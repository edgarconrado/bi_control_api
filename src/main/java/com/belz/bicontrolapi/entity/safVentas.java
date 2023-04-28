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
@Table(name = "saf_ventas")
@Entity
public class safVentas {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "Cliente")
    private String cliente;

    @Column(name = "Concpeto")
    private String concepto;

    @Column(name = "Contenedor")
    private String contenedor;

    @Column(name = "Factura")
    private String factura;

    @Column(name = "FFactura")
    private Date fFactura;

    @Column(name = "FSalidaViaje")
    private Date fSalidaViaje;

    @Column(name = "idBitacora")
    private String idBitacora;

    @Column(name = "idCliente")
    private String idCliente;

    @Column(name = "idComprobanteFiscal")
    private String idComprobanteFiscal;

    @Column(name = "idCuentaContable")
    private String idCuentaContable;

    @Column(name = "idOrdenCarga")
    private String idOrdenCarga;

    @Column(name = "idOrdenCargaSub")
    private String idOrdenCargaSub;

    @Column(name = "idOrigen")
    private String idOrigen;

    @Column(name = "idTarifa")
    private String idTarifa;

    @Column(name = "Importe")
    private Double importe;

    @Column(name = "Iva")
    private Double iva;

    @Column(name = "OrdenCarga")
    private String ordenCarga;

    @Column(name = "ProfitLoss")
    private Integer profitLoss;

    @Column(name = "Referencia")
    private String referencias;

    @Column(name = "Retencion")
    private Integer retencion;

    @Column(name = "StatusFactura")
    private String statusFactura;

    @Column(name = "TasaIva\t")
    private Integer tasaIva;

    @Column(name = "TasaRetencion")
    private Integer tasaRetencion;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "Total")
    private Double total;

    @Column(name = "FTermino_ok")
    private String fTermino_ok;
}
