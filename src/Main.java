import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Event implements ActionListener {
    static int count = 0;
    private int a;
    private int b;

    static int k = -1;
    static String operation = null;
    boolean canParseToInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception ochko) {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand().toString();
        if (canParseToInt(command)) {
            k = k + 1;
            if (k % 2 == 0){
                a = Integer.parseInt(command);
                Main.text = String.valueOf(a);
                Main.textField.setText(Main.text);

            }
            else if (k % 2 != 0){
                b = Integer.parseInt(command);
                if (operation == null){
                    Main.text = "Пустая операция";

                }
                else{
                    if (operation.equals("+")){
                        Main.text = String.valueOf((a + b));
                        Main.textField.setText(Main.text);
                    }
                    if (operation.equals("-")){
                        Main.text = String.valueOf((a - b));
                        Main.textField.setText(Main.text);
                    }
                    if (operation.equals("*")){
                        Main.text = String.valueOf((a * b));
                        Main.textField.setText(Main.text);
                    }
                    if (operation.equals("/")){
                        Main.text = String.valueOf((a / b));
                        Main.textField.setText(Main.text);
                    }

                }
                operation = null;
            }
        }
        else{
            operation = command;
            Main.text = Main.text + command;
            Main.textField.setText(Main.text);
        }

    }
}

public class Main {
    static JFrame frame;
    static Event event = new Event();
    static String text = "";
    static TextField textField = new TextField();

    public static void main(String[] args) {
        frame = new JFrame("Calculator");
        ArrayList<JButton> btns = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(Integer.toString(i));
            button.addActionListener(event);
            btns.add(button);
        }
        List<String> operations = Arrays.asList("+", "-", "/", "*", "=");
        for (String operation : operations) {
            JButton button = new JButton(operation);
            button.addActionListener(event);
            btns.add(button);
        }
        JPanel buttons = new JPanel();
        btns.forEach(buttons::add);
        JPanel mainPanel = new JPanel();
        textField.setPreferredSize(new Dimension(50, 20));
        textField.setEditable(true);
        mainPanel.add(textField);
        mainPanel.add(buttons);
        frame.add(mainPanel);
        GridLayout gridLayout = new GridLayout(3, 4);
        buttons.setLayout(gridLayout);
        frame.setSize(360, 200);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}