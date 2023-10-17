package baseball;


//여기서 컴퓨터의 랜덤값을 생성시켜야 함
//모두 다른 숫자 3개로 구성된 값이다.
public class ComputerAnswer {
    String answer = new String();

    ComputerAnswer(){
        while(answer.length() < 3){
            //이렇게 쓰면 1~9까지 범위 지정하게 됨
            int random = (int) Math.random() * 9 + 1;
            String tmp = Integer.toString(random);
            if(!answer.contains(tmp)){
                answer += tmp;
            }
        }
        System.out.println(answer);
    }
}
