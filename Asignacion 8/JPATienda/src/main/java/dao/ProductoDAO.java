/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import models.Producto;

/**
 *
 * @author Jesus
 */
public class ProductoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");

    public void insertar(Producto p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }

    public Producto buscar(int id) {
        EntityManager em = emf.createEntityManager();
        Producto p = em.find(Producto.class, id);
        em.close();
        return p;

    }

    public void actualizar(Producto p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminar(int id) {
        EntityManager em = emf.createEntityManager();
        Producto p = em.find(Producto.class, id);
        if (p != null) {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        }
        em.close();
    }
}
