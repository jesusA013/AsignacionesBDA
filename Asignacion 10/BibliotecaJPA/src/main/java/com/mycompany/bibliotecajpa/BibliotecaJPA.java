/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bibliotecajpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
/**
 *
 * @author Jesus
 */
public class BibliotecaJPA {

    public static void main(String[] args) {
       EntityManagerFactory emf= Persistence.createEntityManagerFactory("BibliotecaPU");
       EntityManager em = emf.createEntityManager();
    }
}
