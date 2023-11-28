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

public class DSDungCuHocTap implements CHUCNANG,DOCGHIFILE{
    private static final int MAX_DUNGCU = 100;
    private DungCuHocTap[] danhSachDungCu;
    private int soLuongDungCu;
    private Scanner sc = new Scanner(System.in);

    public DS_DungCuHocTap() {
        danhSachDungCu = new DungCuHocTap[MAX_DUNGCU];
        soLuongDungCu = 0;
    }
    public DSDungCuHocTap() {
    }

    @Override
    public void Them() {
        if (soLuongDungCu == danhSachDungCu.length) {
            danhSachDungCu = java.util.Arrays.copyOf(danhSachDungCu, danhSachDungCu.length * 2);
        }

        if (soLuongDungCu < MAX_DUNGCU) {
            System.out.println("Chon loai dung cu:");
            System.out.println("1. Thuoc");
            System.out.println("2. Viet");
            System.out.println("3. Gom");

            int choice = sc.nextInt();
            DungCuHocTap dungCuMoi = null;

            switch (choice) {
                case 1:
                    dungCuMoi = new Thuoc();
                    break;
                case 2:
                    dungCuMoi = new Viet();
                    break;
                case 3:
                    dungCuMoi = new Gom();
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
                    return;
            }
            dungCuMoi.input();
            danhSachDungCu[soLuongDungCu++] = dungCuMoi;
            System.out.println("Them dung cu thanh cong.");
        } else {
            System.out.println("Danh sach dung cu da day. Khong the them moi.");
        }
    }

    @Override
    public void Sua() {
        System.out.println("Nhap ma dung cu can sua: ");
        String maDungCu = sc.nextLine();
        for (DungCuHocTap dc : danhSachDungCu) {
            if (dc != null && dc.getMaDungCu().equals(maDungCu)) {
                dc.input();
                System.out.println("Sua dung cu thanh cong.");
                return;
            }
        }

        System.out.println("Khong tim thay dung cu co ma " + maDungCu);
    }
   
    
@Override
public void Xoa() {
    System.out.println("Nhap ma dung cu can xoa: ");
    String maDungCu = sc.nextLine();
    int index = -1;

    for (int i = 0; i < soLuongDungCu; i++) {
        DungCuHocTap dc = danhSachDungCu[i];
        if (dc != null && dc.getMaDungCu().equals(maDungCu)) {
            index = i;
            break;
        }
    }

    if (index != -1) {
        danhSachDungCu[index] = danhSachDungCu[soLuongDungCu - 1];
        danhSachDungCu[soLuongDungCu - 1] = null;
        soLuongDungCu--;
        System.out.println("Xoa dung cu thanh cong.");
    } else {
        System.out.println("Khong tim thay dung cu co ma " + maDungCu);
    }
}
    
    
@Override
public void timKiem() {
    System.out.println("Nhap ma hoac ten dung cu can tim: ");
    String key = sc.nextLine().toLowerCase();

    for (DungCuHocTap dc : danhSachDungCu) {
        if (dc != null && (dc.getMaDungCu().toLowerCase().contains(key) || dc.getTenSP().toLowerCase().contains(key))) {
            dc.output();
            System.out.println("--------------------");
        }
    }
}

    @Override
    public void readFromFile(String tenFlie) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void docFile(String tenFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            soLuongDungCu = Integer.parseInt(br.readLine());
            danhSachDungCu = new DungCuHocTap[soLuongDungCu];

            for (int i = 0; i < soLuongDungCu; i++) {
                String maDungCu = br.readLine().trim();
                String tenSP = br.readLine().trim();
                String NSX= br.readLine().trim();
                double giaBan= br.readLine().trim();
                double giaNhap= br.readLine().trim();
                int soLuong= br.readLine().trim();
                String loaiDungCu = br.readLine().trim();
                DungCuHocTap dc = null;
                if (loaiDungCu.equalsIgnoreCase("Thuoc")) {
                    Thuoc th = new Thuoc();
                    th.setKichCo(Integer.parseInt(br.readLine().trim()));
                    th.setLoaiThuoc(Integer.parseInt(br.readLine().trim()));
                   
                    dc = th;
                }
                else if (loaiDungCu.equalsIgnoreCase("Viet")) {
                    Viet viet = new Viet();
                    viet.setMauSac(Integer.parseInt(br.readLine().trim()));
                    viet.setLoaiViet(Integer.parseInt(br.readLine().trim()));
                    dc = viet;
                }
                else if (loaiDungCu.equalsIgnoreCase("Gom")) {
                    Gom gom = new Gom();
                    gom.setKichCo(Integer.parseInt(br.readLine().trim()));
                    gom.setLoaiGom(Integer.parseInt(br.readLine().trim()));
                    dc = gom;
                }
                if (dc != null) {
                    dc.setMaDungCu(maDungCu);
                    dc.setTenSP(tenSP);
                    dc.setNSX(NSX);
                    dc.setGiaBan(giaBan);
                    dc.setGiaNhap(giaNhap);
                    dc.setSoLuong(soLuong);
                    dc.setLoai(loaiDungCu);

                    danhSachDungCu[i] = dc;
                }
            }
            System.out.println("Đọc file thành công.");
        }
         catch (IOException | ParseException | NumberFormatException e) {
            System.out.println("Loi khi đọc file: " + e.getMessage());
        }
    }
    @Override
    public void ghiFile(String tenFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            bw.write(Integer.toString(soLuongDungCu));
            bw.newLine();
            for (int i = 0; i < soLuongDungCu; i++) {
                DungCuHocTap dc = danhSachDungCu[i];
                if (dc != null) {
                   
                    bw.write(dc.getMaDungCu() + "\n");
                    bw.write(dc.getTenSP() + "\n");
                    bw.write(dc.getNSX() + "\n");
                    bw.write(dc.getGiaBan() + "\n");
                    bw.write(dc.getGiaNhap() + "\n");
                    bw.write(dc.getSoLuong() + "\n");
                    bw.write(dc.getLoaiDungCu() + "\n");

                    // Ghi dòng trống để phân biệt giữa các đối tượng
                    bw.newLine();
                    if (dc instanceof Thuoc) {
                        Thuoc thc = (Thuoc) dc;
                        bw.write(String.valueOf(thc.getKichCo()) + "\n");
                        bw.write(String.valueOf(thc.getLoaiThuoc()) + "\n");   
                    }
                    if (dc instanceof Viet) {
                        Viet vt = (Viet) dc;
                        bw.write(String.valueOf(vt.getMauSac()) + "\n");
                        bw.write(String.valueOf(vt.getLoaiViet()) + "\n");
                    }
                    
                    if (dc instanceof Gom) {
                        Gom gm = (Gom) dc;
                        bw.write(String.valueOf(gm.getKichCo()) + "\n");
                        bw.write(String.valueOf(gm.getLoaiGom()) + "\n");
                    }
                }
            }
            System.out.println("Ghi file thành công.");
        } catch (IOException  | NumberFormatException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}



        
        



