import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Uretim extends UretimPlanlama {
    static int gunlukKapasite;
    static LocalDate tarih;
     int adet;
     String urun;
    static int uretimSuresi;
    static String teslimTarihi;
    static String uretimBaslangicTarihi;

    public static void uretimBandi(List<Integer> malzeme) {
        System.out.println("uretim bandi calisti");
        Hammadde.demirKg -= malzeme.get(0);
        Hammadde.pvcKg -= malzeme.get(1);
        tarih = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy"); // siparis tarihini bizim duzenledigimiz sekilde vermesi icin format methodunu kullandik.
        uretimBaslangicTarihi = dtf.format(tarih);

    }

    public static void teslimSuresiSorgula(int choice) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Siparis Numaranizi Giriniz");
        int sN = scanner.nextInt();
    int adet = 0;
    String urun = "";



        for (SatinAlma k : UretimPlanlama.siparisler) {
                    if (k.siparisNo==sN){
                       adet = k.adet;
                        urun=k.urun;
                        System.out.println("calisti");
                }
        }
                   if(k.siparisNo!=sN) {
            System.out.println(" Girdiginiz Siparis Numarasi Bulunamadi \n" +
                    "=======================================================\n" +
                    "Tekrar Denemek Icin -> 1\n" +
                    "Geri Donmek Icin -> 2");
            int secim = scanner.nextInt();
            if (secim == 1) {
                teslimSuresiSorgula(choice);
            } else if (choice == 1) {
                main.musteriMenu(choice);
            }else
                main.yetkiliMenu(choice);

        }

          
                if (adet<=kapasiteBelirle(urun)){
                    uretimSuresi=1;
                }else
                uretimSuresi = (int) Math.ceil(adet / kapasiteBelirle(urun));  // uretim suresi: kapasiteye bagli gunluk uretim.

            LocalDate teslimSuresi = tarih.plusDays(uretimSuresi);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");

             teslimTarihi = dtf.format(teslimSuresi);

         if (choice == 1) {
            main.musteriMenu(choice);
        }else
            main.yetkiliMenu(choice);

        }



    public static void siparisSorgula(int choice){
        teslimSuresiSorgula(choice);
        System.out.println("\t\tNumarali Siparisinizin " +
                "\nUretim Baslangic Tarihi: " + uretimBaslangicTarihi + "\n" +
                "Tahmini Teslim Suresi: " + teslimTarihi + "\n" +
                "========================================================");
    }



    public static int kapasiteBelirle(String urun) {
        if (urun.equals("Sandalye(A)")) {
            gunlukKapasite = 100;
        }
        if (urun.equals("Sandalye(B)")) {
            gunlukKapasite = 150;
        }
        if (urun.equals("Koltuk(A)")) {
            gunlukKapasite = 60;
        }
        if (urun.equals("Koltuk(B)")) {
            gunlukKapasite = 80;
        }
        if (urun.equals("Kanepe(A)")) {
            gunlukKapasite = 40;
        }
        if (urun.equals("Kanepe(B)")) {
            gunlukKapasite = 60;
        }
        return gunlukKapasite;
    }


}




