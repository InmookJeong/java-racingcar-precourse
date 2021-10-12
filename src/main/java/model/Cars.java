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
			isCarNameValid(isEmptyCarName(inputCarNames.trim()));
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
			inputCarNames = getNames();
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
		System.out.println("\n실행결과");
		while (getFinishedCar(inputProcessCount).size() == 0) {
			moveCars();
			printRacingStatus();
		}
		printFinishedCarNames(inputProcessCount);
	}

	public void moveCars() {
		for(Car car : this.cars) {
			car.move();
		}
	}

	public void printRacingStatus() {
		for(Car car : cars) {
			System.out.println(car.toString());
		}
		System.out.println();
	}

	// 기능 8. 자동차 전진횟수 중 시도횟수와 일치하는 값이 있는지 확인
	// 즉, 종료된 자동차가 있는지 확인
	public List<Car> getFinishedCar(Integer inputProcessCount) {
		List<Car> finishedCars = new ArrayList<Car>();
		for(Car car : cars) {
			finishedCars = addFinishedCar(finishedCars, car, inputProcessCount);
		}
		return finishedCars;
	}
	
	public List<Car> addFinishedCar(List<Car> finishedCars, Car car, Integer inputProcessCount) {
		if(car.isFinished(inputProcessCount)) {
			finishedCars.add(car);
		}
		return finishedCars;
	}

	// 기능 9. 일치하는 값이 있으면 시도횟수에 도달한 자동차의 명단 출력 후 게임 종료
	public void printFinishedCarNames(Integer inputProcessCount) {
		List<Car> finishedCars = getFinishedCar(inputProcessCount);
		String finishedCarNames = "";
		for(Car finishedCar : finishedCars) {
			finishedCarNames += finishedCar.getName() + ",";
		}
		finishedCarNames = finishedCarNames.substring(0, finishedCarNames.lastIndexOf(","));
		System.out.println("최종 우승자는 " + finishedCarNames + " 입니다.");
	}

}
