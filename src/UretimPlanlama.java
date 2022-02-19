import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UretimPlanlama {
    static List<SatinAlma> siparisler = new ArrayList<SatinAlma>();
    static int siparisNo = 1000;           // siparis no her sipariste bir artsin diye buraya static olarak tanimladik.

    public static void alinanSiparis(int choice) {   // main Method dan call yapilan method
        Scanner scan = new Scanner(System.in);
        char tercih;
        do {
            System.out.println(" Lutfen Urun Kodunu Giriniz \n1-> Sandalye(A) \n2-> Sandalye(B) \n3-> Koltuk(A) \n" +
                    "4-> Koltuk(B) \n5-> Kanepe(A) \n6-> Kanepe(B)");
            String urun = tercihReturn(scan.nextInt());
            scan.nextLine();
            System.out.println("Siparis adedini giriniz.");
            int adet = scan.nextInt();

            LocalDateTime dateTime = LocalDateTime.now(); //dateTime= islem gorulen anin tarihini verir
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
            String siparisTarihi = dtf.format(dateTime);

            SatinAlma siparis = new SatinAlma(urun, adet, siparisTarihi, siparisNo); // SatinAlma class indan bir obje ile verilerimizi cons. gonderdik
            siparisler.add(siparis); // objemizde ki verileri class level da create ettigimiz bos listimize attik
            siparisNo++;   // siparis no her sefeerinde 1 artiyor. her siparisin siparis no su farkli olmali

           // siparisMakbuzu(siparisler, choice);
            do {
                System.out.println("Yeni siparis vermek istiyor musunuz? E/H ");
                tercih = scan.next().toUpperCase().charAt(0);
                if (tercih == ('E') || tercih == ('H')) {
                    break;
                } else System.out.println("lutfen Gecerli bir tercih giriniz");
            } while (tercih != 'E' || tercih != 'H');
        } while (tercih != 'H');
        SatinAlma.siparisAl(siparisler);
        siparisMakbuzu(siparisler, choice);
         // SatinAlma class indaki siparisAl methoduna parametre olarak siparisler listimizi gonderdik.
    }





    public static void siparisMakbuzu(List<SatinAlma> siparisler, int choice) {  // musteriye verdigi siparisin detaylarini gosteren method
        for (SatinAlma k : UretimPlanlama.siparisler) {
            System.out.println("==========================================================================" +
                    "\n\tSiparis Numaraniz :" + k.siparisNo + "\n " +
                    "\tSiparis Edilen Urun: " + k.urun + "\n" +
                    "\tSiparis Edilen Urun Adedi: " + k.adet +
                    "\tSiparis Tarihi: " + k.siparisTarihi + "\n" +
                    "\n ````````````````````````````````````````````````````````````````````" +
                    "\nSiparisiniz Uretim Planlama Departmanimiz tarafindan isleme alinmistir\n" +
                    "Siparis Numaraniz Ile Siparisinizi Sorgulatabilirsiniz \n" +
                    "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        }
        if (choice == 1) {
            main.musteriMenu(choice);
        } else main.yetkiliMenu(choice);

    }

    public static String tercihReturn(int i) { // kullanicinin girdigi tercihin hangi urune karsilik geldigini buldugumuz method. String variable return ediyor
        String urun = "";
        switch (i) {
            case 1:
                urun = "Sandalye(A)";
                break;
            case 2:
                urun = "Sandalye(B)";
                break;
            case 3:
                urun = "Koltuk(A)";
                break;
            case 4:
                urun = "Koltuk(B)";
                break;
            case 5:
                urun = "Kanepe(A)";
                break;
            case 6:
                urun = "Kanepe(B)";
                break;
        }
        return urun;
    }

}
