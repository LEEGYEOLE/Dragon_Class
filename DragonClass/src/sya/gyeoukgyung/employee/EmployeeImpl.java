package sya.gyeoukgyung.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import sya.gyeoukgyung.department.DepartmentDAO;
import sya.gyeoukgyung.department.DepartmentDAOImpl;
import sya.gyeoukgyung.department.DepartmentDTO;
import sya.gyeoukgyung.student.StudentDTO;

public class EmployeeImpl implements Employee{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private EmployeeDAO dao = new EmployeeDAOImpl();
	private DepartmentDAO dDao = new DepartmentDAOImpl();

	/**
	 * 교수 정보 등록 (상세 정보는 선택 가능: 핸드폰, 이메일, 주소) - 관리자
	 */
	@Override
	public void insertEmployee() {
		System.out.println("-- 교직원 정보 등록...");
		EmployeeDTO dto = new EmployeeDTO();
		int result = 0;
		System.out.print("교번 : ");
		try {
			
			dto.setEmployeeNo(Integer.parseInt(br.readLine().trim()));
			
			//TODO: 등록할때 ROOM목록 보여주고 고르게 할지? 근데 이렇게 하려면 주인없는 방만 보여줘야함
			System.out.print("방번호 : ");
			dto.setRoomNo(Integer.parseInt(br.readLine().trim()));

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
			// 현재 년도
			dto.getInfoDTO().setEntYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

			//TODO: 등록할때 학과목록 보여주고 고르게 할지?
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

				result = dao.insertEmployeeOP(dto);
			} else {
				result = dao.insertEmployee(dto);
			}
			System.out.println(dto.toString());
			if (result >= 1) {
				System.out.println("교직원등록이 완료되었습니다.");
			}
		} catch (NumberFormatException e) {
		} catch (IOException e) {
		} catch (Exception e) {
		}

		
	}

	@Override
	public void updateEmployee() {
		System.out.println("-- 교직원 정보 수정...");
	}

	@Override
	public void updateEmployeePw() {
		System.out.println("-- 교직원 비밀번호 수정...");
		System.out.print("교번 입력 > ");
		try {
			int empNo = Integer.parseInt(br.readLine().trim());
			EmployeeDTO dto = dao.findByEmployeeNo(empNo);
			System.out.print("변경할 비밀번호 > ");
			String chPw = br.readLine().trim();
			System.out.print("비밀번호 확인 > ");
			String chPw1 = br.readLine().trim();

			if (chPw.equals(chPw1)) {
				int n = dao.updateEmployeePw(dto.getInfoNo(), chPw);

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
			System.out.println("교번을 잘못입력하셨습니다.");
		} catch (NullPointerException e) {
			System.out.println("없는 교번입니다.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee() {
		System.out.println("-- 교직원 정보 삭제...");
		System.out.print("교번 입력 > ");
		try {
			int empNo = Integer.parseInt(br.readLine().trim());
			EmployeeDTO dto = dao.findByEmployeeNo(empNo);
			System.out.println("교직원정보:\n" + dto.toString());

			System.out.println("정말 삭제하시겠습니까? [ YES는 0, NO는 1 ]");
			int ch;
			do {
				ch = Integer.parseInt(br.readLine().trim());
			} while (ch < 0 || ch > 1);

			if (ch == 0) {
				int n = dao.deleteEmployee(dto.getInfoNo());

				if (n >= 1) {
					System.out.println("교직원 삭제 완료.");
				} else {
					System.out.println("교직원 삭제 실패.");
				}
			}

		} catch (IOException e) {
			System.out.println("잘못된 입력입니다.");
		} catch (NumberFormatException e) {
			System.out.println("잘못된 입력입니다.");
		} catch (NullPointerException e) {
			System.out.println("없는 교번입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void findByEmployeeNo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findByName() {
		System.out.println("-- 이름으로 교직원 검색...");
		List<EmployeeDTO> empList = new ArrayList<>();
		String name = null;
		
		try {
			System.out.print("이름 > ");
		
			 do {
			name = br.readLine().trim();
			 } while ((name==null)||name.length()==0);
			 
			 empList = dao.findByName(name);
			 
			for (EmployeeDTO dto : empList) {
				System.out.println(dto.toString());
			}

		} catch (IOException e) {
			System.out.println("잘못된 입력입니다.");
		} catch (NumberFormatException e) {
			System.out.println("잘못된 입력입니다.");
		} catch (NullPointerException e) {
				System.out.println("해당 학과에 대한 교직원 정보가 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void findByDept() {
		System.out.println("-- 학과별 교직원 검색...");
		List<DepartmentDTO> deptList = new ArrayList<>();
		List<EmployeeDTO> empList = new ArrayList<>();
		int chDeptNo = 0;
		int deptNo=0;
		/*
		 * 전공 다 보여주기 deptList = dept_ddao.listDepartment();?
		 */
		deptList = dDao.listDepartment();
		for (int i = 0; i < deptList.size(); i++) {
			System.out.println(deptList.get(i).toString());
		}
		System.out.print("학과 선택 > ");
		try {

			// 사용자가 선택한 번호가 전공 개수보다 크거나 0보다 작으면 다시..
			// = 리스트 안에 없는 숫자일경우
			 do {
			chDeptNo = Integer.parseInt(br.readLine().trim());
			 } while (chDeptNo < 0 || chDeptNo > deptList.size());

			 deptNo = deptList.get(chDeptNo).getDeptNo();
//			deptNo= 1;
			// 전공번호로 학생 검색.
			empList = dao.findByDept(deptNo);

			for (EmployeeDTO dto : empList) {
				System.out.println(dto.toString());
			}

		} catch (IOException e) {
			System.out.println("잘못된 입력입니다.");
		} catch (NumberFormatException e) {
			System.out.println("잘못된 입력입니다.");
		} catch (NullPointerException e) {
			// TODO: Employee 학과별 검색 : 조건 중 deptNo!=1 빼기
			if (deptNo != 1 && deptList.size() == 0)
				System.out.println("학과 정보가 없습니다.");
			else
				System.out.println("해당 학과에 대한 교직원 정보가 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void listEmployee() {
		System.out.println("-- 모든 교직원 검색...");
		List<EmployeeDTO> list = dao.listEmployee();

		if (list.size() == 0) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		System.out.println("교직원 수: " + list.size());

		Iterator<EmployeeDTO> it = list.iterator();
		while (it.hasNext()) {
			EmployeeDTO dto = it.next();
			System.out.print(dto.toString());
		}

		System.out.println();
	}

	@Override
	public EmployeeDTO login() {
		int id = 0;
		String pwd = null;

		do {
			System.out.print("교번: ");
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
		EmployeeDTO dto = null;
		dto = dao.login(id, pwd);

		if (dto.getInfoNo() == -2) {
			System.out.println("교번을 잘못 입력하셨습니다.");
			dto = null;
		} else if (dto.getInfoNo() == -1) {
			System.out.println("비밀번호를 잘못 입력하셨습니다.");
			dto = null;
		} else {
			System.out.println("로그인 완료!");
		}

		return dto;
	}

}
