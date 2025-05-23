package core;

// Computer.java
public class Computer {
    public static final int MEMORY_SIZE = 1024 * 64; // 64 KB simulados (cada celda = 64 bits)
    public static final int WORD_SIZE = 8; // 8 bytes = 64 bits

    // Memoria principal
    public long[] memory = new long[MEMORY_SIZE];

    // Registros
    public long[] registers = new long[16]; // R0-R15
    public long ACC = 0;  // Acumulador
    public long PC = 0;   // Contador de programa
    public long IR = 0;   // Registro de instrucción
    public int FLAGS = 0; // Banderas (Zero, Carry, Overflow, Sign)

    // ALU
    private ALU alu = new ALU();

    // Métodos de la CPU
    public void loadProgram(long[] program, int baseAddress) {
        System.arraycopy(program, 0, memory, baseAddress, program.length);
        PC = baseAddress;
    }

    public void execute() {
        while (true) {
            IR = memory[(int) (PC / WORD_SIZE)];
            PC += WORD_SIZE;
            if (!decodeAndExecute(IR)) break;
        }
    }

    private void setFlags(long result) {
        FLAGS = (result == 0) ? 1 : 0; // 1 = ZERO, 0 = NO ZERO
    }

    private boolean decodeAndExecute(long instr) {
        int op = Instruction.getOpcode(instr);
        int r1 = Instruction.getReg1(instr);
        int r2 = Instruction.getReg2(instr);
        int r3 = Instruction.getReg3(instr);
        long ext = Instruction.getExtended(instr);

        switch (op) {
            case Opcodes.HALT:
                return false;

            case Opcodes.SUMAR:
                registers[r1] = alu.add(registers[r2], registers[r3]);
                break;

            case Opcodes.RESTAR:
                registers[r1] = alu.sub(registers[r1], registers[r2]);
                break;

            case Opcodes.CARGAR:
                registers[r1] = memory[(int) (registers[r2] / WORD_SIZE)];
                break;

            case Opcodes.GUARDAR:
                memory[(int) (registers[r1] / WORD_SIZE)] = registers[r2];
                break;

            case Opcodes.SALTAR:
                PC = ext;
                break;

            case Opcodes.CMP:
                setFlags(registers[r1] - registers[r2]);
                break;

            case Opcodes.SIZ:
                if (FLAGS == 1) PC = ext;
                break;

            case Opcodes.JGE:
                if (registers[r1] >= registers[r2]) PC = ext;
                break;

            case Opcodes.JL:
                if (registers[r1] < registers[r2]) PC = ext;
                break;

            case Opcodes.JLE:
                if (registers[r1] <= registers[r2]) PC = ext;
                break;

            case Opcodes.INCREMENTAR:
                registers[r1] += ext;
                break;

            case Opcodes.DECREMENTAR:
                registers[r1] -= ext;
                break;

            case Opcodes.MOV:
                registers[r1] = registers[r2];
                break;

            case Opcodes.SHR:
                registers[r1] = alu.shr(registers[r2], (int) ext);
                break;

            default:
                System.err.println("Instrucción no válida: " + op);
                return false;
        }

        return true;
    }
}

