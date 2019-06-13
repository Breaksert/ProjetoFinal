/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import interfaces.models.IQuestion;

/**
 *
 * @author João Paulo Oliveira
 */
public class Receiver {
    
    private String type;
    private IQuestion question;

    
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    

    public IQuestion getQuestion() {
        return question;
    }

    public void setQuestion(IQuestion question) {
        this.question = question;
    }
    
    
}
