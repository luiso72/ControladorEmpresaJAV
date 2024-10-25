package co.edu.umanizales.empresa.servicios;

import co.edu.umanizales.empresa.modelos.*;
import java.util.ArrayList;
import java.util.List;


public class EmpresaServicio {
    private final List<Empleado> empleados = new ArrayList<>();


    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }


    public List<Empleado> consultarEmpleadosPorDepartamento(String departamento) {
        List<Empleado> empleadosDepartamento = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.getDepartamento().equalsIgnoreCase(departamento)) {
                empleadosDepartamento.add(empleado);
            }
        }
        return empleadosDepartamento;
    }


    public List<Double> consultarSalariosMensuales() {
        List<Double> salariosMensuales = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoTiempoCompleto) {
                salariosMensuales.add(((EmpleadoTiempoCompleto) empleado).calcularSalarioMensual());
            } else if (empleado instanceof EmpleadoPorHoras) {
                salariosMensuales.add(((EmpleadoPorHoras) empleado).calcularSalarioMensual());
            }
        }
        return salariosMensuales;
    }

    public Empleado consultarEmpleadoMasAntiguo() {
        Empleado masAntiguo = null;
        for (Empleado empleado : empleados) {
            if (masAntiguo == null || empleado.calcularAntiguedad() > masAntiguo.calcularAntiguedad()) {
                masAntiguo = empleado;
            }
        }
        return masAntiguo;
    }


    public List<Empleado> consultarEmpleadosPorTipo(String tipoEmpleado) {
        List<Empleado> empleadosPorTipo = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (tipoEmpleado.equalsIgnoreCase("Tiempo Completo") && empleado instanceof EmpleadoTiempoCompleto) {
                empleadosPorTipo.add(empleado);
            } else if (tipoEmpleado.equalsIgnoreCase("Por Horas") && empleado instanceof EmpleadoPorHoras) {
                empleadosPorTipo.add(empleado);
            }
        }
        return empleadosPorTipo;
    }
}
