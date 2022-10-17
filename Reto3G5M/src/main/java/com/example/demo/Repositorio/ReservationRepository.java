/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Interface.ReservationInterface;
import com.example.demo.Modelo.Client;
import com.example.demo.Modelo.DTOs.TotalAndClient;
import org.springframework.stereotype.Repository;
import com.example.demo.Modelo.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author USUARIO
 */

@Repository

public class ReservationRepository {
    @Autowired
    private ReservationInterface extencionesCrud;

    public List<Reservation> getAll() {
        return (List<Reservation>) extencionesCrud.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return extencionesCrud.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return extencionesCrud.save(reservation);
    }

    public void delete(Reservation reservation) {
        extencionesCrud.delete(reservation);
    }

    //RETO 5
    public List<Reservation> getReservationInPeriod(Date a, Date b) {
        return extencionesCrud.findAllByStartDateAfterAndDevolutionDateBefore(a, b);
    }

    public List<Reservation> getReservationByStatus(String status) {
        return extencionesCrud.findAllByStatus(status);
    }

    public List<TotalAndClient> getTopClients() {
        List<TotalAndClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = extencionesCrud.countTotalReservationByClient();

        for (int i = 0; i < reporte.size(); i++) {
            respuesta.add(new TotalAndClient((long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }
        return respuesta;
    }

}

