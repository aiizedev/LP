package Algoritmos;
import  core.*;

public class SumaArreglo {
    public static long[] generarPrograma() {
        return new long[]{
                Assembler.movi(1, 0x2000),  // R1 = dir base arreglo
                Assembler.movi(2, 3),       // R2 = longitud
                Assembler.movi(3, 0),       // R3 = suma
                Assembler.movi(4, 0),       // R4 = contador

                // Bucle:
                Assembler.instr(Opcodes.CMP, 4, 2, 0, 0),
                Assembler.instr(Opcodes.SIZ, 0, 0, 0, 11),
                Assembler.instr(Opcodes.CARGAR, 5, 1, 0, 0),
                Assembler.instr(Opcodes.SUMAR, 3, 3, 5, 0),
                Assembler.instr(Opcodes.INCREMENTAR, 1, 0, 0, 8),
                Assembler.instr(Opcodes.INCREMENTAR, 4, 0, 0, 1),
                Assembler.instr(Opcodes.SALTAR, 0, 0, 0, 4),

                // Fin:
                Assembler.instr(Opcodes.GUARDAR, 6, 3, 0, 0x1000),
                Assembler.instr(Opcodes.HALT, 0, 0, 0, 0)
        };
    }
}
