package com.uma.example.springuma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uma.example.springuma.model.Raza;
import com.uma.example.springuma.model.RazaService;

@RestController
public class RazaController {
    @Autowired
    private RazaService razaService;

    @GetMapping("/razas")
    public List<Raza> getRazas(){
        return razaService.getAllRazas();
    }

    @PostMapping(value = "/razas", consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody Raza raza) {
        if(razaService.addRaza(raza) == null){
            return ResponseEntity.internalServerError().body("La raza ya existe");
        }else{
            return ResponseEntity.ok().body("La raza se ha anyadido");
        }
    }

    @GetMapping("/raza/{id}")
    public Raza getRaza(@PathVariable("id") Long id) {
        return razaService.getRaza(id);
    }

    @PutMapping("/raza/{id}")
    public void actualizarRaza (@RequestBody Raza raza) {
        razaService.updateRaza(raza);
    }

    @DeleteMapping("/raza/{id}")
    public ResponseEntity<?> deleteRaza(@RequestBody Raza raza){
        razaService.deleteRaza(raza);
        return ResponseEntity.ok().body("Raza eliminada con exito");
    }
    
}
