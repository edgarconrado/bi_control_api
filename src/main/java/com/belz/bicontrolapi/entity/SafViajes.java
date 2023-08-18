package com.belz.bicontrolapi.entity;

import com.belz.bicontrolapi.util.annotations.CommonConstructor;
import com.belz.bicontrolapi.util.annotations.OrderCustom;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity(name = "saf_viajes")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "saf_viajes")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class SafViajes {

    @Id
    @OrderCustom
    @Column(name = "id")
    private String id;

    @Column(name = "Bitacora")
    private String bitacora;

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

    @CommonConstructor
    public SafViajes(String id, String bitacora, String contenedores, String destino, Date fDespacho, Date fEntrada, Date fPlanta, Date fRetorno, Date fSalidaViaje, Date fTermino, String hEntrada, String hPlanta, String hRetorno, String hSalidaViaje, String hTermino, String idBitacora, String idEquipoM, String idEquipoU, String idOrdenCarga, String idPersonal, String idProveedor, String idRutaDV, String idRutaOD, String idTipoViaje, String idViaje, Double importe, Integer kilometrosVia, Integer kmSalida, String nombreOperador, String notas, Integer nTipo, String numeroUnidad, String numeroUnidadU, String origen, String placas, String planta, String proveedor, Integer solicitud, String status, String tipo, String tipoEquipo, String vacio, String viaDV, Integer viaje, String viaOD, Date fTerminoOk) {
        this.id = id;
        this.bitacora = bitacora;
        this.contenedores = contenedores;
        this.destino = destino;
        this.fDespacho = fDespacho;
        this.fEntrada = fEntrada;
        this.fPlanta = fPlanta;
        this.fRetorno = fRetorno;
        this.fSalidaViaje = fSalidaViaje;
        this.fTermino = fTermino;
        this.hEntrada = hEntrada;
        this.hPlanta = hPlanta;
        this.hRetorno = hRetorno;
        this.hSalidaViaje = hSalidaViaje;
        this.hTermino = hTermino;
        this.idBitacora = idBitacora;
        this.idEquipoM = idEquipoM;
        this.idEquipoU = idEquipoU;
        this.idOrdenCarga = idOrdenCarga;
        this.idPersonal = idPersonal;
        this.idProveedor = idProveedor;
        this.idRutaDV = idRutaDV;
        this.idRutaOD = idRutaOD;
        this.idTipoViaje = idTipoViaje;
        this.idViaje = idViaje;
        this.importe = importe;
        this.kilometrosVia = kilometrosVia;
        this.kmSalida = kmSalida;
        this.nombreOperador = nombreOperador;
        this.notas = notas;
        this.nTipo = nTipo;
        this.numeroUnidad = numeroUnidad;
        this.numeroUnidadU = numeroUnidadU;
        this.origen = origen;
        this.placas = placas;
        this.planta = planta;
        this.proveedor = proveedor;
        this.solicitud = solicitud;
        this.status = status;
        this.tipo = tipo;
        this.tipoEquipo = tipoEquipo;
        this.vacio = vacio;
        this.viaDV = viaDV;
        this.viaje = viaje;
        this.viaOD = viaOD;
        this.fTerminoOk = fTerminoOk;
    }
}
