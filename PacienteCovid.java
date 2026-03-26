package covid;

import java.time.LocalDate;

public class PacienteCovid extends Paciente {

    private String contrasena;
    private char asistenciaRespiratoria;

    public PacienteCovid() {
        super();
        this.contrasena = "N";
        this.asistenciaRespiratoria = 'N';
    }

    public PacienteCovid(String documento,
                         String nombreCompleto,
                         LocalDate fechaNacimiento,
                         char enfermedadPresion,
                         char enfermedadGlicemia,
                         char tosSeca,
                         char dificultadRespiratoria,
                         double temperatura,
                         char cansancioEscalofrio,
                         char dolorCabezaGarganta,
                         String contrasena,
                         char asistenciaRespiratoria) {

        super(documento, nombreCompleto, fechaNacimiento,
                enfermedadPresion, enfermedadGlicemia,
                tosSeca, dificultadRespiratoria,
                temperatura, cansancioEscalofrio,
                dolorCabezaGarganta);

        this.contrasena = contrasena;
        this.asistenciaRespiratoria = Character.toUpperCase(asistenciaRespiratoria);
    }

    @Override
    public void ImprimirReporte() {
        super.ImprimirReporte();
        System.out.println("Asistencia respiratoria: " + asistenciaRespiratoria);
        System.out.println("Contraseña : " + contrasena);
    }

    @Override
    public String Diagnostico() {
        if (temperatura >= 38.0 && (tosSeca == 'S' || dificultadRespiratoria == 'S')) {
            return "Probable infección de (COVID).";
        }
        return "Sin signos claros de COVID.";
    }

    @Override
    public String Tratamiento() {
        String diag = Diagnostico();
        if (diag.startsWith("Probable infección respiratoria")) {
            return "Aislamiento, hidratación, control de temperatura y valoración médica.";
        }
        return "Recomendaciones y control si aparecen síntomas.";
    }

    @Override
    public double ValorConsulta() {
        double valorBase = 70000.0;
        if (hospitalizacion == 'S') {
            valorBase = valorBase + 30000.0; //Deberia ser el 100% del salario :(
        }
        return valorBase;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public char getAsistenciaRespiratoria() {
        return asistenciaRespiratoria;
    }

    public void setAsistenciaRespiratoria(char asistenciaRespiratoria) {
        this.asistenciaRespiratoria = Character.toUpperCase(asistenciaRespiratoria);
    }
}
