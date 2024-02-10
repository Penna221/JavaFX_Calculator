package com.pennanen.main;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
public class CalculatorController implements EventHandler<ActionEvent>{
    @FXML
    Button b_0,b_1,b_2,b_3,b_4,b_5,b_6,b_7,b_8,b_9, b_comma;
    @FXML
    Button b_plus,b_minus,b_multiply,b_divide, b_equal, b_back;
    @FXML
    Label l_formula, l_answer;
    String formula = "";
    private void addNumber(String s){
        formula += s;
        updateFormula();
    }
    private void addOperator(String s){
        if(formula.length()==0){
            return;
        }
        char[] characters = formula.toCharArray();
        char last = characters[characters.length-1];
        if(last == '+'||last =='-'||last =='/'||last =='*'){
            formula = formula.substring(0, formula.length()-1)+s;
        }else{
            formula += s;
        }
        updateFormula();
    }
    private void backspace(){
        if(formula.length()==0){
            return;
        }
        formula = formula.substring(0, formula.length()-1);
        updateFormula();
    }
    public void updateFormula(){
        l_formula.setText(formula);
    }
    @Override
    public void handle(ActionEvent e) {

        if(e.getSource()==b_1){
            addNumber("1");
        }
        if(e.getSource()==b_2){
            addNumber("2");
        }
        if(e.getSource()==b_3){
            addNumber("3");
        }
        if(e.getSource()==b_4){
            addNumber("4");
        }
        if(e.getSource()==b_5){
            addNumber("5");
        }
        if(e.getSource()==b_6){
            addNumber("6");
        }
        if(e.getSource()==b_7){
            addNumber("7");
        }
        if(e.getSource()==b_8){
            addNumber("8");
        }
        if(e.getSource()==b_9){
            addNumber("9");
        }
        if(e.getSource()==b_0){
            addNumber("0");
        }
        if(e.getSource()==b_back){
            backspace();
        }
        if(e.getSource()==b_plus){
            addOperator("+");
        }
        if(e.getSource()==b_minus){
            addOperator("-");
        }
        if(e.getSource()==b_divide){
            addOperator("/");
        }
        if(e.getSource()==b_multiply){
            addOperator("*");
        }
        if(e.getSource()==b_comma){
            addNumber(".");
        }
        if(e.getSource()==b_equal){
            calculate();
        }
    }
    public void calculate(){

        Expression e = new ExpressionBuilder(formula).build();
        double  value = e.evaluate();
        DecimalFormat df = new DecimalFormat("#.##");
        if (Math.abs(value) >= 1e12) {
            df = new DecimalFormat("#.##E0");
        }
        df.setRoundingMode(RoundingMode.DOWN);
        String result = df.format(value);
        
        l_answer.setText(result);
        formula = "";
        updateFormula();
    }

}
