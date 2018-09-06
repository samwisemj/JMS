package com.jms.sender;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.Properties;

import javax.jms.*;

public class Sender {

	public static void main(String[] args) throws NamingException, JMSException {

			
		// Create a connection and start it
		InitialContext context = new InitialContext();
		QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup("myQueueConnectionFactory");
		QueueConnection con=factory.createQueueConnection();
		con.start();
		
		//create a queue session
		QueueSession session=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		
		//get the queue object
		Queue queue=(Queue)context.lookup("myQueue");
		
		//create the queue sender object
		QueueSender sender=session.createSender(queue);
	
		//create TextMessage object and put some message in it
		TextMessage msg=session.createTextMessage(); 
		msg.setText("Hello World..This is a message.");
		
		//send the message
		sender.send(msg);
		System.out.println("Msg sent :)");
		
		//close all the connection
		con.close();
	
	}
}
