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
@Table(name = "saf_combustible")
@Entity
public class SafCombustible {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "Combustible")
    private String combustible;

    @Column(name = "Comentarios")
    private String comentarios;

    @Column(name = "CostoLitro")
    private String costoLitro;

    @Column(name = "Despachador")
    private String despachador;

    @Column(name = "Embarque")
    private String embarque;

    @Column(name = "Equipo")
    private String equipo;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "FechaCarga")
    private Date fechaCarga;

    @Column(name = "Folio")
    private Integer folio;

    @Column(name = "Folios")
    private Integer folios;

    @Column(name = "HoraCarga")
    private String horaCarga;

    @Column(name = "idBitacora")
    private String idBitacora;

    @Column(name = "idDespachador")
    private String idDespachador;

    @Column(name = "idEquipo")
    private String idEquipo;

    @Column(name = "idOficina")
    private String idOficina;

    @Column(name = "idOperador")
    private String idOperador;

    @Column(name = "idProveedor")
    private String idProveedor;

    @Column(name = "idViaje")
    private String idViaje;

    @Column(name = "Importe")
    private Double importe;

    @Column(name = "ImporteLetra")
    private String importeletra;

    @Column(name = "Incremental")
    private Integer incremental;

    @Column(name = "LitrosDespachados")
    private String litrosDespachados;

    @Column(name = "Mes")
    private Integer mes;

    @Column(name = "Operador")
    private String operador;

    @Column(name = "PatioOrigen")
    private String patioOrigen;

    @Column(name = "Placas")
    private String placas;

    @Column(name = "Proveedor")
    private String proveedor;

    @Column(name = "Semana")
    private Integer semana;

    @Column(name = "Status")
    private String status;

    @Column(name = "Tipo")
    private String tipo;
}

