package SPham;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class SanPham {
    private String NSX;
    private String tenSP;
    private double giaBan;
    private double giaNhap;
    private int soLuong;
    
    Scanner sc= new Scanner (System.in);

    public SanPham(String NSX, int soLuong, double giaBan, double giaNhap, String tenSP) {
        this( NSX, tenSP, giaBan, giaNhap, soLuong);
    }
    public SanPham( String tenSP, int soLuong, int giaBan, String giaNhap) {
    }

    public SanPham( String NSX, String tenSP, double giaBan, double giaNhap, int soLuong) {
    
        this.NSX = NSX;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.soLuong = soLuong;
    
    }
    public SanPham( String NSX, String tenSP, double giaBan, double giaNhap) {
    
        this.NSX = NSX;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
    
    }


    /**
     *
     */
    public SanPham() {
        
    }

 
    public String getNSX() {
        return NSX;
    }

    public void setNSX(String NSX) {
        while(NSX.length() < 2 || NSX.length() > 30 ){
         System.out.println("Nhap lai Nha san Xuat");
         NSX=sc.nextLine();
        }
        this.NSX = NSX;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        while(tenSP.length() < 2 || tenSP.length() > 30 ){
         System.out.println("Nhap lai Ten San Pham");
         tenSP=sc.nextLine();
        }
        this.tenSP = tenSP;
    }
     public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double Gia) {
        while( giaBan<0 || giaBan>1000000000){
            System.out.println("Nhap lai gia Ban cua San Pham");
            giaBan=sc.nextDouble();
        }
        this.giaBan = giaBan;
    }
    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double Gia) {
        while( giaNhap<0 || giaNhap>1000000000){
            System.out.println("Nhap lai gia Nhap cua San Pham");
            giaNhap=sc.nextDouble();
        }
        this.giaNhap = giaNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        while(soLuong<0){
         System.out.println("Nhap lai So Luong san pham");
         soLuong=Integer.parseInt(sc.nextLine());
        }
        this.soLuong = soLuong;
    }
    public void input(){
            System.out.println("Nhap NSX: ");
            this.NSX = this.sc.nextLine();
            System.out.println("Nhap ten San Pham: ");
            this.tenSP = this.sc.nextLine();
            System.out.println("Nhap gia Ban: ");
            this.giaBan = this.sc.nextDouble();
            System.out.println("Nhap gia Nhap: ");
            this.giaNhap = this.sc.nextDouble();
            System.out.println("Nhap so luong hang:");
            this.soLuong =this.sc.nextInt();
}
    public void output() {
       System.out.format("| %20s | %10s | %13s | %13s | %20s |\n", this.tenSP,
				this.NSX, this.giaBan, this.giaNhap, this.soLuong);
   }
   public String toString() {
      return  this.getTenSP() + "," + this.getNSX() + "," + this.getGiaBan() + "," + this.getGiaNhap() + "," + this.getSoLuong();
   } 
   

   
}