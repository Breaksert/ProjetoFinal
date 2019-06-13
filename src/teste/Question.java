/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import interfaces.models.IQuestion;
import interfaces.models.IQuestionMetadata;
import interfaces.models.IQuestionMultipleChoice;
import interfaces.models.IQuestionNumeric;
import interfaces.models.IQuestionYesNo;

/**
 *
 * @author João Paulo Oliveira
 */
public class Question{
    
    
    private String title;
    private String question_description;
    private String[] options = new String[4];
    private String correct_answer;
    
    private String user_answer;
    private double correct_anwser;
    private String answer;
    private boolean is_done;
    
    
    public Question() {
    }
    
    
    //Metodos de questoes
    
    public String getTitle() {
        return title;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }

   
    public String getQuestion_description() {
        return question_description;
    }

    
    public void setQuestion_description(String question_description) {
        this.question_description = question_description;
    }
    
    
    public IQuestionMetadata getQuestion_metadata() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
    
   
    public void setQuestion_metadata(IQuestionMetadata question_metadata) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    public boolean isDone() {
        if(this.answer != null){
            setDone(true);
            return true;
        }else{
            return false;
        }
    }
    
    
    public void setDone(boolean done){
        this.is_done = done;
    }
    
    
    public void answer(String user_answer) {
        this.answer = user_answer;
    }
    
   
    public boolean evaluateAnswer() {
        
        return (this.correct_answer == null ? this.correct_answer == null :
                this.correct_answer.equals(this.correct_answer));
    }
    
    
    
    //Metodos de Escolha Multipla

    
    
    
    //Metodos de escolha numerica

    
    
}
