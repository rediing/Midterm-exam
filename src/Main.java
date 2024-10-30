import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Main extends JFrame {
    //결과창
    JTextField result;
    //첫번째 숫자
    double first = 0;
    //두번째 숫자
    double second = 0;
    //계산 결과
    double answer = 0;
    //사칙연산 부호
    String oper;
    //현재 입력된 숫자를 변경하는 부호
    String setCurrentText;
    //새로운 숫자를 받을지 결정하는 변수
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
    /**
     * 버튼을 생성하는 헬퍼 메서드입니다.
     *
     * @param label 버튼의 레이블
     * @return 생성된 JButton
     */
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

    /**
     * @see <a href="https://chatgpt.com/share/6721ec55-bc0c-8013-9bbf-a3bb5c7e26c3">...</a>
     * ChatGPT 사용한 부분
     * switch문을 이용한 코드 간소화
     */
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
                if (startNumber) {
                    result.setText(cmd);
                    startNumber = false;
                } else {
                    result.setText(result.getText() + cmd);
                }
            } else if ("+-×÷".contains(cmd)) {
                if (isValidNumber(result.getText())) {
                    first = Double.parseDouble(result.getText());
                }
                oper = cmd;
                startNumber = true;
            }else if(cmd.equals("%+/-")){
                setCurrentText = cmd;
                modify();
                startNumber = true;
            }else if(cmd.equals("+/-")){
                setCurrentText = cmd;
                modify();
                startNumber = true;
            }else if(cmd.equals("=")){
                if (isValidNumber(result.getText())) {
                    second = Double.parseDouble(result.getText());
                    calculate();
                    startNumber = true;
                }
            }else if(cmd.equals("C")){
                first = 0;
                second = 0;
                result.setText("");
                startNumber = true;
                setCurrentText = "";
                oper = "";
            }else if(cmd.equals("CE")){
                result.setText("");
            }else if (cmd.equals("←")){
                result.setText(result.getText().substring(0, result.getText().length() -1));
            }
        };
        for (String label : buttonLabels) {
            JButton button = createButton(label);
            button.addActionListener(listener);
            panel.add(button);
        }
        add(panel,BorderLayout.CENTER);
    }

    /**
     * 계산을 수행하는 메서드입니다.
     * @see <a href="https://chatgpt.com/share/6721ebcc-76b8-8013-915a-cc993d00cf2b">...</a>
     * ChatGPT 사용한 부분
     * 두 자릿수 이상의 숫자 입력 처리
     * 소수점 처리
     * 부호변경 예외처리
     */
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
                answer = first / second;
            }
        }
        result.setText(String.valueOf(answer));
    }

    /**
     * 입력받은 숫자를 백분율, 부호, 소수점으로 변경하는 메소드입니다.
     */
    void modify(){
        switch(setCurrentText){
            case "%" -> {
                second = first * (Double.parseDouble(result.getText())/100);
                result.setText(String.valueOf(second));
            }
            case "+/-" ->{
                try {
                    result.setText(String.valueOf(Double.parseDouble(result.getText()) * -1));
                } catch (NumberFormatException e) {
                    result.setText("0");
                }
            }
            case "." ->{
                if (startNumber){
                    result.setText("0.");
                    startNumber = false;
                }else if (!result.getText().contains(".")){
                    result.setText(result.getText()+".");
                }
            }
        }
    }

    private boolean isValidNumber(String text) {
        // null, 빈 문자열, 여러 개의 소수점 포함 여부 검사
        return text != null
                && !text.isEmpty()
                && text.chars().filter(ch -> ch == '.').count() <= 1;
    }

    public static void main(String[] args) {
        new Main();
    }
}