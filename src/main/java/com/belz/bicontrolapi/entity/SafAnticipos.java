package com.belz.bicontrolapi.entity;

import com.belz.bicontrolapi.util.annotations.CommonConstructor;
import com.belz.bicontrolapi.util.annotations.OrderCustom;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "saf_anticipos")
@Setter
@Getter
@ToString
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)

public class SafAnticipos {

    @Id
    @OrderCustom
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

    @Column(name = "Cuentabancaria")
    private String CuentaBancaria;

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

    @CommonConstructor
    public SafAnticipos(String id, String banco, String bitacora, String concepto, String conceptoCuenta, String destino, String eBanco, String eCuentaBancaria, String equipo, String eSucursal, Date fecha, Integer folio, String idBitacora, String idCuentabancariaE, String idCuentaBancariaP, String idCuentaContable, String idDepositoBanco, String idEmpresa, String idPersonal, String idViaje, String importe, String importeLetra, String motivo, String origen, String pBanco, String cuentaBancaria, String portador, String razonSocial, String referencia, String rfc, String status, String tipo, String tracto, String transferencia, Integer viaje) {
        this.id = id;
        this.banco = banco;
        this.bitacora = bitacora;
        this.concepto = concepto;
        this.conceptoCuenta = conceptoCuenta;
        this.destino = destino;
        this.eBanco = eBanco;
        this.eCuentaBancaria = eCuentaBancaria;
        this.equipo = equipo;
        this.eSucursal = eSucursal;
        this.fecha = fecha;
        this.folio = folio;
        this.idBitacora = idBitacora;
        this.idCuentabancariaE = idCuentabancariaE;
        this.idCuentaBancariaP = idCuentaBancariaP;
        this.idCuentaContable = idCuentaContable;
        this.idDepositoBanco = idDepositoBanco;
        this.idEmpresa = idEmpresa;
        this.idPersonal = idPersonal;
        this.idViaje = idViaje;
        this.importe = importe;
        this.importeLetra = importeLetra;
        this.motivo = motivo;
        this.origen = origen;
        this.pBanco = pBanco;
        CuentaBancaria = cuentaBancaria;
        this.portador = portador;
        this.razonSocial = razonSocial;
        this.referencia = referencia;
        this.rfc = rfc;
        this.status = status;
        this.tipo = tipo;
        this.tracto = tracto;
        Transferencia = transferencia;
        this.viaje = viaje;
    }
}
