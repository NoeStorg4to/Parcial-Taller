package model;

import java.util.ArrayList;
import java.util.List;


public class Taller {        
        private String nombreTaller;
        private List<Vehiculo> inventarioVehiculos = new ArrayList <>();
        private List <Vehiculo> vehiculosEnReparacion = new ArrayList <>();

        public Taller(String nombreTaller) {
                this.nombreTaller = nombreTaller;
        }

        public String getNombreTaller() {
                return nombreTaller;
        }

        public void setNombreTaller(String nombreTaller) {
                this.nombreTaller = nombreTaller;
        }

        public List<Vehiculo> getInventarioVehiculos() {
                return inventarioVehiculos;
        }

        public void setInventarioVehiculos(List<Vehiculo> inventarioVehiculos) {
                this.inventarioVehiculos = inventarioVehiculos;
        }

        public List<Vehiculo> getVehiculosEnReparacion() {
                return vehiculosEnReparacion;
        }

        public void setVehiculosEnReparacion(List<Vehiculo> vehiculosEnReparacion) {
                this.vehiculosEnReparacion = vehiculosEnReparacion;
        }
        
        public void agregaVehiculo (Vehiculo vehiculo) {
                for (Vehiculo v : inventarioVehiculos) {
                         if (v.getCodigoVehiculo().equals(vehiculo.getCodigoVehiculo())){
                                 throw new IllegalArgumentException ("Ya existe un vehiculo con ese codigo");
                        }
                }
                 this.inventarioVehiculos.add(vehiculo); 
                 System.out.println("Se agrego el vehiculo: " + vehiculo.getModelo() + " exitosamente.");
        }
        public double calcularCostoReparacion(String codigoVehiculo, int horas) throws ErrorEstadoDuplicado{
                         
                 for (Vehiculo v : vehiculosEnReparacion) {
                         if (v.getCodigoVehiculo().equals(codigoVehiculo)){
                                  throw new ErrorEstadoDuplicado ("El vehiculo ya se encuentra en reparacion");
                        } 
                         double precioFinal = v.calcularCostoReparacion(horas);
                         return (double)precioFinal; 
                 }                                                
                return 0;
        }      
        
        public void iniciarReparacion(String codigoVehiculo, String descripcion) throws ErrorEstadoDuplicado{
                        
                for (Vehiculo v : vehiculosEnReparacion) {
                         if (v.getCodigoVehiculo().equals(codigoVehiculo)){
                                  throw new ErrorEstadoDuplicado ("El vehiculo ya se encuentra en reparacion");
                         }
                         v.iniciarReparacion(nombreTaller, descripcion);
                         this.vehiculosEnReparacion.add(v);
                 }             
        }
        
        public void finalizarReparacion (String codigoVehiculo){
                 for (Vehiculo v : vehiculosEnReparacion) {
                         if (v.getCodigoVehiculo().equals(codigoVehiculo)){
                                  v.finalizarReparacion();
                                  vehiculosEnReparacion.remove(v);
                         }
                }
        }
             
        public List<Vehiculo> traerVehiculosDisponibles(){
                 List <Vehiculo> vehiculosDisponibles = new ArrayList <>(); 
                 for (Vehiculo v : inventarioVehiculos){
                         if (v.getEstadoV() == EstadoVehiculo.DISPONIBLE){
                                  vehiculosDisponibles.add(v);
                         }
                 }
                 return vehiculosDisponibles;
        }

        public List<Vehiculo> traerVehiculos(EstadoVehiculo estado){
                 List <Vehiculo> vehiculosSolicitado = new ArrayList <>(); 
                 for (Vehiculo v : inventarioVehiculos){
                         if(v.getEstadoV() == estado)
                                vehiculosSolicitado.add(v);
                 }
                 return vehiculosSolicitado;            
        }
        
        public List<String> obtenerHistorialReparaciones (String codigoVehiculo) throws ErrorEstadoDuplicado{
                 List <String> historial = new ArrayList <>(); 
                 for (Vehiculo v : vehiculosEnReparacion) {
                         if (!v.getCodigoVehiculo().equals(codigoVehiculo)){
                                  throw new ErrorEstadoDuplicado ("El vehiculo no existe");
                         }
                         historial =  v.obtenerHistorialReparaciones();
                 }
                 return historial;                 
        }      

        @Override
        public String toString() {
                return "Taller{" + "nombreTaller=" + nombreTaller + ", inventarioVehiculos=" + inventarioVehiculos + ", vehiculosEnReparacion=" + vehiculosEnReparacion + '}';
        }
        
}
