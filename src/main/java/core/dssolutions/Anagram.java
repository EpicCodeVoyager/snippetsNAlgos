package core.dssolutions;

import java.util.*;

public class Anagram {

    public static boolean isAnagram(String a, String b) {


        if (a.length() != b.length()) {
            return false;
        }


        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        Arrays.sort(aArr);
        Arrays.sort(bArr);

        for (int i = 0; i < aArr.length; i++) {
            if (aArr[i] != bArr[i]) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() {
            {
                add("code");
                add("aabgilo");
                add("bgiloaa");
                add("edoc");
                add("coed");
                add("dfffd");
                add("fffdd");
            }
        };

        List<String> finalList = new ArrayList<>();

        finalList.add(list.get(0));

        Set<String> hs = new HashSet<String>() {

            @Override
            public boolean equals(Object o) {
                return isAnagram(super.toString(), o.toString());
                // return super.equals(o);
            }
        };

        System.out.println(isAnagram("code", "ocde"));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}