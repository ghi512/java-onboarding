package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(isException(pobi) == false)
            return -1;
        if(isException((crong)) == false)
            return -1;

        ArrayList<Integer> pobiLeftPage = getNum(pobi.get(0));
        ArrayList<Integer> pobiRightPage = getNum(pobi.get(1));
        ArrayList<Integer> crongLeftPage = getNum(crong.get(0));
        ArrayList<Integer> crongRightPage = getNum(crong.get(1));

        Integer pobiLeftMax = Math.max(pageSum(pobiLeftPage), pageMultiply(pobiLeftPage));
        Integer pobiRighttMax = Math.max(pageSum(pobiRightPage), pageMultiply(pobiRightPage));
        Integer pobiScore = Math.max(pobiLeftMax, pobiRighttMax);

        Integer crongLeftMax = Math.max(pageSum(crongLeftPage), pageMultiply(crongLeftPage));
        Integer crongRighttMax = Math.max(pageSum(crongRightPage), pageMultiply(crongRightPage));
        Integer crongScore = Math.max(crongLeftMax, crongRighttMax);

        if(pobiScore > crongScore)
            answer = 1;
        else if(crongScore > pobiScore)
            answer = 2;
        else
            answer = 0;

        return answer;
    }

    static Integer pageSum(ArrayList<Integer> page) {
        Integer sum = 0;
        if(page.size() <= 1) {
            sum = page.get(0);
        }
        else {
            for(int i=0; i<page.size(); i++) {
                sum += page.get(i);
            }
        }
        return sum;
    }

    static Integer pageMultiply(ArrayList<Integer> page) {
        Integer multiply = 1;
        if(page.size() <= 1) {
            multiply = page.get(0);
        }
        else {
            for(int i=0; i<page.size(); i++) {
                multiply *= page.get(i);
            }
        }
        return multiply;
    }

    static ArrayList<Integer> getNum(Integer pageNumber) {
        ArrayList<Integer> eachDigitsOfPage = new ArrayList<>();
        if(pageNumber < 10) { // 한 자리수
            eachDigitsOfPage.add(pageNumber);
        }
        else if(pageNumber < 100) { // 두 자리수
            eachDigitsOfPage.add(pageNumber/10);
            pageNumber %= 10;
            eachDigitsOfPage.add(pageNumber);
        }
        else { // 세 자리수
            eachDigitsOfPage.add(pageNumber/100);
            pageNumber %= 100;
            eachDigitsOfPage.add(pageNumber/10);
            pageNumber %= 10;
            eachDigitsOfPage.add(pageNumber);
        }
        return eachDigitsOfPage;
    }

    static boolean isException(List<Integer> person) {
        Integer difference = person.get(1) -  person.get(0);
        if(difference != 1) {
            return false;
        }
        return true;
    }
}