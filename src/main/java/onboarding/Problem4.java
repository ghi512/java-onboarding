package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        sb.append(answer);
        int len = word.length();
        char ch;

        for(int i=0; i<len; i++) {
            ch = word.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                ch = (char)(155 - ch);
            }
            else if (ch >= 'a' && ch <= 'z') {
                ch = (char)(219 - ch);
            }
            sb.append(ch);
        }
        answer = String.valueOf(sb);
        return answer;
    }
}
