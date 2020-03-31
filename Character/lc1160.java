package Character;

public class lc1160 {
    public int countCharacters(String[] words, String chars) {
        char[] charset=chars.toCharArray();
        int start = Integer.valueOf('a');
        int[] map = initialMap();
        int totalLength=0;

        for (int i = 0; i < charset.length; i++) {
            map[Integer.valueOf(charset[i])-start]++;
        }
        for(String word:words){
            boolean canConstruct =true;
            int[] wordMap=initialMap();
            char[] wordChar=word.toCharArray();
            for (int i = 0; i < wordChar.length; i++) {
                wordMap[Integer.valueOf(wordChar[i])-start]++;
            }
            for (int i = 0; i < wordMap.length; i++) {
                if (wordMap[i]>map[i]){
                    canConstruct=false;
                }
            }
            if (canConstruct==true)totalLength+=word.length();
        }
        return totalLength;
    }

    public static int[] initialMap(){
        int[] map = new int[26];
        for (int i = 0; i < map.length; i++) {
            map[i]=0;
        }
        return map;
    }
}
