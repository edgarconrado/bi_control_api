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
@Table(name = "saf_unidades")
@Entity
public class SafUnidades {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "Dimension")
    private Integer dimension;

    @Column(name = "Divisa")
    private String divisa;

    @Column(name = "FechaAdquisicion")
    private Date fechaAdquisicion;

    @Column(name = "FechaServicio")
    private Date fechaServicio;

    @Column(name = "ImporteUnidad")
    private String importeUnidad;

    @Column(name = "KmServicio")
    private Integer kmServicio;

    @Column(name = "Marca")
    private String marca;

    @Column(name = "Modelo")
    private String modelo;

    @Column(name = "MotivoBaja")
    private String motivoBaja;

    @Column(name = "Motor")
    private String motor;

    @Column(name = "NumeroUnidad")
    private String numeroUnidad;

    @Column(name = "NumFactura")
    private String numFactura;

    @Column(name = "NumLlantas")
    private Integer numLlantas;

    @Column(name = "NumMotor")
    private String numMotor;

    @Column(name = "NumSerie")
    private String numSerie;

    @Column(name = "Placas")
    private String placas;

    @Column(name = "Proveedor")
    private String proveedor;

    @Column(name = "RendimientoCargado")
    private String rendimientoCargado;

    @Column(name = "RendimientoVacio")
    private String rendimientoVacio;

    @Column(name = "SegmentoNegocio")
    private String segmentoNegocio;

    @Column(name = "Servicio")
    private String servicio;

    @Column(name = "Status")
    private String status;

    @Column(name = "StatusTaller")
    private String statusTaller;

    @Column(name = "TipoAdquisicion")
    private String tipoAdquisicion;

    @Column(name = "TipoEquipo")
    private String tipoEquipo;

    @Column(name = "ValorContable")
    private String valorContable;

    @Column(name = "ValorDepreciacion")
    private String valorDepreciacion;

    @Column(name = "Years")
    private Integer years;

    @Column(name = "YearsDepreciacion")
    private Integer yearsDepreciacion;

    @Column(name = "YearsRestantes")
    private Integer yearsRestantes;
}

