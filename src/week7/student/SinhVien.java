package week7.student;

public class SinhVien {
    private int id;
    private String name, diaChi, tenLop, namSinh;
    public SinhVien(String hoTen, String diaChi, String tenLop, String namSinh) {
        this.name = hoTen;
        this.diaChi = diaChi;
        this.tenLop = tenLop;
        this.namSinh = namSinh;
    }

    public SinhVien() {
    }

    public SinhVien(int id, String hoTen, String diaChi, String tenLop, String namSinh) {
        this.id = id;
        this.name = hoTen;
        this.diaChi = diaChi;
        this.tenLop = tenLop;
        this.namSinh = namSinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return name;
    }

    public void setHoTen(String hoTen) {
        this.name = hoTen;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTenLop() {
        return tenLop;
    }
    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getNamSinh() {
        return namSinh;
    }
    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }
    @Override
    public String toString() {
        return "{" + "id=" + id + ", hoTen=" + name + ", diaChi=" + diaChi + ", tenLop=" + tenLop + ", namSinh=" + namSinh + '}';
    }

}
