package co.edu.umanizales.empresa.modelos;

public class EmpleadoPorHoras extends Empleado {
    private double tarifaHora;
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, int edad, String departamento, int anioContratacion, double tarifaHora, int horasTrabajadas) {
        super(nombre, edad, departamento, anioContratacion);
        this.tarifaHora = tarifaHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    public double calcularSalarioMensual() {
        return tarifaHora * horasTrabajadas;
    }

    @Override
    public String toString() {
        //
        return super.toString() + ", Salario por horas=" + calcularSalarioMensual();
    }
}