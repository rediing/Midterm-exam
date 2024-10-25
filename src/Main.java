import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    JTextField result;
    Dimension dim = new Dimension(70,70);
    Main(){
        setTitle("계산기");
        setLayout(new BorderLayout());
        North();
        Center();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,500);
        setVisible(true);
    }
    public void North(){
        JPanel panel = new JPanel();
        result = new JTextField(27);
        panel.add(result);
        add(panel,BorderLayout.NORTH);
    }
    public void Center(){
        JPanel panel = new JPanel();
        JButton b1 = new JButton("7");
        JButton b2 = new JButton("8");
        JButton b3 = new JButton("9");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("1");
        JButton b8 = new JButton("2");
        JButton b9 = new JButton("3");
        JButton b10 = new JButton("+/-");
        JButton b11 = new JButton("0");
        JButton b12 = new JButton(".");
        JButton b13 = new JButton("=");
        b1.setPreferredSize(dim);
        b2.setPreferredSize(dim);
        b3.setPreferredSize(dim);
        b4.setPreferredSize(dim);
        b5.setPreferredSize(dim);
        b6.setPreferredSize(dim);
        b7.setPreferredSize(dim);
        b8.setPreferredSize(dim);
        b9.setPreferredSize(dim);
        b10.setPreferredSize(dim);
        b11.setPreferredSize(dim);
        b12.setPreferredSize(dim);
        b13.setPreferredSize(dim);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(b10);
        panel.add(b11);
        panel.add(b12);
        panel.add(b13);
        add(panel,BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        new Main();
    }
}