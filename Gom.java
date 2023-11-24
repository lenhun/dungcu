package SPham;

import java.util.Scanner;

public class Gom extends DungCuHocTap{

    private String loaiGom;
    private String kichCo;
    Scanner sc = new Scanner(System.in);
    public Gom(String NSX, String tenSP, double giaBan, double giaNhap, int soLuong, String chucNang,
    String maDungCu, String loaiGom,String kichCo) {
        super(NSX, tenSP, giaBan, giaNhap, soLuong,chucNang,maDungCu);
        this.loaiGom = loaiGom;
        this.kichCo = kichCo;
    }
    public Gom(DungCuHocTap dcht,String kichCo,String loaiGom){
        super(dcht.getSanPham(),dcht.getMaDungCu(),dcht.getNSX(),dcht.getGiaBan(),dcht.getTenSP());
        this.kichCo=kichCo;
        this.loaiGom=loaiGom;
    }
    public String getLoaiGom() {
        return loaiGom;
    }
    public void setLoaiGom(String loaiGom) {
        this.loaiGom = loaiGom;
    }
    public String getKichCo() {
        return kichCo;
    }
    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }
    @Override
    public void input(){
        super.input();
        System.out.println("Nhap loai gom:");
        loaiGom=sc.nextLine();
        System.out.println("Nhap kich co cua gom:");
        kichCo=sc.nextLine();
    }
    @Override
    public void output(){
        System.out.format("| %6s | %13s | %12s| 10%s | 10%s | 12%s| 15%s \n", this.getNSX(),this.getTenSP(),this.getGiaBan(),this.getGiaNhap(),
        this.getSoLuong(),this.getChucNang(),this.getMaDungCu(),this.getLoaiGom(),this.getKichCo());
    }
    @Override
    public String toString() {
        return "Gom [loaiGom=" + loaiGom + ", kichCo=" + kichCo + "]";
    }
    
}
