import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JButton loginButton;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JPanel rootPanel;

    public Login(){
        add(rootPanel);
        setTitle("Login");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPanel, "Chưa nhập thông tin");
            }
        });
    }
}
