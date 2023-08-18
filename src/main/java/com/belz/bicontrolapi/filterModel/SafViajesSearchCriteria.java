package com.belz.bicontrolapi.filterModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SafViajesSearchCriteria {
    private String id;
    private String bitacora;
    private String contenedores;
    private String destino;
    private Date fDespacho;
    private Date fEntrada;
    private Date fPlanta;
    private Date fRetorno;
    private Date fSalidaViaje;
    private Date fTermino;
    private String hEntrada;
    private String hPlanta;
    private String hRetorno;
    private String hSalidaViaje;
    private String hTermino;
    private String idBitacora;
    private String idEquipoM;
    private String idEquipoU;
    private String idOrdenCarga;
    private String idPersonal;
    private String idProveedor;
    private String idRutaDV;
    private String idRutaOD;
    private String idTipoViaje;
    private String idViaje;
    private Double importe;
    private Integer kilometrosVia;
    private Integer kmSalida;
    private String nombreOperador;
    private String notas;
    private Integer nTipo;
    private String numeroUnidad;
    private String numeroUnidadU;
    private String origen;
    private String placas;
    private String planta;
    private String proveedor;
    private Integer solicitud;
    private String status;
    private String tipo;
    private String tipoEquipo;
    private String vacio;
    private String viaDV;
    private Integer viaje;
    private String viaOD;
    private Date fTerminoOk;
}
