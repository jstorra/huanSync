package com.u2team.huansync.activity.trivia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TriviaGame {
    private JPanel panel1;
    private JButton button1;

    public TriviaGame() {
        // Configura la lógica de tu juego aquí
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica cuando se hace clic en el botón
                JOptionPane.showMessageDialog(null, "¡Hola, esto es un juego de trivia!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Trivia Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TriviaGame triviaGame = new TriviaGame();
        frame.setContentPane(triviaGame.panel1);

        frame.pack();
        frame.setVisible(true);
    }
}
