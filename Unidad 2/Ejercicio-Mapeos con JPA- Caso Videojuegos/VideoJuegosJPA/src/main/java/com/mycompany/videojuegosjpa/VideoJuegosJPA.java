/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.videojuegosjpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Jesus
 */
public class VideoJuegosJPA {

    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("VideoJuegosPU");
        EntityManager em = emf.createEntityManager();
        
        
    }
}
