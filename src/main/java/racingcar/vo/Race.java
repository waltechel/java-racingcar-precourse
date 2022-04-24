package racingcar.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {

	List<Car> cars;

	public Race(List<Car> cars) {
		super();
		this.cars = cars;
	}

	public Race() {
		cars = new ArrayList<>();
	}

	public void enter(Car car) {
		cars.add(car);
	}

	public void relay() {
		for (Car car : cars) {
			car.go();
		}
	}

	public void broadCastProgress() {
		for (Car car : cars) {
			System.out.println(car.toString());
		}
		System.out.println();
	}

	public int calculateHigh() {
		Collections.sort(cars, (c1, c2) -> Integer.compare(c1.getCount(), c2.getCount()) * -1);
		return cars.get(0).getCount();
	}

	public List<Car> getWinners() {
		int index = this.getWinnersLastIndex();
		return cars.subList(0, index);
	}

	// 이 부분은 인덴트 원칙에 어긋난다. 어떻게 비교를 안할 수 있지?
	private int getWinnersLastIndex() {
		int max = this.calculateHigh();
		int ret = 1;
		for (ret = 1; ret <= cars.size(); ret++) {
			if (ret == cars.size() || max > cars.get(ret).getCount())
				break;
		}
		return ret;
	}

	public void start(Time time) {
		System.out.println("실행 결과");
		for (int i = 0; i < time.getValue(); i++) {
			this.relay();
			this.broadCastProgress();
		}
	}

}
