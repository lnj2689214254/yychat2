package com.yychatserver.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.yychat.model.Message;
import com.yychat.model.User;

public class ClientConnect {
	public static Socket s;
        public  ClientConnect(){
        	try {
				s=new Socket("127.0.0.1",3456);
			} catch (IOException e) {
				e.printStackTrace();
			}
        	
        }
        public Message loginValidate(User user){
        	ObjectOutputStream oos;
        	Message  mess=null;
        	 ObjectInputStream ois;
        	 try {
				 oos =new ObjectOutputStream(s.getOutputStream());
                 oos.writeObject(user);		
                 
                 
                  ois=new ObjectInputStream(s.getInputStream());
                 
				  mess=(Message)ois.readObject();
						
        	 } catch (IOException e) {
				e.printStackTrace();{
					
				}
        	 } 
        	 
        	 catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        	 return mess;
        }
        	 public static void main(String[]args){
        }
}



