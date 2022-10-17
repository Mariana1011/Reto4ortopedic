/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import com.example.demo.Modelo.Ortopedic;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Servicio.OrtopedicService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/Ortopedic")

public class OrtopedicController {
      @Autowired
    private OrtopedicService ortopedicService;
    
    @GetMapping("/all")
    public List<Ortopedic> getAll(){
        return ortopedicService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Ortopedic> getTool(@PathVariable("id") int id){
        return ortopedicService.getOrtopedic(id);
    } 
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic save (@RequestBody Ortopedic ortopedic){
        return ortopedicService.save(ortopedic);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic update(@RequestBody Ortopedic ortopedic) {
        return ortopedicService.update(ortopedic);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int ortopedicId){
        return ortopedicService.deleteOrtopedic(ortopedicId);
    }
}
