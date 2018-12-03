import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.Thread;

public class Server {
	private static ServerSocket socket;
	public static void main(String[] args) {
		try {
			try {
				socket = new ServerSocket(4004);
				System.out.println("Server started");

				while (true) {
					Socket client = socket.accept();
					System.out.println("Client connected");

					Runnable r = new MyRun(client);

					Thread t = new Thread(r);
					t.start();
				}
			} finally {
				System.out.println("Server closed");
				socket.close();
			}
		} catch(IOException error) {
			System.err.println(error);
		}
	}
}

class MyRun implements Runnable {
	private Socket client;

	public MyRun(Socket client) {
		this.client = client;
	}

	public void run() {
		try {
			InputStream inStream = this.client.getInputStream();
			OutputStream outStream = this.client.getOutputStream();

			Scanner in = new Scanner(inStream);
			PrintWriter out = new PrintWriter(outStream);

			String recvMsg = in.nextLine();
			System.out.println(recvMsg);

			out.write("Hello, client\n");
			out.flush();

			try{
				Thread.sleep(100000);
			} catch(InterruptedException e){}

			this.client.close();
			in.close();
			out.close();
		} catch(IOException error) {
			System.err.println(error);
		}
	}
}