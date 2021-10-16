package com.example.fivecalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Calendario {

    List<Tarea> tareas = new ArrayList<>();
    Horario horario;

    public Calendario(Horario horario) {
        this.horario = horario;
        actualizarHorario();
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
        actualizarHorario();
    }

    public void agregarTarea(Tarea tarea) {
        int index = 0;
        while(index < tareas.size() && tareas.get(index).before(tarea)) {
            index++;
        }
        if(index < tareas.size() && tareas.get(index).equals(tarea)) return;
        tareas.add(index, tarea);
    }

    public void eliminarTarea(int index) {
        tareas.remove(index);
    }

    public Tarea getTarea(int index) {
        return tareas.get(index);
    }

    private void actualizarHorario() {
        for(Clase clase: horario.getClases()) {
            Calendar fecha = (Calendar) horario.getFechaInicio().clone();
            if(fecha.get(Calendar.DAY_OF_WEEK) > clase.getDiaSemana()) {
                fecha.add(Calendar.DAY_OF_MONTH, 7);
            }
            fecha.set(Calendar.DAY_OF_WEEK, clase.getDiaSemana());
            while(fecha.before(horario.getFechaFin())) {
                agregarTarea(new Tarea(clase.getNombre(), clase.getDescripcion(), (Calendar) fecha.clone(), clase.getHoraInicio(), clase.getHoraFin()));
                fecha.add(Calendar.DAY_OF_MONTH, 7);
            }
        }
    }

}
