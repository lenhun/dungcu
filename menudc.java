package SPham;

import java.util.Scanner;

public class MenuDungCuHocTap {
    private DSDungCuHocTap dsDungCu;
    private Scanner scanner;

    public MenuDungCuHocTap() {
        dsDungCu = new DSDungCuHocTap();
        scanner = new Scanner(System.in);
    }

    public void run() {
        dsDungCu.docFile("output_dungcu.txt");

        int luaChon;
        do {
            hienThiMenu();
            System.out.print("Nhap lua chon cua ban: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); 

            switch (luaChon) {
                case 1:
                    dsDungCu.Them();
                    break;
                case 2:
                    dsDungCu.Xoa();
                    break;
                case 3:
                    dsDungCu.Sua();
                    break;
                case 4:
                    dsDungCu.timKiem();
                    break;
                case 5:
                    dsDungCu.ghiFile("output_dungcu.txt");
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai.");
            }
        } while (luaChon != 0);
    }

    private void hienThiMenu() {
        System.out.println("------ MENU DUNG CU HOC TAP ------");
        System.out.println("1. Them dung cu");
        System.out.println("2. Xoa dung cu");
        System.out.println("3. Sua thong tin dung cu");
        System.out.println("4. Tim kiem dung cu");
        System.out.println("5. Ghi vao file");
        System.out.println("0. Thoat");
    }
}
