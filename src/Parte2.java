import javax.swing.JOptionPane;

/**
 * Taller 6 - Parte 2: Arreglos de dos dimensiones
 * Integrante A: Kadir Gonzalez
 * Integrante B: Kenneth Lau
 *
 * INSTRUCCIONES:
 * Copia aquí el código completo que aparece en el documento del taller.
 * Luego ejecuta, verifica la salida y responde las preguntas en respuestas/parte2.txt
 */
public class Parte2 {
    public static void main(String[] args) {

        // Dimensiones de la tabla
        int filas = 4;
        int columnas = 3;

        // Declaración del arreglo 2D
        int[][] calificaciones = new int[filas][columnas];

        // Nombres de materias
        String[] materias = {"Matematica", "Español", "Ciencias"};

        // Nombres de estudiantes
        String[] estudiantes = {"Ana", "Luis", "Carla", "Pedro"};

        // Llenado de calificaciones
        calificaciones[0][0] = 85;
        calificaciones[0][1] = 72;
        calificaciones[0][2] = 90;

        calificaciones[1][0] = 60;
        calificaciones[1][1] = 88;
        calificaciones[1][2] = 75;

        calificaciones[2][0] = 95;
        calificaciones[2][1] = 70;
        calificaciones[2][2] = 80;

        calificaciones[3][0] = 78;
        calificaciones[3][1] = 65;
        calificaciones[3][2] = 92;

        // Imprimir la tabla
        StringBuilder reporte = new StringBuilder();

        reporte.append("=== TABLA DE CALIFICACIONES ===\n");
        reporte.append(String.format("%-10s", "Alumno"));

        for (String m : materias) {
            reporte.append(String.format("%-12s", m));
        }

        reporte.append("Promedio\n");
        reporte.append("-".repeat(50)).append("\n");

        // Promedios por estudiante y suma por materia
        double[] sumaMaterias = new double[columnas];

        for (int f = 0; f < filas; f++) {
            reporte.append(String.format("%-10s", estudiantes[f]));

            int sumaFila = 0;

            for (int c = 0; c < columnas; c++) {
                int nota = calificaciones[f][c];
                sumaFila += nota;
                sumaMaterias[c] += nota;

                reporte.append(String.format("%-12d", nota));
            }

            double promedio = (double) sumaFila / columnas;
            reporte.append(String.format("%.2f%n", promedio));
        }

        // Promedios por materia
        reporte.append("-".repeat(50)).append("\n");
        reporte.append(String.format("%-10s", "Prom.mat"));

        for (int c = 0; c < columnas; c++) {
            double promedioMateria = sumaMaterias[c] / filas;
            reporte.append(String.format("%-12.2f", promedioMateria));
        }

        JOptionPane.showMessageDialog(null, reporte.toString());
    }
}