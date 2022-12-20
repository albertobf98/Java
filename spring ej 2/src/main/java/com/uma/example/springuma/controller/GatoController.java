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

import com.uma.example.springuma.model.Gato;
import com.uma.example.springuma.model.GatoService;

@RestController
public class GatoController {

    @Autowired
    private GatoService gatoService;

    @GetMapping("/gatos_")
    public List<Gato> getGatos(){
        return gatoService.getAllGatos();
    }

    @PostMapping(value = "/gatos_", consumes = "application/json")
    public ResponseEntity<?> save(@RequestBody Gato gato) {
        if(gatoService.addGato(gato) == null){
            return ResponseEntity.internalServerError().body("El gato ya existe");
        }else{
            return ResponseEntity.ok().body("El gato se ha anyadido");
        }
    }

    @GetMapping("/gato_/{id}")
    public Gato getGato(@PathVariable("id") Long id) {
        return gatoService.getGato(id);
    }

    @PutMapping(value= "/gato_/{id}", consumes = "application/json")
    public void actualizarGato (@RequestBody Gato gato) {
        gatoService.updateGato(gato);
    }

    @DeleteMapping("/gato_/{id}")
    public ResponseEntity<?> deleteGato(@RequestBody Gato g){
        gatoService.deleteGato(g);
        return ResponseEntity.ok().body("Gato eliminada con exito");
    }

}
