package iterators;

import interfaces.IteradorCurso;
import models.Curso;
import java.util.List;

public class IteradorPorNRC implements IteradorCurso {
    private List<Curso> cursos;
    private String nrcBuscado;
    private int posicion;

    public IteradorPorNRC(List<Curso> cursos, String nrcBuscado) {
        this.cursos = cursos;
        this.nrcBuscado = nrcBuscado;
        this.posicion = 0;
    }

    @Override
    public boolean hasNext() {
        
        // Recorrido lineal con filtro de búsqueda por NRC
        while (posicion < cursos.size()) {
            if (cursos.get(posicion).getNrc().equals(nrcBuscado)) {
                return true; 
            }
            posicion++; 
        }
        return false; 
    }

    @Override
    public Curso next() {
        if (this.hasNext()) {
            Curso cursoEncontrado = cursos.get(posicion);
            posicion++; 
            return cursoEncontrado;
        }
        return null;
    }
}