public class Main {

    public static void main(String[] args) {
        String s = "武昌区中南路7号20层A10-1号";
        String[] lineWord = getLineWord(s, 14);
        System.out.println(lineWord);
    }

    public static String[] getLineWord(String s, int wordCount) {
        int zmLength = getStringNumAndWordCount(s);
        int dxzmLength =  getStringUpWordCount(s);
        int length = s.length()-zmLength+zmLength/2+zmLength%2-dxzmLength+dxzmLength*2/3+dxzmLength*2%3;
        int countAdd = 0;
        if (length % wordCount != 0) {
            countAdd = 1;
        }

        int lineCount = length / wordCount + countAdd;
        String[] lines = new String[lineCount];
        int zml = 0;
        int dxzml = 0;
        int subLength = 0;
        String lineValue = "";
        int lineNum = 0;
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                ++zml;
            } else if (c >= 'a' && c <= 'z') {
                ++zml;
            } else if (c >= 'A' && c <= 'Z') {
                ++dxzml;
            } else if (c != '(' && c != ')' && c != ';' && c != ',') {
                ++subLength;
            } else {
                ++zml;
            }

            int l = subLength + zml / 2 + zml % 2 + dxzml * 2 / 3 + dxzml * 2 % 3;
            lineValue = lineValue + String.valueOf(c);
            if (l > wordCount) {
                if (zml % 2 != 0 && i + 1 < s.length()) {
                    char c2 = s.charAt(i + 1);
                    boolean flg = false;
                    if (c2 >= '0' && c2 <= '9') {
                        flg = true;
                    } else if (c2 >= 'a' && c2 <= 'z') {
                        flg = true;
                    }  else if (c2 == '(' || c2 == ')' || c2 == ';' || c2 == ',') {
                        flg = true;
                    }

                    if (flg) {
                        lineValue = lineValue + String.valueOf(c2);
                        ++i;
                    }
                }

                lines[lineNum] = lineValue;
                ++lineNum;
                lineValue = "";
                zml = 0;
                dxzml = 0;
                subLength = 0;
            }

            ++i;
            if (i == s.length()) {
                lines[lineNum] = lineValue;
                ++lineNum;
                lineValue = "";
                zml = 0;
                dxzml = 0;
                subLength = 0;
            }
        }

        return lines;
    }

    public static String[] getLineWord2(String s, int wordCount) {
        int zmLength = getStringNumAndWordCount(s);
        int length = s.length() - zmLength + zmLength / 2 + zmLength % 2;
        int countAdd = 0;
        if (length % wordCount != 0) {
            countAdd = 1;
        }
        int lineCount = length / wordCount + countAdd;
        String[] lines = new String[lineCount];
        int zml = 0;
        int subLength = 0;
        String lineValue = "";
        int lineNum = 0;
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                zml++;  // || (c >= 'A' && c<='Z')
            } else if ((c >= 'a' && c <= 'z')) {
                zml++;
            } else if (c == '(' || c == ')' || c == ';' || c == ',') {
                zml++;
            } else {
                subLength++;
            }
            int l = subLength + zml / 2 + zml % 2;
            lineValue = lineValue + String.valueOf(c);


            if (l > wordCount) {
                if (zml % 2 != 0 && (i + 1) < s.length()) {
                    char c2 = s.charAt(i + 1);
                    boolean flg = false;
                    if (c2 >= '0' && c2 <= '9') {
                        flg = true;// || (c2 >= 'A' && c2<='Z')
                    } else if ((c2 >= 'a' && c2 <= 'z')) {
                        flg = true;
                    } else if (c2 == '(' || c2 == ')' || c2 == ';' || c2 == ',') {
                        flg = true;
                    }

                    if (flg) {
                        lineValue = lineValue + String.valueOf(c2);
                        i++;
                    }
                }
                lines[lineNum] = lineValue;
                lineNum++;
                lineValue = "";
                zml = 0;
                subLength = 0;
            }
            i++;
            if (i == s.length()) {
                lines[lineNum] = lineValue;
                lineNum++;
                lineValue = "";
                zml = 0;
                subLength = 0;
            }
        }

        return lines;
    }

    public static int getStringNumAndWordCount(String str) {
        int unicodeCount = 0;

        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                ++unicodeCount;
            } else if (c >= 'a' && c <= 'z') {
                ++unicodeCount;
            } else if (c == '(' || c == ')' || c == ';' || c == ',') {
                ++unicodeCount;
            }
        }

        return unicodeCount;
    }
    public static int getStringUpWordCount(String str) {
        int unicodeCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                unicodeCount++;  //|| (c >= 'A' && c<='Z')
            }
        }
        return unicodeCount;
    }
}
