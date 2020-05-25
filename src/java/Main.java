import java.util.concurrent.ConcurrentHashMap;

public class Main {
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>(17);
        map.put("s","2");
    }
    private static final int tableSizeFor(int c) {
        int n = c - 1;
        // n |= n >>> 1 n无符号右移1位，即n二进制最高位的1右移一位
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        // 位运算完以后，n的二进制位全为1
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
