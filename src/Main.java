import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    JTextField result;
    double first = 0;
    double second = 0;
    double answer = 0;
    String oper;
    boolean startNumber = true;
    Font font = new Font("Arial", Font.PLAIN, 40);
    Font buttonFont = new Font("Arial", Font.PLAIN, 15);

    Dimension dim = new Dimension(70,60);
    Main(){
        setTitle("계산기");
        setLayout(new BorderLayout());
        North();
        Center();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(330,500);
        setVisible(true);
    }
    JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setFont(buttonFont);
        button.setPreferredSize(dim);
        return button;
    }
    public void North(){
        JPanel panel = new JPanel();
        result = new JTextField(9);
        result.setFont(font);
        result.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(result);
        add(panel,BorderLayout.NORTH);
    }
    public void Center(){
        String[] buttonLabels = {
                "%", "CE", "C", "←", "1/x", "x²", "√x", "÷",
                "7", "8", "9", "×", "4", "5", "6", "-",
                "1", "2", "3", "+", "+/-", "0", ".", "="
        };
        JPanel panel = new JPanel();
        ActionListener listener = e -> {
            String cmd = e.getActionCommand();

            if (cmd.matches("\\d|\\.")) {
                int value = Integer.parseInt(cmd);
                if (startNumber) {
                    result.setText(cmd);
                    startNumber = false;
                } else {
                    result.setText(result.getText() + cmd);
                }
            } else if ("+-×÷".contains(cmd)) {
                first = Double.parseDouble(result.getText());
                oper = cmd;
                startNumber = true;
            }
            else if(cmd.equals("=")){
                second = Double.parseDouble(result.getText());
                calculate();
                startNumber = true;
            }
        };
        for (String label : buttonLabels) {
            JButton button = createButton(label);
            button.addActionListener(listener);
            panel.add(button);
        }
        add(panel,BorderLayout.CENTER);
    }

    void calculate(){
        switch (oper){
            case "+" -> answer = first + second;
            case "-" -> answer = first - second;
            case "×" -> answer = first * second;
            case "÷" -> {
                if (second == 0){
                    result.setText("ERROR");
                    return;
                }
                answer = first / answer;
            }
        }
        result.setText(String.valueOf(answer));
    }
    public static void main(String[] args) {
        new Main();
    }
}