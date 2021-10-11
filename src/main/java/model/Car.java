package model;

import nextstep.utils.Randoms;

public class Car {
	private String name;
	private Integer progressNo;

	public Car(String name) {
		this.name = name;
		this.progressNo = 0;
	}

	// TODO : 기능 5. 임의의 숫자를 가져와 전진할 것인지 체크
	public void move() {
		int randomNo = Randoms.pickNumberInRange(0, 9);
		if(randomNo >= 4) {
			progressNo += 1;
		}
	}

	@Override
	public String toString() {
		String move = "";
		for(int i=0; i<this.progressNo; i++) {
			move += "-";
		}
		return this.name + " : " + move;
	}
}
