
package test;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class Main {

    public static void main(String[] args) {
        List<String> historialReparaciones = new ArrayList <>();
        List<String> inventarioVehiculo = new ArrayList <>();   
        Taller taller = new Taller("TuVieja");

        try {
                System.out.println("1-1");
                 VehiculoCompacto vCompacto = new VehiculoCompacto (2024, "ABC123", "Toyota Corolla", 2000.0, EstadoVehiculo.DISPONIBLE, historialReparaciones);
        } catch (Exception e) {
                 System.out.println(e.getMessage());
        }        
        try { 
                 System.out.println("1-2");
                 VehiculoCompacto vCompacto1 = new VehiculoCompacto (2023, "XYZ5678", "Honda Civic", 2200.0, EstadoVehiculo.DISPONIBLE, inventarioVehiculo);
                 System.out.println("Anio: " + vCompacto1.getAnio() + "\nPatente: " + vCompacto1.getCodigoVehiculo() + "\nModelo: " + vCompacto1.getModelo() + "\nPrecio: " + vCompacto1.getPrecioBase());
                 
                 taller.agregaVehiculo(vCompacto1);          
                 
                 System.out.println("2-1");
                 System.out.println("El costo de reparacion es: " + vCompacto1.calcularCostoReparacion(5));

                 System.out.println("3-1");
                 VehiculoCompacto vCompacto2 = new VehiculoCompacto (2024, "LMN1111", "Volkswagen Polo", 1800.0, EstadoVehiculo.EN_REPARACION, inventarioVehiculo);
                 taller.agregaVehiculo(vCompacto2);
                 
                VehiculoSUV vSUV1= new VehiculoSUV (true, "OPQ2222", "Toyota RAV4", 3000.0, EstadoVehiculo.EN_REPARACION, inventarioVehiculo);
                  taller.agregaVehiculo(vSUV1);          
                  
                  System.out.println("4-1");
                 System.out.println("Los vehiculos disponibles son: " + taller.traerVehiculosDisponibles());
                 System.out.println("Los vehiculos solicitados son" + taller.traerVehiculos(EstadoVehiculo.EN_REPARACION));
                 
        } catch (Exception e) {
                 System.out.println(e.getMessage());
        }
        try {
                System.out.println("3-2");
                 VehiculoSUV vSUV2 = new VehiculoSUV (true, "LMN1111", "Ford Explorer", 3500.0, EstadoVehiculo.EN_REPARACION, inventarioVehiculo);
                 taller.agregaVehiculo(vSUV2);
                 
        } catch (Exception e) {
                 System.out.println(e.getMessage());
        }    
        try { 
                 System.out.println("1-3");
                 VehiculoSUV vSUV = new VehiculoSUV (false, "QRS7890", "Chevrolet Tahoe", 4000.0, EstadoVehiculo.DISPONIBLE, inventarioVehiculo);
                 System.out.println("Traccion integral: " + vSUV.isTraccionIntegral()+ "\nPatente: " + vSUV.getCodigoVehiculo() + "\nModelo: " + vSUV.getModelo() + "\nPrecio: " + vSUV.getPrecioBase());
        
                 taller.agregaVehiculo(vSUV);
                 
                 System.out.println("2-2");
                 System.out.println("El costo de reparacion es: " + vSUV.calcularCostoReparacion(3));
                 
                 System.out.println("4-1");
                 System.out.println("Los vehiculos disponibles son: " + taller.traerVehiculosDisponibles());
                 
        } catch (Exception e) {
                 System.out.println(e.getMessage());
        }
        
    }
    
}
