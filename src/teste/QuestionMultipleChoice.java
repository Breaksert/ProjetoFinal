/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;


import interfaces.models.IQuestionMultipleChoice;

/**
 *
 * @author João Paulo Oliveira
 */

public class QuestionMultipleChoice extends Question implements IQuestionMultipleChoice{
    
    private String[] options;
    private String user_answer;
    
    
    @Override
    public String[] getOptions() {
        return this.options;
    }

    @Override
    public void setOptions(String[] options) {
        this.options = options;
    }

    
}
