import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket("localhost", 4004);

			InputStream inStream = clientSocket.getInputStream();
			Scanner in = new Scanner(inStream);

			OutputStream outStream = clientSocket.getOutputStream();
			PrintWriter out = new PrintWriter(outStream);

			out.write("Hello, server\n");
			out.flush();

			String recvMsg = in.nextLine();
			System.out.println(recvMsg);
			
			clientSocket.close();
			in.close();
			out.close();
		} catch(IOException error) {
			System.err.println(error);
		}
	}
}