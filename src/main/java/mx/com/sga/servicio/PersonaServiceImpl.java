/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.sga.servicio;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.sga.domain.Persona;
import mx.com.sga.els.PersonaDao;

/**
 *
 * @author nestordev
 */
@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaServiceLocal{
    
    @Inject
    private PersonaDao personaDao;

    @Override
    public List<Persona> listaPersonas() {
     return personaDao.findAllPersonas();
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
      return personaDao.findPersonaById(persona);
    }

    @Override
    public Persona encontrarPersonaPorCorreo(Persona persona) {
      return personaDao.findPersonaByEmail(persona);
    }

    @Override
    public void resgistrarPersona(Persona persona) {
        personaDao.insertPersona(persona);
    }

    @Override
    public void modificarpersona(Persona persona) {
       personaDao.updatePersona(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
       personaDao.deletePersona(persona);
    }
    
}
