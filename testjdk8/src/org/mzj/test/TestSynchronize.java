package org.mzj.test;

public class TestSynchronize {
	public static void main(String[] args) {
		A a = new A();
		new Thread() {
			public void run() {
				a.add();
			};
		}.start();
		new Thread() {
			public void run() {
				a.sub();
			};
		}.start();
		A b = new A();
		new Thread() {
			public void run() {
				b.add();
			};
		}.start();
		new Thread() {
			public void run() {
				b.sub();
			};
		}.start();
	}
}

// add和sub不能同时进入
class A {
	public static int i = 0;
	private static String lock = new String("lock");

	public void add() {
		synchronized (lock) {
			System.out.println(this + ".add -->");
			A.i++;

			try {
				Thread.sleep(1000 * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this + ".add --|");
		}
	}

	public void sub() {
		synchronized (lock) {
			System.out.println(this + ".sub -->");
			A.i--;
			System.out.println(this + ".sub --|");
		}
	}
}
