/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package web;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import ejb.NewsItemFacadeLocal;
import ejb.NewsItem;
import java.util.List;
import javax.annotation.Resource;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 *
 * @author student
 */
@Named(value = "newsBean")
@RequestScoped
public class NewsBean {
    @Inject
    private NewsItemFacadeLocal facade;
    
    @Inject
    private JMSContext context;
    @Resource(lookup="java:app/jms/NewsQueue")
    private javax.jms.Queue queue;
    
    private String headingText;
    private String bodyText;
    
    
    /**
     * Creates a new instance of NewsBean
     */
    public NewsBean() {
    }
    
    void sendNewsItem(String heading, String body) {
        try {
            TextMessage message = context.createTextMessage();
            NewsItem e = new NewsItem();
            e.setHeading(heading);
            e.setBody(body);
            message.setText(e.getHeading() + "|" + e.getBody());
            context.createProducer().send(queue, message);
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
    
    public String submitNews() {
        sendNewsItem(this.headingText, this.bodyText);
        return null;
    }
    
    public List<NewsItem> getNewsItems() {
        return facade.getAllNewsItems();
}

    /**
     * @return the headingText
     */
    public String getHeadingText() {
        return headingText;
    }

    /**
     * @param headingText the headingText to set
     */
    public void setHeadingText(String headingText) {
        this.headingText = headingText;
    }

    /**
     * @return the bodyText
     */
    public String getBodyText() {
        return bodyText;
    }

    /**
     * @param bodyText the bodyText to set
     */
    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }
}
