package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = getMoneyCount(money);
        return answer;
    }

    static List<Integer> getMoneyCount (int money) {
        List<Integer> answer = new ArrayList<>();
        ArrayList<Integer> moneyList =  new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        Integer integerMoney = Integer.valueOf(money);

        for(int i=0; i<9; i++) {
            Integer temp = integerMoney / moneyList.get(i);
            answer.add(temp);
            integerMoney -= (moneyList.get(i) * temp);
        }
        return answer;
    }
}
