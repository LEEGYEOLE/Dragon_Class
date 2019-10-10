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
	 * ���� ���� ��� (�� ������ ���� ����: �ڵ���, �̸���, �ּ�) - ������
	 */
	@Override
	public void insertEmployee() {
		System.out.println("-- ������ ���� ���...");
		EmployeeDTO dto = new EmployeeDTO();
		int result = 0;
		System.out.print("���� : ");
		try {
			
			dto.setEmployeeNo(Integer.parseInt(br.readLine().trim()));
			
			//TODO: ����Ҷ� ROOM��� �����ְ� ���� ����? �ٵ� �̷��� �Ϸ��� ���ξ��� �游 ���������
			System.out.print("���ȣ : ");
			dto.setRoomNo(Integer.parseInt(br.readLine().trim()));

			System.out.print("�̸� : ");
			dto.getInfoDTO().setName(br.readLine().trim());
			System.out.print("�ֹε�Ϲ�ȣ[ ex)950000-2400000 ] : ");
			String rrn = br.readLine().trim();
			dto.getInfoDTO().setRrn(rrn);
			// ������� ���ϱ�
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
			// �ʱ� ����� ���� 4�ڸ�
			dto.getInfoDTO().setPassword(dto.getInfoDTO().getRrn().substring(2, 6));
			// ���� �⵵
			dto.getInfoDTO().setEntYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

			//TODO: ����Ҷ� �а���� �����ְ� ���� ����?
			System.out.print("�а���ȣ : ");
			dto.getInfoDTO().setDeptNo(Integer.parseInt(br.readLine().trim()));
			
			System.out.println("������(�ڵ���, �̸���, �ּ�)�� �Է��Ͻðڽ��ϱ�? [ YES�� 1, NO�� 0 ]");
			int ch;
			do {
				ch = Integer.parseInt(br.readLine().trim());
			} while (ch < 0 || ch > 1);

			if (ch == 1) {
				System.out.print("�ڵ��� : ");
				dto.getInfoDTO().setTel(br.readLine().trim());
				System.out.print("�̸��� : ");
				dto.getInfoDTO().setEmail(br.readLine().trim());
				System.out.print("�ּ� : ");
				dto.getInfoDTO().setAddress(br.readLine().trim());

				result = dao.insertEmployeeOP(dto);
			} else {
				result = dao.insertEmployee(dto);
			}
			System.out.println(dto.toString());
			if (result >= 1) {
				System.out.println("����������� �Ϸ�Ǿ����ϴ�.");
			}
		} catch (NumberFormatException e) {
		} catch (IOException e) {
		} catch (Exception e) {
		}

		
	}

	@Override
	public void updateEmployee() {
		System.out.println("-- ������ ���� ����...");
	}

	@Override
	public void updateEmployeePw() {
		System.out.println("-- ������ ��й�ȣ ����...");
		System.out.print("���� �Է� > ");
		try {
			int empNo = Integer.parseInt(br.readLine().trim());
			EmployeeDTO dto = dao.findByEmployeeNo(empNo);
			System.out.print("������ ��й�ȣ > ");
			String chPw = br.readLine().trim();
			System.out.print("��й�ȣ Ȯ�� > ");
			String chPw1 = br.readLine().trim();

			if (chPw.equals(chPw1)) {
				int n = dao.updateEmployeePw(dto.getInfoNo(), chPw);

				if (n >= 1) {
					System.out.println("��й�ȣ ���� �Ϸ�.");
				} else {
					System.out.println("��й�ȣ ���� ����.");
				}

			} else {
				System.out.println("������ ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}

		} catch (IOException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} catch (NumberFormatException e) {
			System.out.println("������ �߸��Է��ϼ̽��ϴ�.");
		} catch (NullPointerException e) {
			System.out.println("���� �����Դϴ�.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee() {
		System.out.println("-- ������ ���� ����...");
		System.out.print("���� �Է� > ");
		try {
			int empNo = Integer.parseInt(br.readLine().trim());
			EmployeeDTO dto = dao.findByEmployeeNo(empNo);
			System.out.println("����������:\n" + dto.toString());

			System.out.println("���� �����Ͻðڽ��ϱ�? [ YES�� 0, NO�� 1 ]");
			int ch;
			do {
				ch = Integer.parseInt(br.readLine().trim());
			} while (ch < 0 || ch > 1);

			if (ch == 0) {
				int n = dao.deleteEmployee(dto.getInfoNo());

				if (n >= 1) {
					System.out.println("������ ���� �Ϸ�.");
				} else {
					System.out.println("������ ���� ����.");
				}
			}

		} catch (IOException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} catch (NumberFormatException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} catch (NullPointerException e) {
			System.out.println("���� �����Դϴ�.");
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
		System.out.println("-- �̸����� ������ �˻�...");
		List<EmployeeDTO> empList = new ArrayList<>();
		String name = null;
		
		try {
			System.out.print("�̸� > ");
		
			 do {
			name = br.readLine().trim();
			 } while ((name==null)||name.length()==0);
			 
			 empList = dao.findByName(name);
			 
			for (EmployeeDTO dto : empList) {
				System.out.println(dto.toString());
			}

		} catch (IOException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} catch (NumberFormatException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} catch (NullPointerException e) {
				System.out.println("�ش� �а��� ���� ������ ������ �����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void findByDept() {
		System.out.println("-- �а��� ������ �˻�...");
		List<DepartmentDTO> deptList = new ArrayList<>();
		List<EmployeeDTO> empList = new ArrayList<>();
		int chDeptNo = 0;
		int deptNo=0;
		/*
		 * ���� �� �����ֱ� deptList = dept_ddao.listDepartment();?
		 */
		deptList = dDao.listDepartment();
		for (int i = 0; i < deptList.size(); i++) {
			System.out.println(deptList.get(i).toString());
		}
		System.out.print("�а� ���� > ");
		try {

			// ����ڰ� ������ ��ȣ�� ���� �������� ũ�ų� 0���� ������ �ٽ�..
			// = ����Ʈ �ȿ� ���� �����ϰ��
			 do {
			chDeptNo = Integer.parseInt(br.readLine().trim());
			 } while (chDeptNo < 0 || chDeptNo > deptList.size());

			 deptNo = deptList.get(chDeptNo).getDeptNo();
//			deptNo= 1;
			// ������ȣ�� �л� �˻�.
			empList = dao.findByDept(deptNo);

			for (EmployeeDTO dto : empList) {
				System.out.println(dto.toString());
			}

		} catch (IOException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} catch (NumberFormatException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} catch (NullPointerException e) {
			// TODO: Employee �а��� �˻� : ���� �� deptNo!=1 ����
			if (deptNo != 1 && deptList.size() == 0)
				System.out.println("�а� ������ �����ϴ�.");
			else
				System.out.println("�ش� �а��� ���� ������ ������ �����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void listEmployee() {
		System.out.println("-- ��� ������ �˻�...");
		List<EmployeeDTO> list = dao.listEmployee();

		if (list.size() == 0) {
			System.out.println("��ϵ� ������ �����ϴ�.");
			return;
		}
		System.out.println("������ ��: " + list.size());

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
			System.out.print("����: ");
			try {
				id = Integer.parseInt(br.readLine().trim());
			} catch (IOException e) {
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
			} catch (NumberFormatException e) {
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
			}
		} while (id == 0);

		do {
			System.out.print("��й�ȣ: ");
			try {
				pwd = br.readLine().trim();
			} catch (IOException e) {
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
			}
		} while (pwd != null && pwd.length() == 0);
		// System.out.println(id+":"+pwd);
		EmployeeDTO dto = null;
		dto = dao.login(id, pwd);

		if (dto.getInfoNo() == -2) {
			System.out.println("������ �߸� �Է��ϼ̽��ϴ�.");
			dto = null;
		} else if (dto.getInfoNo() == -1) {
			System.out.println("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			dto = null;
		} else {
			System.out.println("�α��� �Ϸ�!");
		}

		return dto;
	}

}
