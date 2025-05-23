import Algoritmos.*;
import  core.*;

    public class Main {
        public static void main(String[] args) {
            // Ejecutar cada algoritmo por separado:
            ejecutarSumaArreglo();
            ejecutarBusquedaBinaria();
            ejecutarOrdenamientoInsercion();
        }

        public static void ejecutarSumaArreglo() {
            System.out.println("=== SUMA DE ARREGLO ===");
            Computer comp = new Computer();

            // Cargar arreglo [5, 7, 3] en memoria en 0x2000
            int base = 0x2000 / Computer.WORD_SIZE;
            comp.memory[base] = 5;
            comp.memory[base + 1] = 7;
            comp.memory[base + 2] = 3;

            long[] programa = SumaArreglo.generarPrograma();
            comp.loadProgram(programa, 0);

            System.out.println("Resultado de la suma: " + comp.memory[0x1000 / Computer.WORD_SIZE]);
            System.out.println();
        }

        public static void ejecutarBusquedaBinaria() {
            System.out.println("=== BÚSQUEDA BINARIA ===");
            Computer comp = new Computer();

            // Cargar arreglo ordenado [2, 4, 6, 8] en 0x2000
            int base = 0x2000 / Computer.WORD_SIZE;
            comp.memory[base] = 2;
            comp.memory[base + 1] = 4;
            comp.memory[base + 2] = 6;
            comp.memory[base + 3] = 8;

            long[] programa = BusquedaBinaria.generarPrograma();
            comp.loadProgram(programa, 0);

            System.out.println("Índice encontrado (esperado 2): " + comp.registers[4]);
            System.out.println();
        }

        public static void ejecutarOrdenamientoInsercion() {
            System.out.println("=== ORDENAMIENTO POR INSERCIÓN ===");
            Computer comp = new Computer();

            // Arreglo desordenado [5, 2, 4, 1] en 0x2000
            int base = 0x2000 / Computer.WORD_SIZE;
            comp.memory[base] = 5;
            comp.memory[base + 1] = 2;
            comp.memory[base + 2] = 4;
            comp.memory[base + 3] = 1;

            long[] programa = OrdenamientoInsercion.generarPrograma();
            comp.loadProgram(programa, 0);

            System.out.print("Arreglo ordenado: ");
            for (int i = 0; i < 4; i++) {
                System.out.print(comp.memory[base + i] + " ");
            }
            System.out.println("\n");
        }
    }