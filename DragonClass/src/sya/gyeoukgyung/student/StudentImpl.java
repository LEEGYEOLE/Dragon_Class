package sya.gyeoukgyung.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import sya.gyeoukgyung.department.DepartmentDTO;

public class StudentImpl implements Student {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private StudentDAO dao = new StudentDAOImpl();

	/**
	 * 학생 정보 등록 (상세 정보는 선택 가능: 핸드폰, 이메일, 주소) - 관리자
	 */
	@Override
	public void insertStudent() {
		System.out.println("-- 학생 정보 등록...");
		StudentDTO dto = new StudentDTO();
		int result = 0;
		System.out.print("학번 : ");
		try {
			dto.setStudentNo(Integer.parseInt(br.readLine().trim()));
			dto.setHaknyun(1);
			dto.setStatus("재학");
			System.out.print("이름 : ");
			dto.getInfoDTO().setName(br.readLine().trim());
			System.out.print("주민등록번호[ ex)950000-2400000 ] : ");
			String rrn = br.readLine().trim();
			dto.getInfoDTO().setRrn(rrn);
			// 생년월일 구하기
			int juminGubun = rrn.indexOf("-");
			String birthStr = rrn.substring(0, juminGubun);

			int century = Integer.parseInt(rrn.substring(juminGubun + 1, juminGubun + 2));
			if (century == 9 || century == 0) {
				birthStr = "18" + birthStr;
			} else if (century == 1 || century == 2 || century == 5 || century == 6) {
				birthStr = "19" + birthStr;
			} else if (century == 3 || century == 4 || century == 7 || century == 8) {
				birthStr = "20" + birthStr;
			}
			dto.getInfoDTO().setBirth(birthStr);
			// 초기 비번은 생일 4자리
			dto.getInfoDTO().setPassword(dto.getInfoDTO().getRrn().substring(2, 6));
			dto.getInfoDTO().setEntYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

			System.out.print("학과번호 : ");
			dto.getInfoDTO().setDeptNo(Integer.parseInt(br.readLine().trim()));

			System.out.println("상세정보(핸드폰, 이메일, 주소)를 입력하시겠습니까? [ YES는 1, NO는 0 ]");
			int ch;
			do {
				ch = Integer.parseInt(br.readLine().trim());
			} while (ch < 0 || ch > 1);

			if (ch == 1) {
				System.out.print("핸드폰 : ");
				dto.getInfoDTO().setTel(br.readLine().trim());
				System.out.print("이메일 : ");
				dto.getInfoDTO().setEmail(br.readLine().trim());
				System.out.print("주소 : ");
				dto.getInfoDTO().setAddress(br.readLine().trim());

				result = dao.insertStudentOP(dto);
			} else {
				result = dao.insertStudent(dto);
			}
			System.out.println(dto.toString());

		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("중복된 값이 있습니다.");
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("주민등록번호 형식이 잘못되었습니다. ");
		} catch (NumberFormatException e) {
		} catch (IOException e) {
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (result >= 1) {
				System.out.println("학생 등록이 완료되었습니다.");
			} else {
				System.out.println("등록이 실패했습니다.");
			}
		}

	}

	/**
	 * 학생 비번 수정 --관리자 입력: 학번, 변경할 비밀번호 2개
	 */
	@Override
	public void updateStudentPw() {
		System.out.println("-- 학생 비밀번호 수정...");
		System.out.print("학번 입력 > ");
		try {
			int studentNo = Integer.parseInt(br.readLine().trim());
			StudentDTO dto = dao.findByStudentNo(studentNo);
			System.out.print("변경할 비밀번호 > ");
			String chPw = br.readLine().trim();
			System.out.print("비밀번호 확인 > ");
			String chPw1 = br.readLine().trim();

			if (chPw.equals(chPw1)) {
				int n = dao.updateStudentPw(dto.getInfoNo(), chPw);

				if (n >= 1) {
					System.out.println("비밀번호 변경 완료.");
				} else {
					System.out.println("비밀번호 변경 실패.");
				}

			} else {
				System.out.println("변경할 비밀번호가 일치하지 않습니다.");
			}

		} catch (IOException e) {
			System.out.println("잘못된 입력입니다.");
		} catch (NumberFormatException e) {
			System.out.println("학번을 잘못입력하셨습니다.");
		} catch (NullPointerException e) {
			System.out.println("없는 학번입니다.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 학생 정보 삭제 --관리자 입력: 학번, 삭제할지여부
	 */
	@Override
	public void deleteStudent() {
		System.out.println("-- 학생 정보 삭제...");
		System.out.print("학번 입력 > ");
		try {
			int studentNo = Integer.parseInt(br.readLine().trim());
			StudentDTO dto = dao.findByStudentNo(studentNo);
			System.out.println("학생정보:\n" + dto.toString());

			System.out.println("정말 삭제하시겠습니까? [ YES는 0, NO는 1 ]");
			int ch;
			do {
				ch = Integer.parseInt(br.readLine().trim());
			} while (ch < 0 || ch > 1);

			if (ch == 0) {
				int n = dao.deleteStudent(dto.getInfoNo());

				if (n >= 1) {
					System.out.println("학생 삭제 완료.");
				} else {
					System.out.println("학생 삭제 실패.");
				}
			}

		} catch (IOException e) {
			System.out.println("잘못된 입력입니다.");
		} catch (NumberFormatException e) {
			System.out.println("잘못된 입력입니다.");
		} catch (NullPointerException e) {
			System.out.println("없는 학번입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 학생 이름으로 검색 - 관리자
	 */
	@Override
	public void findByName() {
		System.out.println("-- 이름으로 학생 검색...");
		List<StudentDTO> stuList = new ArrayList<>();
		String name = null;

		try {
			System.out.print("이름 > ");

			do {
				name = br.readLine().trim();
			} while ((name == null) || name.length() == 0);

			stuList = dao.findByName(name);

			for (StudentDTO dto : stuList) {
				System.out.println(dto.toString());
			}

		} catch (IOException e) {
			System.out.println("잘못된 입력입니다.");
		} catch (NumberFormatException e) {
			System.out.println("잘못된 입력입니다.");
		} catch (NullPointerException e) {
			System.out.println("해당 학과에 대한 학생 정보가 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 학생 전공으로 검색 - 관리자
	 */
	@Override
	public void findByDept() {
		System.out.println("-- 학과별 학생 검색...");
		List<DepartmentDTO> deptList = new ArrayList<>();
		List<StudentDTO> stuList = new ArrayList<>();
		int chDeptNo = 0;
		int deptNo = 0;
		/*
		 * 전공 다 보여주기 deptList = dept_dao.listDepartment();?
		 */
		System.out.print("학과 선택 > ");
		try {

			// 사용자가 선택한 번호가 전공 개수보다 크거나 0보다 작으면 다시..
			// = 리스트 안에 없는 숫자일경우
			// do {
			chDeptNo = Integer.parseInt(br.readLine().trim());
			// } while (chDeptNo < 0 || chDeptNo > deptList.size());

			// int deptNo = deptList.get(chDeptNo).getDeptNo();
			deptNo = 1;
			// 전공번호로 학생 검색.
			stuList = dao.findByDept(deptNo);

			for (StudentDTO dto : stuList) {
				System.out.println(dto.toString());
			}

		} catch (IOException e) {
			System.out.println("잘못된 입력입니다.");
		} catch (NumberFormatException e) {
			System.out.println("잘못된 입력입니다.");
		} catch (NullPointerException e) {
			// TODO: student 학과별 검색 : 조건 중 deptNo!=1 빼기
			if (deptNo != 1 && deptList.size() == 0)
				System.out.println("학과 정보가 없습니다.");
			else
				System.out.println("해당 학과에 대한 학생 정보가 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void listStudent() {
		System.out.println("-- 모든 학생 검색...");
		List<StudentDTO> list = dao.listStudent();

		if (list.size() == 0) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		System.out.println("학생수: " + list.size());

		Iterator<StudentDTO> it = list.iterator();
		while (it.hasNext()) {
			System.out.println("나옴");
			StudentDTO dto = it.next();
			System.out.print(dto.toString());
		}

		System.out.println();

	}

	/**
	 * 내 상세정보 수정(핸드폰, 이메일, 주소) - 학생
	 */
	@Override
	public void updateStudent(StudentDTO currDto) {
		System.out.println("-- 상세정보 수정...");
		int result = 0;

		try {
			StudentDTO dto = dao.findByStudentNo(currDto.getStudentNo());
			System.out.println("학생정보:\n" + dto.toString());

			System.out.println("\n수정할 정보 입력:::");
			System.out.print("핸드폰 : ");
			dto.getInfoDTO().setTel(br.readLine().trim());
			System.out.print("이메일 : ");
			dto.getInfoDTO().setEmail(br.readLine().trim());
			System.out.print("주소 : ");
			dto.getInfoDTO().setAddress(br.readLine().trim());

			result = dao.updateStudent(dto);

			if (result >= 1) {
				System.out.println("학생정보 변경 완료.");
			} else {
				System.out.println("학생정보 변경 실패.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 내 비밀번호 수정 -학생
	 */
	@Override
	public void updateStudentPw(StudentDTO dto) {
		System.out.println("-- 내 비밀번호 수정...");
		System.out.print("기존 비밀번호 > ");
		try {
			String nowPw = br.readLine().trim();
			if (nowPw.equals(dto.getInfoDTO().getPassword())) {
				System.out.print("변경할 비밀번호 > ");
				String chPw = br.readLine().trim();
				System.out.print("비밀번호 확인 > ");
				String chPw1 = br.readLine().trim();

				if (chPw.equals(chPw1)) {
					int n = dao.updateStudentPw(dto.getInfoNo(), chPw);

					if (n >= 1) {
						System.out.println("비밀번호 변경 완료.");
					} else {
						System.out.println("비밀번호 변경 실패.");
					}

				} else {
					System.out.println("변경할 비밀번호가 일치하지 않습니다.");
				}

			} else {
				System.out.println("기존 비밀번호를 잘못 입력하셨습니다.");
			}

		} catch (IOException e) {
		}
	}

	@Override
	public void searchStudent(StudentDTO dto) {
		System.out.println("-- 모든 학생 검색...");

		try {
			StudentDTO sdto = dao.findByInfoNo(dto.getInfoNo());
			System.out.println(sdto);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println();
	}

	/**
	 * 로그인 --학생
	 * 
	 * @throws NullPointerException
	 */
	@Override
	public StudentDTO login() throws NullPointerException {
		int id = 0;
		String pwd = null;

		do {
			System.out.print("학번: ");
			try {
				id = Integer.parseInt(br.readLine().trim());
			} catch (IOException e) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		} while (id == 0);

		do {
			System.out.print("비밀번호: ");
			try {
				pwd = br.readLine().trim();
			} catch (IOException e) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		} while (pwd != null && pwd.length() == 0);
		// System.out.println(id+":"+pwd);
		StudentDTO dto = null;
		dto = dao.login(id, pwd);

		if (dto.getInfoNo() == -2) {
			System.out.println("학번을 잘못 입력하셨습니다.");
			throw new NullPointerException();
		} else if (dto.getInfoNo() == -1) {
			System.out.println("비밀번호를 잘못 입력하셨습니다.");
			throw new NullPointerException();
		} else {
			System.out.println("로그인 완료!");
		}

		return dto;
	}

}
