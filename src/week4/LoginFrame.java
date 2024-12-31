package week4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class NewJFrame extends JFrame implements ActionListener {
    private Button btnLogin, btnCancel;
    private TextField txtUsername, txtPassword;
    private JDialog dialog = new JDialog(this, true);
    private Label lbDialog = new Label();
    private GridBagConstraints gbc = new GridBagConstraints();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            lbDialog.setText("Button login clicked!");
            System.out.println(txtPassword.getText());
        } else {
            lbDialog.setText("Button cancel clicked!");
        }
        dialog.add(lbDialog);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        // dialog.setVisible(true);
    }

    public NewJFrame(String title) {
        super(title);
        initComponents();
    }

    public <T extends Component> void properties(int x, int y, int w, T com,
            Panel panel) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        panel.add(com, gbc);
    }

    public void initComponents() {
        // frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // layout panel
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // panel
        Panel panel = new Panel();
        panel.setLayout(new GridBagLayout());

        // child
        Label titleForm = new Label("Login");
        titleForm.setFont(new Font("", Font.PLAIN, 24));
        titleForm.setAlignment(Label.CENTER);
        gbc.gridx = 0;
        gbc.ipady = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 0, 12, 0);
        panel.add(titleForm, gbc);

        Label lbUsername = new Label("Username");
        txtUsername = new TextField(20);
        properties(0, 1, 1, lbUsername, panel);
        properties(1, 1, 2, txtUsername, panel);

        Label lbPassword = new Label("Password");
        txtPassword = new TextField(20);
        properties(0, 2, 1, lbPassword, panel);
        properties(1, 2, 2, txtPassword, panel);

        // panel button
        Panel panelButton = new Panel();
        panelButton.setLayout(new FlowLayout());
        panelButton.add(btnLogin = new Button("Login"));
        panelButton.add(btnCancel = new Button("Cancel"));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        panel.add(panelButton, gbc);

        // event
        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);

        // properties
        txtPassword.setEchoChar('•');

        // add
        int padding = 24;
        gbc.insets = new Insets(12, padding, 0, padding);
        add(panel, gbc);

        // dialog
        dialog.setTitle("Notification");
        dialog.setLayout(new FlowLayout());
        dialog.setSize(200, 100);

        // finally
        setSize(300, 188);
        setLocationRelativeTo(null);
        pack();
    }
}

public class LoginFrame {
    public static void main(String[] args) {
        new NewJFrame("Login Form").setVisible(true);
    }
}