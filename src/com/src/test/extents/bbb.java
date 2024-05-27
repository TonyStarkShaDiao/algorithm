package com.src.test.extents;

public class bbb extends aaa {

    public final void a() {
        b();
    }

    @Override
    protected void c() {
        System.out.println("bbb");
    }

    public static void main(String[] args) {
        bbb bbb = new bbb();
        bbb.a();
    }

}
