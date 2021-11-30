
package proyecto;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import static proyecto.Auspiciante.auspiciantes;
import static proyecto.Ciudad.ciudades;
import static proyecto.Main.*;

public class Concurso {
    private String nombre;
    private LocalDate fechaEvento;
    private LocalTime horaEvento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Ciudad ciudad; 
    private ArrayList<Premio> premios = new ArrayList<Premio>();//Crear Clase
    private ArrayList<Auspiciante> auspiciantesC =new ArrayList<Auspiciante>();
    private String lugar;
    private TipoMascota dirigido;
    private static int lastID;
    private int idConcurso;
    public static ArrayList<Concurso> concursos = new ArrayList<Concurso>();
    private ArrayList<Mascota> mascotasInscrita = new ArrayList<Mascota>();//Lista de mascotas inscritas en ese concurso
    private ArrayList<Mascota> ganadores = new ArrayList<Mascota>();

    public Concurso(String nombre,LocalDate fechaEvento,LocalTime horaEvento,
    LocalDate fechaInicio,LocalDate fechaFin,Ciudad ciudad, ArrayList<Premio> premio,
    ArrayList<Auspiciante> auspiciantes ,String lugar,TipoMascota dirigido){
    this.nombre=nombre;
    this.fechaEvento=fechaEvento;
    this.horaEvento=horaEvento;
    this.fechaInicio=fechaInicio;
    this.fechaFin=fechaFin;
    this.ciudad=ciudad;
    this.premios=premio;
    this.auspiciantesC=auspiciantes;
    this.lugar=lugar;
    this.dirigido=dirigido;
    this.mascotasInscrita= new ArrayList<Mascota>();
    this.ganadores=new ArrayList<Mascota>();
    idConcurso=lastID+1;
    lastID=idConcurso;
    }

    public void setMascotasInscrita(ArrayList<Mascota> mascotasInscrita) {
        this.mascotasInscrita = mascotasInscrita;
    }

    public void setGanadores(ArrayList<Mascota> ganadores) {
        this.ganadores = ganadores;
    }
    
    public static void agregarConcursos(){

        Scanner sc=new Scanner(System.in);
        int opcion_user = 0;

        while(opcion_user!=2){
            
            //Nombre Evento
            System.out.print("Ingrese el nombre del concurso: ");
            String nombre =sc.nextLine();
            
            //Ciudad del evento
            Ciudad.mostrarCiudades();
            System.out.print("\nIndique el nombre de la ciudad: ");
            String ciudad =sc.nextLine();
            Ciudad ciudad_user=new Ciudad();

            int n=0;
            for(Ciudad c:ciudades){
                if (c.nombre.equals(ciudad)){
                    ciudad_user=c;
                    n+=1;
                }
            }
            if (n==0){
                System.out.println("Ciudad no registrada en el sistema.");
                System.out.println("Regresando al menú principal\n");
                metodoMenu();
            }
            
            //Fecha del evento
            System.out.println("Ejemplo de ingreso de fechas (año-mes-dia / 2020-11-28)");
            System.out.print("Ingrese la fecha del evento: ");
            String fecha = sc.nextLine();
            LocalDate fechaEvento=LocalDate.parse(fecha);

            //HoraEvento
            System.out.print("Ingrese la hora en que se llevara a cabo el evento (Ejemplo: 24 = 24h): ");
            int hora=sc.nextInt();
            sc.nextLine();
            LocalTime horaEvento=LocalTime.of(hora,00,00);

            //Fecha de inicio del Evento
            System.out.print("Ingrese la fecha del inicio de inscripcion: ");
            fecha = sc.nextLine();
            LocalDate fechaInicio=LocalDate.parse(fecha);

            //Fecha de fin del Evento
            System.out.print("Ingrese la fecha del cierre de inscripcion: ");
            fecha = sc.nextLine();
            LocalDate fechaFin=LocalDate.parse(fecha);
            System.out.println();

            //Seleccion del AUSPICIANTE
            ArrayList<Auspiciante> listAuspiciante=new ArrayList<Auspiciante>();
            Auspiciante.mostrarAuspiciantes();
            System.out.print("\nIndique el nombre del auspiciante: ");
            String ausp =sc.nextLine();

            int n1=0;
            for(Auspiciante a:auspiciantes){
                if (a.nombre.equals(ausp)){
                    listAuspiciante.add(a);
                    n1+=1;
                }
            }
            if (n1==0){
                System.out.println("Auspiciante no registrado en el sistema.");
                metodoMenu();
            }
            
            //Lugar del Evento
            System.out.print("Ingrese el lugar donde se realizara el evento: ");
            String lugar=sc.nextLine();

            //Hacia quien se dirige el concurso, //Se asume el ingreso correcto de datos 
            System.out.print("Ingrese para que tipo de mascota esta destinado el concurso (perro, gato o ambos): ");
            String tipo=sc.nextLine();
            TipoMascota dirigido = null;

            if (tipo.equals("perro")){
                dirigido=TipoMascota.Perro;
            }else if (tipo.equals("gato")){
                dirigido=TipoMascota.Gato;
            }else if (tipo.equals("ambos")){
                dirigido=TipoMascota.Todos;
            }

            //INGRESO DE PREMIOS
            System.out.println("\nINGRESO DE PREMIOS ");
            ArrayList<Premio> listPremios = new ArrayList<Premio>();
            
            int op= 0;
            while(op!=2){
                Premio p=Premio.crearPremios(listAuspiciante);
                listPremios.add(p);
                System.out.println("\n1.-Continuar agregando Premios \n2.-Salir");
                System.out.print("\nOpción del usuario: ");
                op = sc.nextInt();
                sc.nextLine();
            }

            //Se crea el concurso
            Concurso concurso = new Concurso(nombre,fechaEvento,horaEvento,fechaInicio,fechaFin,ciudad_user,listPremios,listAuspiciante,lugar,dirigido);
            concursos.add(concurso);
            
            System.out.println("Concurso creado.");
            System.out.println("\n1.-Crear Concurso \n2.-Salir");
            System.out.print("\nOpción del usuario: ");
            opcion_user = sc.nextInt();
            sc.nextLine();
        }
    }
    
    public static void mostrarConcursosAbiertos(){

        System.out.println("LISTA DE CONCURSOS ABIERTOS");
        LocalDate fechaHoy = LocalDate.now();
        
        for(Concurso c:concursos){
            if(fechaHoy.isBefore(c.fechaFin)){
                System.out.println(c.toString());
            }
        }
    }
    
    public static void inscribirParticipantes(int id){
        
        Scanner sc=new Scanner(System.in);
        
        for(Concurso c: concursos){
            if(c.idConcurso==id){
                System.out.println("Nombre,  Tipo de Mascota,  ID");
                Mascota.mostrarMascotas();
                System.out.print("\nIngrese el ID de la mascota: ");
                int idM= sc.nextInt();
                sc.nextLine();
                System.out.print("Mascota inscrita.\n");
                for (Mascota m:Mascota.mascotas){
                    if(m.getIdMascota()==idM){
                        c.mascotasInscrita.add(m);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Concurso: " + nombre + "   Codigo: " + idConcurso ;
    }
}
