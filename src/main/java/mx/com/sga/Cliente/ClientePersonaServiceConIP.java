/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.sga.Cliente;

import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import mx.com.sga.domain.Persona;
import mx.com.sga.servicio.PersonaServiceRemote;

/**
 *
 * @author nestordev
 */
public class ClientePersonaServiceConIP {
    
    public static void main(String[] args) {
        System.out.println("Iniciando la peticion a el EJB desde el cliente IP");
        
        try {
            Properties props = new Properties();
            props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            // opcional. Default localhost, aqui se cambia la direccion del servidor.
            props.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
            
            Context  jndi = new InitialContext(props);
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/projectSGA_JEE/PersonaServiceImpl!mx.com.sga.servicio.PersonaServiceRemote");
            
            List<Persona> personas = personaService.listaPersonas();
            
            for (Persona persona : personas) {
                System.out.println(persona);
            }
            System.out.println("\n Fin de peticon al el EJB desde el cliente IP");    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
