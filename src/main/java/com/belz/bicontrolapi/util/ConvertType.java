package com.belz.bicontrolapi.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ConvertType {

    // Función para convertir objetos a Integer de manera segura
    public Integer parseInteger(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        } else if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException e) {
                // Manejar la excepción si el valor no es numérico
                return null; // O algún valor predeterminado apropiado para tu caso
            }
        } else {
            return null; // O algún valor predeterminado apropiado para tu caso
        }
    }


    // Función para convertir objetos a Double de manera segura
    public Double parseDouble(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        } else if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        } else if (obj instanceof String) {
            try {
                return Double.parseDouble((String) obj);
            } catch (NumberFormatException e) {
                // Manejar la excepción si el valor no es numérico
                return null; // O algún valor predeterminado apropiado para tu caso
            }
        } else {
            return null; // O algún valor predeterminado apropiado para tu caso
        }
    }

    // Función para convertir objetos a Date de manera segura
    public Date parseDate(Object obj) {
        if (obj instanceof Date) {
            return (Date) obj;
        } else if (obj instanceof String) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Cambiar el formato según el que tengas en la base de datos
                return dateFormat.parse((String) obj);
            } catch (ParseException e) {
                // Manejar la excepción si el valor no es una fecha válida
                return null; // O alguna fecha predeterminada apropiada para tu caso
            }
        } else {
            return null; // O alguna fecha predeterminada apropiada para tu caso
        }
    }
}
