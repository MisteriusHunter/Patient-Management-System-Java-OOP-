package covid;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Paciente {

    protected String documento;
    protected String nombreCompleto;
    protected LocalDate fechaNacimiento;
    protected int edad;
    protected char enfermedadPresion;
    protected char enfermedadGlicemia;
    protected char tosSeca;
    protected char dificultadRespiratoria;
    protected double temperatura;
    protected char cansancioEscalofrio;
    protected char dolorCabezaGarganta;
    protected char hospitalizacion;
    protected double salario;

    public Paciente() {
        this.documento = "1111111";
        this.nombreCompleto = "N";
        this.fechaNacimiento = LocalDate.of(1, 1, 1);
        this.edad = 1;
        this.enfermedadPresion = 'N';
        this.enfermedadGlicemia = 'N';
        this.tosSeca = 'N';
        this.dificultadRespiratoria = 'N';
        this.temperatura = 36.0;
        this.cansancioEscalofrio = 'N';
        this.dolorCabezaGarganta = 'N';
        this.hospitalizacion = 'N';
        this.salario = 100000.0;
    }

    public Paciente(String documento,
                    String nombreCompleto,
                    LocalDate fechaNacimiento,
                    char enfermedadPresion,
                    char enfermedadGlicemia,
                    char tosSeca,
                    char dificultadRespiratoria,
                    double temperatura,
                    char cansancioEscalofrio,
                    char dolorCabezaGarganta) {

        this.documento = documento;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.enfermedadPresion = Character.toUpperCase(enfermedadPresion);
        this.enfermedadGlicemia = Character.toUpperCase(enfermedadGlicemia);
        this.tosSeca = Character.toUpperCase(tosSeca);
        this.dificultadRespiratoria = Character.toUpperCase(dificultadRespiratoria);
        this.temperatura = temperatura;
        this.cansancioEscalofrio = Character.toUpperCase(cansancioEscalofrio);
        this.dolorCabezaGarganta = Character.toUpperCase(dolorCabezaGarganta);

        calcularEdad();

        Scanner sc = new Scanner(System.in);
        System.out.print("¿Requiere hospitalización? (S/N): ");
        this.hospitalizacion = Character.toUpperCase(sc.next().charAt(0));
        System.out.print("Ingrese su salario: ");
        this.salario = sc.nextDouble();
    }

    public void calcularEdad() {
        LocalDate hoy = LocalDate.now();
        this.edad = hoy.getYear() - this.fechaNacimiento.getYear();
        if (hoy.getMonthValue() < this.fechaNacimiento.getMonthValue()
                || (hoy.getMonthValue() == this.fechaNacimiento.getMonthValue()
                && hoy.getDayOfMonth() < this.fechaNacimiento.getDayOfMonth())) {
            this.edad--;
        }
    }

    public void ImprimirReporte() {
        System.out.println("==== DATOS ====");
        System.out.println("Documento : " + documento);
        System.out.println("Nombre completo : " + nombreCompleto);
        System.out.println("Fecha nacimiento : " + fechaNacimiento);
        System.out.println("Edad : " + edad);
        System.out.println("Enf. presión : " + enfermedadPresion);
        System.out.println("Enf. glicemia : " + enfermedadGlicemia);
        System.out.println("Tos seca : " + tosSeca);
        System.out.println("Dificultad respiratoria: " + dificultadRespiratoria);
        System.out.println("Temperatura : " + temperatura);
        System.out.println("Cansancio/Escalofrío : " + cansancioEscalofrio);
        System.out.println("Dolor cabeza/garganta : " + dolorCabezaGarganta);
        System.out.println("Hospitalización : " + hospitalizacion);
        System.out.println("Salario : " + salario); //Vamos a cobrar el 100% del salario
    }

    public abstract String Diagnostico();
    public abstract String Tratamiento();
    public abstract double ValorConsulta();

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        calcularEdad();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getEnfermedadPresion() {
        return enfermedadPresion;
    }

    public void setEnfermedadPresion(char enfermedadPresion) {
        this.enfermedadPresion = Character.toUpperCase(enfermedadPresion);
    }

    public char getEnfermedadGlicemia() {
        return enfermedadGlicemia;
    }

    public void setEnfermedadGlicemia(char enfermedadGlicemia) {
        this.enfermedadGlicemia = Character.toUpperCase(enfermedadGlicemia);
    }

    public char getTosSeca() {
        return tosSeca;
    }

    public void setTosSeca(char tosSeca) {
        this.tosSeca = Character.toUpperCase(tosSeca);
    }

    public char getDificultadRespiratoria() {
        return dificultadRespiratoria;
    }

    public void setDificultadRespiratoria(char dificultadRespiratoria) {
        this.dificultadRespiratoria = Character.toUpperCase(dificultadRespiratoria);
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public char getCansancioEscalofrio() {
        return cansancioEscalofrio;
    }

    public void setCansancioEscalofrio(char cansancioEscalofrio) {
        this.cansancioEscalofrio = Character.toUpperCase(cansancioEscalofrio);
    }

    public char getDolorCabezaGarganta() {
        return dolorCabezaGarganta;
    }

    public void setDolorCabezaGarganta(char dolorCabezaGarganta) {
        this.dolorCabezaGarganta = Character.toUpperCase(dolorCabezaGarganta);
    }

    public char getHospitalizacion() {
        return hospitalizacion;
    }

    public void setHospitalizacion(char hospitalizacion) {
        this.hospitalizacion = Character.toUpperCase(hospitalizacion);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
