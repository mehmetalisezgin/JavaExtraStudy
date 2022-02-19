import java.util.List;

public class Hammadde extends SatinAlma {


    public Hammadde(String urun, int adet, String siparisTarihi, int siparisNo) { // SatinAlma class inin child i oldugu icin oradaki parametreli cons.
        super(urun, adet, siparisTarihi, siparisNo);                                // kendisindede super() le birlikte olusturmak zorundayiz.

    }
    static int demirKg = 10000;  // depomuzda bulunan demir miktari
    static int pvcKg = 10000;  // depomuzda bulunan pvc miktari

    public static void kontrol(List<Integer> malzeme) { //gelen siparisin depomuzdaki hammaddelerle uretilip uretilemeyecegini kontrol eden
        System.out.println("kontrol method calisti.");
        int flag = 0;                                           // ve eger uretim icin yeterli stok yoksa otomatik hammadde siparisi veren method.
       while(flag!=2) {
           if (malzeme.get(0) < demirKg) {                       // SatinAlma class indan gonderilen malzeme list inin 0 index'i demir 1. index'i pvc
               flag++;
           } else hammaddeSiparisi(1);
           if (malzeme.get(1) < pvcKg) {
               flag++;
           } else hammaddeSiparisi(2);
       }
        Uretim.uretimBandi(malzeme);
    }

    public static void hammaddeSiparisi(int a) {
        if (a == 1) {
            demirKg += 2500;
        }
        if (a == 2) {
            pvcKg += 2500;
        }
    }
    public static void hammaddeSorgula(int choice){

        System.out.println(" Hammadde Stok Durumu\nDemir: "+demirKg+"\n PVC: "+pvcKg);
        main.yetkiliMenu(choice);
    }


}
