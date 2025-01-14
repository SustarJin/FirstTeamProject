package hr.main;

import java.util.List;
import java.util.Scanner;

import hr.dao.EmployeeDAO;
import hr.dao.HistoryDAO;
import hr.dao.ReviewDAO;
import hr.dao.SalaryInfoDAO;
import hr.dao.SalaryPaymentDAO;
import hr.dao.WorkDAO;
import hr.dao.YearDAO;
import hr.vo.HistoryVO;
import hr.vo.WorkVO;
import hr.vo.YearVO;

public class HrReadMain {

	private Scanner sc;
	public static String id; // 직원 번호 받을 필드
	public static int no;
	private EmployeeDAO edao;
	private HistoryDAO hdao;
	private WorkDAO wdao;
	private YearDAO ydao;
	private SalaryInfoDAO sdao;
	private SalaryPaymentDAO spdao;
	private ReviewDAO rdao;

	public HrReadMain() {
		sc = new Scanner(System.in);
		wdao = new WorkDAO();
		ydao = new YearDAO();
		hdao = new HistoryDAO();
	}

	public void pmReader() {
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║            MENU           ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println("  1. 직원 정보 조회   2. 근태 조회 ");
		System.out.println("  3. 급여 조회        4. 인사고과 조회 ");
		System.out.println("  5. 시스템 종료");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("     1번 ~ 5번을 선택해주세요.  ");
		System.out.println("--------------------------------");
		System.out.println();

	}

	public void emView() {
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║       직원 조회 메뉴      ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println("  1. 직원 전체 목록  2. 히스토리 목록");
		System.out.println("  3. 메인 메뉴                       ");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("     1번 ~ 3번을 선택해주세요.  ");
		System.out.println("--------------------------------");
		System.out.println();

	}

	public void emList() {
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║       직원 전체 목록      ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println("────────────────────────────────────────────────────────");
		System.out.println(" NO. |  직원번호 | 직원이름  |  성별 |  부서번호 | 직급 ");
		System.out.println("────────────────────────────────────────────────────────");
		System.out.println("  1  |           |           |      |            |      ");
		System.out.println("────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println(" < 상세조회가 필요하면 아래 메뉴를 선택해주세요. >");
		System.out.println();
		System.out.println(" 1. 부서별 조회  2. 직급별 조회");
		System.out.println(" 3. 개별 조회    4. 직원조회 메뉴");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();

		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║     부서별 직원 조회      ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println("  1. 생산팀(D1)     2. 인사팀(D2)");
		System.out.println("  3. 품질관리팀(D3) 4. 경리팀(D4) ");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();
		System.out.println("─────────────────────────────────────────────────────");
		System.out.println(" NO. |직원번호 |  직원이름 |  성별 |  부서번호 | 직급 ");
		System.out.println("─────────────────────────────────────────────────────");
		System.out.println("  1  |        |           |       |           |       ");
		System.out.println("─────────────────────────────────────────────────────");
		System.out.println();
		System.out.println();
		System.out.println("  1. 개별 조회  2. 직원 조회 메뉴");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();

		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║      직급별 직원 조회　　 ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println("  1. 사원   2. 대리");
		System.out.println("  3. 과장   4. 부장");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();
		System.out.println("────────────────────────────────────────────────────────");
		System.out.println(" NO. |직원번호 | 직원이름  |  성별 |  부서번호  | 직급 ");
		System.out.println("────────────────────────────────────────────────────────");
		System.out.println("  1  |         |            |       |           |      ");
		System.out.println("────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println();
		System.out.println("  1. 개별 조회  2. 직원 조회 메뉴");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();

	}

	public void emDetail(String emid) {
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║      직원 개별 조회       ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println("  💡 직원번호를 입력하세요 >>  ");
		System.out.println();
		System.out.println(
				"─────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("  NO. |직원번호 | 직원이름 | 성별 | 생년월일 | 연락처 | 입사일자 | 부서번호 | 직급  | 주소");
		System.out.println(
				"─────────────────────────────────────────────────────────────────────────────────────────────");
		System.out
				.println("  1  |          |          |      |          |         |          |         |       |      ");
		System.out.println(
				"─────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println("  1. 정보 수정  2. 정보 삭제  3. 직원 조회 메뉴");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();

	}

	public void hisAllList() {
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║     히스토리 전체 목록    ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		List<HistoryVO> list = hdao.hisSelect();
		System.out.println("─────────────────────────────────────────────────");
		System.out.println(" NO.| 직원번호 | 직원이름 | 부서이름 |   구분    ");
		System.out.println("─────────────────────────────────────────────────");
		if (list.size() > 0) { // list의 사이즈가 0보다 크면 즉, list에 값이 들어있으면 목록 조회
			for (HistoryVO hvo : list) { // list를 끝까지 반복
				System.out.println("  " + hvo.getHno() + "  | " + hvo.getEmid() + " |  " + hvo.getName() + "  |  "
						+ hvo.getDname() + "  | " + hvo.getRemark());
				System.out.println("────────────────────────────────────────────────");
			}
		}
		System.out.println();
		System.out.println(" < 상세조회가 필요하면 아래 메뉴를 선택해주세요. >");
		System.out.println();
		System.out.println("  1. 개별 조회  2. 직원조회 메뉴");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		
		int input = sc.nextInt(); // 번호 선택 입력값
		switch (input) {
		case 1: 	// 1 입력 시 히스토리 개별 조회
			hisList(id);
			break;
		case 2: 	// 2 입력 시 직원 조회 메뉴로 돌아감
			emView();
		} // switch end
		System.out.println();

	}

	public void hisList(String emid) {
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║     히스토리 개별 조회    ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.print("  💡 직원번호를 입력하세요 >>  ");
		emid = sc.next(); 							 // 개별 조회할 직원 번호 입력받고
		List<HistoryVO> list = hdao.hisSelect(emid); // select()메소드 호출해서 반환되는 값을 저장한 후 화면에 표시
		System.out.println();
		System.out.println("────────────────────────────────────────────────────────────────────────");
		System.out.println(" NO.| 직원번호 | 직원이름 | 부서이름 | 시작 날짜  |  종료 날짜  |  구분    ");
		System.out.println("─────────────────────────────────────────────────────────────────────────");
		if (list.size() > 0) { 			 // list의 사이즈가 0보다 크면 즉, list에 값이 들어있으면 목록 조회
			for (HistoryVO hvo : list) { // list를 끝까지 반복
				System.out.println("  " + hvo.getHno() + "  | " + hvo.getEmid() + " |  " + hvo.getName() + "  | "
						+ hvo.getDname() + " |   " + hvo.getLeaveStart() + "    |  " + hvo.getLeaveFin() + "   | "
						+ hvo.getRemark());
				System.out.println("──────────────────────────────────────────────────────────────────────────────────");
			}
		}
		System.out.println();
		hisDetail();
		
	}

	public void hisDetail() {
		
		System.out.print("  💡 조회할 번호 선택(숫자 입력) >> ");
		no = sc.nextInt();
		HistoryVO hvo = hdao.hisSelect(no);
		
		System.out.println();
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║     히스토리 상세 조회    ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		if (hvo != null) {
		System.out.println("────────────────────────────────────────────────────────────────────────");
		System.out.println(" NO.| 직원번호 | 직원이름 | 부서코드 | 시작 날짜  |  종료 날짜  | 구분   ");
		System.out.println("─────────────────────────────────────────────────────────────────────────");
		System.out.println("  " + hvo.getHno() + " | " + hvo.getEmid() + " |  " + hvo.getName() + "  | "
				+ hvo.getDname() + " |   " + hvo.getLeaveStart() + "    |  " + hvo.getLeaveFin() + "   | "
				+ hvo.getRemark());
		System.out.println("──────────────────────────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println("  1. 정보 수정  2. 정보 삭제  3. 직원 조회 메뉴");
		System.out.println();
		System.out.print("  💡 선택(숫자 입력) >> ");
		
		int num = sc.nextInt(); // 세부 메뉴 번호 받기
		HrAdminMain hra = new HrAdminMain();
		switch (num) {
		case 1:				// 1 입력 시 HrAdminMain에 있는 yearModify() 실행
			hra.historyModify(no);
			break; 
		case 2:				// 2 입력 시 HrAdminMain에 있는 yearRemove() 실행
			hra.historyRemove(no);
			break; 
		case 3:				// 3 입력 시 직원 조회 메뉴로 돌아감
			emView();
			break; 
		default: 			// 다른 값 입력 시 메시지 출력 후 다시 조회 메뉴 메서드 호출
			System.out.println();
			System.out.println("--------------------------------");
			System.out.println("     1번 ~ 3번을 선택해주세요.  ");
			System.out.println("--------------------------------");
			System.out.println();
			hisDetail();
		} // switch end
		}	// if end
	}

	public void workView() { // 근태에 관련된 내용 조회 메뉴
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║       근태 조회 메뉴      ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println("  1. 근태 기록 목록  ");
		System.out.println("  2. 연차 승인 내역 목록 ");
		System.out.println("  3. 메인 메뉴 ");
		System.out.println();
		System.out.print("  💡 선택(숫자 입력) >> ");

		int input = sc.nextInt(); // 번호 선택 입력값
		switch (input) {
		case 1: // 1 입력 시 근태 기록 전체 목록
			workList();
			break;
		case 2: // 2 입력 시 연차 승인 내역 전체 목록
			yearAllList();
			break;
		case 3: // 3 입력 시 메인 메뉴로 돌아감
			pmReader();
			break;
		default: // 다른 값 입력 시 메시지 출력 후 다시 조회 메뉴 메서드 호출
			System.out.println();
			System.out.println("--------------------------------");
			System.out.println("     1번 ~ 3번을 선택해주세요.  ");
			System.out.println("--------------------------------");
			System.out.println();
			workView();
		} // switch end

	}

	public void workList() { // 모든 직원의 근태 기록 목록
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║      근태기록 전체 목록    	  ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		List<WorkVO> list = wdao.WorkSelect();
		System.out.println("─────────────────────────────────────────────────────────");
		System.out.println(" 직원번호 | 직원이름 | 지각일수 | 조퇴일수 | 결근일수 | 잔여연차일수  ");
		System.out.println("─────────────────────────────────────────────────────────");
		if (list.size() > 0) { // list의 사이즈가 0보다 크면 즉, list에 값이 들어있으면 목록 조회
			for (WorkVO wvo : list) { // list를 끝까지 반복
				System.out.println("  " + wvo.getEmid() + " | " + wvo.getName() + "  |   " + wvo.getLate() + "   |   "
						+ wvo.getEarly() + "    |   " + wvo.getAbs() + "   |   " + wvo.getUnusedAnn());
				System.out.println("─────────────────────────────────────────────────────────");
			} // for end
		} // if end
		System.out.println();
		System.out.println(" < 상세조회가 필요하면 아래 메뉴를 선택해주세요. >");
		System.out.println();
		System.out.println("  1. 개별 조회  2. 근태조회 메뉴");
		System.out.println();
		System.out.print("  💡 선택(숫자 입력) >> ");

		int input = sc.nextInt(); // 번호 선택 입력값
		switch (input) {
		case 1: // 1 입력 시 근태 기록 개별 조회
			workDetail();
			break;
		case 2: // 2 입력 시 근태 조회 메뉴로 돌아감
			workView();
		} // switch end
		System.out.println();

	}

	public void workDetail() { // 한 명의 근태 기록 조회
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║   	  근태 기록 개별 조회    	  ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.print("  💡 직원번호를 입력하세요 >>  ");
		id = sc.next(); // 개별 조회할 직원 번호 입력받고
		WorkVO wvo = wdao.WorkSelect(id); // 입력받은 번호의 데이터들을 select해서 wvo로 보내기
		System.out.println();

		if (wvo != null) {
			System.out.println("──────────────────────────────────────────────────────────────────────────────────────");
			System.out.println(" 직원번호 | 직원이름 | 근속년수 | 지각일수 | 조퇴일수 | 결근일수 | 사용가능연차일수 | 사용연차일수 | 잔여연차일수                ");
			System.out.println("──────────────────────────────────────────────────────────────────────────────────────");
			System.out.println(" " + wvo.getEmid() + " |  " + wvo.getName() + "  |   " + wvo.getCont() + "   |   " 
			+ wvo.getLate() + "   |   "
					+ wvo.getEarly() + "    |   " + wvo.getAbs() + "   |      " + wvo.getAvAnn() + "      |     "
					+ wvo.getUsedAnn() + "     |    " + wvo.getUnusedAnn());
			System.out.println("──────────────────────────────────────────────────────────────────────────────────────");
			System.out.println();
			System.out.println("  1. 근태 기록 수정  2. 근태 기록 삭제  3. 근태 조회 메뉴");
			System.out.println();
			System.out.print("  💡 선택(숫자 입력) >> ");
			int num = sc.nextInt(); // 세부 메뉴 번호 받기
			HrAdminMain hra = new HrAdminMain();
			switch (num) {
			case 1:
				hra.workModify();
				break; // 1 입력 시 HrAdminMain에 있는 workModify() 실행
			case 2:
				hra.workRemove(id);
				break; // 2 입력 시 HrAdminMain에 있는 workRemove() 실행
			case 3:
				workView();
				break; // 3 입력 시 근태 조회 메뉴로 돌아감
			default: // 다른 값 입력 시 메시지 출력 후 다시 조회 메뉴 메서드 호출
				System.out.println();
				System.out.println("--------------------------------");
				System.out.println("     1번 ~ 3번을 선택해주세요.  ");
				System.out.println("--------------------------------");
				System.out.println();
				workDetail();
			} // switch end
		} // if end
		System.out.println();
	}

	public void yearAllList() {		// 모든 직원의 연차 승인 내역 목록
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║    	  연차 승인 내역 목록    	  ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		List<YearVO> list = ydao.yearSelect();
		System.out.println("────────────────────────────────────────────────");
		System.out.println("  NO | 직원번호 | 직원이름 | 연차승인자 | 연차승인일자");
		System.out.println("────────────────────────────────────────────────");
		if (list.size() > 0) { // list의 사이즈가 0보다 크면 즉, list에 값이 들어있으면 목록 조회
			for (YearVO yvo : list) { // list를 끝까지 반복
				System.out.println("  " + yvo.getYno() + "  | " + yvo.getEmid() + " |  " + yvo.getName() + "  |  "
						+ yvo.getApp() + "  | " + yvo.getAppDate());
				System.out.println("────────────────────────────────────────────────");
			}
		}
		System.out.println();
		System.out.println(" < 상세조회가 필요하면 아래 메뉴를 선택해주세요. >");
		System.out.println();
		System.out.println("  1. 개별 조회  2. 근태 조회 메뉴");
		System.out.println();
		System.out.print("  💡 선택(숫자 입력) >> ");

		int input = sc.nextInt(); // 번호 선택 입력값
		switch (input) {
		case 1: // 1 입력 시 연차 승인 내역 개별 조회
			yearList(id);
			break;
		case 2: // 2 입력 시 근태 조회 메뉴로 돌아감
			workView();
		} // switch end

		System.out.println();

	}

	public void yearList(String emid) { // 연차 승인 내역 개별 조회
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║    	  연차 승인 내역 조회    	  ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.print("  💡 직원번호를 입력하세요 >>  ");

		emid = sc.next(); // 개별 조회할 직원 번호 입력받고
		List<YearVO> list = ydao.yearSelect(emid); // select()메소드 호출해서 반환되는 값을 저장한 후 화면에 표시
		System.out.println();
		System.out.println("──────────────────────────────────────────────────────────────────────────────────");
		System.out.println(" NO  | 직원번호 | 직원이름 | 연차사용일자 | 연차사용일수 | 연차승인자 | 연차승인일자");
		System.out.println("──────────────────────────────────────────────────────────────────────────────────");
		if (list.size() > 0) { // list의 사이즈가 0보다 크면 즉, list에 값이 들어있으면 목록 조회
			for (YearVO yvo : list) { // list를 끝까지 반복
				System.out.println("  " + yvo.getYno() + "  | " + yvo.getEmid() + " |  " + yvo.getName() + "  | "
						+ yvo.getYearDate() + " |   " + yvo.getYearCnt() + "    |  " + yvo.getApp() + "   | "
						+ yvo.getAppDate());
				System.out.println("──────────────────────────────────────────────────────────────────────────────────");
			}
		}
		yearDetail();

	}

	public void yearDetail() {		// 개인 연차 승인 내역 중 상세 조회
		System.out.println();
		System.out.print("  💡 조회할 번호 선택(숫자 입력) >> ");

		no = sc.nextInt();
		YearVO yvo = ydao.yearSelect(no);
		System.out.println();
		System.out.println("  ╔════════════════════════════╗"); // 2칸씩
		System.out.println("  ║  	연차 승인 내역 상세 조회  	   ║");
		System.out.println("  ╚════════════════════════════╝");
		System.out.println();
		if (yvo != null) {
			System.out.println("──────────────────────────────────────────────────────────────────────────────────");
			System.out.println(" NO | 직원번호 | 직원이름 | 연차사용일자 | 연차사용일수 | 연차승인자 | 연차승인일자");
			System.out.println("──────────────────────────────────────────────────────────────────────────────────");
			System.out.println("  " + yvo.getYno() + " | " + yvo.getEmid() + " |  " + yvo.getName() + "  | "
					+ yvo.getYearDate() + " |   " + yvo.getYearCnt() + "    |  " + yvo.getApp() + "   | "
					+ yvo.getAppDate());
			System.out.println("──────────────────────────────────────────────────────────────────────────────────");
			System.out.println();
			System.out.println("  1. 연차 승인 내역 수정  2. 연차 승인 내역 삭제  3. 근태 조회 메뉴");
			System.out.println();
			System.out.print("  💡 선택(숫자 입력) >> ");

			int num = sc.nextInt(); // 세부 메뉴 번호 받기
			HrAdminMain hra = new HrAdminMain();
			switch (num) {
			case 1:				// 1 입력 시 HrAdminMain에 있는 yearModify() 실행
				hra.yearModify();
				break; 
			case 2:				// 2 입력 시 HrAdminMain에 있는 yearRemove() 실행
				hra.yearRemove(no);
				break; 
			case 3:				// 3 입력 시 근태 조회 메뉴로 돌아감
				workView();
				break; 
			default: 			// 다른 값 입력 시 메시지 출력 후 다시 조회 메뉴 메서드 호출
				System.out.println();
				System.out.println("--------------------------------");
				System.out.println("     1번 ~ 3번을 선택해주세요.  ");
				System.out.println("--------------------------------");
				System.out.println();
				workDetail();
			} // switch end
		}	// if end
	}

	public void salMain() {
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║       급여 조회 메뉴      ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println("  1.급여 정보 전체 목록");
		System.out.println("  2.급여 지급 내역 전체 목록");
		System.out.println("  3.메인메뉴");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("     1번 ~ 3번을 선택해주세요.  ");
		System.out.println("--------------------------------");
		System.out.println();
	}

	public void salInfoList() {
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║     급여정보 전체 목록    ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println("───────────────────────────────────────────");
		System.out.println(" NO. | 직원번호 | 직원이름 | 기본급(호봉)  ");
		System.out.println("───────────────────────────────────────────");
		System.out.println("  1  |          |          |               ");
		System.out.println("───────────────────────────────────────────");
		System.out.println("  2  |          |          |               ");
		System.out.println("───────────────────────────────────────────");
		System.out.println();
		System.out.println(" < 상세조회가 필요하면 아래 메뉴를 선택해주세요. >");
		System.out.println();
		System.out.println("   1. 개별 조회  2. 급여 조회 메뉴");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();

	}

	public void salInfoDetail(String emid) {
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║     급여정보 개별 조회    ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println("  💡 직원번호를 입력하세요 >>  ");
		System.out.println();
		System.out.println("─────────────────────────────────────────────────────────────────────");
		System.out.println(" NO. | 직원번호 | 직원이름 | 기본급(호봉) | 은행명 | 예금주 | 계좌번호");
		System.out.println("─────────────────────────────────────────────────────────────────────");
		System.out.println(" 1   |         |          |              |        |        |         ");
		System.out.println("─────────────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println();
		System.out.println("  1. 급여 정보 수정  2. 급여 정보 삭제  3. 급여 조회 메뉴");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();

	}

	public void salPayAllList() {
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║    급여 지급 내역 목록    ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println("────────────────────────────────────");
		System.out.println(" NO. | 직원번호 | 지급일시 |  총급여 ");
		System.out.println("────────────────────────────────────");
		System.out.println(" 1   |         |          |          ");
		System.out.println("────────────────────────────────────");
		System.out.println();
		System.out.println(" < 상세조회가 필요하면 아래 메뉴를 선택해주세요. >");
		System.out.println();
		System.out.println("  1. 개별 조회  2. 급여 조회 메뉴");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();

	}

	public void salPayList(String emid) {
		System.out.println("  ╔═════════════════════════════╗"); // 2칸씩
		System.out.println("  ║   급여 지급 내역 개별 조회  ║");
		System.out.println("  ╚═════════════════════════════╝");
		System.out.println();
		System.out.println("  💡 직원번호를 입력하세요 >>  ");
		System.out.println();
		System.out.println("─────────────────────────────────────────────────────────");
		System.out.println(" NO. |직원번호 | 지급일시 | 기본급(호봉) | 상여금 | 총급여 ");
		System.out.println("─────────────────────────────────────────────────────────");
		System.out.println("  1  |        |          |              |        |        ");
		System.out.println("─────────────────────────────────────────────────────────");
		System.out.println("  2  |        |          |              |        |        ");
		System.out.println("─────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println();
		System.out.println("  💡 조회할 번호 선택(숫자 입력) >> ");
		System.out.println();

	}

	public void salPayDetail() {
		System.out.println("  ╔═════════════════════════════╗"); // 2칸씩
		System.out.println("  ║  급여 지급 내역 상세 조회   ║");
		System.out.println("  ╚═════════════════════════════╝");
		System.out.println();
		System.out.println("──────────────────────────────────────────────────────");
		System.out.println(" NO. |직원번호 | 지급일시 | 기본급(호봉) | 상여금 | 총급여 ");
		System.out.println("──────────────────────────────────────────────────────");
		System.out.println("  1  |        |          |              |        |        ");
		System.out.println("──────────────────────────────────────────────────────");
		System.out.println();
		System.out.println("   1. 급여 지급 내역 수정  2. 급여 지급 내역 삭제  3. 급여 조회 메뉴");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();

	}

	public void revView() {
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║     인사 고과 조회 메뉴   ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println("  1. 평가기록 전체 목록");
		System.out.println("  2. 평가기록 개별 조회");
		System.out.println("  3. 메인메뉴");
		System.out.println();
		System.out.println(" 💡 선택(숫자 입력) >> ");
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("     1번 ~ 3번을 선택해주세요.  ");
		System.out.println("--------------------------------");
		System.out.println();

	}

	public void revAllList() {
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║     인사고과 전체 목록    ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println("───────────────────────────────────────────────────");
		System.out.println(" NO | 직원번호 | 부서번호  | 직급  | 평가등급|평가일시 ");
		System.out.println("───────────────────────────────────────────────────");
		System.out.println(" 1  |         |          |        |         |          ");
		System.out.println("───────────────────────────────────────────────────");
		System.out.println(" 2  |         |          |        |         |          ");
		System.out.println("───────────────────────────────────────────────────");
		System.out.println();
		System.out.println(" < 상세조회가 필요하면 아래 메뉴를 선택해주세요. >");
		System.out.println();
		System.out.println(" 1. 부서별 조회  2. 직급별 조회");
		System.out.println(" 3. 연도별 조회  4. 개별 조회");
		System.out.println(" 5. 인사고과 조회 메뉴");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();

		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║    부서별 인사고과 조회   ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println("  1. 생산팀(D1)   2. 인사팀(D2)");
		System.out.println("  3. 품질관리팀(D3) 4. 경리팀(D4) ");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();
		System.out.println("───────────────────────────────────────────────────");
		System.out.println(" NO. |직원번호 | 부서번호  | 직급  | 평가등급|평가일시 ");
		System.out.println("───────────────────────────────────────────────────");
		System.out.println("  1  |         |          |        |         |          ");
		System.out.println("───────────────────────────────────────────────────");
		System.out.println();
		System.out.println("  1. 개별 조회  2. 인사고과 조회 메뉴");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();

		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║    직급별 인사고과 조회   ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println("  1. 사원   2. 대리");
		System.out.println("  3. 과장   4. 부장");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();
		System.out.println("───────────────────────────────────────────────────");
		System.out.println(" NO. |직원번호 | 부서번호  | 직급  | 평가등급|평가일시 ");
		System.out.println("───────────────────────────────────────────────────");
		System.out.println("  1  |         |          |        |         |          ");
		System.out.println("───────────────────────────────────────────────────");
		System.out.println();
		System.out.println("  1. 개별 조회  2. 인사고과 조회 메뉴");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();

		System.out.println("  ╔══════════════════════════════╗"); // 2칸씩
		System.out.println("  ║      연도별 인사고과 조회    ║");
		System.out.println("  ╠══════════════════════════════║");
		System.out.println("  ║ 기록은 평가일로부터 3년 유효 ║");
		System.out.println("  ╚══════════════════════════════╝");
		System.out.println();
		System.out.println("  💡 연도를 입력하세요(숫자 입력) >>  ");
		System.out.println();
		System.out.println("───────────────────────────────────────────────────");
		System.out.println(" NO. |직원번호 | 부서번호  | 직급  | 평가등급|평가일시 ");
		System.out.println("───────────────────────────────────────────────────");
		System.out.println("  1  |         |          |        |         |          ");
		System.out.println("───────────────────────────────────────────────────");
		System.out.println();
		System.out.println("  1. 개별 조회   2. 인사고과 조회 메뉴");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();

	}

	public void revLiet(String emid) {
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║     인사고과 개별 조회    ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println("  💡 직원번호를 입력하세요 >>  ");
		System.out.println();
		System.out.println(
				"─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println(" NO.| 직원번호 | 부서번호 | 직급 | 관리능력 | 유대관계 | 책임감 | 근면성 | 업무지식 | 총점수 | 평가등급 | 비고 |평가일시");
		System.out.println(
				"─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println(
				"  1 |          |          |      |           |         |        |        |          |      |            |       |");
		System.out.println(
				"─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println(
				"  2 |          |          |      |           |         |        |        |          |      |            |       |");
		System.out.println(
				"─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println("  💡 조회할 번호 선택(숫자 입력) >> ");
		System.out.println();

	}

	public void revDetail() {
		System.out.println("  ╔═══════════════════════════╗"); // 2칸씩
		System.out.println("  ║     인사고과 상세 조회    ║");
		System.out.println("  ╚═══════════════════════════╝");
		System.out.println();
		System.out.println(
				"─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println(" NO.| 직원번호 | 부서번호 | 직급 | 관리능력 | 유대관계 | 책임감 | 근면성 | 업무지식 | 총점수 | 평가등급 | 비고 |평가일시");
		System.out.println(
				"─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println(
				"  1 |          |          |      |           |         |        |        |          |      |            |       |");
		System.out.println(
				"─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println("  1. 평가 수정  2. 평가 삭제  3. 인사고과 조회 메뉴");
		System.out.println();
		System.out.println("  💡 선택(숫자 입력) >> ");
		System.out.println();

	}

//	System.out.println("--------------------------------");
//	System.out.println("  💡 시스템을 종료하시겠습니까? ( Y | N )");
//	System.out.println("  💡 >> ");
//	System.out.println("--------------------------------");
//  System.out.println("       1번이나 2번을 선택하세요.     ");
//  System.out.println("--------------------------------");

//	public static void main(String[] args) {	// 근태 조회 메뉴 시험 메서드
//		HrReadMain hrr = new HrReadMain();
//		hrr.workView();
//	}
}