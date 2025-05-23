package Algoritmos;
import  core.*;

public class BusquedaBinaria {
    public static long[] generarPrograma() {
        return new long[]{
                Assembler.movi(1, 0x2000),   // base arreglo
                Assembler.movi(2, 4),        // tamaño
                Assembler.movi(3, 6),        // valor a buscar
                Assembler.movi(4, -1),       // resultado
                Assembler.movi(5, 0),        // inicio
                Assembler.movi(6, 4),        // fin

                // Bucle:
                Assembler.instr(Opcodes.JGE, 5, 6, 0, 20),
                Assembler.instr(Opcodes.RESTAR, 7, 6, 5, 0),
                Assembler.instr(Opcodes.SHR, 7, 7, 0, 1),
                Assembler.instr(Opcodes.SUMAR, 7, 7, 5, 0),
                Assembler.instr(Opcodes.CARGAR, 8, 1, 7, 0),  // R8 = Mem[R1 + R7*8]

                Assembler.instr(Opcodes.CMP, 8, 3, 0, 0),
                Assembler.instr(Opcodes.SIZ, 0, 0, 0, 18),
                Assembler.instr(Opcodes.JGE, 8, 3, 0, 15),
                Assembler.instr(Opcodes.MOV, 5, 7, 0, 0),
                Assembler.instr(Opcodes.INCREMENTAR, 5, 0, 0, 1),
                Assembler.instr(Opcodes.SALTAR, 0, 0, 0, 6),

                // buscar derecha
                Assembler.instr(Opcodes.MOV, 6, 7, 0, 0),
                Assembler.instr(Opcodes.SALTAR, 0, 0, 0, 6),

                // encontrado
                Assembler.instr(Opcodes.MOV, 4, 7, 0, 0),

                // no encontrado:
                Assembler.instr(Opcodes.HALT, 0, 0, 0, 0)
        };
    }
}
