package SPham;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

import SPham.DungCuHocTap;
import SPham.Gom;
import SPham.Viet;
import SPham.Thuoc;

public class DSDungCuHocTap implements CHUCNANG, DOCGHIFILE{
    private static DungCuHocTap[] dsdcht = new DungCuHocTap[200];
    private static int soLuong = 0;
    static Scanner sc = new Scanner(System.in);

  public DSDungCuHocTap() {
    }
  public static DungCuHocTap[] getDSDungCuHocTap() {
        return dsdcht;
    }

   public static int getSoLuong() {
        return soLuong;
    }
    @Override
    public void readFromFile(String outputtxt) {
     try {
         FileReader fr = new FileReader("dungcu.txt");
         BufferedReader br = new BufferedReader(fr);
 
         String line = "";
         while ((line = br.readLine()) != null) {
             System.out.println(line); // In ra nội dung của dòng
             try {
                 String txt[] = line.split(", ");
                 if (txt.length >= 10) { // Kiểm tra xem có đủ giá trị trong mảng không
                                              //NSX, TENSP, GIABAN, GIANHAP
                     SanPham sp = new SanPham(txt[0], txt[1], Double.parseDouble(txt[2]), Double.parseDouble(txt[3]));
                                              //CHỨC NĂNG, MÃ DỤNG CỤ, LOẠI DỤNG CỤ
                     DungCuHocTap dc = new DungCuHocTap(sp, txt[4], txt[5],txt[6]);
 
                     if (txt[6].equals("thuoc")) {
                                                //kích cỡ, loại thước
                         Thuoc thuoc = new Thuoc(dc, txt[8], txt[9]);
                         dsdcht[soLuong] = thuoc;
                     } else if(txt[6].equals("viet")){
                         Viet viet = new Viet(dc, txt[8], txt[9]);
                         dsdcht[soLuong] = viet;  
                     }
                      else if(txt[6].equals("gom")){
                         Gom gom = new Gom(dc, txt[8], txt[9]);
                         dsdcht[soLuong] = gom;  
                     }
                     soLuong++;
                 }
             } catch (Exception e) {
                 System.out.println("Lỗi khi xử lý dòng: " + line);
                 e.printStackTrace();
             }
         }
         br.close();
         fr.close();
         System.out.println("Đọc file thành công!");
 
     } catch (IOException e) {
         System.out.println("Đọc file thất bại!");
         e.printStackTrace();
     }
 }
 @Override
 public void writeToFile(String outputtxt) {
     try {
         FileWriter fw = new FileWriter("dungcu.txt",true);
         BufferedWriter bw = new BufferedWriter(fw);
         
         for (int i = 0; i < soLuong; i++) {
             DungCuHocTap dc = dsdcht[i];
             String line = dc.getTenSP() + "," + dc.getNSX() + "," + dc.getGiaBan() + "," + dc.getGiaNhap() + "," + dc.getMaDungCu() +  "," + dc.getLoaiDungCu();
             
             if (dc instanceof Thuoc) {
                 Thuoc thuoc = (Thuoc) dc;
                 line += ",thuoc," + thuoc.getKichCo() + "," + thuoc.getLoaiThuoc();
             } else if(dc instanceof Viet){
                 Viet viet = (Viet) dc;
                 line += ",viet," + viet.getMauSac() + "," + viet.getLoaiViet();
             }
               else if(dc instanceof Gom){
                 Gom gom = (Gom) dc;
                 line += ",gom," + gom.getKichCo() + "," + gom.getLoaiGom();
             }
             
             bw.write(line);
             bw.newLine();
         }
         
         bw.close();
         fw.close();
         
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
 @Override
    public void Them() {
        if (soLuong == dsdcht.length) {
            dsdcht = java.util.Arrays.copyOf(dsdcht, dsdcht.length * 2);
        }

        System.out.println("Chon Loai Dung Cu:");
        System.out.println("1. Thuoc");
        System.out.println("2. Viet");
        System.out.println("3. Gom");
        int choice = sc.nextInt();

        DungCuHocTap dc1;
        switch (choice) {
            case 1:
                dc1 = new Thuoc();
                break;
            case 2:
                dc1 = new Viet();
                break;
            case 3:
                dc1 = new Gom();
                break;
            default:
                System.out.println("Lua chon khong hop le.");
                return; 
        }

        if (dc1 != null) {
           
            dc1.input();
            dsdcht[soLuong] = dc1;
            soLuong++;
            System.out.println("Them dung cu thanh cong.");
        }
    }
    @Override
    public void Sua() {
        System.out.println("Nhap ma dung cu can sua: ");
        String maDungCu = sc.nextLine();
        for (DungCuHocTap dc2 : dsdcht) {
            if (dc2 != null &&dc2.getMaDungCu().equals(maDungCu)) {
                dc2.input();
                System.out.println("Sua dung cu thanh cong.");
                return;
            }
        }

        System.out.println("Khong tim thay dung cu co ma " + maDungCu);
    }
    @Override
    public void Xoa(){
        System.out.println("Nhap vao ma dung cu can xoa: ");
        String maDungCucanxoa=sc.nextLine();
      
        int index=-1;
        
        for (int i=0; i<soLuong; i++){
            DungCuHocTap DC5 = dsdcht[i];
            if (DC5.getMaDungCu().equals(maDungCucanxoa)){
                index=i;
            } else {
            }
        }
        if (index==-1)
            System.out.println("Không tồn tại ma dung cu");
        else {
            dsdcht[index]=dsdcht[soLuong-1];
            dsdcht[soLuong-1]=null;
            soLuong--;
            System.out.println("Đã xóa dung cu co ma dung cu la: "+maDungCucanxoa);
        }
    }
    @Override
    public void timKiem(){
        System.out.println("Tìm kiếm dung cu theo: ");
        System.out.println("1.ma dung cu");
        System.out.println("2.Ten San Pham");
        System.out.println("3.Khoang Gia Ban");
         System.out.println("4.Loai dung cu");
        System.out.println("0.Thoát");
        int luaChon=-1;
          System.out.println("Vui lòng nhập vào lựa chọn: ");
          luaChon= sc.nextInt();
            sc.nextLine();
        while (luaChon>=0){

           readFromFile("dungcu.txt");
            switch(luaChon){
                case 1:
                    while(true){
                        System.out.println("Nhap vao ma dung cu: ");
                        String ID=sc.nextLine();
                        
                        DungCuHocTap dc[]=this.getDSDungCuHocTap();
                        boolean check=false;
                        for (int i=0; i<soLuong; i++){
                            if (dc[i].getMaDungCu().equals(ID)){
                                check=true;
                                break;
                            }


                        }
                        if (check==true){
                            for (int i=0; i<soLuong; i++){
                                if (dc[i].getMaDungCu().equals(ID))
                                    dc[i].output();
                                    System.out.println("--------------------");
                            }
                            break;
                        }
                        else
                            System.out.println("Ma dung cu không tồn tại.Vui lòng nhập lại.");
                        }
                    
                    break;
                    
                case 2:{
                   while (true) {
					System.out.println("Nhap ten san pham: ");
					String tenDungCu = sc.nextLine().toUpperCase();
					DungCuHocTap DC1[] = DSDungCuHocTap.getDSDungCuHocTap();
					boolean check = false;
					for (int i = 0; i < DSDungCuHocTap.getSoLuong();i++) {
						if (DC1[i].getTenSP().toUpperCase().compareTo(tenDungCu) == 0) {
							check = true;
							break;
						}
					}
					if (check == true) {
						for (int i = 0; i < soLuong; i++) {
							if (DC1[i].getTenSP().toUpperCase().equals(tenDungCu) == true) {
                                                            DC1[i].output();
                                                            System.out.println("--------------------");
								
						}
						break;
					}} else {
						System.out.println("Ten dung cu khong ton tai!! Vui long nhap lai");
					}
				break;}
                }
                                
                case 3:{
                    while (true) {
					System.out.println("Nhap gia tien thap nhat: ");
					  double giaThapNhat=sc.nextDouble();
                    System.out.println("Nhap gia tien cao nhat: ");
					  double giaCaoNhat=sc.nextDouble();
					DungCuHocTap DC2[] = DSDungCuHocTap.getDSDungCuHocTap();
					boolean check = false;
					for (int i = 0; i < DSDungCuHocTap.getSoLuong();i++) {
						if (DC2[i].getGiaBan()>giaThapNhat && DC2[i].getGiaBan()<giaCaoNhat ){
							check = true;
							break;
						}
					}
					if (check == true) {
						for (int i = 0; i < soLuong; i++) {
							if (DC2[i].getGiaBan()>giaThapNhat && DC2[i].getGiaBan()<giaCaoNhat) {
                                 DC2[i].output();
                                 System.out.println("--------------------");
								
						}
						break;
					}} else {
						System.out.println("Ten dung cu khong ton tai!! Vui long nhap lai");
					}
				break;
                }
                }
                case 4:{
        System.out.println("Chon loai dung cu can tim:");
        System.out.println("1. Thuoc ");
        System.out.println("2. Viet");
        System.out.println("3. Gom");
        int choice = sc.nextInt();

        DungCuHocTap DC3[]=this.getDSDungCuHocTap();
        
        switch (choice) {
            case 1:{
                boolean check = false;
                      for (int i=0; i< DSDungCuHocTap.getSoLuong(); i++){
                            if (DC3[i].getLoaiDungCu().equals("Thuoc")){
                                check=true;
                                break;
                            }
                        }
                if (check == true) {
                     for (int i=0; i< DSDungCuHocTap.getSoLuong(); i++){
                                if (DC3[i].getLoaiDungCu().equals("Thuoc")){
                                          DC3[i].output();
                                          System.out.println("--------------------");     
                                  }
                            }
                    }
                     
                    }
                     break;
            
            case 2:{
                      boolean check = false;
                      for (int i=0; i<DSDungCuHocTap.getSoLuong(); i++){
                            if (DC3[i].getLoaiDungCu().equals("Viet")){
                                check=true;
                                break;
                            }
                        }
                   if (check == true) {
                     for (int i=0; i< DSDungCuHocTap.getSoLuong(); i++){
                                if (DC3[i].getLoaiDungCu().equals("Viet")){
                                          DC3[i].output();
                                          System.out.println("--------------------");     
                                  }
                     }
                   }
                     break;    

            }
            case 3:{
                      boolean check = false;
                      for (int i=0; i<DSDungCuHocTap.getSoLuong(); i++){
                            if (DC3[i].getLoaiDungCu().equals("Gom")){
                                check=true;
                                break;
                            }
                        }
                   if (check == true) {
                     for (int i=0; i< DSDungCuHocTap.getSoLuong(); i++){
                                if (DC3[i].getLoaiDungCu().equals("Gom")){
                                          DC3[i].output();
                                          System.out.println("--------------------");     
                                  }
                     }
                   }
                     break;    

            }
            default:{
                System.out.println("Lua chon khong hop le.");
                return;
        }
        }
                }
            }
        }
    }
    @Override
        public void hienThiDanhSach() {
           for (DungCuHocTap DC4 : dsdcht) {
           if (DC4 != null) { 
               DC4.output();
               System.out.println("--------------------");
           }
       }
   }
   @Override
         public void printFileContents(String filename) {
    try {
        FileReader fr = new FileReader("dungcu.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
        fr.close();

    } catch (IOException e) {
        System.out.println("Không thể đọc file!");
        e.printStackTrace();
    }
}
}
       


        
        



