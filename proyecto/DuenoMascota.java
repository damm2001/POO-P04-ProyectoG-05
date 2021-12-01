
package proyecto;

import java.util.ArrayList;
import static proyecto.Main.sc;

public class DuenoMascota extends Persona {
    
    protected String cedula;
    protected String apellido;
    public static ArrayList<DuenoMascota> duenosMascota = new ArrayList<DuenoMascota>();

    public DuenoMascota(String nombre, String direccion, String telefono, String email, String cedula, String apellido, Ciudad ciudad){
        super(nombre, direccion, telefono, email);
        this.cedula = cedula;
        this.apellido = apellido;
        this.ciudad=ciudad;
    }

    public DuenoMascota() {}
        
    public static void agregarDueños(){
        
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
            System.out.print("Ingrese el nombre de la ciudad: ");
            String ciud = sc.nextLine();
            System.out.print("Ingrese el nombre de la provincia de la ciudad: ");
            String prov = sc.nextLine();
            System.out.print("Ingrese el email del dueño: ");
            String email = sc.nextLine();
            
            //Creacion del dueño
            DuenoMascota dueno= new DuenoMascota(nom,dic,telf,email,ced,ap,new Ciudad(ciud,prov));
           
            //Agregamos al dueño al regsitro
            duenosMascota.add(dueno);
            System.out.println("Dueño creado.");
            System.out.println("\n1.-Seguir creando Dueños \n2.-Salir");
            System.out.print("\nOpción del usuario: ");
            opcion_user = sc.nextInt();
            sc.nextLine();
            System.out.println();
        }
    }
    
    public static void mostrarDueños(){

        if (!duenosMascota.isEmpty()){ //!(duenoMascota.size()==0)
            System.out.println("Lista de Dueños:");
            System.out.printf("%5s %25s %15s %n","#","Nombre - Apellido","Cedula");
            int n=1;
            for(DuenoMascota d:duenosMascota){
                System.out.printf("%5s %25s %15s %n",n,d.nombre+" - "+d.apellido,d.cedula);
                n++;
            }
        }else{
            System.out.println("No se ha registrado ningun dueño");
        }
    }
    
    public static void modificarDueños(){

        System.out.print("Ingrese la cedula del dueño: ");
        String id = sc.nextLine();

        int m=0;
        for (DuenoMascota d: duenosMascota){ //Iteracion.
            if (d.cedula.equals(id)){
                m+=1;
                System.out.println("DUEÑO: "+d.nombre+" "+d.apellido);
                System.out.print("OPCIONES\n1. Direccion\n2. Telefono\n3. Email\n¿Que dato desea editar?: ");
                String op = sc.nextLine();
                if (op.equals("1")){
                    System.out.print("Escriba la nueva direccion: ");
                    String dir = sc.nextLine();
                    d.direccion=dir;
                }else if(op.equals("2")){
                    System.out.print("Escriba el nuevo telefono: ");
                    String telf = sc.nextLine();
                    d.telefono=telf;
                }else if(op.equals("3")){
                    System.out.print("Escriba el nuevo email: ");
                    String email = sc.nextLine();
                    d.email=email;
                }
            }
        }
        if (m==0){
            System.out.println("Cedula no registrada en el sistema\nRegresando al menu principal\n");
        }else{
            System.out.println();
        }
    }

    public String getNombre() {
        return nombre;
    }
}  
  
