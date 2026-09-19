import java.util.*;

class Solution {
    
    private static final String[] INDICATORS = {"RT", "CF", "JM", "AN"};
    
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < choices.length; i++) {
            int choice  = choices[i];
            
            int weight = Math.abs(choice - 4);
            char target = choice <= 3 ? survey[i].charAt(0) : survey[i].charAt(1);
            
            map.merge(target, weight, Integer::sum);
        }
        
        for(int i = 0; i < INDICATORS.length; i++ ) {
            char first = INDICATORS[i].charAt(0);
            char second = INDICATORS[i].charAt(1);
            sb.append( map.getOrDefault(first, 0) >= map.getOrDefault(second, 0) ? first : second);
        }
        return sb.toString();
    }
}