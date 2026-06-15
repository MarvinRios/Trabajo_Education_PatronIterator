import interfaces.IteradorCurso;
import models.Curso;
import models.MallaCurricular;

public class Main {
    public static void main(String[] args) {

        Curso mate1 = new Curso("8001", "Matematicas I", 4);
        Curso progra1 = new Curso("8002", "Programacion Basica", 4);
        Curso mate2 = new Curso("8003", "Matematicas II", 4);
        Curso estDatos = new Curso("8004", "Estructura de Datos", 4);

        Curso baseDatos = new Curso("8005", "Base de Datos I", 4);
        Curso estadistica = new Curso("8006", "Estadistica y Probabilidades", 3);
        Curso ingSoftware = new Curso("8007", "Ingenieria de Software", 4);
        Curso redes = new Curso("8008", "Redes y Conectividad", 4);
        Curso desWeb = new Curso("8009", "Desarrollo Web Avanzado", 3);

        mate2.agregarPrerrequisito(mate1);
        estDatos.agregarPrerrequisito(progra1);
        estDatos.agregarPrerrequisito(mate1);

        baseDatos.agregarPrerrequisito(estDatos);    // Para BD I necesitas Estructura de Datos
        estadistica.agregarPrerrequisito(mate2);    // Para Estadística necesitas Mate II
        ingSoftware.agregarPrerrequisito(baseDatos); // Para Ing. Software necesitas BD I
        redes.agregarPrerrequisito(estDatos);       // Para Redes necesitas Estructura de Datos
        desWeb.agregarPrerrequisito(progra1);       // Para Desarrollo Web necesitas Progra Básica
        desWeb.agregarPrerrequisito(baseDatos);     // Y también Base de Datos I

        MallaCurricular malla = new MallaCurricular();
        malla.agregarCurso(mate1);
        malla.agregarCurso(progra1);
        malla.agregarCurso(mate2);
        malla.agregarCurso(estDatos);
        malla.agregarCurso(baseDatos);
        malla.agregarCurso(estadistica);
        malla.agregarCurso(ingSoftware);
        malla.agregarCurso(redes);
        malla.agregarCurso(desWeb);

        // 5. PRUEBA DE ITERADOR POR NRC
        // Probemos buscando un curso avanzado que tenga múltiples prerrequisitos en sus nodos
        String nrcBuscado = "8009"; 
        System.out.println("=== EXAMEN DE RECORRIDO ITERATOR - BUSQUEDA POR NRC ===");
        System.out.println("Buscando en la malla el NRC: " + nrcBuscado + "\n");

        IteradorCurso miIterador = malla.crearIteradorPorNRC(nrcBuscado);

        if (!miIterador.hasNext()) {
            System.out.println("No se encontro ningun curso con el NRC especificado.");
        }

        while (miIterador.hasNext()) {
            Curso cursoEncontrado = miIterador.next();
            System.out.println("► Curso Encontrado: " + cursoEncontrado.getNombre());
            System.out.println("  Creditos: " + cursoEncontrado.getCreditos());
            System.out.println("  Nodos de Prerrequisito Detectados:");
            
            if (cursoEncontrado.getPrerrequisitos().isEmpty()) {
                System.out.println("    (Ninguno - Curso de primer ciclo)");
            } else {
                for (Curso pre : cursoEncontrado.getPrerrequisitos()) {
                    System.out.println("    - [" + pre.getNrc() + "] " + pre.getNombre());
                }
            }
        }
    }
}