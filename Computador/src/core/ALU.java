// ALU.java
package core;

public class ALU {
    public long add(long a, long b) {
        return a + b;
    }

    public long sub(long a, long b) {
        return a - b;
    }

    public long mul(long a, long b) {
        return a * b;
    }

    public long div(long a, long b) {
        return b != 0 ? a / b : 0;
    }

    public long and(long a, long b) {
        return a & b;
    }

    public long or(long a, long b) {
        return a | b;
    }

    public long xor(long a, long b) {
        return a ^ b;
    }

    public long not(long a) {
        return ~a;
    }

    public long shl(long a, int shift) {
        return a << shift;
    }

    public long shr(long a, int shift) {
        return a >>> shift;
    }
}
