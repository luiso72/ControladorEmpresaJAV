package co.edu.umanizales.empresa.modelos;

public class Empleado {
    private String nombre;
    private int edad;
    private String departamento;
    private int anioContratacion;

    //Constructor que permite inicializar el objeto empleado
    public Empleado(String nombre, int edad, String departamento, int anioContratacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.departamento = departamento;
        this.anioContratacion = anioContratacion;
    }


    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getAnioContratacion() {
        return anioContratacion;
    }


    public int calcularAntiguedad() {
        return 2024 - anioContratacion;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", departamento='" + departamento + '\'' +
                ", antigüedad=" + calcularAntiguedad() +
                '}';
        }
    }