package co.edu.umanizales.empresa.controlador;

import co.edu.umanizales.empresa.modelos.*;
import co.edu.umanizales.empresa.servicios.EmpresaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaControlador {

    private final EmpresaServicio empresaService = new EmpresaServicio();


    @PostMapping("/empleadoTiempoCompleto")
    public ResponseEntity<String> agregarEmpleadoTiempoCompleto(
          @RequestBody EmpleadoTiempoCompleto empleadoTiempoCompleto) {

        //EmpleadoTiempoCompleto empleado = new EmpleadoTiempoCompleto(nombre, edad, departamento, anioContratacion, salarioAnual);
        empresaService.agregarEmpleado(empleadoTiempoCompleto);
        return ResponseEntity.ok("Empleado a tiempo completo añadido");
    }


    @PostMapping("/empleadoPorHoras")
    public ResponseEntity<String> agregarEmpleadoPorHoras(
            @RequestParam String nombre,
            @RequestParam int edad,
            @RequestParam String departamento,
            @RequestParam int anioContratacion,
            @RequestParam double tarifaHora,
            @RequestParam int horasTrabajadas) {

        EmpleadoPorHoras empleado = new EmpleadoPorHoras(nombre, edad, departamento, anioContratacion, tarifaHora, horasTrabajadas);
        empresaService.agregarEmpleado(empleado);
        return ResponseEntity.ok("Empleado por horas añadido");
    }

    @GetMapping("/empleadosPorDepartamento")
    public ResponseEntity<List<Empleado>> consultarEmpleadosPorDepartamento(@RequestParam String departamento) {
        List<Empleado> empleados = empresaService.consultarEmpleadosPorDepartamento(departamento);
        return ResponseEntity.ok(empleados);
    }


    @GetMapping("/salariosMensuales")
    public ResponseEntity<List<Double>> consultarSalariosMensuales() {
        List<Double> salarios = empresaService.consultarSalariosMensuales();
        return ResponseEntity.ok(salarios);
    }


    @GetMapping("/empleadoMasAntiguo")
    public ResponseEntity<Empleado> consultarEmpleadoMasAntiguo() {
        Empleado empleadoMasAntiguo = empresaService.consultarEmpleadoMasAntiguo();
        return ResponseEntity.ok(empleadoMasAntiguo);
    }


    @GetMapping("/empleadosPorTipo")
    public ResponseEntity<List<Empleado>> consultarEmpleadosPorTipo(@RequestParam String tipoEmpleado) {
        List<Empleado> empleadosPorTipo = empresaService.consultarEmpleadosPorTipo(tipoEmpleado);
        return ResponseEntity.ok(empleadosPorTipo);
    }
}
