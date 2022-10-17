/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Interface.OrtopedicInterface;
import com.example.demo.Modelo.Ortopedic;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author USUARIO
 */

@Repository

public class OrtopedicRepository {
     @Autowired
    private OrtopedicInterface ortopedicCrud;
    
    public List<Ortopedic> getAll(){
        return (List<Ortopedic>) ortopedicCrud.findAll();
    }
    
    public Optional<Ortopedic> getOrtopedic(int id){
        return ortopedicCrud.findById(id);
    }
    
    public Ortopedic save(Ortopedic ortopedic){
        return ortopedicCrud.save(ortopedic);
    }

    public void delete (Ortopedic ortopedic){ortopedicCrud.delete(ortopedic);
    }
}
