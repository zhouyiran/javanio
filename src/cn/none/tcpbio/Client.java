package cn.none.tcpbio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		String host = "127.0.0.1";
		int port = 9527;
		try {
			Socket socket = new Socket(host,port);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader systemin = new BufferedReader(new InputStreamReader(System.in));
			boolean flag = true;
			while(flag) {
				String line = systemin.readLine();
				if(line==null) {
					Thread.sleep(100);
					continue;
				}else if(line == "quit") {
					System.out.println("Client quit!");
					in.close();
					out.close();
					systemin.close();
					flag = false;
				}else{
					out.write(line+"\n");
					System.out.println("Client send Message " + line);
					out.flush();
				}
			}
		} catch (UnknownHostException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
