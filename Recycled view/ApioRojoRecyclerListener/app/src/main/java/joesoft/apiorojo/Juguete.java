package joesoft.apiorojo;

/**
 * Created by joe on 10/5/16.
 */
public class Juguete {
    private String nombre;
    private Integer platita;

    public Juguete(String nombre, Integer platita) {
        this.nombre = nombre;
        this.platita = platita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPlatita() {
        return platita;
    }

    public void setPlatita(Integer platita) {
        this.platita = platita;
    }
}
