using System;

namespace ConsoleTester
{
    public class KnightBits8 : ITask
    {

        public string Run(string[] data)
        {
            int n = Convert.ToInt32(data[0]);
            ulong bits = getKnightBits8(n);
            return (getQty(bits).ToString() + bits.ToString()).Trim();
        }

        public ulong getKnightBits8(int n)
        {

            int x = n;
            ulong noA = 0xfefefefefefefefe;
            ulong noH = 0x7f7f7f7f7f7f7f7f;
            ulong noB = 0xfdfdfdfdfdfdfdfd;
            ulong noG = 0xbfbfbfbfbfbfbfbf;
            ulong K = 1UL << x;
            ulong Ka = noA & K;
            ulong Kh = noH & K;
            ulong Kb = noB & K;
            ulong Kg = noG & K;

            ulong M = (Ka << 15) | (Kh << 17) |

                      ((Ka & Kb) << 6) | ((Kh & Kg) << 10) |

                      ((Ka & Kb) >> 10) | ((Kh & Kg) >> 6) |

                      (Ka >> 17) | (Kh >> 15);

            Console.WriteLine("x=" + x + ", b=" + M);

            return M;

        }

         static int getQty(ulong bits)
        {
            int qty = 0;
            while(bits > 0)
            {
                qty++;
                bits &= (bits -1);
            }
            return qty;

        }

    }
}
