
import org.jetbrains.annotations.NotNull;

import java.util.Arrays; //Arrays için import edilmesi gerekiyor.




public class ders98_compatarorInterfacesi {
    public static void main(String[] args) {

        Ogrenci ogr1 =new Ogrenci(55, "emre");
        Ogrenci ogr2 = new Ogrenci(290, "hasan");
        Ogrenci ogr3 = new Ogrenci(36, "ayse");

        //simfi ben bunları bir veri turunde saklamak istiyorum. dizimin veri türü Ogrenci olmalı:
        Ogrenci[] ogrenciler = {ogr1, ogr2, ogr3}; //direk new demektense bu şekilde de içeri yerleştirebiliyordum.

        System.out.println("dizi siralanmadan onceki hali: ");
        for(Ogrenci gecici : ogrenciler){
            System.out.println(gecici);
        }

        System.out.println("siralamadan sonraki hali: ");
        //javada dizilerle ilgili Arrays diye bir yapı vardı
        Arrays.sort(ogrenciler);  //hata veiyorusa otomatik import etmemiştir yukarıya ekleme yap
        for(Ogrenci gecici : ogrenciler){
            System.out.println(gecici);
        }

    }
}

class Ogrenci implements Comparable<Ogrenci>{
    int id;
    String ad;

    public Ogrenci(int id, String ad) {  //constructor yaptım
        this.id = id;
        this.ad = ad;
    }

    //bir de ogrenci nesnesini ekrana yazdırdıgımda noluyordu tostring metodu tetikleniyordu:

    @Override
    public String toString() {
        return "ad: " +ad+ " id: " +id;
    }

    //buraya compareto metodu kesinlikle geçilmeli yokha yata alırım.
    @Override
    public int compareTo(@NotNull Ogrenci o) {
        if(this.id < o.id){  //o.id bir sonraki geleni temsil ediyor.
            return -1;
        }else if(this.id > o.id){
            return 1;
        }else{
            return 0;
        }
    }


    /* Eger isime göre sıralayacak olsaydık:
    if(this.ad.compareTo(o.ad) < 0){
        return -1;}
    else if(this.ad.compareTo(o.ad) > 0){
        return 1;}
    else{
        return 0; }

        yapacaktık.

     */
}
