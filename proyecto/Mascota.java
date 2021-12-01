
package proyecto;

import java.time.LocalDate;
import java.util.ArrayList;
import static proyecto.DuenoMascota.duenosMascota;
import static proyecto.Main.*;

public class Mascota {
    
    private String nombre;
    private TipoMascota tipo;
    private String raza;
    private LocalDate fechaNacimiento;
    private String foto;
    private DuenoMascota dueno;
    private static int lastID;
    private int idMascota;
    public static ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    public static ArrayList<Mascota> mascotasQueParticiparon = new ArrayList<Mascota>();

    public Mascota(String nombre, TipoMascota tipo, String raza, LocalDate fechaNacimiento, String foto, DuenoMascota dueno) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.foto = foto;
        this.dueno = dueno;
        idMascota=lastID+1;
        lastID=idMascota;
    }
    
    public static void agregarMascotas(){
        
        int opcion_user = 0;
        while(opcion_user!=2){
        
            System.out.print("Ingrese el nombre de la mascota: ");
            String nom = sc.nextLine();
            System.out.print("Ingrese si es Perro o Gato: ");
            String tipo = sc.nextLine();
            TipoMascota tipoF= null;
            if (tipo.equals("Perro")){
                tipoF= TipoMascota.Perro;
            }else if(tipo.equals("Gato")){
                tipoF= TipoMascota.Gato;
            }
            
            System.out.print("Ingrese la raza: ");
            String raza = sc.nextLine();
            System.out.print("Ingrese la fecha de nacimiento con el formato YYYY-MM-DD: ");
            String fecha= sc.nextLine();
            LocalDate fechaNacimiento=LocalDate.parse(fecha);
            System.out.print("Ingrese la foto: ");
            String foto = sc.nextLine();
            System.out.println();
            DuenoMascota.mostrarDueños();
            System.out.print("\nIngrese el nombre del dueño: ");
            String dueno1 = sc.nextLine();

            DuenoMascota dueno= null;
            for(DuenoMascota d:duenosMascota){
                if (dueno1.equals(d.getNombre())){
                   dueno= d; 
                }
            }
            if(dueno==null){
                System.out.println("Dueño no encontrado\nRegresando al menu principal\n");
                metodoMenu();
            }
            //creacion de mascota
            Mascota mascota= new Mascota(nom,tipoF,raza,fechaNacimiento,foto,dueno);
            System.out.println("Mascota ingresada");
            //Ingreso de la mascota a la lista de Mascotas
            mascotas.add(mascota);
            mascotasQueParticiparon.add(mascota);
            
            //opcion para seguir ingresando mascotas o salir
            System.out.println("\n1.-Seguir creando Mascotas \n2.-Salir");
            System.out.print("\nOpción del usuario: ");
            opcion_user = sc.nextInt();
            sc.nextLine();
            System.out.println();
        }
    }
    
    
    public static void mostrarMascotas(){
        if (!mascotas.isEmpty()){ //!(mascotas.size()==0)
            System.out.println("Lista de Mascotas:");
            System.out.println("Nombre    Tipo Mascota   Id");
            int n=1;
            for(Mascota m:mascotas){
                System.out.println(n+".- "+m.toString());
                n++;
            }
        }else{
            System.out.println("No se ha registrado ninguna mascota");
        }
    }
    
    public static void eliminarMascotas(){
        System.out.print("Ingrese el id de la mascota: ");
        int id = sc.nextInt();
        sc.nextLine();
        int b=mascotasQueParticiparon.size();
        int a=0;

        for(Mascota m:mascotasQueParticiparon){
            if(m.idMascota==id){
                mascotas.remove(m);
                System.out.println("Mascota eliminada\n");
                metodoMenu();
            }else{
                a+=1;
            }
        }
        if(a>=b){
            System.out.println("ID no encontrado\nRegresando al menu principal\n");
        }
    }

    public int getIdMascota() {
        return idMascota;
    }

    public TipoMascota getTipo(){
        return tipo;
    }
    
    public String toString() {
        return nombre + ",     " + tipo + ",      " + idMascota;
    }
}
