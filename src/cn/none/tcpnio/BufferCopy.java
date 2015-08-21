package cn.none.tcpnio;

import java.nio.CharBuffer;

/**
 * 缓冲区copy
 * 
 * @author Administrator
 *
 */
public class BufferCopy {
	public static void main(String[] args) {
		// 复制一个缓冲区
		CharBuffer buffer = CharBuffer.allocate(8);
		buffer.position(3).limit(6).mark().position(5);
		CharBuffer dupeBuffer = buffer.duplicate();
		// buffer postition位置为5
		dupeBuffer.clear();

		// 复制为只读的缓冲区(可读写缓冲区的改变直接反应在关联的只读缓冲区)
		CharBuffer readWriteBuffer = CharBuffer.allocate(8);
		readWriteBuffer.position(3).limit(6).mark().position(5);
		CharBuffer readOnlyBuffer = readWriteBuffer.asReadOnlyBuffer();
		readWriteBuffer.put('a');
		System.out.println(readOnlyBuffer.get());
		System.out.println(readWriteBuffer.position());
		
		// 分割缓冲区slice()
		char[] myBuffer = new char[8];
		CharBuffer buffer2 = CharBuffer.wrap(myBuffer);
		buffer2.position(3).limit(5);
		CharBuffer sliceBuffer = buffer2.slice();
		System.out.println(sliceBuffer.length()); // 缓冲区长度为2
	}
}
