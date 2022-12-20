package com.uma.example.springuma.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RazaService {
    @Autowired
    RepositoryRaza repositoryRaza;

    public List<Raza> getAllRazas(){
        return repositoryRaza.findAll();
    }

    public Raza getRaza(Long id){
        return repositoryRaza.getReferenceById(id);
    }

    public Raza addRaza(Raza g){
        return repositoryRaza.saveAndFlush(g);
    }

    public void deleteRaza(Raza g){
        repositoryRaza.delete(g);
    }

    public void updateRaza(Raza g){
        Raza raza = repositoryRaza.getReferenceById(g.getID());
        raza.setAmabilidad(g.getAmabilidad());
        raza.setPelosidad(g.getPelosidad());
        raza.setTamanyo(g.getTamanyo());
        raza.setNombre(g.getNombre());
        repositoryRaza.saveAndFlush(raza);
    }
}
