package week7.student;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class SinhVienTableModel extends AbstractTableModel {
private ArrayList<SinhVien> dsSinhVien=null;
private Object[][] data=null;
    public SinhVienTableModel(ArrayList<SinhVien> _dsSinhVien) {
        System.out.println("innit sinhvienmodel");
        dsSinhVien=_dsSinhVien;
        data=new Object[dsSinhVien.size()][];
       // for(SinhVien sv: dsSinhVien){
       for(int i=0;i<dsSinhVien.size();i++){
           SinhVien sv=dsSinhVien.get(i);
          Object[] row={sv.getId(),sv.getHoTen(),sv.getDiaChi(),sv.getTenLop(),sv.getNamSinh()};
               // row[0]={1,"To Nguyen","Thai Nguyen","K7G",1989} ;
          data[i]=row;           
        }
    }
    @Override
    public int getRowCount() {
        return data.length;
    }
    @Override
    //data={{01,"nguyen van A", "thai Nguyen", "ktpm k18a", "190"},{"02,"Nguyen Thi B", "thai binh","ktpmk18b","1998"},.....}
    public int getColumnCount() {
       return data[0].length;//số phần tử của dòng đầu tiên
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {   //1,1 ="Nguyen Thi B"  
      System.out.println("rowIndex: "+rowIndex+"  columnIndex"+columnIndex);
       return data[rowIndex][columnIndex];        
    }    
}
