package com.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyListener implements MessageListener {

	@Override
	public void onMessage(Message arg0) {
		try {
			TextMessage message = (TextMessage) arg0;

			System.out.println("from listner\n msg recived was \n" + message.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
