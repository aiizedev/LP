package core;

public class Assembler {
    public static long instr(int opcode, int r1, int r2, int r3, long ext) {
        return ((ext & 0xFFFFFFFFL) << 32)
                | ((r3 & 0xFFL) << 24)
                | ((r2 & 0xFFL) << 16)
                | ((r1 & 0xFFL) << 8)
                | (opcode & 0xFFL);
    }

    public static long movi(int r1, long val) {
        return instr(Opcodes.MOVI, r1, 0, 0, val);
    }
}

