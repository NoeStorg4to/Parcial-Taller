
package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehiculo {
        protected String codigoVehiculo;
        protected String modelo;
        protected double precioBase;
        protected EstadoVehiculo estadoV;
        protected List<String> historialReparaciones = new ArrayList <>();
        //protected static final Set<String> codigosVehiculos = new HashSet<>();

        public Vehiculo(String codigoVehiculo, String modelo, double precioBase, EstadoVehiculo estadoV, List<String> historialReparaciones) throws IllegalArgumentException {
                if (codigoVehiculo.length() != 7 ){
                         throw new IllegalArgumentException ("El codigo del vehiculo tiene que tener 7 caracteres.");
                }
                this.codigoVehiculo = codigoVehiculo;
                this.modelo = modelo;
//                if (precioBase < 0){
//                         throw new IllegalArgumentException ("El precio no debe ser negativo");
//                }
                this.precioBase = precioBase;
                this.estadoV = estadoV;
                this.historialReparaciones = historialReparaciones;
        }

        public String getCodigoVehiculo() {
                return codigoVehiculo;
        }

        public void setCodigoVehiculo(String codigoVehiculo) {
                this.codigoVehiculo = codigoVehiculo;
        }

        public String getModelo() {
                return modelo;
        }

        public void setModelo(String modelo) {
                this.modelo = modelo;
        }

        public double getPrecioBase() {
                return precioBase;
        }

        public void setPrecioBase(double precioBase) {
                this.precioBase = precioBase;
        }

        public EstadoVehiculo getEstadoV() {
                return estadoV;
        }

        public void setEstadoV(EstadoVehiculo estadoV) {
                this.estadoV = estadoV;
        }

        public List<String> getHistorialReparaciones() {
                return historialReparaciones;
        }

        public void setHistorialReparaciones(List<String> historialReparaciones) {
                this.historialReparaciones = historialReparaciones;
        }
         
        public abstract int calcularCostoReparacion(int horas);
        
        public void iniciarReparacion (String nombreTaller, String descripcion) {
                
                this.estadoV = EstadoVehiculo.EN_REPARACION;
                LocalDateTime fechaActual = LocalDateTime.now(); 
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String fechaFormateada = fechaActual.format(formatter);
                String mensaje = "La fecha de inicio de la reparacion es: " + fechaFormateada + ", el nombre del taller en donde se encuentra es: " + nombreTaller + descripcion  ;
                this.historialReparaciones.add(mensaje);
        }
        
        public void finalizarReparacion(){
                this.estadoV = EstadoVehiculo.DISPONIBLE;
                String mensaje = "Fin de la reparacion.";
                this.historialReparaciones.add(mensaje); 
        }
        
        public List<String> obtenerHistorialReparaciones(){
                return this.historialReparaciones;
        }

        @Override
        public String toString() {
                return "Vehiculo{" + "codigoVehiculo=" + codigoVehiculo + ", modelo=" + modelo + ", precioBase=" + precioBase + ", estadoV=" + estadoV + ", historialReparaciones=" + historialReparaciones + '}';
        }
        
        
}
