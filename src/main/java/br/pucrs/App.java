package br.pucrs;

public class App {
    public static void main(String[] args) {
        System.out.println(MULTIPLY(7, 5, 4));
        System.out.println(MULTIPLY(12345, 6789, 16));
        System.out.println(MULTIPLY(123456789L, 987654321L, 64));

        System.out.println(multiply("11", "1011"));
    }

    public static long MULTIPLY(long x, long y, long n) {
        if (n == 1)
            return x * y;
        else {
            long m   = n / 2;
            long pot = 1L << m;          // 2^m
            long a = x / pot;
            long b = x % pot;
            long c = y / pot;
            long d = y % pot;
            long e = MULTIPLY(a, c, m);
            long f = MULTIPLY(b, d, m);
            long g = MULTIPLY(b, c, m);
            long h = MULTIPLY(a, d, m);
            return (1L << (2 * m)) * e + pot * (g + h) + f;   // 2^(2m)·e + 2^m·(g+h) + f
        }
    }

    // Multiplica duas strings de bits x e y
    // e retorna o resultado como um inteiro "long".
    // transforma bits em long, chama MULTIPLY e retorna o resultado
    public static long multiply(String X, String Y){
        long x = Long.parseLong(X, 2);
        long y = Long.parseLong(Y, 2);
        int n = Math.max(X.length(), Y.length());
        return MULTIPLY(x, y, n);
    }
}