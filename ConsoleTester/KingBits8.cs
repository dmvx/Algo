using System;

namespace ConsoleTester
{
    public class KingBits8 : ITask
    {

        public string Run(string[] data)
        {
            int n = Convert.ToInt32(data[0]);
            ulong bits = getKingBits8(n);
            return (getQty(bits).ToString() + bits.ToString()).Trim();
        }

        public ulong getKingBits8(int n)
        {

            int x = n;
            ulong noA = 0xfefefefefefefefe;
            ulong noH = 0x7f7f7f7f7f7f7f7f;
            ulong K = 1UL << x;
            ulong Ka = noA & K;
            ulong Kh = noH & K;

            ulong M = (Ka << 7) | (K << 8) | (Kh << 9) |
                      (Ka >> 1) |            (Kh << 1) |
                      (Ka >> 9) | (K >> 8) | (Kh >> 7);
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
