package com.uma.example.springuma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uma.example.springuma.model.Gato;
import com.uma.example.springuma.model.GatoService;

@Controller
public class GatoViewController {
    @Autowired
    private GatoService gatoService;

    /*---Devuelve el formulario para anyadir una nueva cuenta con una cuenta vacia---*/

    /*---Devuelve el formulario para listar las cuentas del sistema---*/
    @GetMapping("/listGatos")
    public String listGatoView(Model model) {
        model.addAttribute("gatos", gatoService.getAllGatos());
        return "listaGatos";
    }

    @PostMapping("/removeGato/{id}")
    public String removeGato(@PathVariable("id") Long id, Model model) {
        gatoService.deleteGatoID(id);
        model.addAttribute("gato", gatoService.getGato(id));
        
        return listGatoView(model);
    }

    @GetMapping("/nuevoGato")
    public String AddGatoView(Model model) {
        model.addAttribute("gato", new Gato());
        return "addGato";
    }

    @PostMapping("/crearGato")
    public String CrearGato(Gato gato, Model model) {
        gatoService.addGato(gato);
        model.addAttribute("gato", gatoService.getGato(gato.getID()));

        return listGatoView(model);
    }

    @PostMapping("/editaGato/{id}")
    public String EditarGato(@PathVariable("id") Long id, Model model){
        model.addAttribute("gato", gatoService.getGato(id));
        return "editgato";
    }

    @PostMapping("/actualizaGato")
    public String ActGato(Gato gato, Model model){
        gatoService.updateGato(gato);
        model.addAttribute("gato", gatoService.getGato(gato.getID()));

        return listGatoView(model);
    }
}
