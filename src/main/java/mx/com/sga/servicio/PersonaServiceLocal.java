
package mx.com.sga.servicio;
import java.util.List;
import javax.ejb.Local;
import mx.com.sga.domain.Persona;

/**
 *
 * @author nestordev
 */
@Local
public interface PersonaServiceLocal {
    public List<Persona> listaPersonas();
   public Persona encontrarPersonaPorId(Persona persona);
   public Persona encontrarPersonaPorCorreo(Persona persona);
   public void resgistrarPersona(Persona persona);
   public void modificarpersona(Persona persona);
   public void eliminarPersona(Persona persona);
}
