package model;

import org.junit.jupiter.api.Test;
import org.validator.model.Alumno;
import org.validator.model.Inscripcion;
import org.validator.model.Materia;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InscripcionTest {

    @Test
    void aprobada_materiaSinCorrelativas_true(){
        Alumno alumno = new Alumno(List.of());
        Materia materia = new Materia("Algoritmos", List.of());

        Inscripcion inscripcion = new Inscripcion(List.of(materia),alumno);

        assertTrue(inscripcion.aprobada());
    }

    @Test
    void aprobada_materiaConCorrelativas_true(){
        Materia correlativa = new Materia("Algoritmos", List.of());
        Alumno alumno = new Alumno(List.of(correlativa));
        Materia materia = new Materia("Paradigmas", List.of(correlativa));

        Inscripcion inscripcion = new Inscripcion(List.of(materia),alumno);

        assertTrue(inscripcion.aprobada());
    }

    @Test
    void aprobada_materiaConCorrelativaSinAprobar_false(){
        Materia correlativa = new Materia("Algoritmos", List.of());
        Alumno alumno = new Alumno(List.of());
        Materia materia = new Materia("Paradigmas", List.of(correlativa));

        Inscripcion inscripcion = new Inscripcion(List.of(materia),alumno);

        assertFalse(inscripcion.aprobada());
    }

    @Test
    void aprobada_inscripcionSinMaterias_true() {
        Alumno alumno = new Alumno(List.of());

        Inscripcion inscripcion = new Inscripcion(List.of(),alumno);

        assertTrue(inscripcion.aprobada());
    }
}
