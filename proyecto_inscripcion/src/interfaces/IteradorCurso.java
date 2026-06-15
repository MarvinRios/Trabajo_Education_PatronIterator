package interfaces;
import models.Curso;

public interface IteradorCurso {
    boolean hasNext();
    Curso next();
}