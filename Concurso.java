
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


}
