package org.integrados.data.plantillas;

import java.util.List;
import org.integrados.data.bloques.*;

public class Ordenamiento extends Plantilla {

    public Ordenamiento() {
        super();
        super.tipoPlantilla = "Ordenamiento";
    }

    public Ordenamiento(String enunciado, List<Bloque> soluciones) {
        super(enunciado, soluciones);
        super.tipoPlantilla = "Ordenamiento";
    }

    @Override
    public List<Bloque> desordenar() {
        int cambios = 0;
        List<Bloque> listaDesordenada = this.clonarLista(super.soluciones);

        while (cambios < listaDesordenada.size()) {
            for (int i = 0; i < listaDesordenada.size(); i++) {
                int index = (int) (Math.random() * listaDesordenada.size());

                Bloque bloqueActual = listaDesordenada.get(i);
                Bloque auxiliar = listaDesordenada.get(index);

                listaDesordenada.remove(i);
                listaDesordenada.add(i, auxiliar);

                listaDesordenada.remove(index);
                listaDesordenada.add(index, bloqueActual);

                cambios++;
            }
        }
        return listaDesordenada;
    }

    @Override
    public Boolean verificarResultado(List<Bloque> respuestaAlumno) {

        for (int i = 0; i < respuestaAlumno.size(); i++) {
            //desarrollar metodo equals dentro de cada tipo de bloque para que compare por id
            if (!respuestaAlumno.get(i).equals(super.soluciones.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean validarPlantilla() {
        if (super.soluciones.size() < 1) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
