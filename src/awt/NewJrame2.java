package awt;

import javax.swing.*;
import java.awt.*;

public class NewJrame2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fit Content Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo panel chính với BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Tạo panel phụ với FlowLayout để chứa JLabel và JTextField
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Hello, World!"));
        inputPanel.add(new JTextField(20));

        // Thêm panel phụ vào vị trí CENTER của panel chính
        mainPanel.add(inputPanel, BorderLayout.CENTER);

        // Tạo nút bấm và đặt ở phía dưới
        JButton button = new JButton("Click Me");
        mainPanel.add(button, BorderLayout.SOUTH);

        // Thêm panel chính vào frame
        frame.add(mainPanel);
        frame.pack(); // Tự động điều chỉnh kích thước phù hợp với nội dung
        frame.setLocationRelativeTo(null); // Căn giữa JFrame
        frame.setVisible(true);
    }
}

class ButtonFitContentExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fit Content Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sử dụng BorderLayout để nút chiếm toàn bộ chiều ngang
        frame.setLayout(new BorderLayout());

        JButton button = new JButton("Click me");
        frame.add(button, BorderLayout.NORTH);

        // Các thành phần khác nếu cần thiết
        // frame.add(new JLabel("Some other content"), BorderLayout.CENTER);

        // Tự động điều chỉnh kích thước frame phù hợp với nội dung
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class GridBagLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel label = new JLabel("Hello, World!");
        JTextField textField = new JTextField(20);
        JTextField textField2 = new JTextField(20);
        JButton button = new JButton("Click Me");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(textField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 6;
        panel.add(button, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        panel.add(textField2, gbc);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
