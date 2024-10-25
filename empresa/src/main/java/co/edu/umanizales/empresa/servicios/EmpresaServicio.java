package co.edu.umanizales.empresa.servicios;

import co.edu.umanizales.empresa.modelos.*;
import java.util.ArrayList;
import java.util.List;


public class EmpresaServicio { //inicia un publico clase de EmpresaServicio, en "class" creamos un "modelo" o figura
    private final List<Empleado> empleados = new ArrayList<>();


    public void agregarEmpleado(Empleado empleado) { //una clase vacia, esto crea un espacio en la memoria vacia para poder agregar un Empleado
        empleados.add(empleado);//añade el empleado
    }


    public List<Empleado> consultarEmpleadosPorDepartamento(String departamento) { // lista de empleadoos, una lista de empleados que responde a "consultarEmpleadosPorDepartamento"
        List<Empleado> empleadosDepartamento = new ArrayList<>();
        for (Empleado empleado : empleados) {//un ciclo for que por partes for (Empleado /saca de la lista los empleados/ empleado /saca del modelo / : empleados /es la lista en general
            if (empleado.getDepartamento().equalsIgnoreCase(departamento)) { // decisiones, si el modelo sacado de getdepartamento es parecido a (departamento)
                empleadosDepartamento.add(empleado);//añade empleado
            }
        }
        return empleadosDepartamento;//retorna la funcion
    }


    public List<Double> consultarSalariosMensuales() { // list<double> significa que contiene numeros de varias cifras, lista de los salarios mensuales 
        List<Double> salariosMensuales = new ArrayList<>(); //lista los salarios mensuales
        for (Empleado empleado : empleados) { 
            if (empleado instanceof EmpleadoTiempoCompleto) {//es un operador que se usa para verificar si un objeto es una instancia de una clase específica o de una subclase de ella. 
                salariosMensuales.add(((EmpleadoTiempoCompleto) empleado).calcularSalarioMensual()); //agrega a las listas los salarios mensuales y los calcular salarios
            } else if (empleado instanceof EmpleadoPorHoras) {//en caso de que entre empleado y empleadotiempocompleto no haya parecido procedera
                salariosMensuales.add(((EmpleadoPorHoras) empleado).calcularSalarioMensual());
            }
        }
        return salariosMensuales;//retorna funcion
    }

    public Empleado consultarEmpleadoMasAntiguo() {// inicia una funcion con el nombre consultarEmpleadoMasAntiguo
        Empleado masAntiguo = null; // crea un espacio de "masAntiguo" siendo null, o sea esta vacio para entrar las variables
        for (Empleado empleado : empleados) { //para Empleado sacado de la lista empleado que es la forma de llamar a los espacios de la lista : empleados la forma de llamarlos
            if (masAntiguo == null || empleado.calcularAntiguedad() > masAntiguo.calcularAntiguedad()) {//si el empleado actual (en un bucle o en una lista de empleados) tiene una mas tiempo que el empleado almacenado en la variable masAntiguo. Si es así, se actualiza masAntiguo para que apunte al empleado con mayor antigüedad.
                masAntiguo = empleado;
            }
        }
        return masAntiguo;//retorna al empleado con mas tiempo, osea retorna a la funcion
    }


    public List<Empleado> consultarEmpleadosPorTipo(String tipoEmpleado) { // de la lista va a agregar una funcion esa es consultar empleadosportipo y es tipo string o sea cadena de caracteres
        List<Empleado> empleadosPorTipo = new ArrayList<>();//crea el nuevo espacio en la memoria con aquel apodo
        for (Empleado empleado : empleados) {
            if (tipoEmpleado.equalsIgnoreCase("Tiempo Completo") && empleado instanceof EmpleadoTiempoCompleto) {//si tpo de empleado es igual al tiempo completo entonces sera agregado
                empleadosPorTipo.add(empleado);//agregado a la lista
            } else if (tipoEmpleado.equalsIgnoreCase("Por Horas") && empleado instanceof EmpleadoPorHoras) {
                empleadosPorTipo.add(empleado);
            }
        }
        return empleadosPorTipo;//retorna la funcion de los empleados por tipo
    }
}
