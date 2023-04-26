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
@Table(name = "saf_fletes")
@Entity
public class SafFletes {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "Cliente")
    private String cliente;

    @Column(name = "Contenedor")
    private String contenedor;

    @Column(name = "Destino")
    private String destino;

    @Column(name = "FSalida")
    private Date fSalida;

    @Column(name = "idEquipo")
    private String idEquipo;

    @Column(name = "idOrdenCarga")
    private String idOrdenCarga;

    @Column(name = "idPersonal")
    private String idPersonal;

    @Column(name = "idVerificacion")
    private String idVerificacion;

    @Column(name = "idViaje")
    private String idViaje;

    @Column(name = "KmViaje")
    private Integer kmViaje;

    @Column(name = "NombreOperador")
    private String nombreOperador;

    @Column(name = "NumeroUnidad")
    private String nombreUnidad;

    @Column(name = "Origen")
    private String origen;

    @Column(name = "Peso")
    private Integer peso;

    @Column(name = "PlacasUnidad")
    private String placasUnidad;

    @Column(name = "SubCliente")
    private String subCliente;

    @Column(name = "Tarifa")
    private Double tarifa;

    @Column(name = "TipoViaje")
    private String tipoViaje;

    @Column(name = "Vacio")
    private String vacio;

    @Column(name = "Viaje")
    private Integer viaje;

}
