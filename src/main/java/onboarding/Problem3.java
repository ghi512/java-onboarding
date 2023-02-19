package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int thousands, hundreds, tens, units;

        for(int i=1; i<=number; i++) {
            int temp = i;

            thousands = temp / 1000;
            temp %= 1000;
            hundreds = temp / 100;
            temp %= 100;
            tens = temp / 10;
            temp %= 10;
            units = temp;

            if(thousands == 3 || thousands == 6 || thousands == 9)
                answer++;
            if(hundreds == 3 || hundreds == 6 || hundreds == 9)
                answer++;
            if(tens == 3 || tens == 6 || tens == 9)
                answer++;
            if(units == 3 || units == 6 || units == 9)
                answer++;
        }

        return answer;
    }
}
