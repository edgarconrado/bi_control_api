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
@Table(name = "saf_orden-carga")
@Entity
public class SafOrdenCarga {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "AgenteAduanal")
    private String agenteAduanal;

    @Column(name = "Booking")
    private String booking;

    @Column(name = "Cliente")
    private String cliente;

    @Column(name = "ClienteAlias")
    private String clienteAlias;

    @Column(name = "Contenedor")
    private String contenedor;

    @Column(name = "CriterioOrdenamiento")
    private Integer criterioOrdenamiento;

    @Column(name = "Cubicaje")
    private Integer cubicaje;

    @Column(name = "Descarga")
    private Integer descarga;

    @Column(name = "Destino")
    private String detino;

    @Column(name = "Entrega")
    private String entrega;

    @Column(name = "EquipoDespacho")
    private String equipoDespacho;

    @Column(name = "Evidencia")
    private String evidencia;

    @Column(name = "FCitaCliente")
    private Date fCitaCliente;

    @Column(name = "FCitaRecoleccion")
    private Date fCitaRecoleccion;

    @Column(name = "FCitaVacio")
    private Date fCitaVacio;

    @Column(name = "FDespacho")
    private Date fDespacho;

    @Column(name = "FEta")
    private Date fEta;

    @Column(name = "FLlegadaCliente")
    private Date fLlegadaCliente;

    @Column(name = "FProgramacion")
    private Date fProgramacion;

    @Column(name = "FRecoleccion")
    private Date fRecoleccion;

    @Column(name = "FSalidaCliente")
    private Date fSalidaCliente;

    @Column(name = "FSalidaReocoleccion")
    private Date fSalidaReocoleccion;

    @Column(name = "FSalidaVacio")
    private Date fSalidaVacio;

    @Column(name = "FSalidaViaje")
    private Date fSalidaViaje;

    @Column(name = "FSolicitudReocoleccion")
    private Date fSolicitudReocoleccion;

    @Column(name = "FSolicitudVacio")
    private Date fSolicitudVacio;

    @Column(name = "FTermino")
    private Date fTermino;

    @Column(name = "FVacio")
    private Date fVacio;

    @Column(name = "HCitaCliente")
    private String hCitaCliente;

    @Column(name = "HCitaRecoleccion")
    private String hCitaRecoleccion;

    @Column(name = "HCitaVacio")
    private String hCitaVacio;

    @Column(name = "HEta")
    private String hEta;

    @Column(name = "HLlegadaCliente")
    private String hLlegadaCliente;

    @Column(name = "HRecoleccion")
    private String hRecoleccion;

    @Column(name = "HSalidaCliente")
    private String hSalidaCliente;

    @Column(name = "HSalidaReocoleccion")
    private String hSalidaReocoleccion;

    @Column(name = "HSalidaVacio")
    private String hSalidaVacio;

    @Column(name = "HSalidaViaje")
    private String hSalidaViaje;

    @Column(name = "HSolicitudReocoleccion")
    private String hSolicitudReocoleccion;

    @Column(name = "HSolicitudVacio")
    private String hSolicitudVacio;

    @Column(name = "HTermino")
    private String hTermino;

    @Column(name = "HVacio")
    private String hVacio;

    @Column(name = "idAgenteAduanal")
    private String idAgenteAduanal;

    @Column(name = "idCliente")
    private String idCliente;

    @Column(name = "idEquipoDespacho")
    private String idEquipoDespacho;

    @Column(name = "idOrigen")
    private String idOrigen;

    @Column(name = "idPatioEntrega")
    private String idPatioEntrega;

    @Column(name = "idPatioRecolecta")
    private String idPatioRecolecta;

    @Column(name = "idProveedorEntrega")
    private String idProveedorEntrega;

    @Column(name = "idProveedorRecolecta")
    private String idProveedorRecolecta;

    @Column(name = "idRelacion")
    private String idRelacion;

    @Column(name = "idSubCliente")
    private String idSubCliente;

    @Column(name = "idTarifa")
    private String idTarifa;

    @Column(name = "ImpoExpo")
    private String ImpoExpo;

    @Column(name = "Instrucciones")
    private String Instrucciones;

    @Column(name = "Lavado")
    private String lavado;

    @Column(name = "MetrosCubicos")
    private Integer metrosCubicos;

    @Column(name = "NumeroOrden")
    private Integer numeroOrden;

    @Column(name = "NumeroOrdenAscendente")
    private Integer numeroOrdenAscendente;

    @Column(name = "NumeroOrdenCal")
    private String numeroOrdenCal;

    @Column(name = "NumeroOrdenDescendiente")
    private Integer numeroOrdenDescendiente;

    @Column(name = "Observaciones")
    private String observaciones;

    @Column(name = "Orden")
    private Integer orden;

    @Column(name = "OrdenamientoCampo")
    private String ordenamientoCampo;

    @Column(name = "OrdenAscendenteTexto")
    private String ordenAscendenteTexto;

    @Column(name = "OrdenDescendienteTexto")
    private String ordenDescendienteTexto;

    @Column(name = "Origen")
    private String origen;

    @Column(name = "PatioEntrega")
    private String patioEntrga;

    @Column(name = "PatioRecolecta")
    private String patioRecolecta;

    @Column(name = "Pesaje")
    private Integer pesaje;

    @Column(name = "Peso")
    private String peso;

    @Column(name = "Piso")
    private Integer piso;

    @Column(name = "PisoLugar")
    private String pisoLugar;

    @Column(name = "Proformado")
    private Integer proformado;

    @Column(name = "Programado")
    private Integer programado;

    @Column(name = "ProveedorRecolecta")
    private String proveedorRecolecta;

    @Column(name = "SeleccionarContenedor")
    private Integer seleccionarContenedor;

    @Column(name = "Sello")
    private String sello;

    @Column(name = "SubCliente")
    private String subCliente;

    @Column(name = "TarifaImporte")
    private String tarifaImporte;

    @Column(name = "TarifaRuta")
    private String tarifaRuta;

    @Column(name = "TipoCarga")
    private String tipoCarga;

    @Column(name = "TipoContenedor")
    private String tipoContenedor;

    @Column(name = "TipoOperacion")
    private String tipoOperacion;

    @Column(name = "TipoProfit")
    private String tipoProfit;

    @Column(name = "UsrActivo")
    private String usrActivo;
    @Column(name = "Vacio")
    private String vacio;

    @Column(name = "ViaDetino")
    private String viaDestino;

    @Column(name = "ViaVacio")
    private String viaVacio;
}
