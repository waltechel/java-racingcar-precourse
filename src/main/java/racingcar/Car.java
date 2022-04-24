package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

	String name;
	int count;

	public Car(String name) {
		super();
		this.name = name;
		this.count = 0;
	}

	public Car(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", count=" + count + "]";
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void go() {
		int num = Randoms.pickNumberInRange(0, 10);
		if (num >= 4) {
			this.count++;
		}
	}

}
