/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.sga.Cliente;

import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import mx.com.sga.servicio.PersonaServiceRemote;
import mx.com.sga.domain.Persona;

/**
 *
 * @author nestordev
 */

public class ClientePersonaService {
    
    public static void main(String[] args) {
        System.out.println("Iniciando la peticion a el EJB desde el cliente");
        
        try {
            
            Context  jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/projectSGA_JEE/PersonaServiceImpl!mx.com.sga.servicio.PersonaServiceRemote");
            
            List<Persona> personas = personaService.listaPersonas();
            
            for (Persona persona : personas) {
                System.out.println(persona);
            }
            System.out.println("\n Fin de peticon al el EJB desde el cliente");    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
