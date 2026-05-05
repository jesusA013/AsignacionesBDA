/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

/**
 *
 * @author Jesus
 */
@Entity
public class Cliente implements Serializable {

    //LLave Primaria
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_cliente")
    private Long id;

    //Atributos simples
    @Column(name = "fch_nac", nullable = false)
    private LocalDate fch_nac;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "ap_pat", nullable = false)
    private String ap_pat;

    @Column(name = "ap_mat", nullable = false)
    private String ap_mat;

    //Atributos multivaluados
    @ElementCollection
    @CollectionTable(name = "Cliente_Correos", joinColumns = @JoinColumn(name = "num_cliente"))
    @Column(name = "correo")
    private Set<String> correos;

    @ElementCollection
    @CollectionTable(name = "Cliente_Telefonos", joinColumns = @JoinColumn(name = "num_cliente"))
    @Column(name = "telefono")
    private Set<String> telefonos;


    
    
    
    public Cliente() {
    }

 

    public LocalDate getFch_nac() {
        return fch_nac;
    }

    public void setFch_nac(LocalDate fch_nac) {
        this.fch_nac = fch_nac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_pat() {
        return ap_pat;
    }

    public void setAp_pat(String ap_pat) {
        this.ap_pat = ap_pat;
    }

    public String getAp_mat() {
        return ap_mat;
    }

    public void setAp_mat(String ap_mat) {
        this.ap_mat = ap_mat;
    }

    public Set<String> getCorreos() {
        return correos;
    }

    public void setCorreos(Set<String> correos) {
        this.correos = correos;
    }

    public Set<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<String> telefonos) {
        this.telefonos = telefonos;
    }

    public int getEdad() {
        if (this.fch_nac == null) {
            return 0;
        }
        return Period.between(this.fch_nac, LocalDate.now()).getYears();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Cliente[ id=" + id + " ]";
    }

}
