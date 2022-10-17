/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Interface;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.Modelo.Reservation;

import java.util.Date;
import java.util.List;

/**
 *
 * @author USUARIO
 */

public interface ReservationInterface extends CrudRepository<Reservation, Integer> {

    //RETO 5
    //select * from reservation where stardate, after fecha y devolution before fehca 2
    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo );

    //selec count(*) FROM reservation WHERE status = "completed" --> retorna un numero de las completadas
    //selec count(*) FROM reservation WHERE status = "cancelled" --> retorna un numero de las canceladas

    public List<Reservation>findAllByStatus(String status);

    //[cliente total]
//posicion 0     1
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC ")
    public List<Object[]> countTotalReservationByClient();

}
