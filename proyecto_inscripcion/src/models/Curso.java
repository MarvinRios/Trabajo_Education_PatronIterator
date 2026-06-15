package models;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nrc;        
    private String nombre;     
    private int creditos;
    private List<Curso> prerrequisitos;
    
    public Curso(String nrc, String nombre, int creditos) {
        this.nrc = nrc;
        this.nombre = nombre;
        this.creditos = creditos;
        this.prerrequisitos = new ArrayList<>();
    }

    public void agregarPrerrequisito(Curso cursoPrevio) {
        this.prerrequisitos.add(cursoPrevio);
    }

    public String getNrc() { return nrc; }
    public void setNrc(String nrc) { this.nrc = nrc; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }

    public List<Curso> getPrerrequisitos() { return prerrequisitos; }
    public void setPrerrequisitos(List<Curso> prerrequisitos) { this.prerrequisitos = prerrequisitos; }

    @Override
    public String toString() {
        return "[" + nrc + "] " + nombre + " (" + creditos + " crds)";
    }
}