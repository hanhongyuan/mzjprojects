package org.mzj.test;

import org.junit.Test;

public class TestCollection {

	@Test
	public void test01(){
		System.out.println(1 << 4);
		System.out.println(~2);
		System.out.println(Integer.toBinaryString(4));
		System.out.println(toFullBinaryString(4));
	}
	
	/**

     * 打印整型数值的完整二进制格式
     * @param x
     * @return
     */
    private static String toFullBinaryString(int x) {
        int[] buffer = new int[Integer.SIZE];
        for (int i = (Integer.SIZE - 1); i >= 0; i--) {
            buffer[i] = x >> i & 1;
        }
        String s = "";
        for (int j = (Integer.SIZE - 1); j >= 0; j--) {
            s = s + buffer[j];
        }
        return s;
    }
}
