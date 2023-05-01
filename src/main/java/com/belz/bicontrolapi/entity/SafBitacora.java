package com.belz.bicontrolapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "Bitacora")
    private Integer bitacora;

    @Column(name = "BitacoraF")
    private Integer bitacoraF;

    @Column(name = "idPersonal")
    private String idPersonal;

    @Column(name = "NombreOperador")
    private String nombreOperador;

    @Column(name = "NumeroOperador")
    private String numeroOperador;

    @Column(name = "SalarioDiario")
    private Double salarioDiario;

    @Column(name = "SueldoBase")
    private Double sueldoBase;

    @Column(name = "TipoEquipo")
    private String tipoeEquipo;

    @Column(name = "Status")
    private String status;

    @Column(name = "FTerminoViaje")
    private Date fTerminoViaje;

    @Column(name = "Anticipos")
    private String anticipos;

    @Column(name = "CierreAnno")
    private String cierreAnno;

    @Column(name = "CierreMes")
    private String cierreMes;

    @Column(name = "ConceptoConta")
    private String conceptoConta;

    @Column(name = "Configuracion")
    private String configuracion;

    @Column(name = "CuentaOperador")
    private String cuentaOperador;

    @Column(name = "DieselEfectivo")
    private String dieselEfectivo;

    @Column(name = "FactorRendimiento")
    private String factorRendimiento;

    @Column(name = "GastosComprobados")
    private String gastosComprobados;

    @Column(name = "idEquipo")
    private String idEquipo;

    @Column(name = "Liquidacion")
    private String liquidacion;

    @Column(name = "Nota")
    private String nota;

    @Column(name = "NumeroUnidad")
    private String numeroUnidad;

    @Column(name = "Placas")
    private String placas;

    @Column(name = "PorPagarLetra")
    private String porPagarLetra;

    @Column(name = "Segmento")
    private String segmento;

    @Column(name = "Viajes")
    private String viajes;

    @Column(name = "ConvenioSeguro")
    private Double convenioSeguro;

    @Column(name = "FormaPagoOperador")
    private String formaPagoOperador;

    @Column(name = "KmAnetrior")
    private Double kmAnterior;

    @Column(name = "kmFinal")
    private Double kmFinal;

    @Column(name = "kmRecoridos")
    private Double kmRecorridos;

    @Column(name = "KmSalida")
    private Double kmSalida;

    @Column(name = "LCombustible")
    private Double lCombustible;

    @Column(name = "LDiferencia")
    private Double lDiferencia;

    @Column(name = "LitrosCargados")
    private Double litrosCargados;

    @Column(name = "LKilometros")
    private Double lKilometros;

    @Column(name = "LLitrosCombustible")
    private Double lLitrosCombustible;

    @Column(name = "LOverSpeed1")
    private Double lOverSpeed1;

    @Column(name = "LOverSpeed2")
    private Double lOverSpeed2;

    @Column(name = "LPTO")
    private Double lpto;

    @Column(name = "LRalenti")
    private Double lRalenti;

    @Column(name = "LRendimeinto")
    private Double lRendimiento;

    @Column(name = "LRevolucionesMax")
    private Double lRevolucionesMax;

    @Column(name = "LVelocidadMax")
    private Double lVolocidadMax;

    @Column(name = "MontoDiario")
    private Double montoDiario;

    @Column(name = "MontoIMSS")
    private Double montoImss;

    @Column(name = "Peso")
    private Double pero;

    @Column(name = "PisasEfectivo")
    private Double peroEfectivo;

    @Column(name = "Semana")
    private Double semana;

    @Column(name = "Sueldo")
    private Double sueldo;

    @Column(name = "SueldoDiario")
    private Double sueldoDiario;

    @Column(name = "SueldoOperador")
    private Double sueldoOperador;

    @Column(name = "Termino")
    private Double termino;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "Fsalida")
    private Date fSalida;

    @Column(name = "CuentaContpaq")
    private String cuentaContpaq;

    @Column(name = "Equipos")
    private String equipos;

    @Column(name = "Ref")
    private String ref;

    @Column(name = "ZzQuienCreo")
    private String zzQuienCreo;

    @Column(name = "ZzFechaCreo")
    private Date zzFEchaCreo;

    @Column(name = "ZzHoraCreo")
    private String zzHoraCreo;

}

