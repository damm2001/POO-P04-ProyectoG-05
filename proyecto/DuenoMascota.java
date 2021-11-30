
package proyecto;

import java.util.ArrayList;
import java.util.Scanner;



public class DuenoMascota extends Persona {
    protected String cedula;
    protected String apellido;
    public static ArrayList<DuenoMascota> duenosMascota = new ArrayList<DuenoMascota>();

    public DuenoMascota(String nombre, String direccion, String telefono, String email, String cedula, String apellido) {
        super(nombre, direccion, telefono, email);
        this.cedula = cedula;
        this.apellido = apellido;
        
    }

    public DuenoMascota() {}
    
    public static void agregarDueños(){
        Scanner sc=new Scanner(System.in);
        
        int opcion_user = 0;
       
        while(opcion_user!=2){
            
            System.out.print("Ingrese el numero de cédula del dueño: ");
            String ced = sc.nextLine();
            System.out.print("Ingrese el nombre del dueño: ");
            String nom = sc.nextLine();
            System.out.print("Ingrese el apellido del dueño: ");
            String ap = sc.nextLine();
            System.out.print("Ingrese su direccion: ");
            String dic = sc.nextLine();
            System.out.print("Ingrese el numero de telefono del dueño: ");
            String telf = sc.nextLine();
            System.out.print("Ingrese la ciudad: ");
            String ciud = sc.nextLine();
            System.out.print("Ingrese el email del dueño: ");
            String email = sc.nextLine();
            
            //Creacion del dueño
            DuenoMascota dueno= new DuenoMascota(nom,dic,telf,email,ced,ap);
            //Agregamos al dueño al regsitro
            duenosMascota.add(dueno);
            System.out.println("Dueño creado.");
            System.out.println("\n1.-Crear Dueño \n2.-Salir");
            System.out.print("\nOpción del usuario: ");
            opcion_user = sc.nextInt();
            sc.nextLine();
        }
    }
    
    public static void mostrarDueños(){
        if (!duenosMascota.isEmpty()){
            System.out.println("Lista de Dueños:");
            int n=1;
            for(DuenoMascota d:duenosMascota){
                System.out.println(n+".- "+d.nombre);
                n++;
            }
        }else{
            System.out.println("No se ha registrado ningun dueño");
        }
    }
    
    public static void modificarDueños(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Ingrese la cedula del dueño: ");
            String id = sc.nextLine();
            duenosMascota.forEach(d-> {
                if (d.cedula.equals(id)){
                    System.out.println("DUEÑO: "+d.nombre+" "+d.apellido);
                    System.out.println("OPCIONES");
                    System.out.println("1. Direccion");
                    System.out.println("2. Telefono");
                    System.out.println("3. Email");
                    System.out.println("¿Que dato desea editar?: ");
                    String op = sc.nextLine();
                    if (op.equals("1")){
                        System.out.println("Escriba la nueva direccion: ");
                        String dir = sc.nextLine();
                        d.direccion=dir;
                    }else if(op.equals("2")){
                        System.out.println("Escriba el nuevo telefono: ");
                        String telf = sc.nextLine();
                        d.telefono=telf;
                    }else if(op.equals("3")){
                        System.out.println("Escriba el nuevo email: ");
                        String email = sc.nextLine();
                        d.email=email;
                    }
                }
            });
        
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "DuenoMascota{" + "cedula=" + cedula + ", apellido=" + apellido + '}';
    }
    
    public static void main(String args[]) {
        agregarDueños();
        mostrarDueños();
    }
    
}   