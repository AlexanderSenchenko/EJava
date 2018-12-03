import java.net.*;
import java.io.*;
import java.util.*;


public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket socket = new ServerSocket(4004);
			System.out.println("Server started");

			Socket client = socket.accept();
			System.out.println("Client connected");

			InputStream inStream = client.getInputStream();
			OutputStream outStream = client.getOutputStream();

			Scanner in = new Scanner(inStream);
			PrintWriter out = new PrintWriter(outStream);

			String recvMsg = in.nextLine();
			System.out.println(recvMsg);

			out.write("Hello, client\n");
			out.flush();

			client.close();
			in.close();
			out.close();

			System.out.println("Server closed");
			socket.close();
		} catch(IOException error) {
			System.err.println(error);
		}
	}
}