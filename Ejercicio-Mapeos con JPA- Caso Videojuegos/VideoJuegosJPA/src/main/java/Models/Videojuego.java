/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jesus
 */
@Entity
public class Videojuego implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private int puntaje;
    private String desarrolladora;
    
    @OneToMany(mappedBy = "videojuego", cascade = CascadeType.ALL)
    private Set<Logro> logros;
    
    @ManyToMany
    @JoinTable(
            name = "videojuego_jugador",
            joinColumns= @JoinColumn(name = "videojuego_id"),
            inverseJoinColumns =@JoinColumn(name ="jugador_id")
    
    )
    private Set<Jugador> jugadores = new HashSet<>();
    
    

    public Videojuego() {
    }

    public Videojuego(Long id, String nombre, int puntaje, String desarrolladora, Set<Logro> logros) {
        this.id = id;
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.desarrolladora = desarrolladora;
        this.logros = logros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public Set<Logro> getLogros() {
        return logros;
    }

    public void setLogros(Set<Logro> logros) {
        this.logros = logros;
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
        if (!(object instanceof Videojuego)) {
            return false;
        }
        Videojuego other = (Videojuego) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Videojuego[ id=" + id + " ]";
    }
    
}
