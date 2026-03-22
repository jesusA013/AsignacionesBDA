package com.mycompany.dogosobregon.servicio;

import com.mycompany.dogosobregon_dominio.Cliente;



public interface IClienteService extends IGenericoService<Cliente, Long> {
    Cliente buscarPorNombre(String nombre);
    void registrarClienteNuevo(Cliente c);
}
