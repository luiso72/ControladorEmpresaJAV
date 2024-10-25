package co.edu.umanizales.empresa.modelos;

public class EmpleadoTiempoCompleto extends Empleado {
    private double salarioAnual;

    public EmpleadoTiempoCompleto(String nombre, int edad, String departamento, int anioContratacion, double salarioAnual) {
        super(nombre, edad, departamento, anioContratacion);
        this.salarioAnual = salarioAnual;
    }

    public double calcularSalarioMensual() {
        return salarioAnual / 12;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salario mensual=" + calcularSalarioMensual();
    }
}