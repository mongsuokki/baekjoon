import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String[] answer = new String[players.length];
        for(int i=0;i<players.length;i++){
            map.put(players[i],i);
        }
        for(int i=0;i<callings.length;i++){
            Integer overtake = map.get(callings[i]);
            String takedPlayer = players[overtake-1];
            map.put(callings[i],overtake-1);
            map.put(takedPlayer, overtake);
            players[overtake-1] = callings[i];
            players[overtake] = takedPlayer;
        }
        return players;
    }
}