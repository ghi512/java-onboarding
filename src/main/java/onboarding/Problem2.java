package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuffer sb = new StringBuffer();
        sb.append(cryptogram);

        int len = sb.length();
        int arr[] = new int[len];

        while(true) {
            int flag = 0;
            for(int i=0; i<len-1; i++) {
                if(sb.charAt(i) == sb.charAt(i+1)) {
                    arr[flag] = i;
                    i++;
                    flag++;
                }
            }
            if(flag != 0) {
                for(int j=0; j<flag; j++) {
                    sb.deleteCharAt(arr[j]);
                    sb.deleteCharAt(arr[j]);
                    arr[j+1] -= 2;
                }
                len = sb.length();
            }
            else {
                break;
            }
        }

        answer = String.valueOf(sb);
        return answer;
    }
}
