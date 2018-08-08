package cn.edu.jxnu.other;

public class TestInstanceOf {

	public static void main(String[] args) {
		A a = new A();
		System.out.println(a instanceof B);// true a与父类
		System.out.println(a instanceof C);// true a与父接口
		System.out.println(a instanceof D);// false a与子类
	}

}

interface C {

}

abstract class B implements C {

}

class A extends B {

}

class D extends A {

}