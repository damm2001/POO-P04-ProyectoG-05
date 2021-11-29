
package proyecto;


public class Persona {
   
    protected String nombre;
    protected String direccion;
    protected String telefono;
    protected Ciudad ciudad;
    protected String email;

    public Persona(String nombre,String direccion,String telefono, String email){
        this.nombre=nombre;
        this.direccion=direccion;
        this.telefono=telefono;
        this.email=email;
    }

    public Persona() {
    }

  
    
}
