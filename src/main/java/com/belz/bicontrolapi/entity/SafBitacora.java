package com.belz.bicontrolapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Table(name = "saf_bitacora")
@Entity
public class SafBitacora {

    private Long idBitacora;
    private Integer bitacora;
    private Integer bitacoraF;
    private String idPersonal;
    private String nombreOperador;
    private String numeroOperador;
    private Double salarioDiario;
    private Double sueldoBase;
    private String tipoeEquipo;
    private String status;
    private Date fTerminoViaje;
    private String anticipos;
    private String cierreAnno;
    private String cierreMes;
    private String conceptoConta;
    private String configuracion;
    private String cuentaOperador;
    private String dieselEfectivo;
    private String factorRendimiento;
    private String gastosComprobados;
    private String idEquipo;
    private String loquidacion;
    private String nota;
    private String numeroUnidad;
    private String placas;
    private String porPagarLetra;
    private String segmento;
    private String viajes;
    private Double convenioSeguro;
    private String formaPagoOperador;
    private Double kmAnterior;
    private Double kmFinal;
    private Double kmRecorridos;
    private Double kmSalida;
    private Double lCombustible;
    private Double lDiferencia;
    private Double litrosCargados;
    private Double lKilometros;
    private Double lLitrosCombustible;
    private Double lOverSpeed1;
    private Double lOverSpeed2;
    private Double lpto;
    private Double lRalenti;
    private Double lRendimiento;
    private Double lRevolucionesMax;
    private Double lVolocidadMax;
    private Double montoDiario;
    private Double montoImss;
    private Double pero;
    private Double peroEfectivo;
    private Double semana;
    private Double sueldo;
    private Double sueldoDiario;
    private Double sueldoOperador;
    private Double termino;
    private Date fecha;
    private Date fSalida;
    private String cuentaContpaq;
    private String equipos;
    private String ref;
    private String zzQuienCreo;
    private Date zzFEchaCreo;
    private String zzHoraCreo;

}
