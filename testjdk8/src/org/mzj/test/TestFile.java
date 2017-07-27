package org.mzj.test;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.junit.Test;

public class TestFile {
	@Test
	public void test01() {
//		System.out.println((long) (Math.random() * 100));
		String a = "a";
		String b = "b";
		String ab = "ab";
		String ab1 = a+b;
		System.out.println(ab==ab1);
		System.out.println(ab.intern() == ab1.intern());
	}

	// 并发写文件没有问题
	@Test
	public void testConcurrentOptFile() {
		ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new FileOpt(i, rwl));
			t.start();
		}

		try {
			Thread.sleep(1000 * 60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestFile test = new TestFile();
		ReentrantReadWriteLock rwl = new ReentrantReadWriteLock(true);
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(test.new FileOpt(i, rwl));
			t.start();
		}
	}

	class FileOpt implements Runnable {
		int i;
		ReentrantReadWriteLock lock;

		public FileOpt(int i, ReentrantReadWriteLock lock) {
			this.i = i;
			this.lock = lock;
		}

		public void run() {
			log("进入线程。。。");
			boolean locked = false;
			try {
				// 上读锁，其他线程只能读不能写；上写锁，其他线程不能读也不能写
				locked = lock.writeLock().tryLock(1, TimeUnit.SECONDS);
				log("获取锁 " + locked);
				if (locked) {
					Thread.sleep((long) (100 * Math.random()));//
					File f = new File("d:/tmp/1.txt");
					if (!f.exists())
						f.createNewFile();
					RandomAccessFile raf = new RandomAccessFile(f, "rw");
					String line = raf.readLine();
					Thread.sleep(100);//
					log("读取了文件，内容为" + line);
					if (line == null || "".equals(line.trim()))
						line = "0";
					Integer r = Integer.valueOf(line) + 1;
					raf.setLength(0);
					String result = "" + r;
					raf.write(result.getBytes());
					raf.close();
					log("写入了文件，内容为" + result);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
//				if (lock.writeLock().isHeldByCurrentThread()) {
				if (locked) {
					try {
						lock.writeLock().unlock();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		public void log(String msg) {
			System.out.println("线程" + i + "：" + msg);
		}
	}
}
