package com.example.fivecalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Calendario {

    private List<Tarea> tareas = new ArrayList<>();
    private Horario horario;
    private static Calendario instance;

    public static Calendario getInstance() {
        if (instance == null) instance = new Calendario();
        return instance;
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

    public List<Tarea> getTareasDia(int dia, int mes, int anio) {
        Calendar fecha = Calendar.getInstance();
        fecha.set(anio, mes, dia);
        Horario.updateFecha(fecha);
        List<Tarea> tareas = new ArrayList<>();
        int index = 0;
        while(index < this.tareas.size() && this.tareas.get(index).getFecha().before(fecha)) {
            index++;
        }
        fecha.add(Calendar.DAY_OF_YEAR, 1);
        while(index < this.tareas.size() && this.tareas.get(index).getFecha().before(fecha)) {
            tareas.add(this.tareas.get(index));
        }
        return tareas;
    }

    public List<Tarea> getTareasSemana(int dia, int mes, int anio) {
        Calendar fecha = Calendar.getInstance();
        fecha.set(anio, mes, dia);
        fecha.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Horario.updateFecha(fecha);
        List<Tarea> tareas = new ArrayList<>();
        int index = 0;
        while(index < this.tareas.size() && this.tareas.get(index).getFecha().before(fecha)) {
            index++;
        }
        fecha.add(Calendar.WEEK_OF_YEAR, 1);
        while(index < this.tareas.size() && this.tareas.get(index).getFecha().before(fecha)) {
            tareas.add(this.tareas.get(index));
        }
        return tareas;
    }

    public List<Tarea> getTareasMes(int mes, int anio) {
        Calendar fecha = Calendar.getInstance();
        fecha.set(anio, mes, 1);
        Horario.updateFecha(fecha);
        List<Tarea> tareas = new ArrayList<>();
        int index = 0;
        while(index < this.tareas.size() && this.tareas.get(index).getFecha().before(fecha)) {
            index++;
        }
        fecha.add(Calendar.MONTH, 1);
        while(index < this.tareas.size() && this.tareas.get(index).getFecha().before(fecha)) {
            tareas.add(this.tareas.get(index));
        }
        return tareas;
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
