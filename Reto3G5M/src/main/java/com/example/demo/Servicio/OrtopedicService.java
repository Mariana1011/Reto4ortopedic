/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Ortopedic;
import com.example.demo.Repositorio.OrtopedicRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */

@Service

public class OrtopedicService {
      @Autowired
    private OrtopedicRepository ortopedicRepository;
    
    public List<Ortopedic> getAll(){
        return ortopedicRepository.getAll();
    }
    
    public Optional<Ortopedic> getOrtopedic(int id){
        return ortopedicRepository.getOrtopedic(id);
    }
    
    public Ortopedic save (Ortopedic ortopedic){
        if (ortopedic.getId() == null){
            return ortopedicRepository.save(ortopedic);
        } else {
            Optional<Ortopedic> ortopedic1 = ortopedicRepository.getOrtopedic(ortopedic.getId());
            if(ortopedic1.isEmpty()){
                return ortopedicRepository.save(ortopedic);
            } else {
                return ortopedic;
            }
        }
    }

    public Ortopedic update(Ortopedic ortopedic){
        if(ortopedic.getId()!=null){
            Optional<Ortopedic> e= ortopedicRepository.getOrtopedic(ortopedic.getId());
            if(!e.isEmpty()){
                if(ortopedic.getName()!=null){
                    e.get().setName(ortopedic.getName());
                }
                if(ortopedic.getBrand()!=null){
                    e.get().setBrand(ortopedic.getBrand());
                }
                if(ortopedic.getYear()!=null){
                    e.get().setYear(ortopedic.getYear());
                }
                if(ortopedic.getDescription()!=null){
                    e.get().setDescription(ortopedic.getDescription());
                }
                if(ortopedic.getCategory()!=null){
                    e.get().setCategory(ortopedic.getCategory());
                }
                ortopedicRepository.save(e.get());
                return e.get();
            }else{
                return ortopedic;
            }
        }else{
            return ortopedic;
        }
    }

    public boolean deleteOrtopedic(int ortopedicId){
        Boolean d=getOrtopedic(ortopedicId).map(ortopedic -> {
            ortopedicRepository.delete(ortopedic);
            return true;
        }).orElse(false);
        return d;
    }
}
