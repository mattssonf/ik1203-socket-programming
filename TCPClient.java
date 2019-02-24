package tcpclient;
import java.net.*;
import java.io.*;

public class TCPClient {

    public static String askServer(String hostname, int port, String ToServer) throws  IOException {
      String line;
      StringBuilder sb = new StringBuilder();

      Socket clientSocket = new Socket(hostname, port);

      DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

      BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

      outToServer.writeBytes(ToServer + '\n');

      try{
        clientSocket.setSoTimeout(4000);
        while((line = inFromServer.readLine()) != null){
          sb.append(line);
          sb.append("\n");
        }
      }
      catch (Exception e) {

      }

      clientSocket.close();

      return sb.toString();
    }

    public static String askServer(String hostname, int port) throws  IOException {
      return askServer(hostname, port, "");
    }
}
