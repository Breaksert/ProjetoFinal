/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.*;
import interfaces.controller.ITest;
import interfaces.controller.ITestStatistics;
import interfaces.exceptions.TestException;
import interfaces.models.IQuestion;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.TestWindow;
/**
 *
 * @author João Paulo Oliveira
 */
public class Teste{

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    
    public static void main(String[] args) throws FileNotFoundException {
        /**
        Test teste = new Test();
        teste.loadFromJSONFile("C:\\FP\\PP_FinalProject\\teste_A.txt");
        
        Receiver[] array = teste.getReceiver();
        System.out.println(array[3].getType());
        Question questao = array[3].getQuestion();
        String resposta = questao.getCorrect_answer();
        System.out.println(questao.getCorrect_answer());
        System.out.println(questao.getClass());
        */
        
        ITest demoTest = new Test();
        try {
            demoTest.loadFromJSONFile("C:\\FP\\PP_FinalProject\\teste_A.txt");
        } catch (TestException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TestWindow t = new TestWindow();
        try {
            t.startTest(demoTest);
        } catch (TestException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Teste Efectuado");
        System.out.println(demoTest.toString());
        
    }
}
