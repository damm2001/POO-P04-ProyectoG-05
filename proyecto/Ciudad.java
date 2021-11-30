
package proyecto;
import java.util.ArrayList;
import java.util.Scanner;

public class Ciudad {

    protected String nombre;
    protected String provincia;
    public static int lastID;
    public int id_ciudad;
    public static ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();

    public Ciudad(String nombre, String provincia){
        this.nombre=nombre;
        this.provincia=provincia;
        id_ciudad= lastID+1;
        lastID =   id_ciudad;
    }
    
    public static void mostrarCiudades(){
        if (!ciudades.isEmpty()){
            System.out.println("\nLista de Ciudades:");
            int n=1;
            for(Ciudad c:ciudades){
                System.out.println(n+".- "+c.nombre);
                n++;
            }
        }else{
            System.out.println("No se ha registrado ni una ciudad");
        }
    }
    
    public static void agregarCiudades(){
        
        Scanner sc=new Scanner(System.in);
        int opcion_user = 1;

        while(opcion_user!=2){
            System.out.print("\nIngrese el nombre de una Ciudad: ");
            String n=sc.nextLine();
            System.out.print("Ingrese el nombre de una Provincia: ");
            String p=sc.nextLine();
            ciudades.add(new Ciudad(n,p));
            System.out.println("Ciudad creada.");
            System.out.println("\n1.-Crear Ciudad \n2.-Salir");
            System.out.print("\nOpción del usuario: ");
            opcion_user = sc.nextInt();
            sc.nextLine();
        }
    }

    public Ciudad() {
    }
}
