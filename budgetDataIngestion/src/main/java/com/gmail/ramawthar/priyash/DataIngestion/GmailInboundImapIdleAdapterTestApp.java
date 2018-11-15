
package com.gmail.ramawthar.priyash.budgetDataIngestion;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

public class GmailInboundImapIdleAdapterTestApp {
	//private static Log logger = LogFactory.getLog(GmailInboundImapIdleAdapterTestApp.class);


	public static void main (String[] args) throws Exception {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
				"/META-INF/spring/integration/gmail-imap-idle-config.xml");
		DirectChannel inputChannel = ac.getBean("receiveChannel", DirectChannel.class);
		inputChannel.subscribe(new MessageHandler() {
			public void handleMessage(Message<?> message) throws MessagingException {
				//logger.info("Message: " + message);
				try{
				MimeMessage mm = (MimeMessage) message.getPayload();
				
				Multipart mp = (Multipart) mm.getContent();
				mm.getFolder().open(Folder.READ_ONLY);
				System.out.println("mp.getCount(): "+mp.getCount());
				mm.getFolder().open(Folder.READ_ONLY);
				for (int i = 0; i < mp.getCount(); i++) {
					System.out.println("i count: "+i);
	                BodyPart part = mp.getBodyPart(i);
	                if (part.isMimeType("text/plain")) {
	                	System.out.println("Body Priyash: " + part.getContent().toString());
	                }
	            }
				}catch(Exception e){
					
					e.printStackTrace();
				}
			}
		});
	}
}
