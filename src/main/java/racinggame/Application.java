package racinggame;

import exception.InvalidInputException;
import model.Cars;
import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        Cars cars = new Cars();
        Integer inputProcessCount = inputProcessCount();
        System.out.println("count : " + inputProcessCount);
    }

    // 기능 3. 사용자 시도횟수 입력
    public static Integer inputProcessCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String processCount = Console.readLine();
        return Integer.parseInt(processCount);
    }
    
    // TODO : 기능 4. 시도횟수가 숫자인지 체크
    
    // TODO : 기능 5. 임의의 숫자를 가져와 전진할 것인지 체크
    
    // TODO : 기능 7. 자동차 별 전진한 수 출력
    
    // TODO : 기능 8. 자동차 전진횟수 중 시도횟수와 일치하는 값이 있는지 확인
    
    // TODO : 기능 9. 일치하는 값이 있으면 시도횟수에 도달한 자동차의 명단 출력 후 게임 종료
}
