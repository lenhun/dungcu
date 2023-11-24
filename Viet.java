package SPham;

import java.util.Scanner;

public class Viet extends DungCuHocTap {
    private String mauSac;
    private String loaiViet;
    Scanner sc = new Scanner(System.in);
    public Viet(String NSX, String tenSP, double giaBan, double giaNhap, int soLuong, String chucNang,
    String maDungCu, String mauSac,String loaiViet) {
        super(NSX, tenSP, giaBan, giaNhap, soLuong,chucNang,maDungCu);
        this.mauSac = mauSac;
        this.loaiViet = loaiViet;
    }
    public Viet(DungCuHocTap dcht,String mauSac,String loaiViet){
        super(dcht.getSanPham(),dcht.getMaDungCu(),dcht.getNSX(),dcht.getGiaBan(),dcht.getTenSP());
        this.mauSac=mauSac;
        this.loaiVietc=loaiViet;
    }
    public String getMauSac() {
        return mauSac;
    }
    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
    public String getLoaiViet() {
        return loaiViet;
    }
    public void setLoaiViet(String loaiViet) {
        this.loaiViet = loaiViet;
    }
    @Override
    public void input(){
        super.input();
        System.out.println("Nhap mau sac cua viet:");
        mauSac=sc.nextLine();
        System.out.println("Nhap loai viet:");
        loaiViet=sc.nextLine();
    }
    @Override
    public void output(){
        System.out.format("| %6s | %13s | %12s | %14s | %13s | %20s  | %10s | %13s\n", this.getNSX(),this.getTenSP(),this.getGiaBan(),this.getGiaNhap(),
        this.getSoLuong(),this.getChucNang(),this.getMaDungCu(),this.getMauSac(),this.getLoaiViet());
    }
    @Override
    public String toString() {
        return "Viet [mauSac=" + mauSac + ", loaiViet=" + loaiViet + "]";
    }

    
}
