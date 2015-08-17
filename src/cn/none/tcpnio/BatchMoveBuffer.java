package cn.none.tcpnio;

import java.nio.CharBuffer;

/**
 * 缓冲区批量移动的两种方式
 * 
 * @author Administrator
 */
public class BatchMoveBuffer {
	private static int index = 0;
	private static String[] strings = { "A random string value",
			"The product of an infinite number of monkeys",
			"Hey hey we're the Monkees",
			"Opening act for the Monkees: Jimi Hendrix",
			"'Scuse me while I kiss this fly", // Sorry Jimi ;-)
			"Help Me! Help Me!", };

	public static void main(String[] argv) throws Exception {
		CharBuffer buffer = CharBuffer.allocate(10000);
		while (fillBuffer(buffer)) { // 填充
			buffer.flip(); // 翻转
			drainBuffer(buffer);
			buffer.clear();
		}
	}

	private static void drainBuffer(CharBuffer buffer) {

		/*
		 * while (buffer.hasRemaining()) {
		 * 
		 * System.out.print(buffer.get()); }
		 * System.out.println("=========================");
		 */

		/**
		 * // 缓冲区内的数据小于1000 char [] bigArray = new char [1000]; // Get count of
		 * chars remaining in the buffer int length = buffer.remaining( ); //
		 * Buffer is known to contain < 1,000 chars buffer.get(bigArray, 0,
		 * length); // Do something useful with the data processData (bigArray,
		 * length);
		 **/

		/**
		 * 缓冲区内数据大于数组，则需要多次获取
		 */
		char[] smallArray = new char[10];
		while (buffer.hasRemaining()) {
			int length = Math.min(buffer.remaining(), smallArray.length);
			buffer.get(smallArray, 0, length);
			processData(smallArray, length);
		}
		System.out.println("---------------");
	}

	private static boolean fillBuffer(CharBuffer buffer) {
		if (index >= strings.length) {
			return (false);
		}
		String string = strings[index++];
		for (int i = 0; i < string.length(); i++) {
			buffer.put(string.charAt(i));
		}
		return (true);
	}

	public static void processData(char[] charBuffer, int length) {
		for (int i = 0; i < charBuffer.length; i++) {
			System.out.print(charBuffer[i]);
		}
	}
}
