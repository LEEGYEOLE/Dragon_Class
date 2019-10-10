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
	 * �л� ���� ��� (�� ������ ���� ����: �ڵ���, �̸���, �ּ�) - ������
	 */
	@Override
	public void insertStudent() {
		System.out.println("-- �л� ���� ���...");
		StudentDTO dto = new StudentDTO();
		int result = 0;
		System.out.print("�й� : ");
		try {
			dto.setStudentNo(Integer.parseInt(br.readLine().trim()));
			dto.setHaknyun(1);
			dto.setStatus("����");
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
			dto.getInfoDTO().setEntYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

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

				result = dao.insertStudentOP(dto);
			} else {
				result = dao.insertStudent(dto);
			}
			System.out.println(dto.toString());

		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("�ߺ��� ���� �ֽ��ϴ�.");
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("�ֹε�Ϲ�ȣ ������ �߸��Ǿ����ϴ�. ");
		} catch (NumberFormatException e) {
		} catch (IOException e) {
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (result >= 1) {
				System.out.println("�л� ����� �Ϸ�Ǿ����ϴ�.");
			} else {
				System.out.println("����� �����߽��ϴ�.");
			}
		}

	}

	/**
	 * �л� ��� ���� --������ �Է�: �й�, ������ ��й�ȣ 2��
	 */
	@Override
	public void updateStudentPw() {
		System.out.println("-- �л� ��й�ȣ ����...");
		System.out.print("�й� �Է� > ");
		try {
			int studentNo = Integer.parseInt(br.readLine().trim());
			StudentDTO dto = dao.findByStudentNo(studentNo);
			System.out.print("������ ��й�ȣ > ");
			String chPw = br.readLine().trim();
			System.out.print("��й�ȣ Ȯ�� > ");
			String chPw1 = br.readLine().trim();

			if (chPw.equals(chPw1)) {
				int n = dao.updateStudentPw(dto.getInfoNo(), chPw);

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
			System.out.println("�й��� �߸��Է��ϼ̽��ϴ�.");
		} catch (NullPointerException e) {
			System.out.println("���� �й��Դϴ�.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �л� ���� ���� --������ �Է�: �й�, ������������
	 */
	@Override
	public void deleteStudent() {
		System.out.println("-- �л� ���� ����...");
		System.out.print("�й� �Է� > ");
		try {
			int studentNo = Integer.parseInt(br.readLine().trim());
			StudentDTO dto = dao.findByStudentNo(studentNo);
			System.out.println("�л�����:\n" + dto.toString());

			System.out.println("���� �����Ͻðڽ��ϱ�? [ YES�� 0, NO�� 1 ]");
			int ch;
			do {
				ch = Integer.parseInt(br.readLine().trim());
			} while (ch < 0 || ch > 1);

			if (ch == 0) {
				int n = dao.deleteStudent(dto.getInfoNo());

				if (n >= 1) {
					System.out.println("�л� ���� �Ϸ�.");
				} else {
					System.out.println("�л� ���� ����.");
				}
			}

		} catch (IOException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} catch (NumberFormatException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} catch (NullPointerException e) {
			System.out.println("���� �й��Դϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �л� �̸����� �˻� - ������
	 */
	@Override
	public void findByName() {
		System.out.println("-- �̸����� �л� �˻�...");
		List<StudentDTO> stuList = new ArrayList<>();
		String name = null;

		try {
			System.out.print("�̸� > ");

			do {
				name = br.readLine().trim();
			} while ((name == null) || name.length() == 0);

			stuList = dao.findByName(name);

			for (StudentDTO dto : stuList) {
				System.out.println(dto.toString());
			}

		} catch (IOException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} catch (NumberFormatException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} catch (NullPointerException e) {
			System.out.println("�ش� �а��� ���� �л� ������ �����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * �л� �������� �˻� - ������
	 */
	@Override
	public void findByDept() {
		System.out.println("-- �а��� �л� �˻�...");
		List<DepartmentDTO> deptList = new ArrayList<>();
		List<StudentDTO> stuList = new ArrayList<>();
		int chDeptNo = 0;
		int deptNo = 0;
		/*
		 * ���� �� �����ֱ� deptList = dept_dao.listDepartment();?
		 */
		System.out.print("�а� ���� > ");
		try {

			// ����ڰ� ������ ��ȣ�� ���� �������� ũ�ų� 0���� ������ �ٽ�..
			// = ����Ʈ �ȿ� ���� �����ϰ��
			// do {
			chDeptNo = Integer.parseInt(br.readLine().trim());
			// } while (chDeptNo < 0 || chDeptNo > deptList.size());

			// int deptNo = deptList.get(chDeptNo).getDeptNo();
			deptNo = 1;
			// ������ȣ�� �л� �˻�.
			stuList = dao.findByDept(deptNo);

			for (StudentDTO dto : stuList) {
				System.out.println(dto.toString());
			}

		} catch (IOException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} catch (NumberFormatException e) {
			System.out.println("�߸��� �Է��Դϴ�.");
		} catch (NullPointerException e) {
			// TODO: student �а��� �˻� : ���� �� deptNo!=1 ����
			if (deptNo != 1 && deptList.size() == 0)
				System.out.println("�а� ������ �����ϴ�.");
			else
				System.out.println("�ش� �а��� ���� �л� ������ �����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void listStudent() {
		System.out.println("-- ��� �л� �˻�...");
		List<StudentDTO> list = dao.listStudent();

		if (list.size() == 0) {
			System.out.println("��ϵ� ������ �����ϴ�.");
			return;
		}
		System.out.println("�л���: " + list.size());

		Iterator<StudentDTO> it = list.iterator();
		while (it.hasNext()) {
			System.out.println("����");
			StudentDTO dto = it.next();
			System.out.print(dto.toString());
		}

		System.out.println();

	}

	/**
	 * �� ������ ����(�ڵ���, �̸���, �ּ�) - �л�
	 */
	@Override
	public void updateStudent(StudentDTO currDto) {
		System.out.println("-- ������ ����...");
		int result = 0;

		try {
			StudentDTO dto = dao.findByStudentNo(currDto.getStudentNo());
			System.out.println("�л�����:\n" + dto.toString());

			System.out.println("\n������ ���� �Է�:::");
			System.out.print("�ڵ��� : ");
			dto.getInfoDTO().setTel(br.readLine().trim());
			System.out.print("�̸��� : ");
			dto.getInfoDTO().setEmail(br.readLine().trim());
			System.out.print("�ּ� : ");
			dto.getInfoDTO().setAddress(br.readLine().trim());

			result = dao.updateStudent(dto);

			if (result >= 1) {
				System.out.println("�л����� ���� �Ϸ�.");
			} else {
				System.out.println("�л����� ���� ����.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * �� ��й�ȣ ���� -�л�
	 */
	@Override
	public void updateStudentPw(StudentDTO dto) {
		System.out.println("-- �� ��й�ȣ ����...");
		System.out.print("���� ��й�ȣ > ");
		try {
			String nowPw = br.readLine().trim();
			if (nowPw.equals(dto.getInfoDTO().getPassword())) {
				System.out.print("������ ��й�ȣ > ");
				String chPw = br.readLine().trim();
				System.out.print("��й�ȣ Ȯ�� > ");
				String chPw1 = br.readLine().trim();

				if (chPw.equals(chPw1)) {
					int n = dao.updateStudentPw(dto.getInfoNo(), chPw);

					if (n >= 1) {
						System.out.println("��й�ȣ ���� �Ϸ�.");
					} else {
						System.out.println("��й�ȣ ���� ����.");
					}

				} else {
					System.out.println("������ ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				}

			} else {
				System.out.println("���� ��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			}

		} catch (IOException e) {
		}
	}

	@Override
	public void searchStudent(StudentDTO dto) {
		System.out.println("-- ��� �л� �˻�...");

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
	 * �α��� --�л�
	 * 
	 * @throws NullPointerException
	 */
	@Override
	public StudentDTO login() throws NullPointerException {
		int id = 0;
		String pwd = null;

		do {
			System.out.print("�й�: ");
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
		StudentDTO dto = null;
		dto = dao.login(id, pwd);

		if (dto.getInfoNo() == -2) {
			System.out.println("�й��� �߸� �Է��ϼ̽��ϴ�.");
			throw new NullPointerException();
		} else if (dto.getInfoNo() == -1) {
			System.out.println("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			throw new NullPointerException();
		} else {
			System.out.println("�α��� �Ϸ�!");
		}

		return dto;
	}

}
