package ch11_문자열;

import java.nio.charset.StandardCharsets;

public class String01 {
    public static void main(String[] args) {
//        String str = new String("코리아 아이티 아카데미");
        //new로 주소를 하나 만들고 그 주소를 str에 대입하는 방법

        //new String 안해도 되는 이유 : 리터럴. 리터럴은 그 자체로 주소가 있다.
        String str = "코리아 아이티 아카데미";
        System.out.println(str == "코리아 아이티 아카데미"); //주소는 같다  ==: 주소 비교
        String str2 = new String("코리아 아이티 아카데미".getBytes(StandardCharsets.UTF_8));
        System.out.println(str2 == "코리아 아이티 아카데미"); //false 주소가 다르다!
        //
        System.out.println(str);
    }
}
