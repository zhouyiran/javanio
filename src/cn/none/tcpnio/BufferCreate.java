package cn.none.tcpnio;

import java.nio.CharBuffer;

public class BufferCreate {
	public static void main(String[] args) {
		/**
		 * 方式一: 分配一个容量为100个char变量的CharBuffer
		 * 隐含从堆空间分配一个char类型数组作为备份存储器存储100个char变量
		 * 
		 */
		CharBuffer.allocate(100);

		/**
		 * 方式二:提供自己的数组用作缓冲区的备份存储器,wrap()函数
		 * 带有offset length参数的wrap函数设置了缓冲区的初始的状态，通过clear()函数
		 * 可以填充整个数组
		 */
		char[] myArray = new char[100];
		CharBuffer charbuffer = CharBuffer.wrap(myArray);
		CharBuffer.wrap(myArray, 12, 42);
		
		// 通过备份存储数组的形式创建的缓冲区通过hasArray()检测是否有一个可存取的备份数组
		boolean hasArray = charbuffer.hasArray();
		CharBuffer charBuffer = CharBuffer.wrap("Hello Word");
		System.out.println(charBuffer);
	}
}
