using System;

namespace ConsoleTester
{
    class Program
    {
        static void Main(string[] args)
        {
            //KnightBits8 task = new KnightBits8();
            //KingBits8 task = new KingBits8();
            //RookBits8 task = new RookBits8();
            //BishopBits8 task = new BishopBits8();
            QueenBits8 task = new QueenBits8();
            Tester tester = new Tester(task,
                //@"/Users/D/Desktop/Algo/A_03/0-2.BITS/1.Bitboard - Король");
                //@"/Users/D/Desktop/Algo/A_03/0-2.BITS/2.Bitboard - Конь");
                //@"/Users/D/Desktop/Algo/A_03/0-2.BITS/3.Bitboard - Ладья");
                //@"/Users/D/Desktop/Algo/A_03/0-2.BITS/4.Bitboard - Слон");
                @"/Users/D/Desktop/Algo/A_03/0-2.BITS/5.Bitboard - Ферзь");
            tester.RunTest();
            
        }
    }
}
