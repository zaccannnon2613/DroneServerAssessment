/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.droneserver;

/**
 *
 * @author Zac
 */
import java.net.*;
import java.io.*;
public class DroneClient {
    
    public static void main (String args[]){
        Socket s=null;
        String hostName = "localhost";
        String message = "Hello";
        
        try{
            int serverPort = 7896;
            
            s = new Socket(hostName, serverPort);
            
        }
        catch (UnknownHostException e){
	   System.out.println("Sock:"+e.getMessage()); 
	} catch (EOFException e){
	   System.out.println("EOF:"+e.getMessage());
    	} catch (IOException e){
	   System.out.println("IO:"+e.getMessage());
        }
	finally {
	   if(s!=null)
	     try {
              s.close();
             } catch (IOException e){
		System.out.println("close:"+e.getMessage());}
        } 
    }
    }

