package com.belz.bicontrolapi.entity;

import jakarta.persistence.Entity;
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
public class safUnidades {

    private Long idUnidades;
    private String unidadId;
    private Integer dimension;
    private String divisa;
    private Date fechaAdquisicion;
    private Date fechaServicio;
    private String importeUnidad;
    private Integer kmServicio;
    private String marca;
    private String modelo;
    private String motivoBaja;
    private String motor;
    private String numeroUnidad;
    private String numFactura;
    private Integer numLlantas;
    private String numMotor;
    private String numSerie;
    private String placas;
    private String proveedor;
    private String rendimientoCargado;
    private String rendimientoVacio;
    private String segmentoNegocio;
    private String servicio;
    private String status;
    private String statusTaller;
    private String tipoAdquisicion;
    private String valorContable;
    private String valorDepreciacion;
    private Integer years;
    private Integer yearsDepreciacion;
    private Integer yearsRestantes;
}
