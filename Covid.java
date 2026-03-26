package covid;

import java.time.LocalDate;
import java.util.Scanner;

public class Covid {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==== FORMULARIO ====");
        System.out.print("Documento: ");
        String doc = sc.next();

        System.out.print("Nombre completo: ");
        sc.nextLine();
        String nombre = sc.nextLine();

        System.out.print("Fecha nacimiento (año): ");
        int anio = sc.nextInt();
        System.out.print("Fecha nacimiento (mes): ");
        int mes = sc.nextInt();
        System.out.print("Fecha nacimiento (día): ");
        int dia = sc.nextInt();

        System.out.print("Enfermedad presión (S/N): ");
        char presion = sc.next().charAt(0);

        System.out.print("Enfermedad glicemia (S/N): ");
        char glicemia = sc.next().charAt(0);

        System.out.print("Tos seca (S/N): ");
        char tos = sc.next().charAt(0);

        System.out.print("Dificultad respiratoria (S/N): ");
        char difResp = sc.next().charAt(0);

        System.out.print("Temperatura: ");
        double temp = sc.nextDouble();

        System.out.print("Cansancio/Escalofrío (S/N): ");
        char cansancio = sc.next().charAt(0);

        System.out.print("Dolor cabeza/garganta (S/N): ");
        char dolor = sc.next().charAt(0);

        System.out.print("Contraseña: ");
        String contrasena = sc.next();

        System.out.print("Asistencia respiratoria (S/N): ");
        char asistencia = sc.next().charAt(0);

        PacienteCovid pc = new PacienteCovid(
                doc,
                nombre,
                LocalDate.of(anio, mes, dia),
                presion,
                glicemia,
                tos,
                difResp,
                temp,
                cansancio,
                dolor,
                contrasena,
                asistencia
        );

        System.out.println();
        pc.ImprimirReporte();
        System.out.println();
        System.out.println("==== CONCLUSION ====");
        System.out.println("Diagnóstico : " + pc.Diagnostico());
        System.out.println("Tratamiento : " + pc.Tratamiento());
        System.out.println("Valor consulta: " + pc.ValorConsulta());

        /*
        System.out.println();
        System.out.println("==== (POR DEFECTO) ====");
        PacienteGeneral pg = new PacienteGeneral();
        pg.ImprimirReporte();
        System.out.println("Diagnóstico : " + pg.Diagnostico());
        System.out.println("Tratamiento : " + pg.Tratamiento());
        System.out.println("Valor consulta: " + pg.ValorConsulta());
        */

        sc.close();
    }
}
// @Andres Felipe Grimaldos Garcia
