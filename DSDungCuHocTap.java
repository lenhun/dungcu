package SPham;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import SPham.DungCuHocTap;

public class DSDungCuHocTap{
    private static DungCuHocTap[] dungCu = new DungCuHocTap [0];
    private static int soLuong = 0;
    static Scanner sc = new Scanner(System.in);
    
    public static DungCuHocTap[] getDSDungCuHocTap() {
        return dungCu;
    }
    public static int getSoLuong() {
        return soLuong;
    }
    
public static void readFromFile(){
   try {
    FileReader fr = new FileReader("dsdcht.txt");
    BufferedReader br = new BufferedReader(fr);

    String line = "";
    while ((line = br.readLine()) != null) {
        String txt[] = line.split(",");
        SanPham sp = new SanPham(txt[0], txt[1], Double.parseDouble(txt[2]), Double.parseDouble(txt[3]),Integer.parseInt(text[4]));
        DungCuHocTap dcht = new DungCuHocTap(sp, txt[5], Integer.parseInt(txt[6]),txt[7]);

        if (txt[7].equals("thuoc")) {
            Thuoc thuoc = new Thuoc(dcht, txt[8], txt[9]);
            dungCu[soLuong] = thuoc;
        } else if(txt[7].equals("gom")){
            Gom gom = new Gom(dcht, txt[8],txt[9]);
            dungCu[soLuong] = gom;  
        }
        else{
            Viet viet = new Viet(dcht, txt[8], txt[9]);
            dungCu[soLuong] = viet;
        }
        soLuong++;
    }
    br.close();
    fr.close();

} catch (IOException e) {
    e.printStackTrace();
		}
    }
   
    public void ghiFile(){
        try {
            FileWriter fw= new FileWriter("dsdc.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0; i<soLuong; i++){
                String line= dungCu[i].getTenSP()+","+dungCu[i].getNSX()+","+
                             dungCu[i].getGiaBan()+","+
                             dungCu[i].getGiaNhap()+","+
                             dungCu[i].getMaDungCu()+","+dungCu[i].getChucNang();
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Xuất file thành công!");
            bw.close();
            fw.close();
        } catch (IOException e) {
        }
        
    }
    public void Them(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ma dung cu");
        String maDungCu = sc.nextLine();
        int pos = -1;
        do {
            int pos1 = 1;
            for(int i = 0 ; i < dungCu.length ; i++){
                pos1 = 1;
                    if(dungCu[i].getMaDungCu().equalsIgnoreCase(maDungCu))
                    {
                        System.out.println("Ma dung cu bi trung ! ");
                        System.out.println("Nhap lai ma dung cu : ");
                        maDungCu = sc.nextLine();
                        break;
                    }
                    pos1 = maDungCu.indexOf("DC");
                    if(pos1 != 0)
                    {
                        System.out.println("Bat buoc hai ki tu dau tien la : 'DC' ");
                        System.out.println("Nhap lai ma dung cu");
                        maDungCu = sc.nextLine();
                    }
                }
                for(int i = 0 ; i < dungCu.length ; i++)
                {
                    if((dungCu[i].getMaDungCu().equalsIgnoreCase(maDungCu)) || pos1 != 0)
                    {
                        pos = i;
                        break;
                    }
                    else{
                        pos = -1;
                    }
                }
            }while(pos != -1);
            System.out.println("Ten dung cu hoc tap");
            String tenSP = sc.nextLine();
            System.out.println("So Luong Ton Kho");
            int soluong = Integer.parseInt(sc.nextLine());
            System.out.println("gia ban");
            int giaBan = Integer.parseInt(sc.nextLine());
            System.out.println("gia nhap ");
            String giaNhap = sc.nextLine();
            dungCu = Arrays.copyOf(dungCu, dungCu.length+1);
            dungCu[dungCu.length-1] = new DungCuHocTap(maDungCu,tenSP,soLuong,giaBan,giaNhap);
        System.out.println("Them san pham thanh cong");    
    }
    public void sua() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma dung cu can sua thong tin:");
        String ma = sc.nextLine();
        int pos = -1;
        for (int i = 0; i < dungCu.length; i++) {
            if (dungCu[i].getMaDungCu().equalsIgnoreCase(ma)) {
              pos = i;
              break; 
        }
    }
    while (pos == -1) {
        System.out.println("Ma dung cu khong ton tai");
        System.out.println("Nhap lai ma dung cu:");
        ma = sc.nextLine();
        for (int i = 0; i < dungCu.length; i++) {
            if (dungCu[i].getMaDungCu().equalsIgnoreCase(ma)) {
                pos = i;
                break;
            }
        }
    }
    System.out.println("Ma dung cu");
    String madc = sc.nextLine();
    System.out.println("Ten dung cu ");
    String tendc = sc.nextLine();
    System.out.println("So Luong Ton Kho");
    int soluongtonkho = Integer.parseInt(sc.nextLine());
    System.out.println("Don Gia");
    int dongia = Integer.parseInt(sc.nextLine());
    System.out.println("Loai");
    String loai = sc.nextLine();
    dungCu[pos].setMaDungCu(madc);
    dungCu[pos].setTenSP(tendc);
    dungCu[pos].setSoLuongTonKho(soluongtonkho);
    dungCu[pos].setDonGia(dongia);
    dungCu[pos].setLoai(loai);

    System.out.println("Sua thanh cong");
}
   
    public void xoa() {
        Scanner sc = new Scanner(System.in);
        String ma;
        int pos=-1;
        int pos1 = -1;
        System.out.println("Nhap ma dung cu can xoa: ");
        ma = sc.nextLine();
        do{
            for(int i = 0 ; i  < dungCu.length;i++)
            {
                if(dungCu[i].getMaDungCu().equalsIgnoreCase(ma))
                {
                    pos = i;
                    pos1 = -1;
                }
                
            }
            if ( pos == -1)
            {
                System.out.println("Ma dung cu khong ton tai");
                System.out.println("Nhap lai ma dung cu");
                ma = sc.nextLine();
                pos1 = 1;
            }
            else{
                DungCuHocTap[] temp = Arrays.copyOf(dungCu, dungCu.length-1);
                for(int i = pos ; i < temp.length ; i++)
                {
                    temp[i] = dungCu[i+1];
                }
                dungCu = temp;
                System.out.println("Xoa thanh cong");
            }
        }while(pos1 != -1);
        
    }
    
    public void timkiem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("======Tim Kiem Dung Cu======");
        System.out.println("1.Tim kiem theo ma dung cu");
        System.out.println("2.Tim kiem theo ten san pham");
        System.out.println("============================");
        System.out.println("Lua chon");
        int option = Integer.parseInt(sc.nextLine());
        switch(option)
        {
            case 1:
            {
                String madc;
                System.out.println("Nhap ma dung cu can tim kiem: ");
                madc = sc.nextLine();
                System.out.printf("%-15s %-10s %-20s %15s %15s \n",
                       "Ma DC","Ten SP","SL ","Gia ban","Gia Nhap");
                for( int i = 0 ; i < dungCu.length ; i++)
                {
                    if(dungCu[i].getMaDungCu().toLowerCase().contains(madc.toLowerCase()))
                    {
                       System.out.printf("%-15s %-10s %-20s %15s %15s \n",
                       dungCu[i].getMaDungCu(),dungCu[i].getTenSP(),dungCu[i].getSoLuong(),dungCu[i].getGiaBan(),dungCu[i].getGiaNhap()); 
                    }
                }
                break;
            }
            case 2:
            {
                System.out.println("Nhap ten dung cu can tim kiem");
                String tensp = sc.nextLine();
                System.out.printf("%-15s %-10s %-20s %15s %15s \n",
                "Ma DC","Ten SP","SL Ton Kho","Don Gia","Loai");
                for( int i = 0 ; i < dungCu.length ; i++)
                {
                    if(dungCu[i].getTenSP().toLowerCase().contains(tensp.toLowerCase()))
                    {
        
                      
                       System.out.printf("%-15s %-10s %-20s %15s %15s \n",
                       dungCu[i].getMaDungCu(),dungCu[i].getTenSP(),dungCu[i].getSoLuong(),dungCu[i].getGiaBan(),dungCu[i].getGiaNhap());
                       break;
                    }
                }
                break;
            }

            }
        }
    }
        



