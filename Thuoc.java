package SPham;

import java.util.Scanner;

public class Thuoc extends DungCuHocTap{
    private String kichCo;
    private String loaiThuoc;
    Scanner sc = new Scanner(System.in);
    public Thuoc(String NSX, String tenSP, double giaBan, double giaNhap, int soLuong, String chucNang,
    String maDungCu,String kichCo, String loaiThuoc){
    super(NSX, tenSP, giaBan, giaNhap, soLuong,chucNang,maDungCu);
    this.kichCo=kichCo;
    this.loaiThuoc=loaiThuoc;
 }
     public Thuoc(DungCuHocTap dcht,String kichCo,String loaiThuoc){
    super(dcht.getSanPham(),dcht.getMaDungCu(),dcht.getNSX(),dcht.getGiaBan(),dcht.getTenSP());
    this.kichCo=kichCo;
    this.loaiThuoc=loaiThuoc;
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
        this.kichCo=sc.nextLine();
        System.out.println("Nhap loai thuoc");
        this.loaiThuoc=sc.nextLine();
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