package com.example.demo;

public class TestLambda {
    public static void main(String[] args) {
        TestLambda obj = new TestLambda();
        obj.setAction1(() -> System.out.println("Hello from T1 foo method"));
        obj.setAction2((int nr) -> System.out.println("Hello from T2 bar method, got value " + nr));
        obj.setAction3((int nr1, int nr2) -> nr1 * nr2);
    }

    public void setAction1(T1 t1) {
        t1.foo();
    }
    public void setAction2(T2 t2) {
        t2.bar(20);
    }
    public void setAction3(T3 t3) {
        System.out.println(t3.qux(20, 30));
    }
}

@FunctionalInterface
interface T1 {
    void foo();
}

@FunctionalInterface
interface T2 {
    void bar(int a);
}

@FunctionalInterface
interface T3 {
    int qux(int a, int b);
}


