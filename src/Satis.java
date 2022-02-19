public class Satis {
Uretim u=new Uretim();

public static void tumSiparisleriSorgula(){
    for (SatinAlma k : UretimPlanlama.siparisler) {
        System.out.println("==========================================================================" +
                "\n\tSiparis Numaraniz :" + k.siparisNo + "\n " +
                "\tSiparis Edilen Urun: " + k.urun + "\n" +
                "\tSiparis Edilen Urun Adedi: " + k.adet +"\n"+
                "\tSiparis Tarihi: " + k.siparisTarihi + "\n" +
                "\n ````````````````````````````````````````````````````````````````````" );
    }
}





}
