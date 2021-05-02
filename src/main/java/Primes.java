
//Простые числа

public class Primes {

    //Перебор делителей
    public int getPrimesByIter(int n){

        int q=0;
        for(int i=2; i <= n; i++){
            if(isPrimebySqrt(i)) {
                q++;
            }
        }
        return q;
    }

    long primes[];
    //Перебор делителей с массивом
    public int getPrimesByIterArray(int n){

        int q=0;
        primes = new long[n];
        primes[q++] = 2;
        for(long i=3; i <= n; i+=2){
            if(isPrimebySqrtArray(i) == true) {
                primes[q++] = i;
            }
        }
        return q;
    }

    public int getPrimesWithArray(int n){
        int q=0;
        for(int i=0; i <= n; i++){
            if(isPrimebySqrt(i) == true) {
                q++;
            }
        }
        return q;
    }

    private boolean isPrime(int p){
        for(int d=2; d<p; d++){
            if(p % d == 0){return false;}
        }
        return true;
    }

    //До полповины ряда чисел
    private boolean isPrimeby2(int p){
        for(int d=2; d<p/2; d++){
            if(p % d == 0){return false;}
        }
        return true;
    }
    //До корня
    private boolean isPrimebySqrt(int p){
        int sqtr = (int)Math.sqrt(p);
        for(int d=2; d<=sqtr; d++){
            if(p % d == 0){return false;}
        }
        return true;
    }

    private boolean isPrimebySqrtArray(long p){
        long sqtr = (long)Math.sqrt(p);
        for(int d=0; primes[d]<=sqtr; d++){
            if(p % primes[d] == 0){return false;}
        }
        return true;
    }

    //С использованием алгоритма Эрастофена
    public int getPrimesEratosthen(int n){
        boolean[] div = new boolean[n+1];
        int q=0;
        for (long p = 2; p <= n; p += 1) {
            if (!div[(int) p]) {
                q++;
                for (long j = p * p; j <= n; j += p) {
                    div[(int) j] = true;
                }
            }
        }
        return q;
    }

    //С использованием алгоритма Эрастофена только для нечетных чисел
    public int getPrimesEratosthenOdd(int n){
        boolean[] div = new boolean[n+1];
        int q=1;
        if(n==1){return 0;}
            for (long p = 3; p <= n; p += 2) {
                if (!div[(int) p]) {
                    q++;
                    for (long j = p * p; j <= n; j += p) {
                        div[(int) j] = true;
                    }
                }
            }
        return q;
    }


    //С использованием алгоритма Эрастофена оптимизированного по битовому массиву вместо boolean
    public int getPrimesEratosthenByteArray(int n){

       BitArray ba = new BitArray(n+1);
        int q=1;
        if(n==1){return 0;}
         for (long p = 3; p <= n; p += 2) {
            if (!ba.getBit(p)) {
                q++;
                for (long j = p*p; j <= n; j += p) {
                    ba.setBit(j,true);
                }
            }
        }
        return q;
    }

}
