/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.backing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author student
 */
@Named(value="resultBean")
@RequestScoped
public class ResultBean {
    private int number1;
    private int number2;
    private int result;
    private String date;

    
    ResultBean() {
        LocalDateTime obj = LocalDateTime.now();
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss"); 
        String date_temp = obj.format(formatObj);
        this.date = date_temp;
    }
    
    public void calculate() {
        this.result = this.number1 + this.number2;
        FacesContext.getCurrentInstance().addMessage("result", new FacesMessage(FacesMessage.SEVERITY_INFO, "Result", "" + number1 + " + " + number2 + " = " + result));
    }
    /**
     * @return the number1
     */
    public int getNumber1() {
        return number1;
    }

    /**
     * @param number1 the number1 to set
     */
    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    /**
     * @return the number2
     */
    public int getNumber2() {
        return number2;
    }

    /**
     * @param number2 the number2 to set
     */
    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    /**
     * @return the result
     */
    public int getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(int result) {
        this.result = result;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
