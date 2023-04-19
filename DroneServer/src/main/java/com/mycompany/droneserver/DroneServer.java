/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.droneserver;

/**
 *
 * @author Zac
 */
import java.net.*;
import java.io.*;
import java.util.LinkedList;

public class DroneServer {

    public static void main(String[] args) {

        try {
            int serverPort = 4444;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while (true) {
                Socket clientSocket = listenSocket.accept();
                Connection c = new Connection(clientSocket);
                System.out.printf("\nServer waiting on: %d for client from %d ",
                        listenSocket.getLocalPort(), clientSocket.getPort());
            }
        } catch (IOException e) {
            System.out.println("Listen :" + e.getMessage());
        }
    }
}

class Connection extends Thread {
      DataInputStream in;
      DataOutputStream out;
      Socket clientSocket;
      public Connection (Socket aClientSocket) {
        try {
          clientSocket = aClientSocket;
          in=new DataInputStream( 
                    clientSocket.getInputStream());
          out=new DataOutputStream(
                    clientSocket.getOutputStream());
          this.start();
        } catch(IOException e){
           System.out.println("Connection:" +e.getMessage());
          }
      }
     public void run(){
         LinkedList<Drone> droneList = new LinkedList<Drone>();
         LinkedList<Fire> fireList = new LinkedList<Fire>();
         NewJFrame mainGui = new NewJFrame();
         mainGui.mainFrame();
         
         
        try { // an echo server
           String data = in.readUTF();
         // System.out.println(data);
          out.writeUTF("Server received:"+data);

        }catch(EOFException e) {
             System.out.println("EOF:"+e.getMessage());
        }
        catch(IOException e){
           System.out.println("IO:"+e.getMessage());
        }
	 
	finally {
	   try {clientSocket.close();
           }
	    catch(IOException e){/*close failed*/
           }
        }
     }
}
