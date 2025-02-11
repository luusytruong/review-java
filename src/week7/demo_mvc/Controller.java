package week7.demo_mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author ashraf
 *
 */
public class Controller implements ActionListener {

    private JTextField searchTermTextField = new JTextField(26);
    private DefaultTableModel model;

    public Controller(JTextField searchTermTextField, DefaultTableModel model) {
        super();
        this.searchTermTextField = searchTermTextField;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("clicked ====================");

        String searchTerm = searchTermTextField.getText();
        if (searchTerm != null && !"".equals(searchTerm)) {
            String[][] newData = new String[Constants.DATA.length][];
            int idx = 0;
            for (String[] row : Constants.DATA) {
                System.out.println(idx);
                if ("*".equals(searchTerm.trim())) {
                    newData[idx++] = row;
                } else {
                    if (row[0].contains(searchTerm.toUpperCase().trim())) {
                        newData[idx++] = row;
                    }
                }
            }
            model.setDataVector(newData, Constants.TABLE_HEADER);
        } else {
            JOptionPane.showMessageDialog(null, "Search term is empty", "Error", 0);
        }
    }

}