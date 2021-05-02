import org.decimal4j.util.DoubleRounder;
import java.math.BigDecimal;
import java.math.RoundingMode;
//Возведение в степпень


//Последовательное умножение
class GetPower {
    public static double getPowerIter(Double a, int b)
    {
        Double p = 1.0;
        for (int i = 0; i < b; i++)
            if (b == 0){
                p = 1.0;
            } else{p = p * a;}

        return DoubleRounder.round(p,11);
    }

    //Оптимизация с умножением
    public static double getPowerby2(double a, int b)
    {
        BigDecimal p = new BigDecimal(a).setScale(50, RoundingMode.FLOOR);

        int i = 1;
        if (b == 0) {
            return 1.0;
        }
        while (i < b) {
            if(i * 2 > b){break;}else {i = i * 2;}
            p = p.multiply(p).setScale(50, RoundingMode.FLOOR);
            //System.out.println(p.toPlainString());
        };

        for(int j = i; j < b; j++) {
            p = p.multiply(new BigDecimal(a).setScale(50, RoundingMode.FLOOR)).setScale(50, RoundingMode.FLOOR);
        }
        return DoubleRounder.round(p.doubleValue(),11);
    }

    //С разложением по степени двойки
    public static double getPowerbyBin(double a, int b){

        String bs8 = Integer.toBinaryString(b);

        //Приводим число к 8-битному формату
        while (bs8.length() % 4 > 0)
        {
            bs8 = "0" + bs8;
        }
        char[] strBinArray = bs8.toCharArray();
        long[] N=new long[strBinArray.length];

        for (int i=0; i < strBinArray.length; i++) {
            if (i>0) {
                N[i] = N[i - 1] * 2;
            }else{
                N[i] = 2;
            }
        }

        BigDecimal r = new BigDecimal(1.0);
        for(int i=0; i < strBinArray.length; i++) {

            if (strBinArray[i] == '1') {
                int j = 1;

                BigDecimal p = new BigDecimal(a);
                while (j < N[i]) {
                    p = p.multiply(p);
                    j += j;
                }
                r = r.multiply(p);
            }
        }
        return DoubleRounder.round(r.doubleValue(),11);
    }
}
