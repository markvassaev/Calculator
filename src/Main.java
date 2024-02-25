import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static JFrame frame;
    static JTextField result;
    public static void main(String[] args) {
        frame = new JFrame("Calculator");
        frame.add(result);
        ArrayList<JButton> btns = new ArrayList<>();
        for(int i = 0; i < 10 ; i++){
            JButton button = new JButton(Integer.toString(i));
            btns.add(button);
        }
        List<String> operations = Arrays.asList("+","-","/","*");
        JPanel buttons = new JPanel();
        btns.forEach(buttons::add);

        frame.setSize(360,200);
        frame.setVisible(true);
        result.setEditable(true);

    }
}
