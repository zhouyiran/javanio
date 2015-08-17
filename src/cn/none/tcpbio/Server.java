package cn.none.tcpbio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws InterruptedException {
		try {
			ServerSocket socket = new ServerSocket(9527);
			Socket server = socket.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			PrintWriter out = new PrintWriter(server.getOutputStream(),true);
			while(true) {
				String line = in.readLine();
				if(line==null) {
					try {
						Thread.sleep(100);
						continue;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(line=="quit"){
					in.close();
					out.close();
					System.exit(0);
				}else{
					System.out.println("Server Receive Message from clinet " + line);
					out.println("Server Receive Message from client " + line);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
