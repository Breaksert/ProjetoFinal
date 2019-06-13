/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import interfaces.models.IQuestionNumeric;

/**
 *
 * @author João Paulo Oliveira
 */
/**
public class QuestionNumeric {

    private double correct_anwser = Double.parseDouble(super.getCorrect_answer());
    private double user_anwser;
    
    @Override
    public double getCorrect_anwser() {
        return this.correct_anwser;
    }

    @Override
    public void setCorrect_anwser(double correct_anwser) {
        this.correct_anwser = correct_anwser;
    }

    @Override
    public double getUser_answer() {
        return this.user_anwser;
    }

    @Override
    public void setUser_answer(double user_answer) {
        this.user_anwser = user_answer;
        super.answer(Double.toString(this.user_anwser));
    }
    
}
*/