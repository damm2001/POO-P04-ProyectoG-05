
package proyecto;

import java.util.ArrayList;
import static proyecto.Main.sc;

public class Auspiciante extends Persona {
    
    private String webpage;
    public static int sponsor; 
    public int id_sponsor;
    public static ArrayList<Auspiciante> auspiciantes = new ArrayList<Auspiciante>();

    public Auspiciante(String nombre, String direccion, String telefono, String email,String webpage) {
        super(nombre, direccion, telefono, email);
        this.webpage = webpage;
        id_sponsor= sponsor+1;
        sponsor =   id_sponsor;
    }

    public static void agregarAuspiciantes(){
        
        int opcion_user = 1;
        while(opcion_user!=2){
            
            System.out.print("Ingrese el nombre del auspiciante: ");
            String nombre=sc.nextLine();
            System.out.print("Ingrese la direccion del auspiciante: ");
            String direccion=sc.nextLine();
            System.out.print("Ingrese el numero de telefono del auspiciante: ");
            String telefono=sc.nextLine();
            System.out.print("Ingrese el email del auspiciante: ");
            String email=sc.nextLine();
            System.out.print("Ingrese el nombre de la pagina web del auspiciante: ");
            String webpage=sc.nextLine();
            Auspiciante a=new Auspiciante(nombre,direccion,telefono,email,webpage);
            auspiciantes.add(a);
        
            System.out.println("Auspiciante ingresado.");
            System.out.println("\n1.-Crear Auspiciante \n2.-Salir");
            System.out.print("\nOpción del usuario: ");
            opcion_user = sc.nextInt();
            sc.nextLine();
        }
    }

    public static void mostrarAuspiciantes(){
        if (!auspiciantes.isEmpty()){ //!(auspiciantes.size()==0)
            System.out.println("LISTA DE AUSPICIANTES:");
            int n=1;
            for(Auspiciante a:auspiciantes){
                System.out.println(n+".- "+a.nombre);
                n++;
            }
        }else{
            System.out.println("No se ha registrado ningun auspiciante");
        }
    }
}
