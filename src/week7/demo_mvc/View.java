package week7.demo_mvc;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author ashraf
 *
 */
public class View extends JFrame{

	private static final long serialVersionUID = 1L;

	public View() {
		// Create views swing UI components 
                super("Swing MVC Demo");
		JTextField searchTermTextField = new JTextField(26);
		JButton filterButton = new JButton("Filter");
		JTable table = new JTable();

		// Create table model
		Model model = new Model();
		table.setModel(model);

		// Create controller
		Controller controller = new Controller(searchTermTextField, model);
		filterButton.addActionListener(controller);

		// Set the view layout
		JPanel ctrlPane = new JPanel();
		ctrlPane.add(searchTermTextField);
		ctrlPane.add(filterButton);

		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension(700, 300));
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Market Movers",
				TitledBorder.CENTER, TitledBorder.TOP));

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
		splitPane.setDividerLocation(35);
		splitPane.setEnabled(false);

		// Display it all in a scrolling window and make the window appear
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(splitPane);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}