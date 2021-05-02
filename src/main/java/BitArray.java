import java.util.Arrays;

public class BitArray {

    private static final long ALL_ONES = 0xFFFFFFFF;
    private static final long WORD_SIZE = 32;
    private long bits[] = null;

    public BitArray(long size) {
            bits = new long[(int) ((int)size / WORD_SIZE + (size % WORD_SIZE == 0 ? 0 : 1))];
    }

    public boolean getBit(long pos) {
        return (bits[(int) (pos / WORD_SIZE)] & (1 << (pos % WORD_SIZE))) != 0;
    }

    public void setBit(long pos, boolean b) {
            long word = bits[(int) (pos / WORD_SIZE)];
            int posBit = 1 << (pos % WORD_SIZE);
            if (b) {
                word |= posBit;
            } else {
                word &= (ALL_ONES - posBit);
            }
            bits[(int) (pos / WORD_SIZE)] = word;
    }

}