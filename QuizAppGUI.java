/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quizappgui;

/**
 *
 * @author USER
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizAppGUI extends JFrame implements ActionListener {
    private JLabel questionLabel;
    private JRadioButton[] options;
    private JButton nextButton;
    private ButtonGroup group;

    private String[] questions = {
        "What is the capital of France?",
        "Which programming language is used for Android development?",
        "Who wrote 'Romeo and Juliet'?"
    };

    private String[][] optionsData = {
        {"Berlin", "Madrid", "Paris", "Rome"},
        {"Python", "Java", "C++", "Ruby"},
        {"Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen"}
    };

    private int[] correctAnswers = {2, 1, 1}; // Index of correct answers
    private int currentQuestion = 0;
    private int score = 0;

    public QuizAppGUI() {
        // Frame setup
        setTitle("Quiz Application");
        setSize(500, 350);
        setLayout(new GridLayout(6, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Question label
        questionLabel = new JLabel();
        add(questionLabel);
        // Options (radio buttons)
        options = new JRadioButton[4];
        group = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            group.add(options[i]);
            add(options[i]);
        }
        // Next button
        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        add(nextButton);

        // Load first question
        loadQuestion();

        setVisible(true);
    }

    private void loadQuestion() {
        if (currentQuestion < questions.length) {
            questionLabel.setText("Q" + (currentQuestion + 1) + ": " + questions[currentQuestion]);
            for (int i = 0; i < 4; i++) {
                options[i].setText(optionsData[currentQuestion][i]);
                options[i].setSelected(false);
            }
        } else {
            // Show final score
            JOptionPane.showMessageDialog(this, "Quiz Over! Your Score: " + score + "/" + questions.length);
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check selected answer
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected() && i == correctAnswers[currentQuestion]) {
                score++;
            }
        }
        currentQuestion++;
        loadQuestion();
    }

    public static void main(String[] args) {
        new QuizAppGUI();
    }
}