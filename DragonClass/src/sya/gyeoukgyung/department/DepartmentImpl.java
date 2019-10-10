package sya.gyeoukgyung.department;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class DepartmentImpl implements Department{
	private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	private DepartmentDAO dao=new DepartmentDAOImpl();
	
	/**
	 * �а� ������ ����ϴ� �޼ҵ�
	 * -������
	 */
	@Override
	public void insertDepartment() {
		System.out.println("\n�а� ���...");
		
		try {
			List<DepartmentDTO> list=null;
			DepartmentDTO dto=new DepartmentDTO();
			
			System.out.print("����ϰ��� �ϴ� �а����� �Է��Ͻÿ� : ");
			dto.setDeptName(br.readLine().trim());
			list=dao.findByDeptName(dto.getDeptName());
			if(list.size()!=0) {
				System.out.println("�̹� ��ϵ� �а��� �ֽ��ϴ�...");
				return;
			}
			
			int result=dao.insertDepartment(dto);
			if(result>=1) {
				System.out.println("�а� ��Ͽ� �����߽��ϴ�!");
			} else {
				System.out.println("�а� ��Ͽ� �����߽��ϴ�...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * �а� ������ �����ϴ� �޼ҵ�
	 * -������
	 */
	@Override
	public void updateDepartment() {
		System.out.println("\n�а� ����...");
		
		try {
			int num;
			String deptName;
			
			System.out.print("������ �а����� �Է��Ͻÿ� : ");
			deptName=br.readLine();
			
			// ���� �Է��� �а����� ���Ե� ����Ʈ�� ���� �����ش�.
			List<DepartmentDTO> list=dao.findByDeptName(deptName);
			if(list.size()==0) {
				System.out.println("��ϵ� �а��� �ƴմϴ�.");
				return;
			}
			
			// �а��� �˻��Ǹ� ���� �˻��� �а��� ���Ƿ� �ο����� ��ȣ�� ���� �����ش�.
			System.out.println("\n�˻��� �а�...");
			for(int i=0; i<list.size(); i++) {
				DepartmentDTO dto=list.get(i);
				System.out.print(i+"\t");
				System.out.println(dto.getDeptName());
			}
			
			// �� ���� ���Ƿ� �� ��ȣ�� �Է��Ͽ� �����ϰ��� �ϴ� �а��� �����Ѵ�.
			do {
				System.out.print("�����ϰ� ���� �а��� ��ȣ�� �Է��Ͻÿ� : ");
				num=Integer.parseInt(br.readLine());
			} while(num>list.size()||num<0);
			
			System.out.print("�����Ϸ��� �а��̸��� ��Ȯ�� �Է��Ͻÿ� : ");
			list.get(num).setDeptName(br.readLine());
			
			int result=dao.updateDepartment(list.get(num));
			
			if(result>=1) {
				System.out.println("�а��� ������ �����߽��ϴ�!");
			} else {
				System.out.println("�а��� ������ �����߽��ϴ�...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	
	/**
	 * �а� ������ �����ϴ� �޼ҵ�
	 * -������
	 */
	@Override
	public void deleteDepartment() {
		System.out.println("\n�а� ����...");
		
		try {
			String deptName;
			int num;
			
			System.out.print("������ �а����� �Է��Ͻÿ� : ");
			deptName=br.readLine();
			
			// ���� �Է��� �а����� ���Ե� ����Ʈ�� ���� �����ش�.
			List<DepartmentDTO> list=dao.findByDeptName(deptName);
			if(list.size()==0) {
				System.out.println("�˻��� �а��� �����ϴ�.");
				return;
			}
			
			// �а��� �˻��Ǹ� ���� �˻��� �а��� ���Ƿ� �ο����� ��ȣ�� ���� �����ش�.
			System.out.println("\n�˻��� �а�...");
			for(int i=0; i<list.size(); i++) {
				DepartmentDTO dto=list.get(i);
				System.out.print(i+"\t");
				System.out.println(dto.getDeptName());
			}
			
			// �� ���� ���Ƿ� �� ��ȣ�� �Է��Ͽ� �����ϰ��� �ϴ� �а��� �����Ѵ�.
			do {
				System.out.print("�����ϰ� ���� �а��� ��ȣ�� �Է��Ͻÿ� : ");
				num=Integer.parseInt(br.readLine());
			} while(num>list.size()||num<0);
			
			
			int result=dao.deleteDepartment(list.get(num).getDeptNo());
			
			if(result>=1) {
				System.out.println("�а� ������ �����߽��ϴ�!");
			} else {
				System.out.println("�а� ������ �����߽��ϴ�...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	
	/**
	 * �а� ������ ��ü ����ϴ� �޼ҵ�
	 * -������
	 */
	@Override
	public void listDepartment() {
		System.out.println("\n�а� ��ü ���...");
		
		List<DepartmentDTO> list=dao.listDepartment();
		for(DepartmentDTO dto : list) {
			System.out.print(dto.getDeptNo()+"\t");
			System.out.println(dto.getDeptName());
		}
		System.out.println();
		
	}

	
}
