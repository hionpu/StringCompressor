import java.util.*;


public class Compressor {
    public static String compressString(String str) {
        // TODO:
        // 무한루프 방지용으로 마지막 문자에 ascii code +1 한 문자 추가함
        String newStr = str + (char) (str.charAt(str.length()-1) +1);
        ArrayList<String> array = new ArrayList<>();
        // 문자열이 서로 다른게 나오면 거기서 잘라서 리스트에 삽입함
        int count = 0;
        while (newStr.length() > 1 && count < newStr.length()+1) {
            char head = newStr.charAt(0);
            for (int i = 1; i < newStr.length(); i++) {
                if (head != newStr.charAt(i)) {
                    System.out.println(newStr.substring(0,i));
                    array.add(newStr.substring(0, i));
                    newStr = newStr.substring(i);
                    break;
                }

            }
            count++;

        }
        System.out.println(array);
        // replaceFirst로 대체
        for (String ele : array) {
            if (ele.length() >= 3) {
                String sub = Integer.toString(ele.length())+ele.charAt(0);
                str = str.replaceFirst(ele, sub);
            }
        }
    return str;
    }

    public static void main(String[] args) {
        System.out.println(Compressor.compressString("dsafdasfffffsgaaaaabbbscccdd"));


    }
}
