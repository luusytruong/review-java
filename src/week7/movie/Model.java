package week7.movie;

import java.util.*;

import javax.swing.table.DefaultTableModel;

public class Model {
    public DefaultTableModel getModel(List<Movie> movies) {
        Object[] columnName = { "Ma phim", "Ten phim", "Dao dien", "Phat hanh", "The loai" };
        Object[][] data = new Object[movies.size()][columnName.length];

        for (int i = 0; i < movies.size(); i++) {
            data[i][0] = movies.get(i).getId();
            data[i][1] = movies.get(i).getTitle();
            data[i][2] = movies.get(i).getDirector();
            data[i][3] = movies.get(i).getYear();
            data[i][4] = movies.get(i).getType();
        }

        return new DefaultTableModel(data, columnName);
    }
}
