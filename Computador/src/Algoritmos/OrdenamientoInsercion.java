package Algoritmos;
import  core.*;

public class OrdenamientoInsercion {
    public static long[] generarPrograma() {
        return new long[]{
                Assembler.movi(1, 0x2000), // base arreglo
                Assembler.movi(2, 4),      // longitud
                Assembler.movi(3, 1),      // i

                // Bucle externo (i < n)
                Assembler.instr(Opcodes.CMP, 3, 2, 0, 0),
                Assembler.instr(Opcodes.JGE, 3, 2, 0, 21),

                // key = arr[i]
                Assembler.instr(Opcodes.CARGAR, 4, 1, 3, 0),
                Assembler.instr(Opcodes.MOV, 5, 3, 0, 0),
                Assembler.instr(Opcodes.DECREMENTAR, 5, 0, 0, 1),

                // Bucle interno (j >= 0 y arr[j] > key)
                Assembler.instr(Opcodes.CMP, 5, 0, 0, 0),
                Assembler.instr(Opcodes.JL, 5, 0, 0, 13),
                Assembler.instr(Opcodes.CARGAR, 6, 1, 5, 0),
                Assembler.instr(Opcodes.CMP, 6, 4, 0, 0),
                Assembler.instr(Opcodes.JLE, 6, 4, 0, 13),
                Assembler.instr(Opcodes.CARGAR, 7, 1, 5, 0),
                Assembler.instr(Opcodes.GUARDAR, 1, 7, 0, 0), // arr[j+1] = arr[j]
                Assembler.instr(Opcodes.INCREMENTAR, 1, 0, 0, 8),
                Assembler.instr(Opcodes.DECREMENTAR, 5, 0, 0, 1),
                Assembler.instr(Opcodes.SALTAR, 0, 0, 0, 8),

                // FIN_J:
                Assembler.instr(Opcodes.INCREMENTAR, 5, 0, 0, 1),
                Assembler.instr(Opcodes.GUARDAR, 1, 4, 0, 0),
                Assembler.instr(Opcodes.INCREMENTAR, 3, 0, 0, 1),
                Assembler.instr(Opcodes.SALTAR, 0, 0, 0, 3),

                // FIN:
                Assembler.instr(Opcodes.HALT, 0, 0, 0, 0)
        };
    }
}


