package org.validator.model;

import java.util.List;

public class Alumno {
    private List<Materia> aprobadas;

    public Alumno(List<Materia> aprobadas) {
        this.aprobadas = aprobadas;
    }

    public List<Materia> getAprobadas() {
        return aprobadas;
    }
}
