import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.Thread;

public class Server
{
	private static ServerSocket serverSocket;
	
	public static void main(String[] args)
	{
		try {
			try {
				serverSocket = new ServerSocket(4004);
				System.out.println("Server started");

				while (true) {
					Socket clientSocket = serverSocket.accept();
					System.out.println("Client connected");

					Runnable run = new MyRun(clientSocket);

					Thread thread = new Thread(run);
					thread.start();
				}
			} finally {
				System.out.println("Server closed");
				serverSocket.close();
			}
		} catch(IOException error) {
			System.err.println(error);
		}
	}
}

class MyRun implements Runnable
{
	private Socket clientSocket;

	public MyRun(Socket clientSocket)
	{
		this.clientSocket = clientSocket;
	}

	public void run()
	{
		try {
			InputStream inStream = this.clientSocket.getInputStream();
			Scanner in = new Scanner(inStream);
			
			OutputStream outStream = this.clientSocket.getOutputStream();
			OutputStreamWriter out = new OutputStreamWriter(outStream);

			String recvMsg = in.nextLine();
			System.out.println(recvMsg);

			// out.write(
			// 	"HTTP/1.0 200 OK\r\n" +
			// 	"Content-type: text/html\r\n" +
			// 	"\r\n" +
			// 	"<h2>Hello</h2>\r\n");
			out.write("Hello\r\n");
			out.flush();

			this.clientSocket.close();
			System.out.println("Client closed");
			in.close();
			out.close();
		} catch(IOException error) {
			System.err.println(error);
		}
	}
}