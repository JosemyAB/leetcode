import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public static void main(String[] args) {
        String s = "testt";
        String t = "esttt";

        IsAnagram isAnagramClass = new IsAnagram();
        System.out.println(isAnagramClass.isAnagram(s, t));

    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return mapS.equals(mapT);
    }
}
