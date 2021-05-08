using System;

namespace ConsoleTester
{
    public class RookBits8 : ITask
    {

        public string Run(string[] data)
        {
            int n = Convert.ToInt32(data[0]);
            ulong bits = getRookBits8(n);
            return (getQty(bits).ToString() + bits.ToString()).Trim();
        }

        public ulong getRookBits8(int n)
        {

            int x = n;
            ulong K = 1UL << x;


            ulong M = (K << 56) |
                                (K << 48) |
                                (K << 40) |
                                (K << 32) |
                                (K << 24) |
                                (K << 16) |
                                (K << 8) ;


            for (int i = 1; i <= 7; i++)
            {
                if (i <= x % 8)
                {
                    M = M | (K >> 1 * i) ;
                }

                if (i <= (7 - x % 8))
                {
                    M = M | (K << 1 * i);
                }

            }

            M = M |            (K >> 56) |
                                (K >> 48) |
                                (K >> 40) |
                                (K >> 32) |
                                (K >> 24) |
                                (K >> 16) |
                                (K >> 8);

            Console.WriteLine("x=" + x + ", b=" + M);

            return M;

        }

        static int getQty(ulong bits)
        {
            int qty = 0;
            while (bits > 0)
            {
                qty++;
                bits &= (bits - 1);
            }
            return qty;

        }

    }
}
