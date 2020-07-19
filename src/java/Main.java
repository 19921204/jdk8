public class Main {

    public static void main(String[] args) {
        String s = new StringBuilder("ja").append("va").toString();
        System.out.println(s.intern() == s);
    }
}
