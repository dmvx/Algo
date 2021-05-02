import org.decimal4j.util.DoubleRounder;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;

//Число Фибоначи

class Fibo {
    BigInteger F = new BigInteger("0"),F1 = new BigInteger("0"),F2 = new BigInteger("1");
    int i=0;

    public static BigDecimal sqrt(BigDecimal in, int scale){
        BigDecimal sqrt = new BigDecimal(1);
        sqrt.setScale(scale + 3, RoundingMode.FLOOR);
        BigDecimal store = new BigDecimal(in.toString());
        boolean first = true;
        do{
            if (!first){
                store = new BigDecimal(sqrt.toString());
            }
            else first = false;
            store.setScale(scale + 3, RoundingMode.FLOOR);
            sqrt = in.divide(store, scale + 3, RoundingMode.FLOOR).add(store).divide(
                    BigDecimal.valueOf(2), scale + 3, RoundingMode.FLOOR);
        }while (!store.equals(sqrt));
        return sqrt.setScale(scale, RoundingMode.FLOOR);
    }

    //Итеративный подход
    public BigInteger getFiboWIter(int n)
    {

        for(int i=0; i<=n; i++){
            if(i==0) {F1 = new BigInteger("0");F = new BigInteger("0");}
            if(i==1) {F2 = new BigInteger("1");F = new BigInteger("1");}
            if(i>=2) {
                F = F1.add(F2);
                F1 = F2;
                F2 = F;
            }

        }
        return F;
    }

    //С использованием рекурсии
    public BigInteger getFiboWRec(int n)
    {
        if(n > 0){
            n = n - 1;
            F = F1.add(F2);
            F1 = F2;
            F2 = F;
            if(n>1){getFiboWRec(n);}
        }
           return F;
    }

    //По формуле золотого сечения
    public BigInteger getFiboWGS(int n)
    {
        BigDecimal Ft;
        BigDecimal sqrt5 = sqrt(BigDecimal.valueOf(5),9995);
        BigDecimal fi = (sqrt5
                        .add(BigDecimal.valueOf(1)))
                        .divide(BigDecimal.valueOf(2));

        //System.out.println(sqrt5.toString());

        Ft = fi.pow(n);
        F = Ft.divide(sqrt5, 9999, RoundingMode.FLOOR)
                .add(BigDecimal.valueOf(1/2)).setScale(0, BigDecimal.ROUND_HALF_UP).toBigInteger();
        //System.out.println(F.toString());
        return F;
    }

    //С использованием матрицы
    public BigInteger getFiboWMatrix(int n) {

        BigInteger a1 = new BigInteger("1");
        BigInteger a2 = new BigInteger("1");
        BigInteger a3 = new BigInteger("1");
        BigInteger a4 = new BigInteger("0");

        BigInteger r1 = new BigInteger("1");
        BigInteger r2 = new BigInteger("1");
        BigInteger r3 = new BigInteger("1");
        BigInteger r4 = new BigInteger("0");

        BigInteger a1sh;
        BigInteger a2sh;
        BigInteger a3sh;
        BigInteger a4sh;

        int i = 1;

        if(n==0) {return new BigInteger("0");}
        if(n==1) {return new BigInteger("1");}
        if(n>=2) {
            while (i < n - 1) {

                if(i * 2 > n - 1){break;}else {i = i * 2;}

                a1sh = (a1.multiply(a1)).add(a2.multiply(a3));
                a2sh = (a1.multiply(a2)).add(a2.multiply(a4));
                a3sh = (a3.multiply(a1)).add(a4.multiply(a3));
                a4sh = (a3.multiply(a2)).add(a4.multiply(a4));

                a1 = a1sh;
                a2 = a2sh;
                a3 = a3sh;
                a4 = a4sh;
            }

            for (int j = i; j < n - 1; j++) {
                a1sh = (a1.multiply(r1)).add(a2.multiply(r3));
                a2sh = (a1.multiply(r2)).add(a2.multiply(r4));
                a3sh = (a3.multiply(r1)).add(a4.multiply(r3));
                a4sh = (a3.multiply(r2)).add(a4.multiply(r4));

                a1 = a1sh;
                a2 = a2sh;
                a3 = a3sh;
                a4 = a4sh;
            }
        }
        return a1;
    }
}
