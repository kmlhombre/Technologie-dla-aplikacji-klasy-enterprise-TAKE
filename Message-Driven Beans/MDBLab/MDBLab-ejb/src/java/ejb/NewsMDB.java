/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author student
 */
@JMSDestinationDefinition(name = "java:app/jms/NewsQueue", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "NewsQueue")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:app/jms/NewsQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class NewsMDB implements MessageListener {
    
    @PersistenceContext
    private EntityManager em;
    
    public NewsMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage msg = null;
        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
                NewsItem e = new NewsItem();
                String[] result_msg = msg.getText().split("\\|");
                e.setHeading(result_msg[0]);
                e.setBody(result_msg[1]);
                em.persist(e);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
}
