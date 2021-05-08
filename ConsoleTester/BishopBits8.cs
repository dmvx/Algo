using System;

namespace ConsoleTester
{
    //Слон 
    public class BishopBits8 : ITask
    {

        public string Run(string[] data)
        {
            int n = Convert.ToInt32(data[0]);
            ulong bits = getBishopBits8(n);
            return (getQty(bits).ToString() + bits.ToString()).Trim();
        }

        public ulong getBishopBits8(int n)
        {

            int x = n;
            ulong K = 1UL << x;

            ulong M = 0;

            for (int i = 1; i <= 7; i++)
            {
                if (i <= x % 8)
                {
                    M = M | (K << 7 * i) |
                            (K >> 9 * i);
                }

                if (i <= (7 - x % 8))
                {
                    M = M | (K << 9 * i) |
                            (K >> 7 * i);
                }

            }

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
