package baseball;

import java.util.Scanner;

public class Application {

    //실행 메인
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        System.out.println("시작");
        Scanner kb= new Scanner(System.in);
        ComputerAnswer computerAnswer;
        ComputerGame game;
        UserAnswer userAnswer;

        String answer = "";//사용자 입력값에 따른 반복 설정
        //첫시작은 무조건 실행함
        do{
            game = new ComputerGame();//게임 객체 생성
            game.gameStart();//게임 시작시킴
            //복귀 후
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            answer = kb.next();//사용자 입력값을 받아서
        }while(answer.equals("1"));// 1인 동안 입력받음
    }
}

