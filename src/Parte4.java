import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

/**
 * Taller 6 - Parte 4: Colecciones ArrayList y LinkedList
 * Integrante A: ___________________________
 * Integrante B: ___________________________
 */
public class Parte4 {
    public static void main(String[] args) {

        // ════════════════════════════════
        // SECCIÓN A: ArrayList de Strings
        // ════════════════════════════════

        ArrayList<String> ciudades = new ArrayList<>();
        ciudades.add("Panamá");
        ciudades.add("Colón");
        ciudades.add("David");
        ciudades.add("Santiago");
        ciudades.add("Chitré");

        StringBuilder sb = new StringBuilder();
        sb.append("=== ArrayList de ciudades ===\n");
        sb.append("Tamaño: ").append(ciudades.size()).append("\n");
        sb.append("Primera ciudad: ").append(ciudades.get(0)).append("\n");
        sb.append("Última ciudad : ").append(ciudades.get(ciudades.size() - 1)).append("\n");
        sb.append("¿Contiene 'David'? ").append(ciudades.contains("David")).append("\n");
        sb.append("¿Contiene 'Bocas'? ").append(ciudades.contains("Bocas")).append("\n");

        sb.append("\nLista completa:\n");
        for (String ciudad : ciudades) {
            sb.append("  - ").append(ciudad).append("\n");
        }

        ciudades.remove("Colón");
        sb.append("\nDespués de eliminar 'Colón': ").append(ciudades).append("\n");

        ciudades.add(1, "Bocas del Toro");
        sb.append("Después de insertar en pos 1: ").append(ciudades).append("\n");

        Collections.sort(ciudades);
        sb.append("Ordenadas alfabéticamente: ").append(ciudades).append("\n");

        JOptionPane.showMessageDialog(null, sb.toString());
        sb.setLength(0);

        // ════════════════════════════════
        // SECCIÓN B: ArrayList de enteros (modificado: >= 40 y suma)
        // ════════════════════════════════

        ArrayList<Integer> numeros = new ArrayList<>();
        int[] datos = {34, 12, 78, 56, 23, 89, 45, 67};
        for (int d : datos) {
            numeros.add(d);
        }

        int suma = 0;
        int mayor = numeros.get(0);
        for (int n : numeros) {
            suma += n;
            if (n > mayor) mayor = n;
        }

        sb.append("=== ArrayList de números ===\n");
        sb.append("Lista: ").append(numeros).append("\n");
        sb.append("Suma  : ").append(suma).append("\n");
        sb.append(String.format("Prom  : %.2f\n", (double) suma / numeros.size()));
        sb.append("Mayor : ").append(mayor).append("\n");

        ArrayList<Integer> mayoresDe40 = new ArrayList<>();
        int sumaMayoresDe40 = 0;
        for (int n : numeros) {
            if (n >= 40) {
                mayoresDe40.add(n);
                sumaMayoresDe40 += n;
            }
        }
        sb.append("Mayores o iguales a 40: ").append(mayoresDe40).append("\n");
        sb.append("Suma (>= 40): ").append(sumaMayoresDe40).append("\n");

        JOptionPane.showMessageDialog(null, sb.toString());
        sb.setLength(0);

        // ════════════════════════════════
        // SECCIÓN C: LinkedList como cola (modificado: llegan Cliente 5 y Cliente 6)
        // ════════════════════════════════

        LinkedList<String> cola = new LinkedList<>();
        cola.addLast("Cliente 1");
        cola.addLast("Cliente 2");
        cola.addLast("Cliente 3");
        cola.addLast("Cliente 4");

        sb.append("=== LinkedList como Cola (turno bancario) ===\n");
        sb.append("Cola inicial: ").append(cola).append("\n\n");

        sb.append("Atendiendo clientes:\n");
        boolean llegaronNuevos = false;
        while (!cola.isEmpty()) {
            String cliente = cola.removeFirst();
            sb.append("  Atendido: ").append(cliente);
            sb.append(" | Restantes en cola: ").append(cola.size()).append("\n");

            // Simula que llegan Cliente 5 y Cliente 6 mientras aún hay clientes en cola
            if (!llegaronNuevos && !cola.isEmpty()) {
                cola.addLast("Cliente 5");
                cola.addLast("Cliente 6");
                llegaronNuevos = true;
                sb.append("  >> Llegan 'Cliente 5' y 'Cliente 6'. Cola actual: ")
                  .append(cola).append("\n");
            }
        }
        sb.append("\nCola vacía. Fin de atención.\n");

        cola.addLast("Cliente A");
        cola.addLast("Cliente B");
        cola.addFirst("URGENTE");
        sb.append("\nNueva cola con urgencia: ").append(cola).append("\n");

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}