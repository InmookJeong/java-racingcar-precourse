package utils;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberUtilTest {

	@Test
	@DisplayName("인자로 전달된 값이 0~9 사이의 숫자인지 확인")
	void isMinToMaxNumeric() {
		assertThat(NumberUtil.isMinToMaxNumeric(1, 0, 9)).isTrue();
		assertThat(NumberUtil.isMinToMaxNumeric(5, 0, 9)).isTrue();
		assertThat(NumberUtil.isMinToMaxNumeric(9, 0, 9)).isTrue();
		assertThat(NumberUtil.isMinToMaxNumeric(0, 0, 9)).isTrue();
		assertThat(NumberUtil.isMinToMaxNumeric(10, 0, 9)).isFalse();
	}
}
