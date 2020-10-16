package intern06;

import java.util.HashMap;

public class Programmers04 {

    public static void main(String[] args) {
        // 마라톤 경기 //
        String[] participant = {"mislav","mislav","stanko","ana","frank"};
        String[] completion = {"ana","mislav"};
        
        String answer = "";
        HashMap<String,Integer> resultMap = new HashMap<String, Integer>();
        for(String player:participant) resultMap.put(player, resultMap.getOrDefault(player, 0)+1);
        System.out.println(resultMap);
        for(String player:completion) resultMap.put(player, resultMap.get(player)-1);
        
        System.out.println(resultMap);
        
        for(String key:resultMap.keySet()) {
            if(resultMap.get(key)!=0) {
                answer += key+",";
            }
        }
        answer = answer.substring(0, answer.length()-1);
        System.out.println("결과값:"+answer);
    }

}
