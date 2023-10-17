package baseball;


import java.util.Scanner;

//사용자 입력값을 처리할 객체
public class UserAnswer {
    String userAnswers;
    Scanner kb = new Scanner(System.in);
    UserAnswer(){
        String tmp = kb.next();//사용자 입력값을 얻기
        checkException(tmp);//체킹 하고 입력값을
        userAnswers = tmp;//담아주기
    }

    //사용자 입력값 오류에 대한 예외처리 용
    public void checkException(String userAnswers) throws IllegalArgumentException {
        if (userAnswers.length() != 3) {//사용자의 답 길이 3 이 아니어도
            throw new IllegalArgumentException(); //던지고
        }
        //(1) 사용자가 1-9 범위 벗어난 값 입력 시 던지기
        for(char x : userAnswers.toCharArray()){
            int tmp = Character.getNumericValue(x);
            if(tmp < 1 || tmp > 9) {
                throw new IllegalArgumentException();
            }
        }
        String st = new String();
        //(2) 사용자가 모두 다른 숫자를 입력하지 않았을 경우도 던지기
        for(char x : userAnswers.toCharArray()){
            if(!st.contains(String.valueOf(x))){
                st += String.valueOf(x);
            }else{
                //만약에 현재 존재하는 값이 이미 입력된 st 에 포함되어 있다면
                throw new IllegalArgumentException();
            }
        }

    }


}
