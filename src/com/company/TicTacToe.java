package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class TicTacToe extends JFrame implements ActionListener {

    Random random = new Random();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JButton [] buttons = new JButton[9];
    JLabel textField = new JLabel();
    boolean player_turn;

    TicTacToe(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,800);
        getContentPane().setBackground(Color.black);
        setLocationRelativeTo(null);
        setTitle("Tic-Tac-Toe Game");
        setLayout(new BorderLayout());

        //Work on text field

        textField.setText("Tic Tac Toe");
//        textField.setBackground(Color.BLUE);
        textField.setForeground(Color.GREEN);
        textField.setFont(new Font("Ink Free",Font.ITALIC,80));
        textField.setHorizontalAlignment(JLabel.CENTER);

        //add text field to title panel and title panel to frame
        title_panel.setBounds(0,0,800,100);
        title_panel.add(textField);
        title_panel.setBackground(Color.GRAY);
        add(title_panel,BorderLayout.NORTH);

        //Work on button panel
        button_panel.setLayout(new GridLayout(3,3));

        for(int i =0;i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.ITALIC,120));
            buttons[i].addActionListener(this);
            buttons[i].setFocusable(false);
            buttons[i].setContentAreaFilled(true);
//            buttons[i].setFocusable(false);
        }

        add(button_panel,BorderLayout.CENTER);
        setVisible(true);

        firstTurn();
    }

    public void actionPerformed(ActionEvent e){
        for(int i = 0 ;i<9;i++){
            if(e.getSource() == buttons[i]){
                if(player_turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("X");
                        player_turn = false;
                        textField.setText("O turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("O");
                        player_turn = true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }

    }

    public void firstTurn(){

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(2) == 0){
            player_turn = true;
            textField.setText("X turn");
            textField.setForeground(Color.BLUE);
        }
        else{
            player_turn = false;
            textField.setText("O turn");
            textField.setForeground(Color.RED);

        }
    }

    public void check(){
            //Check if x wins
        if((buttons[0].getText() == "X") &&( buttons[1].getText() == "X")&& (buttons[2].getText() == "X")){
            xWins(0,1,2);
        }
        if((buttons[3].getText() == "X") &&( buttons[4].getText() == "X")&& (buttons[5].getText() == "X")){
            xWins(3,4,5);
        }
        if((buttons[6].getText() == "X") &&( buttons[7].getText() == "X")&& (buttons[8].getText() == "X")){
            xWins(6,7,8);
        }
        if((buttons[0].getText() == "X") &&( buttons[3].getText() == "X")&& (buttons[6].getText() == "X")){
            xWins(0,3,6);
        }
        if((buttons[1].getText() == "X") &&( buttons[4].getText() == "X")&& (buttons[7].getText() == "X")){
            xWins(1,4,7);
        }
        if((buttons[2].getText() == "X") &&( buttons[5].getText() == "X")&& (buttons[8].getText() == "X")){
            xWins(2,5,8);
        }
        if((buttons[0].getText() == "X") &&( buttons[4].getText() == "X")&& (buttons[8].getText() == "X")){
            xWins(0,4,8);
        }
        if((buttons[2].getText() == "X") &&( buttons[4].getText() == "X")&& (buttons[6].getText() == "X")){
            xWins(2,4,6);
        }

        //check if O wins
        if((buttons[0].getText() == "O") &&( buttons[1].getText() == "O")&& (buttons[2].getText() == "O")){
            oWins(0,1,2);
        }
        if((buttons[3].getText() == "O") &&( buttons[4].getText() == "O")&& (buttons[5].getText() == "O")){
            oWins(3,4,5);
        }
        if((buttons[6].getText() == "O") &&( buttons[7].getText() == "O")&& (buttons[8].getText() == "O")){
            oWins(6,7,8);
        }
        if((buttons[0].getText() == "O") &&( buttons[3].getText() == "O")&& (buttons[6].getText() == "O")){
            oWins(0,3,6);
        }
        if((buttons[1].getText() == "O") &&( buttons[4].getText() == "O")&& (buttons[7].getText() == "O")){
            oWins(1,4,7);
        }
        if((buttons[2].getText() == "O") &&( buttons[5].getText() == "O")&& (buttons[8].getText() == "O")){
            oWins(2,5,8);
        }
        if((buttons[0].getText() == "O") &&( buttons[4].getText() == "O")&& (buttons[8].getText() == "O")){
            oWins(0,4,8);
        }
        if((buttons[2].getText() == "O") &&( buttons[4].getText() == "O")&& (buttons[6].getText() == "O")){
            oWins(2,4,6);
        }
    }

    public void xWins(int a,int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }

        textField.setText("X wins");


    }
    public void oWins(int a,int b, int c){


        for(int i= 0; i<9;i++){
            buttons[i].setEnabled(false);
        }

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        textField.setText("O wins");

    }

    public static void main(String[] args){
        new TicTacToe();
    }
}
