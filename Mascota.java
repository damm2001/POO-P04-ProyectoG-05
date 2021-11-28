
package proyecto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import static proyecto.DuenoMascota.duenosMascota;



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
        Scanner sc=new Scanner(System.in);
        System.out.println("Opciones: \n1.-Crear Mascota \n2.-Salir");
        System.out.print("\nOpción del usuario: ");
        int opcion_user = sc.nextInt();
        sc.nextLine();
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
            System.out.print("Ingrese el dueño: ");
            String dueno1 = sc.nextLine();
            DuenoMascota dueno= new DuenoMascota();
            for(DuenoMascota d:duenosMascota){
                if (dueno1.equals(d.getNombre())){
                   dueno= d; 
                }
            }
            
            //creacion de mascota
            Mascota mascota= new Mascota(nom,tipoF,raza,fechaNacimiento,foto,dueno);
            System.out.println("Mascota ingresada");
            //Ingreso de la mascota a la lista de Mascotas
            mascotas.add(mascota);
            
            
            
            //opcion para seguir ingresando mascotas o salir
            System.out.println("\n1.-Crear Mascota \n2.-Salir");
            System.out.print("\nOpción del usuario: ");
            opcion_user = sc.nextInt();
            sc.nextLine();
            
        }sc.close();
    }
    
    
    public static void mostrarMascotas(){
        if (!mascotas.isEmpty()){
            System.out.println("Lista de Mascotas:");
            int n=1;
            for(Mascota m:mascotas){
                System.out.println(n+".- "+m.nombre);
                n++;
            }
        }else{
            System.out.println("No se ha registrado ninguna mascota");
        }
    }
    
    public static void eliminarMascotas(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Ingrese el id de la mascota: ");
            int id = sc.nextInt();
            mascotas.forEach(m-> {
                if(m.getIdMascota()==id){
                    //aqui debo quitar a la mascota para futuras inscripcciones
                }
            });
        
    }
    public int getIdMascota() {
        return idMascota;
    }
    
    

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", tipo=" + tipo + ", raza=" + raza + ", fechaNacimiento=" + fechaNacimiento + ", foto=" + foto + ", dueno=" + dueno + '}';
    }
    
    public static void main(String args[]) {
        agregarMascotas();
        mostrarMascotas();
    }
    
}
