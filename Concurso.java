
import java.time.LocalDate;
import java.time.LocalTime;

public class Concurso {
    private String nombre;
    private LocalDate fechaEvento;
    private LocalTime horaEvento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Ciudad ciudad; 
    private Premio premio;
    private Auspiciante auspiciante;
    private String lugar;
    private TipoMascota dirigido;

    public Concurso(String nombre,LocalDate fechaEvento,LocalTime horaEvento,
    LocalDate fechaInicio,LocalDate fechaFin,Ciudad ciudad, Premio premio,
    Auspiciante auspiciante,String lugar,TipoMascota dirigido){
    this.nombre=nombre;
    this.fechaEvento=fechaEvento;
    this.horaEvento=horaEvento;
    this.fechaInicio=fechaInicio;
    this.fechaFin=fechaFin;
    this.ciudad=ciudad;
    this.premio=premio;
    this.auspiciante=auspiciante; 
    this.lugar=lugar;
    this.dirigido=dirigido;
    }

    //Sin Auspiciante:
    public Concurso(String nombre,LocalDate fechaEvento,LocalTime horaEvento,
    LocalDate fechaInicio,LocalDate fechaFin,Ciudad ciudad, Premio premio,
    String lugar,TipoMascota dirigido){
    this.nombre=nombre;
    this.fechaEvento=fechaEvento;
    this.horaEvento=horaEvento;
    this.fechaInicio=fechaInicio;
    this.fechaFin=fechaFin;
    this.ciudad=ciudad;
    this.premio=premio;
    this.lugar=lugar;
    this.dirigido=dirigido;
    }

    /*public static void agregarConcurso(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Opciones: \n1.-Crear Concurso \n2.-Salir");
        System.out.print("\nOpción del usuario: ");
        int opcion_user = sc.nextInt();
        sc.nextLine();
        while(opcion_user!=2){
            System.out.print("\nIngrese el nombre del Concurso: ");
            String n=sc.nextLine();
            System.out.print("Ingrese la dirección: ");
            String d=sc.nextLine();
            System.out.print("Ingrese el teléfono: ");
            String t=sc.nextLine();
            System.out.print("Ingrese el correo electrónico: ");
            String correo=sc.nextLine();
            System.out.print("Ingrese la cédula de identidad: ");
            String c_i=sc.nextLine();
            System.out.print("Ingrese  el apellido del Dueño de la mascota: ");
            String last_n=sc.nextLine();
            owners.add(new DuenoMascota(n,d,t,correo,c_i,last_n));
            System.out.println("Dueño de Mascota creado.");
            System.out.println("\n1.-Crear Dueño de Mascota\n2.-Salir");
            System.out.print("\nOpción del usuario: ");
            opcion_user = sc.nextInt();
            sc.nextLine();
        }sc.close();
    }   */

}
