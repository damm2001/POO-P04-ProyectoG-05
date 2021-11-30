
package proyecto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import static proyecto.Auspiciante.auspiciantes;
import static proyecto.Ciudad.ciudades;
import static proyecto.Concurso.concursos;
import static proyecto.DuenoMascota.duenosMascota;
import static proyecto.Mascota.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    
    public static void metodoMenu(){
        System.out.println("1. Administrar Concursos\n2. Administrar Dueños\n3. Administrar Mascotas");
        System.out.print("\nElija una opcion: ");
        String opcion=sc.nextLine();
        System.out.println();

        if(opcion.equals("1")){
            admConcurso();
        } else if(opcion.equals("2")){
            admDuenos();
        } else if(opcion.equals("3")){
            admMascota();
        }else{
            System.out.println("Programa Finalizado.");
        }    
    }
    
    public static void admConcurso(){
        System.out.println("1. Crear Concurso\n2. Inscribir Participante\n3. Regresar al menú principal");
        System.out.print("\nElija una opcion: ");
        String opcion=sc.nextLine();
        System.out.println();
        
        if(opcion.equals("1")){
            Concurso.agregarConcursos();
            metodoMenu();
        } else if(opcion.equals("2")){
            Concurso.mostrarConcursosAbiertos();
            System.out.print("\nIngrese el codigo del concurso: ");
            int cod= sc.nextInt();
            sc.nextLine();
            System.out.println();
            Concurso.inscribirParticipantes(cod);
            System.out.println();
        } else if(opcion.equals("3")){
            metodoMenu();
        }
    }
    
    public static void admDuenos(){
        DuenoMascota.mostrarDueños();
        System.out.println("\n4. Crear Dueño\n5. Editar dueño\n6. Regresar al menú principal");
        System.out.print("\nElija una opcion: ");
        String opcion=sc.nextLine();
        System.out.println();
        
        if(opcion.equals("4")){
            DuenoMascota.agregarDueños();
            metodoMenu();
        } else if(opcion.equals("5")){
            DuenoMascota.modificarDueños();
            metodoMenu();
        } else if(opcion.equals("6")){
            metodoMenu();
        }
    }
    
    public static void admMascota(){
        Mascota.mostrarMascotas();
        System.out.println("\n7. Crear mascota\n8. Eliminar mascota\n9. Regresar al menú principal");
        System.out.print("\nElija una opcion: ");
        String opcion=sc.nextLine();
        System.out.println();
    
        if(opcion.equals("7")){
            Mascota.agregarMascotas();
            metodoMenu();
        } else if(opcion.equals("8")){
            Mascota.eliminarMascotas();
            metodoMenu();
        } else if(opcion.equals("9")){
            metodoMenu();
        }
    }
    
    public static void main(String[] args) {
        
        //Creacion y agregacion de los dueños
        DuenoMascota d1= new DuenoMascota("Michael","Avenida de las Americas","0988093309","mvelastegui2000@gmail.com","0928046389","Velastegui");
        DuenoMascota d2= new DuenoMascota("Diego","Ciudad Celeste","0988093309","diego2001martinez@gmail.com","0926409699","Martinez");
        DuenoMascota d3= new DuenoMascota("Kenyi","Samanes","0983717401","ktrivino@espole.edu.ec","0928363763","Triviño");
        DuenoMascota d4= new DuenoMascota("Meiyin","Centro","0992762653","mchang@gespol.edu.ec","0992563553","Chang");
        DuenoMascota d5= new DuenoMascota("Jose","Villaclub","0826355352","jzambramo@gmail.com","0982876621","Zambrano");
        DuenoMascota d6= new DuenoMascota("Arianna","Isla Sol","8177662267","acorrea@gmail.com","0971652514","Correa");
        DuenoMascota d7= new DuenoMascota("Elizabeth","San Bernardo","0996152410","elijara@gmail.com","0972581862","Jara");
        DuenoMascota d8= new DuenoMascota("Isabella","Santa Maria de Casa Grande","0982552141","isavergara@hotmail.com","0986162536","Vergara");
        DuenoMascota d9= new DuenoMascota("Mya","Vista Sol","0998726838","myamacias@hotmail.com","0992752471","Macias");
        DuenoMascota d10= new DuenoMascota("Emily","Laguna del Sol","0952627882","emilyrodrig@hotmail.com","0986252537","Rodriguez");
        duenosMascota.add(d1);
        duenosMascota.add(d2);
        duenosMascota.add(d3);
        duenosMascota.add(d4);
        duenosMascota.add(d5);
        duenosMascota.add(d6);
        duenosMascota.add(d7);
        duenosMascota.add(d8);
        duenosMascota.add(d9);
        duenosMascota.add(d10);
        
        //Creacion y agregacion de las mascotas
        Mascota m1= new Mascota("Max",TipoMascota.Perro,"Golden",LocalDate.parse("2018-10-30"),"foto",d1);
        Mascota m2= new Mascota("Nina",TipoMascota.Perro,"Pekines",LocalDate.parse("2015-12-30"),"foto",d2);
        Mascota m3= new Mascota("Cooper",TipoMascota.Perro,"Shitzu",LocalDate.parse("2019-04-18"),"foto",d3);
        Mascota m4= new Mascota("Mike",TipoMascota.Perro,"Schnauzer",LocalDate.parse("2012-05-10"),"foto",d4);
        Mascota m5= new Mascota("Beto",TipoMascota.Perro,"Pitbull",LocalDate.parse("2007-09-28"),"foto",d5);
        Mascota m6= new Mascota("Temari",TipoMascota.Gato,"Persa",LocalDate.parse("2016-08-22"),"foto",d6);
        Mascota m7= new Mascota("Felix",TipoMascota.Gato,"Bengala",LocalDate.parse("2010-06-15"),"foto",d7);
        Mascota m8= new Mascota("Figaro",TipoMascota.Gato,"Siamés",LocalDate.parse("2011-04-18"),"foto",d8);
        Mascota m9= new Mascota("Gatsby",TipoMascota.Gato,"Siberiano",LocalDate.parse("2019-10-08"),"foto",d9);
        Mascota m10= new Mascota("Coco",TipoMascota.Gato,"Munchkin",LocalDate.parse("2020-02-10"),"foto",d10);
        mascotas.add(m1);
        mascotas.add(m2);
        mascotas.add(m3);
        mascotas.add(m4);
        mascotas.add(m5);
        mascotas.add(m6);
        mascotas.add(m7);
        mascotas.add(m8);
        mascotas.add(m9);
        mascotas.add(m10);
        
        //Creacion y agregacion de las ciudades
        Ciudad c1= new Ciudad("Guayaquil","Guayas");
        Ciudad c2= new Ciudad("Quito","Pichinca");
        Ciudad c3= new Ciudad("Cuenca","Azuay");
        ciudades.add(c1);
        ciudades.add(c2);
        ciudades.add(c3);
        
        ////Creacion y agregacion de los auspiciantes
        Auspiciante a1= new Auspiciante("Pilsener","Km. 16,5 Vía a Daule, Guayaquil","0988926529","pilsener@gmail.com","https://www.pilsener.com.ec");
        Auspiciante a2= new Auspiciante("Banco de Guayaquil"," Av. Vicente Rocafuerte Bejarano 623","3730100","bguayaquildc@superbancos.gob.ec","https://www.bancoguayaquil.com");
        Auspiciante a3= new Auspiciante("Kia Motors","Av. Luis Cordero Crespo entre Av. Americas","542542","kiamotors@gmail.com","https://www.kia.com.ec");
        auspiciantes.add(a1);
        auspiciantes.add(a2);
        auspiciantes.add(a3);
        
        //Creacion del premio para concurso pasado
        Premio p1=new Premio("Primer Puesto","Una jaba de cerveza",a1);
        ArrayList<Premio> premios = new ArrayList<Premio>();
        premios.add(p1);
        
        //Creacion del ArrayList de Auspiciantes de este concurso pasado
        ArrayList<Auspiciante> auspiciantes = new ArrayList<Auspiciante>();
        auspiciantes.add(a1);
        
        //Creacion del concurso pasado
        Concurso c=new Concurso("Patitas para todos",LocalDate.parse("2020-11-24"),LocalTime.of(12, 00, 00),LocalDate.parse("2020-11-18"),LocalDate.parse("2020-11-22"),c1,premios,auspiciantes,"Centro de convenciones",TipoMascota.Perro);
        
        //Asignacion de las mascotas inscritas
        ArrayList<Mascota> mascInscritas= new ArrayList<Mascota>();
        mascInscritas.add(m1);
        mascInscritas.add(m2);
        mascInscritas.add(m3);
        mascInscritas.add(m4);
        mascInscritas.add(m5);
        c.setMascotasInscrita(mascInscritas);

        //Asignacion de los ganadores
        ArrayList<Mascota> ganadores= new ArrayList<Mascota>();
        ganadores.add(m1);
        ganadores.add(m3);
        ganadores.add(m5);
        c.setGanadores(ganadores);
        concursos.add(c);
        
        //Creacion del premio para concurso vigente
        Premio p2=new Premio("Primer Puesto","Moto",a2);
        ArrayList<Premio> premios2 = new ArrayList<Premio>();
        premios2.add(p2);
        
        //Creacion del ArrayList de Auspiciantes de este concurso pasado
        ArrayList<Auspiciante> auspiciantes2 = new ArrayList<Auspiciante>();
        auspiciantes2.add(a3);
        
        //Creacion del concurso vigente
        Concurso con1=new Concurso("Navidad de gatos",LocalDate.parse("2021-12-20"),LocalTime.of(14, 00, 00),LocalDate.parse("2021-12-10"),LocalDate.parse("2021-12-18"),c2,premios2,auspiciantes2,"El Dorado",TipoMascota.Gato);
        
        //Asignacion de las mascotas inscritas del concurso vigente
        ArrayList<Mascota> mascInscritas2= new ArrayList<Mascota>();
        mascInscritas2.add(m6);
        mascInscritas2.add(m7);
        mascInscritas2.add(m8);
        mascInscritas2.add(m9);
        mascInscritas2.add(m10);
        con1.setMascotasInscrita(mascInscritas2);
        concursos.add(con1);

        for(Mascota m:mascotas){
            mascotasQueParticiparon.add(m);
        }

        metodoMenu();
     }  
}
