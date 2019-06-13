/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.google.gson.Gson;
import interfaces.controller.ITest;
import interfaces.controller.ITestStatistics;
import interfaces.exceptions.TestException;
import interfaces.models.IQuestion;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João Paulo Oliveira
 */
public class Test implements ITest{
    
    private Receiver[] receiver;
   

    public Test() {
    }
    
    public Receiver[] getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver[] receiver) {
        this.receiver = receiver;
    }
    
    
    
    BufferedReader reader = null;
    @Override
    public boolean loadFromJSONFile(String path) throws TestException {
        
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gson gson = new Gson();
        Receiver[] teste = gson.fromJson(reader, Receiver[].class);
        
        this.receiver = teste;

        return this.receiver == teste;
    }

    @Override
    public boolean addQuestion(IQuestion q) throws TestException {
        
        if(q == null){
            throw new TestException("A questão que pretende adicionar não existe");
        }else{
            if(numberQuestions() >= this.receiver.length){
                throw new TestException("Não existe mais espaço no teste");
            }else{
                int i=0;
                while(this.receiver[i].getQuestion() != null && i<this.receiver.length){
                    i++; 
                }
                this.receiver[i].setQuestion(q);
                
                return true;
            }  
        }
    }

    @Override
    public IQuestion getQuestion(int pos) throws TestException {
        
        if(pos < 0 || pos >= numberQuestions()){
            throw new TestException("A posição indicada é inválida!");
        }else{
            if(this.receiver[pos].getQuestion() == null){
                throw new TestException("Não existe ficheiro na posição indicada!");
            }else{
                return this.receiver[pos].getQuestion();
            }
        }
    }

    @Override
    public boolean removeQuestion(int pos) {
        if(numberQuestions() == 0){
            System.out.println("Não existem questões no teste para serem removidas!");
            return false;
        }else{
            if(pos < 0 || pos >= numberQuestions()){
                System.out.println("A posição indicada para remover não existe!");
                return false;
            }
            else{
                this.receiver[pos]=null;
                while(pos < receiver.length-1){
                    receiver[pos] = receiver[pos + 1];
                    pos++;
                }
                receiver[pos]=null;
                return true;
            }
        }
    }

    @Override
    public boolean removeQuestion(IQuestion q) {

        if(numberQuestions() == 0){
            System.out.println("Não existem questões no teste para serem removidas!");
            return false;
        }else{
            if(q == null){
                System.out.println("A posição indicada para remover não existe!");
                return false;
            }
            else{
                for(int i=0; i<receiver.length; i++){
                    if(this.receiver[i].getQuestion() == q){
                        this.receiver[i] = null;
                        while(i < receiver.length-1){
                            receiver[i] = receiver[i + 1];
                            i++;
                        }
                        receiver[i]=null;
                        return true;
                    }
                    if(i == receiver.length){
                        return false;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public int numberQuestions() {
        int i=0;
        
        while(i<receiver.length && receiver[i]!=null){
            i++;
        }
        return i;
    }

    @Override
    public boolean isComplete() {
        int cont=0;
        
        for(int i=0; i<this.receiver.length; i++){
            IQuestion questao = receiver[i].getQuestion();
            if(questao.isDone() == true){
                cont++;
            }
        }
        return cont==receiver.length;
    }

    @Override
    public ITestStatistics getTestStatistics() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
