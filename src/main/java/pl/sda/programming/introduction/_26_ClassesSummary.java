package pl.sda.programming.introduction;

final class _26_ClassesSummary {

    public static void main(String[] args) {
        // inheritance
        A a1 = new B();
        // overriding
        a1.test();

        // overloading
        B b1 = new B();
        b1.test();
        b1.test(1);
    }
}

// inheritance: A <- B <- C
class A {
    // private it's visible only in this class
    private int i;
    // protected it's visible only in this class and in inherited classes
    protected int u;
    // package visible
    int p;
    // public visibility - visible everywhere
    public int r;

    public int getI() {
        return i;
    }

    void test() {
        System.out.println("test A");
    }

    // public methods - visible everywhere
    public void publicMethod() {
        System.out.println("public test a");
    }
    // protected - visible in subclasses
    protected void protectedMethod() {
        System.out.println("protected test a");
    }
    // package visibility - you cannot override if classes are in different packages
    void packageMethod() {
        System.out.println("package test a");
    }
    // private - visible only in class
    private void privateMethod() {
        System.out.println("private test a");
    }
}

class B extends A {
    private int w;
    private int u;

    @Override
    void test() {
        System.out.println("test B");
        super.test();
        int u = super.u;
    }

    // overloading
    void test(int k) {
        w = k;
    }
}

final class C extends B {
    private int y;

    void test() {
        int i = getI();
//        i = this.u;
        i = p;
    }
}

// cannot extend final class
// class D extends C {}