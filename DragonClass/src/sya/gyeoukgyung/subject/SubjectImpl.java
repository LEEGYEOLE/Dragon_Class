package sya.gyeoukgyung.subject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

public class SubjectImpl implements Subject{
	private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	private SubjectDAO dao=new SubjectDAOImpl();
	
	/**
	 * ���� ������ ����ϴ� �޼ҵ�
	 * -������
	 */
	@Override
	public void insertSubject() {
		System.out.println("\n���� ���...");
		
		try {
			List<HashMap<String, Object>> list=dao.listSubject();
			for(int i=0; i<list.size(); i++) {
				System.out.printf("[%-5d]", list.get(i).get("dept_no"));
				System.out.printf("[%10s]", list.get(i).get("dept_name"));
				System.out.printf("[%-5d]", list.get(i).get("sub_no"));
				System.out.printf("[%15s]", list.get(i).get("sub_name"));
				System.out.printf("[%6s]", list.get(i).get("sub_code"));
				System.out.println();
			}
			System.out.println();
			
			
			List<HashMap<String, Object>> list2=null;
			SubjectDTO dto=new SubjectDTO();
			
			System.out.print("����ϰ��� �ϴ� ������� �Է��Ͻÿ� : ");
			dto.setSubName(br.readLine().trim());
			list2=dao.findBySubName(dto.getSubName());
			if(list2.size()!=0) {
				System.out.println("�̹� ��ϵ� ������Դϴ�...");
				return;
			}
			
			System.out.print("����ϰ��� �ϴ� ������ �����ڵ带 �Է��Ͻÿ� : ");
			dto.setSubCode(br.readLine().trim());
			list2=null;
			list2=dao.findBySubCode(dto.getSubCode());
			if(list2.size()!=0) {
				System.out.println("�̹� ��ϵ� �����ڵ��Դϴ�...");
				return;
			}
			
			System.out.print("����ϰ��� �ϴ� ������ �а���ȣ�� �Է��Ͻÿ� : ");
			dto.setDeptNo(Integer.parseInt(br.readLine()));
			list2=null;
			list2=dao.findByDept(dto.getDeptNo());
			if(list2.size()==0) {
				System.out.println("�������� �ʴ� �а���ȣ�Դϴ�...");
				return;
			}
			
			int result=dao.insertSubject(dto);
			if(result>=1) {
				System.out.println("���� ��Ͽ� �����߽��ϴ�!");
			} else {
				System.out.println("���� ��Ͽ� �����߽��ϴ�...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ���� ������ �����ϴ� �޼ҵ�
	 * -������
	 */
	@Override
	public void deleteSubject() {
		System.out.println("\n���� ����...");
		
		try {
			List<HashMap<String, Object>> list=dao.listSubject();
			for(int i=0; i<list.size(); i++) {
				System.out.printf("[%-5d]", list.get(i).get("dept_no"));
				System.out.printf("[%10s]", list.get(i).get("dept_name"));
				System.out.printf("[%-5d]", list.get(i).get("sub_no"));
				System.out.printf("[%15s]", list.get(i).get("sub_name"));
				System.out.printf("[%6s]", list.get(i).get("sub_code"));
				System.out.println();
			}
			System.out.println();
			
			List<HashMap<String, Object>> list2=null;
			SubjectDTO dto=new SubjectDTO();
			
			System.out.print("�����ϰ��� �ϴ� ������ �����ȣ�� �Է��Ͻÿ� : ");
			dto.setSubNo(Integer.parseInt(br.readLine()));
			
			list2=dao.findBySubNo(dto.getSubNo());
			if(list2.size()==0) {
				System.out.println("�������� �ʴ� �����ȣ�Դϴ�...");
				return;
			}
		
			
			int result=dao.deleteSubject(dto.getSubNo());
			if(result>=1) {
				System.out.println("���� ������ �����߽��ϴ�!");
			} else {
				System.out.println("���� ������ �����߽��ϴ�...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * ���� ������ ��������� �˻��ϴ� �޼ҵ�
	 * -������
	 */
	@Override
	public void findBySubName() {
		System.out.println("\n��������� ���� ã��...");
		
		
		try {
			String subName;
			
			System.out.print("ã�����ϴ� ������ ������� �Է��Ͻÿ� : ");
			subName=br.readLine();
			
			List<HashMap<String, Object>> list=dao.findBySubName(subName);
			if(list.size()==0) {
				System.out.println("��ϵ� ������ �ƴմϴ�.");
				return;
			}
			
			System.out.println("\n�˻��� ����...");
			for(int i=0; i<list.size(); i++) {
				System.out.printf("[%-5d]", list.get(i).get("dept_no"));
				System.out.printf("[%10s]", list.get(i).get("dept_name"));
				System.out.printf("[%-5d]", list.get(i).get("sub_no"));
				System.out.printf("[%15s]", list.get(i).get("sub_name"));
				System.out.printf("[%6s]", list.get(i).get("sub_code"));
				System.out.println();
			}
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���� ������ �����ڵ�� �˻��ϴ� �޼ҵ�
	 * -������
	 */
	@Override
	public void findBySubCode() {
		System.out.println("\n�����ڵ�� ���� ã��...");
		
		
		try {
			String subCode;
			
			System.out.print("ã�����ϴ� ������ �����ڵ带 �Է��Ͻÿ� : ");
			subCode=br.readLine();
			
			List<HashMap<String, Object>> list=dao.findBySubCode(subCode);
			if(list.size()==0) {
				System.out.println("��ϵ� ������ �ƴմϴ�.");
				return;
			}
			
			System.out.println("\n�˻��� ����...");
			for(int i=0; i<list.size(); i++) {
				System.out.printf("[%-5d]", list.get(i).get("dept_no"));
				System.out.printf("[%10s]", list.get(i).get("dept_name"));
				System.out.printf("[%-5d]", list.get(i).get("sub_no"));
				System.out.printf("[%15s]", list.get(i).get("sub_name"));
				System.out.printf("[%6s]", list.get(i).get("sub_code"));
				System.out.println();
			}
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ���� ������ ��ü ����ϴ� �޼ҵ�
	 * -������
	 */
	@Override
	public void listSubject() {
		System.out.println("\n���� ��ü ���...");
		
		List<HashMap<String, Object>> list=dao.listSubject();
		for(int i=0; i<list.size(); i++) {
			System.out.printf("[%-5d]", list.get(i).get("dept_no"));
			System.out.printf("[%10s]", list.get(i).get("dept_name"));
			System.out.printf("[%-5d]", list.get(i).get("sub_no"));
			System.out.printf("[%15s]", list.get(i).get("sub_name"));
			System.out.printf("[%6s]", list.get(i).get("sub_code"));
			System.out.println();
		}
		System.out.println();
		
	}
	
	/**
	 * ���� ������ ������ȣ�� �˻��ϴ� �޼ҵ�
	 * -������
	 */
	@Override
	public void findByDept() {
		System.out.println("\n������ȣ�� ���� ã��...");
		
		
		try {
			String deptNo;
			
			System.out.print("ã�����ϴ� ������ ������ȣ�� �Է��Ͻÿ� : ");
			deptNo=br.readLine();
			
			List<HashMap<String, Object>> list=dao.findByDept(Integer.parseInt(deptNo));
			if(list.size()==0) {
				System.out.println("��ϵ� �а��� �ƴմϴ�.");
				return;
			}
			
			System.out.println("\n�˻��� ����...");
			for(int i=0; i<list.size(); i++) {
				System.out.printf("[%-5d]", list.get(i).get("dept_no"));
				System.out.printf("[%10s]", list.get(i).get("dept_name"));
				System.out.printf("[%-5d]", list.get(i).get("sub_no"));
				System.out.printf("[%15s]", list.get(i).get("sub_name"));
				System.out.printf("[%6s]", list.get(i).get("sub_code"));
				System.out.println();
			}
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ���� ������ �����ȣ�� �˻��ϴ� �޼ҵ�
	 * -������
	 */
	@Override
	public void findBySubNo() {
		System.out.println("\n�����ȣ�� ���� ã��...");
		
		
		try {
			String subNo;
			
			System.out.print("ã�����ϴ� ������ ������ȣ�� �Է��Ͻÿ� : ");
			subNo=br.readLine();
			
			List<HashMap<String, Object>> list=dao.findBySubNo(Integer.parseInt(subNo));
			if(list.size()==0) {
				System.out.println("��ϵ� �����ȣ�� �ƴմϴ�.");
				return;
			}
			
			System.out.println("\n�˻��� ����...");
			for(int i=0; i<list.size(); i++) {
				System.out.printf("[%-5d]", list.get(i).get("dept_no"));
				System.out.printf("[%10s]", list.get(i).get("dept_name"));
				System.out.printf("[%-5d]", list.get(i).get("sub_no"));
				System.out.printf("[%15s]", list.get(i).get("sub_name"));
				System.out.printf("[%6s]", list.get(i).get("sub_code"));
				System.out.println();
			}
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}

