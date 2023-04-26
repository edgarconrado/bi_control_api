package com.belz.bicontrolapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
@Table(name = "saf_anticipos")
@Entity
public class SafAnticipos {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "Banco")
    private String banco;

    @Column(name = "Bitacora")
    private String bitacora;

    @Column(name = "Concepto")
    private String concepto;

    @Column(name = "ConceptoCuenta")
    private String conceptoCuenta;

    @Column(name = "Destino")
    private String destino;

    @Column(name = "EBanco")
    private String eBanco;

    @Column(name = "ECuentabancaria")
    private String eCuentaBancaria;
    @Column(name = "Equipo")
    private String equipo;

    @Column(name = "ESucursal")
    private String eSucursal;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "Folio")
    private Integer folio;

    @Column(name = "idBitacora")
    private String idBitacora;

    @Column(name = "idCuentaBancariaE")
    private String idCuentabancariaE;

    @Column(name = "idCuentaBancariaP")
    private String idCuentaBancariaP;

    @Column(name = "idCuentaContable")
    private String idCuentaContable;

    @Column(name = "idDepositoBanco")
    private String idDepositoBanco;

    @Column(name = "idEmpresa")
    private String idEmpresa;

    @Column(name = "idPersonal")
    private String idPersonal;

    @Column(name = "idViaje")
    private String idViaje;

    @Column(name = "Importe")
    private String importe;

    @Column(name = "ImporteLetra")
    private String importeLetra;

    @Column(name = "Motivo")
    private String motivo;

    @Column(name = "Origen")
    private String origen;

    @Column(name = "PBanco")
    private String pBanco;

    @Column(name = "PCuentabancaria")
    private String pCuentaBancaria;

    @Column(name = "Portador")
    private String portador;

    @Column(name = "RazonSocial")
    private String razonSocial;

    @Column(name = "Referencia")
    private String referencia;

    @Column(name = "Rfc")
    private String rfc;

    @Column(name = "Status")
    private String status;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "Tracto")
    private String tracto;

    @Column(name = "Transferencia")
    private String Transferencia;

    @Column(name = "Viaje")
    private Integer viaje;

}
