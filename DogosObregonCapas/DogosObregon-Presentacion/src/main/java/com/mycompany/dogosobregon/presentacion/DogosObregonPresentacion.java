/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dogosobregon.presentacion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author j_ama
 */
public class DogosObregonPresentacion {

    public static void main(String[] args) {
       

        System.out.println("--- Iniciando Pruebas de Servicios Dogos Obregón ---");

        try {
            // 1. Guardar Cliente
            Cliente cliente = new Cliente();
            cliente.setNombre("Juan");
            cliente.setApPaterno("Pérez");
            cliente.setFchNac(LocalDate.of(1990, 5, 20));
            clienteService.guardar(cliente);
            System.out.println("Cliente guardado exitosamente.");

            // 2. Guardar HotDog
            HotDog hotdog = new HotDog();
            hotdog.setNombre("Dogo Sencillo");
            hotdog.setPrecio(new BigDecimal("35.00"));
            hotdog.setIva(new BigDecimal("0.16"));
            hotDogService.guardar(hotdog);
            System.out.println("HotDog guardado exitosamente.");

            // 3. Crear Pedido
            Pedido pedido = new Pedido();
            pedido.setCliente(cliente);
            pedido.setFecha(LocalDateTime.now());
            pedido.setMetodoPago(MetodoPago.EFECTIVO);
            pedidoService.guardar(pedido);
            System.out.println("Pedido guardado exitosamente.");

            // 4. Crear Detalles de Pedido
            PedidoDetalle detalle = new PedidoDetalle();
            detalle.setPedido(pedido);
            detalle.setHotdog(hotdog);
            detalle.setCantidad(2);
            detalle.setPrecioVenta(hotdog.getPrecio());
            detalle.setSubtotal(hotdog.getPrecio().multiply(new BigDecimal(2)));
            pedidoDetalleService.guardar(detalle);
            System.out.println("Detalle guardado exitosamente.");

            // 5. Prueba de Validaciones (Debe lanzar excepción)
            System.out.println("\nProbando validación de HotDog sin nombre...");
            HotDog hotDogInvalido = new HotDog();
            // Esto lanzará IllegalArgumentException porque el nombre es nulo
            hotDogService.guardar(hotDogInvalido);

        } catch (IllegalArgumentException e) {
            System.out.println("Excepción de validación capturada exitosamente: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Excepción inesperada: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
