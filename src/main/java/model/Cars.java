package model;

import exception.InvalidInputException;
import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private List<Car> cars;

	public Cars() {
		String inputCarNames = getNames();
		cars = getCar(inputCarNames);
	}
	
	// 기능 5. 자동차 객체 생성
	public List<Car> getCar(String inputCarNames) {
		List<Car> carArray = new ArrayList<Car>();
		String[] carNames = inputCarNames.split(",");
		for(String carName : carNames) {
			carArray.add(new Car(carName.trim()));
		}
		return carArray;
	}

	public String getNames() {
		String inputCarNames = inputCarNames();
		try {
			isCarNameValid(isEmptyCarName(inputCarNames));
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
			getNames();
		}
		return inputCarNames;
	}

	// 기능 1. 자동차 이름 입력
	public String inputCarNames(){
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return Console.readLine();
	}

	public String isEmptyCarName(String inputCarNames) {
		if(inputCarNames.equals("")) {
			throw new InvalidInputException("[ERROR] 자동차의 이름을 입력해주세요.");
		}
		return inputCarNames;
	}

	// 기능 2. 자동차 이름이 5자 이하인지 체크
	public void isCarNameValid(String inputCarNames) {
		String[] carNames = inputCarNames.split(",");
		for(String carName : carNames) {
			checkCarNameLength(carName);
		}
	}

	public void checkCarNameLength(String carName) {
		if(carName.length() < 1 || carName.length() > 5) {
			throw new InvalidInputException("[ERROR] 자동차의 이름은 1자 이상 5자 이하만 가능합니다.");
		}
	}

	public void startRace(Integer inputProcessCount) {
		System.out.println("inputProcessCount : " + inputProcessCount);
		for(int i=0; i<10; i++) {
			for(Car car : cars) {
				car.move();
			}
		}
		printRacingStatus();
	}

	public void printRacingStatus() {
		for(Car car : cars) {
			System.out.println(car.toString());
		}
	}

}
