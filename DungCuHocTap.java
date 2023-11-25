package SPham;

import java.util.Scanner;

public class DungCuHocTap extends SanPham {
    private String chucNang;
    private String maDungCu;
    private String loai;
    private String tenSP;
    private int soluongtonkho;
    private int dongia;
    Scanner sc= new Scanner (System.in);
    public DungCuHocTap(String NSX, String tenSP, double giaBan, double giaNhap, int soLuong, String chucNang,
            String maDungCu) {
        super(NSX, tenSP, giaBan, giaNhap, soLuong);
        this.chucNang = chucNang;
        this.maDungCu = maDungCu;
    }
    public DungCuHocTap(String maDungCu, String tenSP, int soluongtonkho, int dongia, String loai) {
        this.maDungCu = maDungCu;
        this.tenSP=tenSP;
        this.soluongtonkho = soluongtonkho;
        this.dongia = dongia;
        this.loai=loai;
    }
    public DungCuHocTap(String maDungCu, String tenSP, int soLuong, int giaBan, String giaNhap, String loai) {
        super(tenSP, soLuong, giaBan, giaNhap);
        this.maDungCu = maDungCu;
        this.loai = loai;
    }
    DungCuHocTap(SanPham sp, String string, int parseInt, String par1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void setSoLuongTonKho(int soluongtonkho) {
        this.soluongtonkho = soluongtonkho;
    }

    public void setDonGia(int dongia) {
        this.dongia = dongia;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getChucNang() {
        return chucNang;
    }
    public void setChucNang(String chucNang) {
        this.chucNang = chucNang;
    }
    
    public String getMaDungCu() {
        return maDungCu;
    }
    public void setMaDungCu(String maDungCu) {
        this.maDungCu = maDungCu;
    }
    public void input(){
        super.input();
        System.out.println("Nhap chuc nang:");
        chucNang = sc.nextLine();
        System.out.println("Nhap ma dung cu");
        maDungCu = sc.nextLine();
        boolean c = true;
        while (c == true) {
                System.out.println("Chon loai dung cu:");
                System.out.println("  1. Thuoc");
                System.out.println("  2. Viet");
                System.out.println("  3. Gom");
                System.out.println("Moi ban chon: ");
                int chon = sc.nextInt();
                switch (chon) {
                case 1: {
                    
                    System.out.println("Thuoc");
                    c = false;
                    
                    break;
                }
                case 2: {
                    
                    System.out.println("Viet");
                    c = false;
                    break;
                }
                case 3: {
                    
                    System.out.println("Gom");
                    c = false;
                    break;
                }
                default:{
                    System.out.println("Lua chon khong dung yeu cau ! Vui long chon lai");
                }
            }
        }
        }
        @Override
        public void output () {
                System.out.format("| %6s | %20s | %10s | %13s | %20s | %12s | %12s |%12s |\n", this.getNSX(),
                    this.getTenSP, this.getGiaBan(), this.getGiaNhap(),this.getSoLuong(),this.getChucNang(),this.getMaDungCu());
        }
        @Override
         public String toString() {
        return "DungCuHocTap [chucNang=" + chucNang + ", maDungCu=" + maDungCu + ", sc=" + sc + "]";
    }
    }

