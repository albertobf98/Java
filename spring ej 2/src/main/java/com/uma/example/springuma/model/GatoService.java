package com.uma.example.springuma.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatoService {
    @Autowired
    RepositoryGato repositoryGato;

    public List<Gato> getAllGatos(){
        return repositoryGato.findAll();
    }

    public Gato getGato(Long id){
        return repositoryGato.getReferenceById(id);
    }

    public Gato addGato(Gato g){
        return repositoryGato.saveAndFlush(g);
    }

    public void deleteGato(Gato g){
        repositoryGato.delete(g);
    }

    public void deleteGatoID (Long id){
        repositoryGato.deleteById(id);
    }

    public void updateGato(Gato g){
        Gato gato = repositoryGato.getReferenceById(g.getID());
        gato.setColor(g.getColor());
        gato.setEdad(g.getEdad());
        gato.setName(g.getName());
        gato.setRaza(g.getRaza());
        repositoryGato.saveAndFlush(gato);
    }
}
