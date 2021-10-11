package racinggame;

import exception.InvalidInputException;
import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현
        String inputCarNames = inputCarNames();
        try {
            isCarNameValid(inputCarNames);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            inputCarNames = inputCarNames();
        }
    }

    // 기능 1. 자동차 이름 입력
    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    
    // TODO : 기능 2. 자동차 이름이 5자 이하인지 체크
    public static void isCarNameValid(String inputCarNames) {
        String[] carNames = inputCarNames.split(",");
        for(String carName : carNames) {
            if(carName.length() > 5) {
                throw new InvalidInputException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    // TODO : 기능 3. 사용자 시도횟수 입력
    
    // TODO : 기능 4. 시도횟수가 숫자인지 체크
    
    // TODO : 기능 5. 임의의 숫자를 가져와 전진할 것인지 체크
    
    // TODO : 기능 6. 자동차 별 전진한 수 출력
    
    // TODO : 기능 7. 자동차 전진횟수 중 시도횟수와 일치하는 값이 있는지 확인
    
    // TODO : 기능 8. 일치하는 값이 있으면 시도횟수에 도달한 자동차의 명단 출력 후 게임 종료
}
