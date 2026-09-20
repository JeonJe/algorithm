import java.util.*; 

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        //사람, 몇회 신고 메일 받았는지 
        Map<String, Integer> countMap = new HashMap<>();
        
        //신고당한사람, 신고한사람 
        Map<String, Set<String>> map = new HashMap<>();
        
        for(int i = 0; i < report.length; i++) {
            String[] reportingInfo = report[i].split(" ");
            //신고한 사람 
            String from = reportingInfo[0];
            //신고 당한사람 
            String to = reportingInfo[1];
            
            map.computeIfAbsent(to, f -> new HashSet<>()).add(from);
        }
        
        for(Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Set<String> values = entry.getValue();
            
            if(values.size() >= k) {
                for(String v : values) {
                    int c = countMap.getOrDefault(v, 0);
                    countMap.put(v, c+1);
                }
            }
        }
        
        for(int i = 0; i < id_list.length; i++) {
            answer[i] = countMap.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}