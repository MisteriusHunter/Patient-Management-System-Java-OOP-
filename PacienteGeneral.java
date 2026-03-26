package covid;

import java.time.LocalDate;

public class PacienteGeneral extends Paciente {

    private char conjuntivitis;
    private double peso;

    public PacienteGeneral() {
        super();
        this.conjuntivitis = 'N';
        this.peso = 0.0;
    }

    public PacienteGeneral(String documento,
                           String nombreCompleto,
                           LocalDate fechaNacimiento,
                           char enfermedadPresion,
                           char enfermedadGlicemia,
                           char tosSeca,
                           char dificultadRespiratoria,
                           double temperatura,
                           char cansancioEscalofrio,
                           char dolorCabezaGarganta,
                           char conjuntivitis,
                           double peso) {

        super(documento, nombreCompleto, fechaNacimiento,
                enfermedadPresion, enfermedadGlicemia,
                tosSeca, dificultadRespiratoria,
                temperatura, cansancioEscalofrio,
                dolorCabezaGarganta);

        this.conjuntivitis = Character.toUpperCase(conjuntivitis);
        this.peso = peso;
    }

    @Override
    public void ImprimirReporte() {
        super.ImprimirReporte();
        System.out.println("Conjuntivitis : " + conjuntivitis);
        System.out.println("Peso : " + peso);
    }

    @Override
    public String Diagnostico() {
        if (temperatura >= 38.0) {
            return "Cuadro de fiebre, requiere valoración básica.";
        }
        if (conjuntivitis == 'S') {
            return "Posible infección ocular leve.";
        }
        return "Paciente sin alteraciones importantes.";
    }

    @Override
    public String Tratamiento() {
        String diag = Diagnostico();
        if (diag.startsWith("Cuadro de fiebre")) {
            return "Antipirético, hidratación y observación en casa."; //Google que tratamiento tiene alguien con fiebre? 
        }
        if (diag.startsWith("Posible infección ocular")) {
            return "Higiene ocular y consulta si el cuadro empeora.";
        }
        return "Hábitos saludables y control rutinario.";
    }

    @Override
    public double ValorConsulta() {
        double valorBase = 50000.0;
        if (temperatura >= 38.0 || hospitalizacion == 'S') {
            valorBase = valorBase + 20000.0;
        }
        return valorBase;
    }

    public char getConjuntivitis() {
        return conjuntivitis;
    }

    public void setConjuntivitis(char conjuntivitis) {
        this.conjuntivitis = Character.toUpperCase(conjuntivitis);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
