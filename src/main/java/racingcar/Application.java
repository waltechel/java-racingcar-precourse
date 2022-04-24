package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Application {

	public static void main(String[] args) {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String line = Console.readLine();
		StringTokenizer st = new StringTokenizer(line, ",");
		List<Car> list = new ArrayList<>();
		while (st.hasMoreTokens()) {
			String name = st.nextToken();
			list.add(new Car(name));
		}
		System.out.println("시도할 횟수는 몇회인가요?");
		int time = Integer.parseInt(Console.readLine());
		for (int i = 0; i < time; i++) {
			for (Car car : list) {
				car.go();
			}
		}
		System.out.print("최종 우승자:");
		Optional<Integer> max = list.stream().map(a -> a.count).max((a, b) -> Integer.compare(a, b));
		if (max.isPresent()) {
			String answer = list.stream().filter(car -> car.count == max.get()).map(car -> car.name).collect(Collectors.joining(","));
			System.out.println(answer);
		}
	}
}
