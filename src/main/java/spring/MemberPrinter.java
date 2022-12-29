package spring;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberPrinter {

	// 날짜 출력 형식을 지정하는 필드를 추가

	private DateTimeFormatter dateTimeFormatter;

	public MemberPrinter() {
		this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyy년 MM월 dd일");
	}

	@Autowired
	public void setDateTimeFormatter(Optional<DateTimeFormatter> dateTimeFormatter) {
		// 빈 존재 여부에 따라 의존 객체를 사용하도록 코딩
		if (dateTimeFormatter.isPresent()) {
			this.dateTimeFormatter = dateTimeFormatter.get();
		} else {
			this.dateTimeFormatter = null;
		}
	}

	public void print(Member member) {
		if (dateTimeFormatter == null) {
			System.out.printf("회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", member.getId(), member.getEmail(),
					member.getName(), member.getRegisterDateTime());
		} else {
			System.out.printf("회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", member.getId(), member.getEmail(),
					member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}
}