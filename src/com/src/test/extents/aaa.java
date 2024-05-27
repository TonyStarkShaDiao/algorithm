package com.src.test.extents;

public class aaa {
    public void a() {
        throw new RuntimeException("aaa");
    }

    public final void b() {
        c();
    }

    ;


    protected void c() {
        throw new RuntimeException("aaa");
    }

    ;
}
//