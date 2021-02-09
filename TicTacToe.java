/*

		Save this file as TicTacToe.java
		To compile  -> javac TicTacToe.java
		To run      ->  java TicTacToe
		Author @Shivesh 
		
*/

import java.awt.*;
import static java.awt.Font.BOLD;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;


public class TicTacToe {
    public static void main(String[] args) {	
        TTT ttt =new TTT();
    }
}


class TTT implements ActionListener {

    int x1 = 0;
    int y1 = 0;
    int count = 0;
	String player1,player2;
    JButton[] btn = new JButton[9];
     
	 TTT ()
	{
		 player1=JOptionPane.showInputDialog("Enter the name of 1st Player :");
		 player2=JOptionPane.showInputDialog("Enter the name of 2nd Player :");

        JFrame frame = new JFrame("TicTacToe by Shivesh");
        frame.setSize(300, 390);
        frame.setLocation(200, 100);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 9; i++) {
            btn[i] = new JButton();
            btn[i].setBounds(x1, y1, 100, 100);
            btn[i].setFont(new Font("", BOLD, 30));                        
            frame.add(btn[i]);

            x1 += 100;

            if (i == 2) {
                y1 += 100;
                x1 = 0;
            }
            if (i == 5) {
                y1 += 100;
                x1 = 0;
            }
            btn[i].addActionListener(this);
        }
        
        JButton btn = new JButton("Reset");
        btn.setBounds(0,310,300,60);
        frame.add(btn);

        btn.addActionListener((ActionEvent ae)->{
            frame.dispose();
            new TTT();
        });
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        JButton b = (JButton) ae.getSource();

        if (count % 2 == 0) {
            b.setText("X");
            b.setForeground(Color.BLUE);
        } else {
            b.setText("O");
            b.setForeground(Color.red);
        }
        count++;
        b.removeActionListener(this);

        if (btn[0].getText().equals("X") && btn[1].getText().equals("X") && btn[2].getText().equals("X")
          || btn[0].getText().equals("X") && btn[3].getText().equals("X") && btn[6].getText().equals("X") 
          ||btn[0].getText().equals("X") && btn[4].getText().equals("X") && btn[8].getText().equals("X")
          ||btn[1].getText().equals("X") && btn[4].getText().equals("X") && btn[7].getText().equals("X")
          ||btn[2].getText().equals("X") && btn[5].getText().equals("X") && btn[8].getText().equals("X")      
          ||btn[2].getText().equals("X") && btn[4].getText().equals("X") && btn[6].getText().equals("X")
          ||btn[3].getText().equals("X") && btn[4].getText().equals("X") && btn[5].getText().equals("X")  
          ||btn[6].getText().equals("X") && btn[7].getText().equals("X") && btn[8].getText().equals("X")      ) 
          { 
                JOptionPane.showMessageDialog(null,player1 + " is Winner");
					System.exit(0);
          }
        
        if (btn[0].getText().equals("O") && btn[1].getText().equals("O") && btn[2].getText().equals("O")
          || btn[0].getText().equals("O") && btn[3].getText().equals("O") && btn[6].getText().equals("O") 
          ||btn[0].getText().equals("O") && btn[4].getText().equals("O") && btn[8].getText().equals("O")
          ||btn[1].getText().equals("O") && btn[4].getText().equals("O") && btn[7].getText().equals("O")
          ||btn[2].getText().equals("O") && btn[5].getText().equals("O") && btn[8].getText().equals("O")      
          ||btn[2].getText().equals("O") && btn[4].getText().equals("O") && btn[6].getText().equals("O")
          ||btn[3].getText().equals("O") && btn[4].getText().equals("O") && btn[5].getText().equals("O")    
          ||btn[6].getText().equals("O") && btn[7].getText().equals("O") && btn[8].getText().equals("O")      )
           {
                JOptionPane.showMessageDialog(null,player2 + " is Winner");   
					System.exit(0);
           }
       
    }
}

