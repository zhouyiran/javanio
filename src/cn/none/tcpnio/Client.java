package cn.none.tcpnio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Client {
	public static void main(String[] args)throws Exception {
		int port = 8232;
		// 建立socket通信信道
		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);
		SocketAddress target = new InetSocketAddress("127.0.0.1", port);
		// 连接socket地址
		channel.connect(target);
		
		Selector selector = Selector.open();
		channel.register(selector, SelectionKey.OP_CONNECT);
		BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			if(channel.isConnected()) {
				String command = systemIn.readLine();
				channel.write(Charset.forName("UTF-8").encode(command));
				
			}
		}
		
	}
}
