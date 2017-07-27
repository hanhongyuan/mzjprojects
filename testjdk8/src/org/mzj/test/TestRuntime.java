package org.mzj.test;

import org.junit.Test;

public class TestRuntime {
	// 在jvm中增加一个关闭的钩子
	@Test
	public void testHook() {
		Thread hook = new Thread() {
			public void run() {
				System.out.println("虚拟机正常退出。。。");
			}
		};
		Runtime.getRuntime().addShutdownHook(hook);

		new Thread() {
			public void run() {
				System.out.println("业务操作进行中。。。");
			};
		}.start();

		try {
			Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testProcessors() {
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
}
