import com.google.common.math.IntMath;
import com.google.common.math.BigIntegerMath;
import java.math.BigInteger;

/*
  Для расчета количества счастливых билетов используем формулу
  Sum{i=0..n-1} (-1)^i * binomial(2n,i) * binomial(11n-1-10i,2n-1)
*/
class luckyTickets {

    public BigInteger getTicketsQty(int n){

        BigInteger r = new BigInteger("0");
        for (int i = 0; i < n; i++) {

            r = r.add(BigIntegerMath.binomial(2 * n, i).multiply(
                  BigIntegerMath.binomial(11 * n - 1 - 10 * i, 2 * n - 1))
                    .multiply(BigInteger.valueOf(IntMath.pow(-1,i))));

        }
        return r;

    }
}
