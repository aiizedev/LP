package core;

public class Instruction {
    public static int getOpcode(long instr) {
        return (int) (instr & 0xFF);
    }

    public static int getReg1(long instr) {
        return (int) ((instr >> 8) & 0xFF);
    }

    public static int getReg2(long instr) {
        return (int) ((instr >> 16) & 0xFF);
    }

    public static int getReg3(long instr) {
        return (int) ((instr >> 24) & 0xFF);
    }

    public static long getExtended(long instr) {
        return (instr >> 32);
    }
}
