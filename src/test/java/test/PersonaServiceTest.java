/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import mx.com.sga.servicio.PersonaServiceLocal;
import mx.com.sga.domain.Persona;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author nestordev
 */
public class PersonaServiceTest {

    private PersonaServiceLocal clienteService;
    
    EJBContainer contenedor;
    
   @Before
    public void iniciarContenedor() throws Exception {
         contenedor = EJBContainer.createEJBContainer();
         System.out.println("Iniciando EJB Container mio");
         clienteService =  (PersonaServiceLocal) contenedor.getContext().lookup("java:global/classes/PersonaServiceImpl!mx.com.sga.servicio.PersonaServiceLocal");
         
    }
    
    @Test
    public void testEJB() {
        this.testEJBPersonaService();        
    }
    
    private void testEJBPersonaService() {
        System.out.println("Iniciando test EJB PersonaService");
        assertTrue(clienteService != null);

        assertEquals(2, clienteService.listaPersonas().size());

        System.out.println("El no. de personas es igual a:" + clienteService.listaPersonas().size());

        this.desplegarPersonas(clienteService.listaPersonas());
        System.out.println("Fin test EJB PersonaService");
    }



    private void desplegarPersonas(List<Persona> personas) {

        for (Persona p : personas) {
            System.out.println(p);
        }
        //Esto genera un error ya que el servidor embebido no soporta Java 8
        //personas.forEach((persona) -> {
        //    System.out.println(persona);
        //});
    }
    
}
