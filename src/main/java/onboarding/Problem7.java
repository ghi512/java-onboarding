package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = getSuggestFriend(user, friends, visitors);
        return answer;
    }

    private static List<String> getSuggestFriend(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> friendOfUser = getUserFriends(user, friends);
        HashMap<String, Integer> waitingFriends = getConnectedScores(user, friends, friendOfUser);
        getVisitorScores(waitingFriends, visitors, friendOfUser);

        List<String> keySet = new ArrayList<>(waitingFriends.keySet());
        keySet.sort((o1, o2) -> waitingFriends.get(o2).compareTo(waitingFriends.get(o1)));

        for(String key : keySet) {
            answer.add(key);
        }

        return answer;
    }

    private static void getVisitorScores(HashMap<String, Integer> waitingFriends, List<String> visitors, List<String> friendOfUser) {
        for(int i=0; i<visitors.size(); i++) {
            int temp = 0;
            for(int k=0; k<friendOfUser.size(); k++) {
                if(visitors.get(i) == friendOfUser.get(k)) {
                    temp++;
                    break;
                }
            }
            if(temp >= 1) break;
            if(waitingFriends.containsKey(visitors.get(i))) {
                waitingFriends.put(visitors.get(i), waitingFriends.get(visitors.get(i)) + 1);
            }
            else {
                waitingFriends.put(visitors.get(i), 1);
            }
        }
    }

    private static HashMap<String, Integer> getConnectedScores(String user, List<List<String>> friends, List<String> friendOfUser) {
        HashMap<String, Integer> waitingFriends = new HashMap<>();

        for(int i=0; i<friends.size(); i++) {
            if((friends.get(i).get(0) == user) || (friends.get(i).get(1) == user))
                continue;
            for(int k=0; k<friendOfUser.size(); k++) {
                if(friends.get(i).get(1) == friendOfUser.get(k)) {
                    if(waitingFriends.containsKey(friends.get(i).get(0))) {
                        waitingFriends.put(friends.get(i).get(0), waitingFriends.get(friends.get(i).get(0)) + 10);
                    }
                    else {
                        waitingFriends.put(friends.get(i).get(0), 10);
                    }
                }
                else if(friends.get(i).get(0) == friendOfUser.get(k)) {
                    if(waitingFriends.containsKey(friends.get(i).get(1))) {
                        waitingFriends.put(friends.get(i).get(1), waitingFriends.get(friends.get(i).get(1)) + 10);
                    }
                    else {
                        waitingFriends.put(friends.get(i).get(1), 10);
                    }
                }
            }
        }

        return waitingFriends;
    }

    private static List<String> getUserFriends(String user, List<List<String>> friends) {
        List<String> friendOfUser = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0) == user) {
                friendOfUser.add(friends.get(i).get(1));
            }
            if (friends.get(i).get(1) == user) {
                friendOfUser.add(friends.get(i).get(0));
            }
        }
        return friendOfUser;
    }

}
