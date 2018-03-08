
package mx.com.sga.servicio;
import java.util.List;
import javax.ejb.Remote;
import mx.com.sga.domain.Persona;

@Remote
public interface PersonaServiceRemote {
   public List<Persona> listaPersonas();
   public Persona encontrarPersonaPorId(Persona persona);
   public Persona encontrarPersonaPorCorreo(Persona persona);
   public void resgistrarPersona(Persona persona);
   public void modificarpersona(Persona persona);
   public void eliminarPersona(Persona persona);
}
