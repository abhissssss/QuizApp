package com.abhisheksingh.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Quiz implements ActionListener {

    String[] questions = {"At run-time a Java program is nothing more than objects talking to ?",
                          "The relation between Car and Owner or BankAccount and Customer is example for ?",
                          "Subclassing polymorphism is sometimes called true polymorphism ?",
                          "An interface cannot have an inner class ? "
    };
    String[][] options = {

            {"Other objects", "Other methods", "Other classes", "Other binders"},
            {"Aggregation", "Composition", "Association", "None"},
            {"True", "False", "Cannot say" , "Contradictory"},
            {"True", "False" , "Cannot Say" , "Contradictory"}
    };

    char[] answers = {
            'A',
            'B',
            'B',
            'A'
    };

    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = questions.length;
    int result;
    int seconds = 15;
    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField numbers_right = new JTextField();
    JTextField percentage = new JTextField();

    public Quiz() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(true);

        textField.setBounds(0, 0, 650, 50);
        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(255, 25, 255));
        textField.setFont(new Font("MV Boli", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);


        textArea.setBounds(0, 50, 650, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25, 25, 25));
        textArea.setForeground(new Color(255, 0, 128));
        textArea.setFont(new Font("Courier M", Font.BOLD, 20));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        buttonA.setBounds(0, 100, 100, 100);
        buttonA.setFont(new Font("MV Boli", Font.BOLD, 25));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0, 200, 100, 100);
        buttonB.setFont(new Font("MV Boli", Font.BOLD, 25));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0, 300, 100, 100);
        buttonC.setFont(new Font("MV Boli", Font.BOLD, 25));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0, 400, 100, 100);
        buttonD.setFont(new Font("MV Boli", Font.BOLD, 25));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelA.setBounds(125, 100, 300, 100);
        answer_labelA.setBackground(new Color(0x323232));
        answer_labelA.setForeground(new Color(25, 255, 0));
        answer_labelA.setFont(new Font("MV Boli", Font.PLAIN, 25));

        answer_labelB.setBounds(125, 200, 300, 100);
        answer_labelB.setBackground(new Color(0x323232));
        answer_labelB.setForeground(new Color(25, 255, 0));
        answer_labelB.setFont(new Font("MV Boli", Font.PLAIN, 25));

        answer_labelC.setBounds(125, 300, 300, 100);
        answer_labelC.setBackground(new Color(0x323232));
        answer_labelC.setForeground(new Color(25, 255, 0));
        answer_labelC.setFont(new Font("MV Boli", Font.PLAIN, 25));

        answer_labelD.setBounds(125, 400, 300, 100);
        answer_labelD.setBackground(new Color(0x323232));
        answer_labelD.setForeground(new Color(25, 255, 0));
        answer_labelD.setFont(new Font("MV Boli", Font.PLAIN, 25));


        seconds_left.setBounds(535, 510, 100, 100);
        seconds_left.setBackground(new Color(25, 25, 25));
        seconds_left.setForeground(new Color(255, 0, 0));
        seconds_left.setFont(new Font("Courier M", Font.PLAIN, 60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_label.setBounds(535,475,100,25);
        time_label.setBackground(new Color(50,50,50));
        time_label.setForeground(new Color(255,0,0));
        time_label.setFont(new Font("Courier M" , Font.PLAIN , 16));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("Timer!!!!");

        numbers_right.setBounds(225,225,200,100);
        numbers_right.setBackground(new Color(25,25,25));
        numbers_right.setForeground(new Color(25,255,0));
        numbers_right.setFont(new Font("Segoe Script" , Font.BOLD, 50  ));
        numbers_right.setBorder(BorderFactory.createBevelBorder(1));
        numbers_right.setHorizontalAlignment(JTextField.CENTER);
        numbers_right.setEditable(false);

        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("Ink Free",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);



        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textField);
        frame.add(textArea);
        frame.setVisible(true);
        nextQuestion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        if (e.getSource()==buttonA) {
            answer = 'A';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
            if (e.getSource() == buttonB) {
                answer = 'B';
                if (answer == answers[index]) {
                    correct_guesses++;
                }
            }
                if (e.getSource() == buttonC) {
                    answer = 'C';
                    if (answer == answers[index]) {
                        correct_guesses++;
                    }
                }
                    if (e.getSource() == buttonD) {
                        answer = 'D';
                        if (answer == answers[index]) {
                            correct_guesses++;
                        }
                    }
        displayAnswer();
    }
    public void nextQuestion (){
        if (index>=total_questions) {
            results() ;
        }
        else{
            textField.setText("Question : " + (index +1));
            textArea.setText(questions[index]);
            answer_labelA.setText(options [index] [0]);
            answer_labelB.setText(options [index] [1]);
            answer_labelC.setText(options [index] [2]);
            answer_labelD.setText(options [index] [3]);
        }
    }

public void displayAnswer () {
    buttonA.setEnabled(false);
    buttonB.setEnabled(false);
    buttonC.setEnabled(false);
    buttonD.setEnabled(false);

    if (answers[index] != 'A')
        answer_labelA.setForeground(new Color(255,0,0));
    if (answers[index] != 'B')
        answer_labelB.setForeground(new Color(255,0,0));
    if (answers[index] != 'C')
        answer_labelC.setForeground(new Color(255,0,0));
    if (answers[index] != 'D')
        answer_labelD.setForeground(new Color(255,0,0));

    Timer pause = new Timer(1500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          answer_labelA.setForeground(new Color(25,255,0));
            answer_labelB.setForeground(new Color(25,255,0));
            answer_labelC.setForeground(new Color(25,255,0));
            answer_labelD.setForeground(new Color(25,255,0));

            answer = ' ' ;
            seconds=10;
            seconds_left.setText(String.valueOf(seconds));
            buttonA.setEnabled(true);
            buttonB.setEnabled(true);
            buttonC.setEnabled(true);
            buttonD.setEnabled(true);
            index++;
            nextQuestion();





        }
    });
    pause.setRepeats(false);
    pause.start();

}

    public void results () {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int)((correct_guesses/(double)total_questions)*100);
        textField.setText("RESULTS!!");
        textArea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        numbers_right.setText("(" +correct_guesses + "/" + total_questions + ")");
        percentage.setText(result + "%");
        frame.add(numbers_right);
        frame.add(percentage);

    }
}
