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
@Table(name = "saf_viajes")
@Entity
public class SafViajes {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "Bitacora")
    private String bitacota;

    @Column(name = "Contenedores")
    private String contenedores;

    @Column(name = "Destino")
    private String destino;
    @Column(name = "FDespacho")
    private Date fDespacho;

    @Column(name = "FEntrada")
    private Date fEntrada;

    @Column(name = "FPlanta")
    private Date fPlanta;

    @Column(name = "FRetorno")
    private Date fRetorno;

    @Column(name = "FSalidaViaje")
    private Date fSalidaViaje;

    @Column(name = "FTermino")
    private Date fTermino;

    @Column(name = "HEntrada")
    private String hEntrada;

    @Column(name = "HPlanta")
    private String hPlanta;

    @Column(name = "HRetorno")
    private String hRetorno;

    @Column(name = "HSalidaViaje")
    private String hSalidaViaje;

    @Column(name = "HTermino")
    private String hTermino;

    @Column(name = "idBitacora")
    private String idBitacora;

    @Column(name = "idEquipoM")
    private String idEquipoM;

    @Column(name = "idEquipoU")
    private String idEquipoU;

    @Column(name = "idOrdenCarga")
    private String idOrdenCarga;

    @Column(name = "idPersonal")
    private String idPersonal;

    @Column(name = "idProveedor")
    private String idProveedor;

    @Column(name = "idRutaDV")
    private String idRutaDV;

    @Column(name = "idRutaOD")
    private String idRutaOD;

    @Column(name = "idTipoViaje")
    private String idTipoViaje;

    @Column(name = "idViaje")
    private String idViaje;

    @Column(name = "Importe")
    private Double importe;

    @Column(name = "KilometrosVia")
    private Integer kilometrosVia;

    @Column(name = "kmSalida")
    private Integer kmSalida;

    @Column(name = "NombreOperador")
    private String nombreOperador;

    @Column(name = "Notas")
    private String notas;

    @Column(name = "NTipo")
    private Integer nTipo;

    @Column(name = "NumeroUnidad")
    private String numeroUnidad;

    @Column(name = "NumeroUnidadU")
    private String numeroUnidadU;

    @Column(name = "Origen")
    private String origen;

    @Column(name = "Placas")
    private String placas;

    @Column(name = "Planta")
    private String planta;

    @Column(name = "Proveedor")
    private String proveedor;

    @Column(name = "Solicitud")
    private Integer solicitud;

    @Column(name = "Status")
    private String status;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "TipoEquipo")
    private String tipoEquipo;

    @Column(name = "Vacio")
    private String vacio;

    @Column(name = "ViaDV")
    private String viaDV;

    @Column(name = "Viaje")
    private Integer viaje;

    @Column(name = "ViaOD")
    private String viaOD;

    @Column(name = "FTermino_ok")
    private Date fTerminoOk;

}
