import java.net.*;
import java.io.*;
import java.util.*;

//simple http echo server
public class HTTPEcho {
    public static void main( String[] args) throws IOException {

      int portnr = Integer.parseInt(args[0]);
      ServerSocket welcomeSocket = new ServerSocket(portnr);

      while(true){

        Socket connectionSocket = welcomeSocket.accept();

        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        OutputStream outToClient = connectionSocket.getOutputStream();

        String line = inFromClient.readLine();
        while(!line.isEmpty()){

          line = line + "\r\n";
          outToClient.write(line.getBytes("UTF-8"));
          line = inFromClient.readLine();

        }
        connectionSocket.close();
      }
    }
}
