
package model;

import java.time.LocalDate;
import java.util.List;

public class VehiculoCompacto extends Vehiculo {
        private int anio;

        public VehiculoCompacto(int anio, String codigoVehiculo, String modelo, double precioBase, EstadoVehiculo estadoV, List<String> historialReparaciones) {
                 super(codigoVehiculo, modelo, precioBase, estadoV, historialReparaciones);
                 this.anio = anio;
        }

        public int getAnio() {
                 return anio;
        }

        public void setAnio(int anio) {
                 this.anio = anio;
        }

//    public double getPrecioBase() {
//        return precioBase;
//    }
//
//    public void setPrecioBase(double precioBase) {
//        this.precioBase = precioBase;
//    }
//        
        public boolean esVehiculoNuevo(){
                int anioActual = LocalDate.now().getYear();
                
                 return this.anio == anioActual; 
                }
        
        @Override
        public int calcularCostoReparacion(int horas) {
                 double costoFinal;
                 if (esVehiculoNuevo()){
                         double precioDescuento = (this.precioBase * 5)/ 100;
                         costoFinal = (this.precioBase * horas) - precioDescuento;
                } else {
                         costoFinal = this.precioBase * horas;
                } 
                 return (int)costoFinal;
        }
        
}
