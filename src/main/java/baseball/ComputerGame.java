package baseball;
//컴퓨터 게임 객체
public class ComputerGame { //여기에서 두 가지 값에 대한 비교 처리
    //게임의 큰 규격 담당
    //컴퓨터 답
    ComputerAnswer computerAnswer;
    //사용자 답
    UserAnswer userAnswer;
    //1) 게임 시작처리
    public void gameStart(){
        //(1) 컴퓨터 랜덤값 생성
        computerAnswer = new ComputerAnswer();//값 생성
        boolean chk ;

        do{
            String userInput = new String();
            System.out.println("숫자를 입력해주세요 : ");
            userAnswer = new UserAnswer();//사용자의 입력값
            chk = getHint(userAnswer.userAnswers);//해당 객체에서 사용자의 입력값을 받아서 그 String 값만 들고 옴
        }while(!chk); //chk가 false 인 동안 반복
    }

    //1) getHint
    public boolean getHint(String userAnswer){
        int ball = ballCnt(userAnswer);
        int strike = strikeCnt(userAnswer);
        ball = ball - strike;//그냥 포함된 값 - 자리까지 정답인 애들
        //사용자의 입력값에 대하여
        //==> 컴퓨터 입력값과 비교하여 output 값을 처리 하여 출력할 것
        String output = new String();
        if(ball > 0){
            output += Integer.toString(ball) + "볼 ";
        }
        if(strike > 0 ){
            output += Integer.toString(strike) + "스트라이크 ";
        }
        //한개도 못맞췄으면
        if(ball == 0 && strike == 0){
            output += "낫싱";
        }
        System.out.println(output);//여기서 정답 출력해주고

        //ball 로직에 strike 낀 부분 수정함
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }
    //2) 스트라이크 판단
    public int strikeCnt(String userAnswer){
        int cnt = 0;
        for(int i=0; i<3; i++){
            if(userAnswer.charAt(i) == computerAnswer.answer.charAt(i)){
                cnt++;
            }
        }
        return cnt;
    }
    //3) 볼 판단
    public int ballCnt(String userAnswer){
        int cnt = 0;
        for(int i=0; i<3; i++){
            if(computerAnswer.answer.contains(String.valueOf(userAnswer.charAt(i)))){
                //컴퓨터 정답 값에 대해, 사용자 입력값이 존재하긴 한다면
                cnt++;
            }
        }
        return cnt;
    }
}
