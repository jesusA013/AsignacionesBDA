/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 *
 * @author Jesus
 */
@Entity
public class Pedido implements Serializable {

    //Llave primaria
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "num_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private Set<PedidoProducto> pedidosProductos;

    public Pedido() {
    }

    public Pedido(Long id, Cliente cliente, Set<PedidoProducto> pedidosProductos) {
        this.id = id;
        this.cliente = cliente;
        this.pedidosProductos = pedidosProductos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<PedidoProducto> getPedidosProductos() {
        return pedidosProductos;
    }

    public void setPedidosProductos(Set<PedidoProducto> pedidosProductos) {
        this.pedidosProductos = pedidosProductos;
    }

    //Metodos Derivados
    public BigDecimal getSubtotal() {
        BigDecimal acumulador = BigDecimal.ZERO;

        if (this.pedidosProductos == null) {
            return acumulador;
        }

        for (PedidoProducto pedidoProducto : this.pedidosProductos) {

            acumulador = acumulador.add(pedidoProducto.getImporte());
        }

        return acumulador;
    }

    public BigDecimal getIva() {
        BigDecimal porcentajeIva = new BigDecimal("0.16");
        //IVA =subtotal *0.16
        return this.getSubtotal().multiply(porcentajeIva);
    }

    public BigDecimal getTotal() {
        return this.getSubtotal().add(this.getIva());
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Pedido[ id=" + id + " ]";
    }

}
