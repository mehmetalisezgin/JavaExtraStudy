import java.util.Scanner;

public class main {
    static String yetkiliSifre = "1111";

    public static void main(String[] args) {

        loginMenu();
    }
    private static void sifreKontrol( int choice) {
        Scanner scan = new Scanner(System.in);
        System.out.println(" Kullanici Sifrenizi Giriniz");
        String sifre = scan.nextLine();
        if (sifre.equals(yetkiliSifre)) {
            yetkiliMenu(choice);
        }
    }

    public static void yetkiliMenu(int choice) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1-> Siparis Gir\n2-> Siparis Sorgula\n3-> Stok Sorgula\n4-> Hammadde Sorgula\n5-> Tum Siparisleri Sorgula\n6-> Cikis");
        int tercih = scan.nextInt();
        switch (tercih) {
            case 1:
                UretimPlanlama.alinanSiparis(choice);
                break;
            case 2:
                Uretim.siparisSorgula(choice);
                break;
            case 3:
                break;
            case 4:
                Hammadde.hammaddeSorgula(choice);
                break;
            case 5:
               Satis.tumSiparisleriSorgula();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Hatali Giris Yaptiniz");

        }

    }

    public static void loginMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1-> Musteri\n2->Yetkili");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                musteriMenu(choice);
                break;
            case 2:
                sifreKontrol(choice);
                break;
            default:
                System.out.println("Hatali Giris Yaptiniz");
                loginMenu();
                break;
        }


    }

    public static void musteriMenu(int choice) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1-> Siparis Gir\n2-> Siparis Sorgula\n3-> Cikis");
        int secim = scan.nextInt();
        switch (secim) {
            case 1:
                UretimPlanlama.alinanSiparis(choice);
                break;
            case 2:
                Uretim.siparisSorgula(choice);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Hatali Giris Yaptiniz");
                musteriMenu(choice);
                break;
        }
    }
}
