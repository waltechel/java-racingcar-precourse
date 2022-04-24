package racingcar;

import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
import racingcar.vo.Car;
import racingcar.vo.Race;
import racingcar.vo.Time;

public class Application {

	public static void main(String[] args) {

		Race race;
		boolean needToRepeat = false;
		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String line = Console.readLine();
			StringTokenizer st = new StringTokenizer(line, ",");
			race = new Race();
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
				race.enter(new Car(name));
			}
		} while (needToRepeat);

		Time time;
		needToRepeat = false;
		do {
			System.out.println("시도할 횟수는 몇회인가요?");
			String input = Console.readLine();
			if (input == null || "".equals(input)) {
				needToRepeat = true;
				System.out.println("[ERROR] : 시도할 횟수가 입력되지 않았습니다.");
			}
			if (!input.matches("[0-9]+")) {
				needToRepeat = true;
				System.out.println("[ERROR] : 숫자 이외의 문자가 입력되었습니다.");
			}
			time = new Time(Integer.parseInt(input));
		} while (needToRepeat);

		race.start(time);

		System.out.print("최종 우승자: ");
		List<Car> winners = race.getWinners();
		for (int i = 0; i < winners.size(); i++) {
			System.out.println(winners.get(i) + (i != winners.size() - 1 ? "," : ""));
		}

	}
}
