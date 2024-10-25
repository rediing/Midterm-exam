import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    JTextField result;
    int first = 0;
    int second = 0;
    int answer = 0;
    boolean f = true;

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

        ActionListener listener = e -> {
            if(e.getSource() == b1 ){
                if (f == true){
                    f= false;
                    result.setText(String.valueOf(7));
                    first = 7;
                }else{
                    f = true;
                    result.setText(String.valueOf(7));
                    second = 7;
                }
            }else if(e.getSource() == b2){
                if (f == true){
                    f= false;
                    result.setText(String.valueOf(8));
                    first = 8;
                }else{
                    f = true;
                    result.setText(String.valueOf(8));
                    second = 8;
                }
            }else if(e.getSource() == b3){
                if (f == true){
                    f= false;
                    result.setText(String.valueOf(9));
                    first = 9;
                }else{
                    f = true;
                    result.setText(String.valueOf(9));
                    second = 9;
                }
            }else if(e.getSource() == b4){
                if (f == true){
                    f= false;
                    result.setText(String.valueOf(4));
                    first = 4;
                }else{
                    f = true;
                    result.setText(String.valueOf(4));
                    second = 4;
                }
            }else if(e.getSource() == b5){
                if (f == true){
                    f= false;
                    result.setText(String.valueOf(5));
                    first = 5;
                }else{
                    f = true;
                    result.setText(String.valueOf(5));
                    second = 5;
                }
            }else if(e.getSource() == b6){
                if (f == true){
                    f= false;
                    result.setText(String.valueOf(6));
                    first = 6;
                }else{
                    f = true;
                    result.setText(String.valueOf(6));
                    second = 6;
                }
            }else if(e.getSource() == b7){
                if (f == true){
                    f= false;
                    result.setText(String.valueOf(1));
                    first = 1;
                }else{
                    f = true;
                    result.setText(String.valueOf(1));
                    second = 1;
                }
            }else if(e.getSource() == b8){
                if (f == true){
                    f= false;
                    result.setText(String.valueOf(2));
                    first = 2;
                }else{
                    f = true;
                    result.setText(String.valueOf(2));
                    second = 2;
                }
            }else if(e.getSource() == b9){
                if (f == true){
                    f= false;
                    result.setText(String.valueOf(3));
                    first = 3;
                }else{
                    f = true;
                    result.setText(String.valueOf(3));
                    second = 3;
                }
            }else if(e.getSource() == b11){
                if (f == true){
                    f= false;
                    result.setText(String.valueOf(0));
                    first = 0;
                }else{
                    f = true;
                    result.setText(String.valueOf(0));
                    second = 0;
                }
            }else if(e.getSource() == b13){
                answer = first + second;
                result.setText(String.valueOf(answer));
            }
        };
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);
        b6.addActionListener(listener);
        b7.addActionListener(listener);
        b8.addActionListener(listener);
        b9.addActionListener(listener);
        //b10.addActionListener(listener);
        b11.addActionListener(listener);
        //b12.addActionListener(listener);
        b13.addActionListener(listener);
    }
    public static void main(String[] args) {
        new Main();
    }
}