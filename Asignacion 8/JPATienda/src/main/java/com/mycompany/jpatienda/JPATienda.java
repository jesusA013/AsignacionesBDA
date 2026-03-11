/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jpatienda;

import dao.ProductoDAO;
import models.Producto;

/**
 *
 * @author Jesus
 */
public class JPATienda {

    public static void main(String[] args) {
        ProductoDAO dao = new ProductoDAO();
        Producto p1 = new Producto();
        
        //Insertar
        p1.setNombre("Laptop");
        p1.setPrecio(15000.50);
        dao.insertar(p1);
        
        //Buscar
        Producto buscado = dao.buscar(1);
        System.out.println("Producto encontrado: "+ buscado.getNombre());
        
        //Actualizar
        buscado.setPrecio(14000.00);
        dao.actualizar(buscado);
        
        //Eliminar
        dao.eliminar(1);
    }
}
