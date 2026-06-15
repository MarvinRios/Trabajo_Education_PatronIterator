package models;

import interfaces.ColeccionCursos;
import interfaces.IteradorCurso;
import iterators.IteradorPorNRC;
import java.util.ArrayList;
import java.util.List;

public class MallaCurricular implements ColeccionCursos {
    private List<Curso> listaCursos;

    public MallaCurricular() {
        this.listaCursos = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        this.listaCursos.add(curso);
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    @Override
    public IteradorCurso crearIteradorPorNRC(String nrcBuscado) {
        return new IteradorPorNRC(this.listaCursos, nrcBuscado);
    }
}