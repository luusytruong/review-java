package week7.demo_mvc;

import javax.swing.table.DefaultTableModel;

/**
 * @author ashraf
 *
 */
public class Model extends DefaultTableModel {

	public Model() {
		super(Constants.DATA, Constants.TABLE_HEADER);
	}

}
