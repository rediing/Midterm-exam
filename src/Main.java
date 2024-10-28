import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    JTextField result;
    int first = 0;
    int second = 0;
    int answer = 0;
    boolean f = true;
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

            if (cmd.matches("\\d")) {  // 숫자 버튼 클릭 처리
                int value = Integer.parseInt(cmd);
                if (f) {
                    first = value;
                } else {
                    second = value;
                }
                result.setText(cmd);
                f = !f;
            } else if (cmd.equals("=")) {  // = 버튼 클릭 시 계산
                answer = first + second;
                result.setText(String.valueOf(answer));
            }
        };
        for (String label : buttonLabels) {
            JButton button = createButton(label);
            button.addActionListener(listener);
            panel.add(button);
        }
        add(panel,BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        new Main();
    }
}