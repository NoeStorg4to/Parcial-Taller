
package model;

import java.util.List;

public class VehiculoSUV extends Vehiculo {
        private boolean traccionIntegral;

        public VehiculoSUV(boolean traccionIntegral, String codigoVehiculo,String modelo, double precioBase, EstadoVehiculo estadoV, List<String> historialReparaciones) {
                super(codigoVehiculo, modelo, precioBase, estadoV, historialReparaciones);
                this.traccionIntegral = traccionIntegral;
        }

    public boolean isTraccionIntegral() {
        return traccionIntegral;
    }

    public void setTraccionIntegral(boolean traccionIntegral) {
        this.traccionIntegral = traccionIntegral;
    }

        
         public boolean esTraccionIntegral (){
                return true;
        }

        @Override
        public int calcularCostoReparacion(int horas) {
                double costoFinal;
        if (!esTraccionIntegral()){
                double precioDescuento = (this.precioBase * 10)/ 100;
                costoFinal = (this.precioBase * horas) + precioDescuento;
        } else {
                costoFinal = this.precioBase * horas;
        } 
        return (int)costoFinal;
        }

       
}
