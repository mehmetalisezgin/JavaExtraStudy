import java.util.ArrayList;
import java.util.List;

    public class SatinAlma {
          UretimPlanlama uP=new UretimPlanlama();
         String urun;
         int adet;
         String siparisTarihi;
         int siparisNo;
        public SatinAlma(String urun, int adet, String siparisTarihi, int siparisNo) {  //  parameetrreliconstructer
            this.urun=urun;
            this.adet=adet;
            this.siparisTarihi=siparisTarihi;
            this.siparisNo=++siparisNo;
        }

        public SatinAlma() {  // parametresiz constructer
        }

        public static void siparisAl(List<SatinAlma> siparisler) { // inner list seklinde gelen siparis verilerini ayirip adet belirleme methoduna gonderen method
            System.out.println("siparis al calisti");
                for (SatinAlma k : siparisler) {
                    String urun=k.urun;
                    int adet = k.adet;

                    adetBelirleme(urun,adet);
                }

            }

        public static  List<Integer> adetBelirleme(String urun, int adet){ // gelen siparisin uretim safhasinda hangi urunden ne kadar kullanilacagini hesaplayan method
            System.out.println("adet belirleme calisti");
            int gerekliDemirMiktariKg=0;
           int gerekliPVCMiktariKg=0;
            if(urun.equals("Sandalye(A)")){
                gerekliDemirMiktariKg=10*adet;
                gerekliPVCMiktariKg=5*adet;
            }
            if(urun.equals("Sandalye(B)")){
                gerekliDemirMiktariKg=8*adet;
                gerekliPVCMiktariKg=3*adet;
            }
            if(urun.equals("Koltuk(A)")){
                gerekliDemirMiktariKg=20*adet;
                gerekliPVCMiktariKg=10*adet;
            }
            if(urun.equals("Koltuk(B)")){
                gerekliDemirMiktariKg=15*adet;
                gerekliPVCMiktariKg=8*adet;
            }
            if(urun.equals("Kanepe(A)")){
                gerekliDemirMiktariKg=30*adet;
                gerekliPVCMiktariKg=25*adet;
            }
            if(urun.equals("Kanepe(B)")){
                gerekliDemirMiktariKg=25*adet;
                gerekliPVCMiktariKg=20*adet;
            }

            List<Integer>malzeme=new ArrayList<Integer>(); // malzeme listine gerekli malzemeleri koyup hammadde classina gonderiyoruz ki oradaki verilerle karsilastiracagiz
            malzeme.add(gerekliDemirMiktariKg);        // listimize object data type belirledik cunku hem String bir variable hemde int bir variable icine alacak.
            malzeme.add(gerekliPVCMiktariKg);
            Hammadde.kontrol(malzeme);
            return malzeme;
        }


        public String toString() {
            return "Siparis Bilgisi{" +
                    ", siparisNo=" + siparisNo +
                    "urun='" + urun + '\'' +
                    ", adet='" + adet + '\'' +
                    ", siparisTarihi='" + siparisTarihi + '\'' +
                    '}';
        }
    }
