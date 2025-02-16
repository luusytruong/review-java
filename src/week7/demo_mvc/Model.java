package week7.demo_mvc;

import javax.swing.table.DefaultTableModel;

/**
 * @author ashraf
 *
 */
public class Model extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public Model() {
		super(Constants.DATA, Constants.TABLE_HEADER);
	}

}
