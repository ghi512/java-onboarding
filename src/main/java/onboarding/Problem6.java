package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = getEmailOfLimitedNickName(forms);
        return answer;
    }

    private static List<String> getEmailOfLimitedNickName(List<List<String>> forms) {
        ArrayList<String> duplicatedEmail = new ArrayList<>();
        int crewNumber = forms.size();
        for(int i=0; i<crewNumber-1; i++) {
            String targetNickName = String.valueOf(forms.get(i).get(1)); // 검색할 닉네임
            for(int j=i+1; j<crewNumber; j++) {
                String comparedNickName = String.valueOf(forms.get(j).get(1)); // 비교할 닉네임
                if(isDuplicated(targetNickName, comparedNickName) == true) {
                    duplicatedEmail.add(forms.get(i).get(0));
                    duplicatedEmail.add(forms.get(j).get(0));
                }
            }
        }

        TreeSet<String> treeSet = new TreeSet<>();
        for(String email : duplicatedEmail) {
            treeSet.add(email);
        }
        ArrayList<String> answer = new ArrayList<String>(treeSet);
        return answer;
    }

    private static boolean isDuplicated(String targetNickName, String comparedNickName) {
        for(int i=0; i<(targetNickName.length() - 1); i++) {
            String targetPart = targetNickName.substring(i, i+2);
            for(int j=0; j<(comparedNickName.length() - 1); j++) {
                String comparedPart = comparedNickName.substring(j, j+2);
                if(targetPart.equals(comparedPart))
                    return true;
            }
        }
        return false;
    }
}
