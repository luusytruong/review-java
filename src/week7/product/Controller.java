package week7.product;

import java.awt.event.*;
import java.util.ArrayList;

public class Controller implements ActionListener, MouseListener {
    private Model model = new Model();
    private View view = new View();
    private ProductDAO dao = new ProductDAO();
    private ArrayList<Product> products = new ArrayList<>();
    public static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void init() {
        view.initComponents();
        loadData();
        handleClick(0);
    }

    public void loadData() {
        products = dao.getAll();
        view.render(model.getModel(products));
    }

    public void hanldeAdd(Product obj) {
        dao.insert(obj);
        loadData();
    }

    public void handleUpdate(Product obj) {
        dao.update(obj);
        loadData();
    }

    public void handleDelete(int id) {
        dao.delete(id);
        loadData();
    }

    public void handleClick(int i) {
        Object[] obj = new Object[] {
                products.get(i).getId(),
                products.get(i).getName(),
                products.get(i).getPrice(),
                products.get(i).getStock()
        };
        view.setDataToField(obj);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "UPDATE":
                System.out.println("UPDATE");
                handleUpdate(view.getObj());
                break;
            case "DELETE":
                System.out.println("DELETE");
                handleDelete(view.getObj().getId());
                view.clearDataFromField();
                break;
            default:
                System.out.println("ADD");
                hanldeAdd(view.getObj());
                break;
        }
    }

    public void print(Product obj) {
        System.out.println(obj);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        handleClick(view.getSelectedRow());
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