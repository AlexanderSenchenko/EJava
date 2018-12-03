import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 4004);

			InputStream inStream = socket.getInputStream();
			OutputStream outStream = socket.getOutputStream();

			Scanner in = new Scanner(inStream);
			PrintWriter out = new PrintWriter(outStream);

			out.write("Hello, server\n");
			out.flush();

			String recvMsg = in.nextLine();
			System.out.println(recvMsg);
			
			socket.close();
			in.close();
			out.close();
		} catch(IOException error) {
			System.err.println(error);
		}
	}
}