package week7.movie;

import java.awt.event.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Controller extends KeyAdapter implements ActionListener, MouseListener {
    private Model model = new Model();
    private View view = View.getInstance();
    private MovieDAO dao = new MovieDAO();

    private List<Movie> movies = new ArrayList<>();

    private static Controller instance;

    private Controller() {
    }

    public synchronized static Controller getInstance() {
        // nếu thể hiện chưa được tạo, khởi tạo
        if (instance == null) {
            instance = new Controller();
        }
        // trả về thể hiện
        return instance;
    }

    public void init() {
        view.initComponents();
        showData();
        // view.setDataToField(movies.get(0));
    }

    public void showData() {
        movies = dao.getAll();
        view.render(model.getModel(movies));
    }

    public void insert(Movie movie) {
        if (dao.insert(movie)) {
            JOptionPane.showMessageDialog(view, "Them thanh cong", "Thong bao", 1);
        } else {
            JOptionPane.showMessageDialog(view, "Them that bai", "Thong bao", 0);
        }
    }

    public void update(Movie movie) {
        if (dao.update(movie)) {
            JOptionPane.showMessageDialog(view, "Sua thanh cong", "Thong bao", 1);
        } else {
            JOptionPane.showMessageDialog(view, "Sua that bai", "Thong bao", 0);
        }
    }

    public void delete(Movie movie) {
        int option = JOptionPane.showOptionDialog(
                view,
                "Khong the hoan tac",
                "Canh bao",
                JOptionPane.OK_CANCEL_OPTION,
                2,
                null,
                new Object[] { "Ok", "Thoat" },
                "Thoat");
        if (option != JOptionPane.OK_OPTION) {
            return;
        }
        if (dao.delete(movie.getId())) {
            JOptionPane.showMessageDialog(view, "Xoa thanh cong", "Thong bao", 1);
        } else {
            JOptionPane.showMessageDialog(view, "Xoa that bai", "Thong bao", 0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (!Character.isDigit(e.getKeyChar())) {
            e.consume();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Movie movie = view.getMovie();
        if (movie == null) {
            return;
        }
        if (e.getActionCommand() == "INSERT") {
            System.out.println("them");
            insert(movie);
        } else if (e.getActionCommand() == "UPDATE") {
            System.out.println("sua");
            update(movie);
        } else {
            System.out.println("xoa");
            delete(movie);
            view.setDataToField(new Object[] { "", "", "", "", "" });
        }
        showData();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int rowId = view.getRowClicked();
        view.setDataToField(new Object[] {
                movies.get(rowId).getId(),
                movies.get(rowId).getTitle(),
                movies.get(rowId).getDirector(),
                movies.get(rowId).getYear(),
                movies.get(rowId).getType(),
        });
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
