package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Application {

	public static void main(String[] args) {

		List<Car> list ;
		boolean needToRepeat = false;
		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String line = Console.readLine();
			StringTokenizer st = new StringTokenizer(line, ",");
			list = new ArrayList<>();
			while (st.hasMoreTokens()) {
				String name = st.nextToken();
				if (name == null || "".equals(name)) {
					needToRepeat = true;
					System.out.println("[ERROR] : 이름이 입력되지 않았습니다.");
				}
				if (name.length() > 5) {
					needToRepeat = true;
					System.out.println("[ERROR] : 이름이 5자 이상입니다.");
				}
				list.add(new Car(name));
			}
		} while (needToRepeat);

		int time;
		needToRepeat = false;
		do {
			System.out.println("시도할 횟수는 몇회인가요?");
			String input = Console.readLine();
			if (input == null || "".equals(input)) {
				needToRepeat = true;
				System.out.println("[ERROR] : 시도할 횟수가 입력되지 않았습니다.");
			}
			if(!input.matches("[0-9]+")) {
				needToRepeat = true;
				System.out.println("[ERROR] : 숫자 이외의 문자가 입력되었습니다.");
			}
			time = Integer.parseInt(input);
		} while (needToRepeat);

		System.out.println("실행 결과");
		for (int i = 0; i < time; i++) {
			for (Car car : list) {
				car.go();
			}
			for (Car car : list) {
				System.out.println(car.toString());
			}
			System.out.println();
		}

		System.out.print("최종 우승자: ");
		Optional<Integer> max = list.stream().map(a -> a.count).max((a, b) -> Integer.compare(a, b));
		if (max.isPresent()) {
			String answer = list.stream().filter(car -> car.count == max.get()).map(car -> car.name).collect(Collectors.joining(","));
			System.out.println(answer);
		}
	}
}
