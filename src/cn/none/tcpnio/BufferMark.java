package cn.none.tcpnio;

import java.nio.CharBuffer;

public class BufferMark {

	public static void main(String[] args) {
		CharBuffer buffer = CharBuffer.allocate(10);
		buffer.put((char) 'H').put((char) 'e').put((char)'e').put((char)'l').put((char)'l').put((char)'o');
		Byte[] mybyte = new Byte[1024];
		buffer.position(2).mark().position(4);
	   for (int i = 0; buffer.hasRemaining(); i++) {
			//mybyte[i] = buffer.get();
		   System.out.println(buffer.get());
		}
		System.out.println(buffer);
		
		buffer.reset();
		System.out.println(buffer);
	
	}
}
