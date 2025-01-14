package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EventButton implements ActionListener {
    private JFrame frame;
    private JButton btnReg;
    private JTextField tfUsername, tfPassword, tfRepeatPassword;

    public EventButton(JFrame _frame, JButton _btnReg, JTextField _tfUsername, JTextField _tfPassword,
            JTextField _tfRepeatPassword) {
        this.frame = _frame;
        this.btnReg = _btnReg;
        this.tfUsername = _tfUsername;
        this.tfPassword = _tfPassword;
        this.tfRepeatPassword = _tfRepeatPassword;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnReg) {
            if (tfUsername.getText().isEmpty() || tfPassword.getText().isEmpty()
                    || tfRepeatPassword.getText().isEmpty()) {
                // JOptionPane.showMessageDialog(frame, "Thong bao, phai nhap tat ca cac
                // truong");
            }
        }
        System.out.println("khong duoc de trong cac");
    }

}
