package SPham;

import java.util.Scanner;
import SPham.DungCuHocTap;

public class Thuoc extends DungCuHocTap{
    private String kichCo;
    private String loaiThuoc;
    Scanner sc = new Scanner(System.in);
    public Thuoc( int NSX, String maDungCu, String chucNang, String kichCo, String loaiThuoc) {
        super(NSX,maDungCu,chucNang);
        this.kichCo = kichCo;
        this.loaiThuoc = loaiThuoc;
    }
    public Thuoc(String NSX, String tenSP, double giaBan, double giaNhap, int soLuong, String chucNang,
    String maDungCu,String kichCo, String loaiThuoc){
    super(NSX, tenSP, giaBan, giaNhap, soLuong, chucNang, maDungCu);
    this.kichCo=kichCo;
    this.loaiThuoc=loaiThuoc;
 }
 public Thuoc(String maDungCu, String tenSP, String NSX, double giaBan, double giaNhap, int soLuong, String chucNang, String kichCo, String loaiThuoc) {
    super(NSX, tenSP, giaBan, giaNhap, soLuong, chucNang, maDungCu);
    this.kichCo = kichCo;
    this.loaiThuoc = loaiThuoc;
}
public Thuoc(DungCuHocTap dcht, String kichCo, String loaiThuoc) {
    super(dcht.getMaDungCu(), dcht.getTenSP(), dcht.getNSX(), dcht.getGiaBan(), dcht.getGiaNhap(), dcht.getSoLuong(), dcht.getChucNang());
    this.kichCo = kichCo;
    this.loaiThuoc = loaiThuoc;
}
   

    public String getLoaiThuoc(){
        return this.loaiThuoc;
    }
    public void setLoaiThuoc(String loaiThuoc){
        this.loaiThuoc=loaiThuoc;
    }
     public String getKichCo(){
        return kichCo;
    }
    public void setKichCo (String kichCo){
        this.kichCo=kichCo;
    }
    @Override
    public void input(){
        super.input();
        System.out.println("nhap kich co cua thuoc");
        kichCo=sc.nextLine();
        System.out.println("Nhap loai thuoc");
        loaiThuoc=sc.nextLine();
    }
    @Override
    public void output() {
        System.out.format("| %12s | %5s | %14s | %13s | %20s  | %10s | %13s \n", this.getNSX(),this.getTenSP(),this.getGiaBan(),this.getGiaNhap(),this.getSoLuong(),
        this.getChucNang(),this.getMaDungCu(),this.getKichCo(),this.getLoaiThuoc());
    }
    @Override
    public String toString() {
        return "Thuoc [kichCo=" + kichCo + ", loaiThuoc=" + loaiThuoc + "]";
    }
}