package com.belz.bicontrol.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.DatabindException;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="saf_unidades")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@id"
)
public class SafUnidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String unidadId;
    private  int dimension;
    private String divisa;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYY-MM-dd")
    private Date fechaAdquisicion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYY-MM-dd")
    private Date fechaServicio;
    private String importeUnidad;
    private int kmServicio;
    private  String marca;
    private String modelo;
    private String motivoBaja;
    private String motor;
    private String numeroUnidad;
    private String numFactura;
    private int numLlantas;
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
    private int years;
    private int yearsDepreciacion;
    private int yearsRestantes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnidadId() {
        return unidadId;
    }

    public void setUnidadId(String unidadId) {
        this.unidadId = unidadId;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public String getImporteUnidad() {
        return importeUnidad;
    }

    public void setImporteUnidad(String importeUnidad) {
        this.importeUnidad = importeUnidad;
    }

    public int getKmServicio() {
        return kmServicio;
    }

    public void setKmServicio(int kmServicio) {
        this.kmServicio = kmServicio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotivoBaja() {
        return motivoBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getNumeroUnidad() {
        return numeroUnidad;
    }

    public void setNumeroUnidad(String numeroUnidad) {
        this.numeroUnidad = numeroUnidad;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public int getNumLlantas() {
        return numLlantas;
    }

    public void setNumLlantas(int numLlantas) {
        this.numLlantas = numLlantas;
    }

    public String getNumMotor() {
        return numMotor;
    }

    public void setNumMotor(String numMotor) {
        this.numMotor = numMotor;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getRendimientoCargado() {
        return rendimientoCargado;
    }

    public void setRendimientoCargado(String rendimientoCargado) {
        this.rendimientoCargado = rendimientoCargado;
    }

    public String getRendimientoVacio() {
        return rendimientoVacio;
    }

    public void setRendimientoVacio(String rendimientoVacio) {
        this.rendimientoVacio = rendimientoVacio;
    }

    public String getSegmentoNegocio() {
        return segmentoNegocio;
    }

    public void setSegmentoNegocio(String segmentoNegocio) {
        this.segmentoNegocio = segmentoNegocio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusTaller() {
        return statusTaller;
    }

    public void setStatusTaller(String statusTaller) {
        this.statusTaller = statusTaller;
    }

    public String getTipoAdquisicion() {
        return tipoAdquisicion;
    }

    public void setTipoAdquisicion(String tipoAdquisicion) {
        this.tipoAdquisicion = tipoAdquisicion;
    }

    public String getValorContable() {
        return valorContable;
    }

    public void setValorContable(String valorContable) {
        this.valorContable = valorContable;
    }

    public String getValorDepreciacion() {
        return valorDepreciacion;
    }

    public void setValorDepreciacion(String valorDepreciacion) {
        this.valorDepreciacion = valorDepreciacion;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getYearsDepreciacion() {
        return yearsDepreciacion;
    }

    public void setYearsDepreciacion(int yearsDepreciacion) {
        this.yearsDepreciacion = yearsDepreciacion;
    }

    public int getYearsRestantes() {
        return yearsRestantes;
    }

    public void setYearsRestantes(int yearsRestantes) {
        this.yearsRestantes = yearsRestantes;
    }

    public SafUnidades(Long id, String unidadId, int dimension, String divisa, Date fechaAdquisicion, Date fechaServicio, String importeUnidad, int kmServicio, String marca, String modelo, String motivoBaja, String motor, String numeroUnidad, String numFactura, int numLlantas, String numMotor, String numSerie, String placas, String proveedor, String rendimientoCargado, String rendimientoVacio, String segmentoNegocio, String servicio, String status, String statusTaller, String tipoAdquisicion, String valorContable, String valorDepreciacion, int years, int yearsDepreciacion, int yearsRestantes) {
        this.id = id;
        this.unidadId = unidadId;
        this.dimension = dimension;
        this.divisa = divisa;
        this.fechaAdquisicion = fechaAdquisicion;
        this.fechaServicio = fechaServicio;
        this.importeUnidad = importeUnidad;
        this.kmServicio = kmServicio;
        this.marca = marca;
        this.modelo = modelo;
        this.motivoBaja = motivoBaja;
        this.motor = motor;
        this.numeroUnidad = numeroUnidad;
        this.numFactura = numFactura;
        this.numLlantas = numLlantas;
        this.numMotor = numMotor;
        this.numSerie = numSerie;
        this.placas = placas;
        this.proveedor = proveedor;
        this.rendimientoCargado = rendimientoCargado;
        this.rendimientoVacio = rendimientoVacio;
        this.segmentoNegocio = segmentoNegocio;
        this.servicio = servicio;
        this.status = status;
        this.statusTaller = statusTaller;
        this.tipoAdquisicion = tipoAdquisicion;
        this.valorContable = valorContable;
        this.valorDepreciacion = valorDepreciacion;
        this.years = years;
        this.yearsDepreciacion = yearsDepreciacion;
        this.yearsRestantes = yearsRestantes;
    }
}
