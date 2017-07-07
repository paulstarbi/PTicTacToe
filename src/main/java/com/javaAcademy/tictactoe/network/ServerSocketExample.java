package com.javaAcademy.tictactoe.network;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample {
	
	public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1978);
        int cnt = 0;
        while (true){
        	cnt++;
        	System.out.println(cnt);
            Socket socket = serverSocket.accept();
            System.out.println(socket.getRemoteSocketAddress());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("getLocalAddress: " + socket.getLocalAddress() +" \n");
		    bufferedWriter.write("getRemoteSocketAddress: "  + socket.getRemoteSocketAddress() +" \n");
		    bufferedWriter.write("socket.getInetAddress: "  + socket.getInetAddress() +" \n");
		    bufferedWriter.write("socket.getInetAddress().getLoopbackAddress() : "  + socket.getInetAddress().getLoopbackAddress() +" \n");
		    bufferedWriter.write("socket.getLocalSocketAddress: " + socket.getLocalSocketAddress() +" \n\n");
            bufferedWriter.write("Napisz: \"END\" by zakończyć połączenie.");
            String line = bufferedReader.readLine();
            System.out.println("TO JEST ODEBRANE: " + line);
            while (!line.equals("")){
                bufferedWriter.write("\nServer says: ");
                bufferedWriter.write(line);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
                line = bufferedReader.readLine();
                System.out.println("TO JEST ODEBRANE: " + line+".");
            }
            
            bufferedWriter.write("Koniec polaczenia.");
            bufferedWriter.flush();
            socket.close();
        }
    }
}
