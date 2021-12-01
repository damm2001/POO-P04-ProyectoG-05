
package proyecto;

import java.util.ArrayList;
import static proyecto.Main.sc;

public class Premio {

    public String puesto;
    public String descripcion;
    public Auspiciante auspiciante;

    public Premio(String puesto, String descripcion,Auspiciante auspiciante){
        this.puesto= puesto;
        this.descripcion=descripcion;
        this.auspiciante=auspiciante;
    }

    public Premio(String puesto, String descripcion) {
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.auspiciante=null;
    }
    
    public static Premio crearPremios(ArrayList<Auspiciante> lista){
        
        Premio premio = null;
            
        System.out.print("Indique el puesto del premio (Ej: Primer Puesto): ");
        String puesto=sc.nextLine();
        System.out.print("Ingrese la descripcion del premio del evento: ");
        String descripcion=sc.nextLine();
        System.out.print("El premio tiene auspiciante? Si/No: ");
        String tiene=sc.nextLine();
            
        if(tiene.equals("Si")){
            for(Auspiciante a:lista){
                System.out.print("Auspiciante del concurso: "+a.nombre);
            }
            System.out.print("\nIndique el auspiciante del premio '"+puesto+"' : ");
            String ausp=sc.nextLine();

            for(Auspiciante a:lista){
                if(a.nombre.equals(ausp)){
                    premio=new Premio(puesto, descripcion, a); 
                }
            }
                
        }else{
            premio=new Premio(puesto, descripcion);
        }System.out.println("Premio creado."); 
        return premio;
    }

    public String toString() {
        if (auspiciante==null){
            return puesto+":"+descripcion+", no tiene auspiciante";
        }else{
            return puesto+": "+descripcion+", "+auspiciante;
        }  
    } 
}
