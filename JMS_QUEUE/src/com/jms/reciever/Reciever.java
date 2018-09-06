package com.jms.reciever;


import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jms.listener.MyListener;

public class Reciever {

	ConnectionFactory factory;

	public static void main(String[] args) throws NamingException, JMSException, InterruptedException {

		
		
		
		
		
		InitialContext initialContext=new InitialContext();
		ConnectionFactory connectionFactory=(ConnectionFactory) initialContext.lookup("myQueueConnectionFactory");
		Connection connection=connectionFactory.createConnection();
		connection.start();
		
		Queue queue = (Queue) initialContext.lookup("myQueue");

		Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		MessageConsumer consumer=session.createConsumer(queue);
		TextMessage message =(TextMessage) consumer.receive();
		System.out.println(message.getText());
		
		
//		while (true) {
//			Thread.sleep(1000);
//		}
		/*// Create a connection and start it
		InitialContext context = new InitialContext(props);
		QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup("myQueueConnectionFactory");
		QueueConnection con = factory.createQueueConnection();
		con.start();

		// create a queue session
		QueueSession session = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

		// get the queue object
		Queue queue = (Queue) context.lookup("myQueue");

		// create a queue receiver
		QueueReceiver receiver = session.createReceiver(queue);

		
		// create a Listener object
		MyListener listener = new MyListener();

		// register the listener object with receiver
		receiver.setMessageListener(listener);
		System.out.println("Ready For the messages\nTerminate to stop");*/

	}

}
