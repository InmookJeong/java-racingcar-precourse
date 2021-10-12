package racinggame;

import exception.InvalidInputException;
import model.Cars;
import nextstep.utils.Console;
import utils.NumberUtil;

public class Application {
    public static void main(String[] args) {
        Cars cars = new Cars();
        Integer inputProcessCount = inputProcessCount();
        cars.startRace(inputProcessCount);
    }

    // 기능 3. 사용자 시도횟수 입력
    public static Integer inputProcessCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String inputNumber = Console.readLine();
        try{
            isValidNumber(inputNumber, 1, Integer.MAX_VALUE);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            inputNumber = inputProcessCount()+"";
        }
        return Integer.parseInt(inputNumber);
    }
    
    // 기능 4. 시도횟수가 숫자인지 체크
    public static void isNumber(String inputNumber) {
        try{
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public static void isValidNumber(String inputNumber, int min, int max) {
        isNumber(inputNumber);
        if(!NumberUtil.isMoreThanMin(Integer.parseInt(inputNumber), min-1)) {
            throw new InvalidInputException(min + " 이상의 숫자를 입력해주세요.");
        }
    }
}
