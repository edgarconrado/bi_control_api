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

@Entity(name = "saf_bitacora-ptofit")
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class SafBitacoraPtofit {

    @Id
    @OrderCustom
    @Column(name = "id")
    private String id;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "Concepto")
    private String concepto;

    @Column(name = "ConceptoComp")
    private String  concepto_comp;

    @Column(name = "ConceptoContable")
    private String concepto_contable;

    @Column(name = "Cuenta")
    private String cuenta;

    @Column(name = "CuentaContpaq")
    private String cuenta_contpaq;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "Forma")
    private String forma;

    @Column(name = "Hora")
    private String hora;

    @Column(name = "idBitacora")
    private String id_bitacota;

    @Column(name = "idCaseta")
    private String id_caseta;

    @Column(name = "idCuentaContable")
    private String id_cuenta_contable;

    @Column(name = "idOrigen")
    private String id_origen;

    @Column(name = "idProveedor")
    private String id_proveedor;

    @Column(name = "idViaje")
    private String id_viaje;

    @Column(name = "Importe")
    private Double importe;

    @Column(name = "ImporteAbono")
    private Double importe_abono;

    @Column(name = "ImporteGasto")
    private Double importe_gasto;

    @Column(name = "ImporteOperador")
    private Double importe_operador;

    @Column(name = "ImporteUnitario")
    private Double importe_unitario;

    @Column(name = "Iva")
    private Double iva;

    @Column(name = "MainTable")
    private String main_table;

    @Column(name = "Prefijo")
    private String prefijo;

    @Column(name = "Proveedor")
    private String proveedor;

    @Column(name = "Ref")
    private String ref;

    @Column(name = "Referencia")
    private String referencia;

    @Column(name = "Retencion")
    private Integer retencion;
    @Column(name = "TasaIva")
    private Integer tasa_iva;

    @Column(name = "TasaRet")
    private Integer tasa_ret;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "Total")
    private Double total;

    @Column(name = "Transferencia")
    private String transferencia;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "Viaje")
    private String viaje;

    @Column(name = "ZzFechaCreo")
    private Date zz_fecha_creo;

    @Column(name = "ZzFechaModifico")
    private Date zz_fecha_modifico;

    @Column(name = "ZzHoraCreo")
    private String zz_hora_creo;

    @Column(name = "ZzHoraModifico")
    private String zz_hora_modifico;

    @Column(name = "ZzQuienCreo")
    private String zz_quien_creo;

    @Column(name = "ZzQuienModifico")
    private String zz_quien_modifico;

    @Column(name = "viajeCompleto")
    private String viaje_completo;

    @CommonConstructor
    public SafBitacoraPtofit(String id, Integer cantidad, String concepto, String concepto_comp, String concepto_contable, String cuenta, String cuenta_contpaq, Date fecha, String forma, String hora, String id_bitacota, String id_caseta, String id_cuenta_contable, String id_origen, String id_proveedor, String id_viaje, Double importe, Double importe_abono, Double importe_gasto, Double importe_operador, Double importe_unitario, Double iva, String main_table, String prefijo, String proveedor, String ref, String referencia, Integer retencion, Integer tasa_iva, Integer tasa_ret, String tipo, Double total, String transferencia, String uuid, String viaje, Date zz_fecha_creo, Date zz_fecha_modifico, String zz_hora_creo, String zz_hora_modifico, String zz_quien_creo, String zz_quien_modifico, String viaje_completo) {
        this.id = id;
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.concepto_comp = concepto_comp;
        this.concepto_contable = concepto_contable;
        this.cuenta = cuenta;
        this.cuenta_contpaq = cuenta_contpaq;
        this.fecha = fecha;
        this.forma = forma;
        this.hora = hora;
        this.id_bitacota = id_bitacota;
        this.id_caseta = id_caseta;
        this.id_cuenta_contable = id_cuenta_contable;
        this.id_origen = id_origen;
        this.id_proveedor = id_proveedor;
        this.id_viaje = id_viaje;
        this.importe = importe;
        this.importe_abono = importe_abono;
        this.importe_gasto = importe_gasto;
        this.importe_operador = importe_operador;
        this.importe_unitario = importe_unitario;
        this.iva = iva;
        this.main_table = main_table;
        this.prefijo = prefijo;
        this.proveedor = proveedor;
        this.ref = ref;
        this.referencia = referencia;
        this.retencion = retencion;
        this.tasa_iva = tasa_iva;
        this.tasa_ret = tasa_ret;
        this.tipo = tipo;
        this.total = total;
        this.transferencia = transferencia;
        this.uuid = uuid;
        this.viaje = viaje;
        this.zz_fecha_creo = zz_fecha_creo;
        this.zz_fecha_modifico = zz_fecha_modifico;
        this.zz_hora_creo = zz_hora_creo;
        this.zz_hora_modifico = zz_hora_modifico;
        this.zz_quien_creo = zz_quien_creo;
        this.zz_quien_modifico = zz_quien_modifico;
        this.viaje_completo = viaje_completo;
    }
}
