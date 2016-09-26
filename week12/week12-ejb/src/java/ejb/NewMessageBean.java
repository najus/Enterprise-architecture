/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author najus
 */

@JMSDestinationDefinition(name = "jms/NewMessage", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "NewMessage")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/NewMessage"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class NewMessageBean implements MessageListener {

    @Resource
    private MessageDrivenContext mdc;
    
    @PersistenceContext(unitName = "week12-ejbPU")
    private EntityManager em;
    
    public NewMessageBean() {
    }

    @Override
    public void onMessage(Message message) {
        ObjectMessage msg = null;
    try {
        if (message instanceof ObjectMessage) {
            msg = (ObjectMessage) message;
            NewsEntity e = (NewsEntity) msg.getObject();
            persist(e);            
        }
    } catch (JMSException e) {
        e.printStackTrace();
        mdc.setRollbackOnly();
    } catch (Throwable te) {
        te.printStackTrace();
    }
    }

    public void persist(Object object) {
        em.persist(object);
    }

}
