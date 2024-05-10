//Codigo Incompleto que simula el prestamo de un libro en una biblioteca, se muestra la informacion del estudiante, libro, fecha de prestamo, 
//fecha de devolucion y multa si es que la hay, falta agregar clases y metodos para que el codigo sea mucho mejor.
//Autor: Joel Tapia_Jxel117
import java.time.LocalDate;
import java.time.Period;

class Estudiante {
    private String nombre;
    private String dni;

    public Estudiante(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }
}

class Publicacion {
    private String titulo;
    private String autor;
    private String edicion;

    public Publicacion(String titulo, String autor, String edicion) {
        this.titulo = titulo;
        this.autor = autor;
        this.edicion = edicion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEdicion() {
        return edicion;
    }
}

class Estado {
    private Estudiante estudiante;
    private Publicacion libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private int multa;

    public Estado(Estudiante estudiante, Publicacion libro, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.multa = 0;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Publicacion getLibro() {
        return libro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public int getMulta() {
        return multa;
    }

    public void calcularMulta() {
        LocalDate fechaActual = LocalDate.now();
        if (fechaActual.isAfter(fechaDevolucion)) {
            Period periodo = Period.between(fechaDevolucion, fechaActual);
            multa += periodo.getDays() * 10;
        }
    }

    public String informacion() {
        String informacion = "";
        informacion += "Estudiante: " + estudiante.getNombre() + " - " + estudiante.getDni() + "\n";
        informacion += "Libro recibido: " + libro.getTitulo() + " - " + libro.getAutor() + " - " + libro.getEdicion() + "\n";
        informacion += "Fecha prestamo: " + fechaPrestamo.toString() + "\n";
        informacion += "Fecha devolucion: " + fechaDevolucion.toString() + "\n";
        informacion += "Multa: " + multa + "\n";
        return informacion;
    }
}
public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Joel Tapia", "1105242380");
        Publicacion libro = new Publicacion("Codigo Limpio", "Robert Cecil Martin", "Primera edición");
        LocalDate fechaPrestamo = LocalDate.of(2024, 5, 1);
        LocalDate fechaDevolucion = LocalDate.of(2024, 5, 15);

        Estado estado= new Estado(estudiante, libro, fechaPrestamo, fechaDevolucion);
        estado.calcularMulta();

        System.out.println(estado.informacion());
    }
}