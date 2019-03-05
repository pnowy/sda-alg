package pl.sda.programming.introduction;

final class _34_StackTrace {
    public static void main(String[] args) {
        m1();
    }

    static void m1() {
        //m2();
        try {
            m2();
        } catch (RuntimeException ex) {
            throw new IllegalStateException("illegal state exception", ex);
        }
    }

    static void m2() {
        m3();
    }

    static void m3() {
        throw new RuntimeException("runtime exception");
    }
}
