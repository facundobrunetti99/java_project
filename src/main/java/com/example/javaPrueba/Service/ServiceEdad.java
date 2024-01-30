package com.example.javaPrueba.Service;
import com.example.javaPrueba.Models.Cliente;
import java.time.LocalDate;
import java.time.Month;

public  class ServiceEdad extends Cliente  {

    public void edadPersona(Cliente cliente) {
                int diaNac = cliente.getFehcanac().getDayOfMonth();
                Month mes;
                mes = cliente.getFehcanac().getMonth();
                int mesNac = mes.getValue();
                int añoNac = cliente.getFehcanac().getYear();
                LocalDate fechaActual = LocalDate.now();
                int añoActual = fechaActual.getYear();
                Month mesActualMonth = fechaActual.getMonth();
                int mesActual = mesActualMonth.getValue();
                int diaActual = fechaActual.getDayOfMonth();

                /*12/1/1999 29/1/2024*/

                int edadOp = 0;
                int mesOp = mesActual - mesNac;
                int diaOp = diaActual - diaNac;

                if (mesOp == 0) {/*--0 Se ecnuentra en el mes de cumpleaños*/
                    if (diaOp > 0) {/*--17 Ya fue su cumpeaños*/
                        edadOp = añoActual - añoNac;/*2024-1999=25*/
                    }
                    if (diaOp == 0 || diaOp < 0) {/*se le resta 1. ((2024-1999)=25 -- (25-1)=24) si todavia no cumple años*/
                        edadOp = añoActual - añoNac - 1;
                    }
                }
                if (mesOp < 0) {
                    edadOp = añoActual - añoNac - 1;
                }
                if (mesOp > 0) {
                    edadOp = añoActual - añoNac;
                }
                cliente.setEdad(edadOp);/*25--En este caso, añado edadOp(25) al cliente, donde es el resultado de la operacion*/

    }






}

