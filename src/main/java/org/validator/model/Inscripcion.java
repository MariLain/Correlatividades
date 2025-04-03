package org.validator.model;

import java.util.List;

public class Inscripcion {

    private List<Materia> materias;

    private Alumno alumno;

    public Inscripcion(List<Materia> materias, Alumno alumno) {
        this.materias = materias;
        this.alumno = alumno;
    }

    public boolean aprobada() {
        List<Materia> aprobadas = alumno.getAprobadas();
        List<Materia> necesarias = materias.stream()
                .flatMap(materia -> materia.getCorrelativas().stream())
                .distinct()
                .toList();
        return aprobadas.containsAll(necesarias);
    }
}
