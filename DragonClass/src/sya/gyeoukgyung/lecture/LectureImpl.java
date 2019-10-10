package sya.gyeoukgyung.lecture;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class LectureImpl implements Lecture {
	private LectureDAO dao = new LectureDAOImpl();
	private Scanner sc=new Scanner(System.in);

	@Override
	public void insertLecture() {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("\n���� ���..");
		try {
			LectureDTO dto=new LectureDTO();
			
			System.out.print("�̼����� ?");
			dto.setDivision(br.readLine());
						
			System.out.print("�������� ?");
			dto.setMkYear(br.readLine().trim());
						
			System.out.print("�б� ?");
			dto.setSemester(Integer.parseInt(br.readLine()));
						
			System.out.print("�������� ?");
			dto.setCDay(br.readLine());
						
			System.out.print("���۽ð� ?");
			dto.setStartTime(br.readLine());
						
			System.out.print("����ð� ?");
			dto.setEndTime(br.readLine());
						
			System.out.print("���� ?");
			dto.setCredit(Integer.parseInt(br.readLine()));
						
			System.out.print("���� ?");
			dto.setCount(Integer.parseInt(br.readLine()));
						
			System.out.print("������ȣ ?");
			dto.setProfessorNo(Integer.parseInt(br.readLine().trim()));
						
			System.out.print("�����ȣ ?");
			dto.setSubNo(Integer.parseInt(br.readLine()));
						
			System.out.print("���ǽǹ�ȣ ?");
			dto.setRoomNo(Integer.parseInt(br.readLine()));
			
			int result = dao.insertLecture(dto);
			if(result>=1)
				System.out.println("���� ��� ����...");
			else
				System.out.println("���� ��� ����...");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		System.out.println();
		
	}
		
	

	@Override
	public void deleteLecture() {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int lecNo;
		System.out.println("���� ����...");
		
		try {
		System.out.print("������ ���� ? [���ǹ�ȣ] ");
		lecNo= Integer.parseInt(br.readLine());
		
		int result = dao.deleteLecture(lecNo);
		
		if(result>=1)
			System.out.println("���� ���� ����...");
		else
			System.out.println("���� ���� ����...");
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		System.out.println();
		
	}
		
	

	@Override
	public void findByDept() {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("�а��� �˻�...");
		
		String dept;
		System.out.print("�˻��� �а��� ? ");
		try {
			dept = br.readLine();
			List<HashMap<String, Object>> list=dao.findByDept(dept);
			
			if(list.size()==0) {
				System.out.println("�ش� �а��� �����ϴ�.");
				return;
			}
			Iterator<HashMap<String, Object>> it=list.iterator();
			
			while(it.hasNext()) {
				HashMap<String, Object> map=it.next();
						System.out.print(map.get("LECTURE_NO")+"\t");
						System.out.print(map.get("DIVISION")+"\t");
						System.out.print(map.get("MKYEAR")+"\t");
						System.out.print(map.get("SEMESTER")+"\t");
						System.out.print(map.get("DAY")+"\t");
						System.out.print(map.get("STIME")+"\t");
						System.out.print(map.get("ETIME")+"\t");
						System.out.print(map.get("CREDIT")+"\t");
						System.out.print(map.get("COUNT")+"\t");
						System.out.print(map.get("PROFESSOR_NO")+"\t");
						System.out.print(map.get("SUB_NO")+"\t");
						System.out.print(map.get("ROOM_NO")+"\t");
						System.out.print(map.get("SUB_NAME")+"\t");
						System.out.print(map.get("SUB_CODE")+"\t");
						System.out.print(map.get("DEPT_NO")+"\t");
						System.out.print(map.get("DEPT_NAME")+"\t");
						System.out.print(map.get("room_name")+"\t");
						System.out.print(map.get("name")+"\t");
						
						System.out.println();
				
		}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
					
	}
	
	
	@Override
	public void findByDivision() {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("�̼����� �˻�...");
		
		String div;
		System.out.print("�˻��� �̼����� [����/�ʼ�] ? ");
		try {
			div = br.readLine();
			List<HashMap<String, Object>> list=dao.findByDivision(div);
			
			if(list.size()==0) {
				System.out.println("�ش� �̼������� �����ϴ�.");
				return;
			}
			Iterator<HashMap<String, Object>> it=list.iterator();
			
			while(it.hasNext()) {
				HashMap<String, Object> map=it.next();
						System.out.print(map.get("LECTURE_NO")+"\t");
						System.out.print(map.get("DIVISION")+"\t");
						System.out.print(map.get("MKYEAR")+"\t");
						System.out.print(map.get("SEMESTER")+"\t");
						System.out.print(map.get("DAY")+"\t");
						System.out.print(map.get("STIME")+"\t");
						System.out.print(map.get("ETIME")+"\t");
						System.out.print(map.get("CREDIT")+"\t");
						System.out.print(map.get("COUNT")+"\t");
						System.out.print(map.get("PROFESSOR_NO")+"\t");
						System.out.print(map.get("SUB_NO")+"\t");
						System.out.print(map.get("ROOM_NO")+"\t");
						System.out.print(map.get("SUB_NAME")+"\t");
						System.out.print(map.get("SUB_CODE")+"\t");
						System.out.print(map.get("DEPT_NO")+"\t");
						System.out.print(map.get("DEPT_NAME")+"\t");
						System.out.print(map.get("room_name")+"\t");
						System.out.print(map.get("name")+"\t");
						
						System.out.println();
				
		}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
					
	}
		
	
	
	
	@Override
	public void findByCode() {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				
		System.out.println("�����ڵ�� �˻�...");
		
		String Code;
		System.out.print("�˻��� �����ڵ� ? ");
		try {
			Code = br.readLine();
			List<HashMap<String, Object>> list=dao.findByCode(Code);
			
			if(list.size()==0) {
				System.out.println("�ش� �����ڵ尡 �����ϴ�.");
				return;
			}
			Iterator<HashMap<String, Object>> it=list.iterator();
			
			while(it.hasNext()) {
				HashMap<String, Object> map=it.next();
						System.out.print(map.get("LECTURE_NO")+"\t");
						System.out.print(map.get("DIVISION")+"\t");
						System.out.print(map.get("MKYEAR")+"\t");
						System.out.print(map.get("SEMESTER")+"\t");
						System.out.print(map.get("DAY")+"\t");
						System.out.print(map.get("STIME")+"\t");
						System.out.print(map.get("ETIME")+"\t");
						System.out.print(map.get("CREDIT")+"\t");
						System.out.print(map.get("COUNT")+"\t");
						System.out.print(map.get("PROFESSOR_NO")+"\t");
						System.out.print(map.get("SUB_NO")+"\t");
						System.out.print(map.get("ROOM_NO")+"\t");
						System.out.print(map.get("SUB_NAME")+"\t");
						System.out.print(map.get("SUB_CODE")+"\t");
						System.out.print(map.get("DEPT_NO")+"\t");
						System.out.print(map.get("DEPT_NAME")+"\t");
						System.out.print(map.get("room_name")+"\t");
						System.out.print(map.get("name")+"\t");
						
						System.out.println();
				
		}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
					
	}
	
	
	@Override
	public void findByLecName() {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				
		System.out.println("����� �˻�...");
		
		String lecName;
		System.out.print("�˻��� ����� ? ");
		try {
			lecName = br.readLine();
			List<HashMap<String, Object>> list=dao.findByLecName(lecName);
			
			if(list.size()==0) {
				System.out.println("�ش� ������� �����ϴ�.");
				return;
			}
			Iterator<HashMap<String, Object>> it=list.iterator();
			
			while(it.hasNext()) {
				HashMap<String, Object> map=it.next();
						System.out.print(map.get("LECTURE_NO")+"\t");
						System.out.print(map.get("DIVISION")+"\t");
						System.out.print(map.get("MKYEAR")+"\t");
						System.out.print(map.get("SEMESTER")+"\t");
						System.out.print(map.get("DAY")+"\t");
						System.out.print(map.get("STIME")+"\t");
						System.out.print(map.get("ETIME")+"\t");
						System.out.print(map.get("CREDIT")+"\t");
						System.out.print(map.get("COUNT")+"\t");
						System.out.print(map.get("PROFESSOR_NO")+"\t");
						System.out.print(map.get("SUB_NO")+"\t");
						System.out.print(map.get("ROOM_NO")+"\t");
						System.out.print(map.get("SUB_NAME")+"\t");
						System.out.print(map.get("SUB_CODE")+"\t");
						System.out.print(map.get("DEPT_NO")+"\t");
						System.out.print(map.get("DEPT_NAME")+"\t");
						System.out.print(map.get("room_name")+"\t");
						System.out.print(map.get("name")+"\t");
						
						System.out.println();
				
		}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
						
	}

	
	
	@Override
	public void listLecture() {
		System.out.println("\n��ü ����Ʈ...");
		
		List<HashMap<String, Object>> list=dao.listLecture();
		
		if(list.size()==0) {
			System.out.println("��ϵ� ������ �����ϴ�.");
			return;
		}
		Iterator<HashMap<String, Object>> it=list.iterator();
		while(it.hasNext()) {
			HashMap<String, Object> map=it.next();
					System.out.print(map.get("LECTURE_NO")+"\t");
					System.out.print(map.get("DIVISION")+"\t");
					System.out.print(map.get("MKYEAR")+"\t");
					System.out.print(map.get("SEMESTER")+"\t");
					System.out.print(map.get("DAY")+"\t");
					System.out.print(map.get("STIME")+"\t");
					System.out.print(map.get("ETIME")+"\t");
					System.out.print(map.get("CREDIT")+"\t");
					System.out.print(map.get("COUNT")+"\t");
					System.out.print(map.get("PROFESSOR_NO")+"\t");
					System.out.print(map.get("SUB_NO")+"\t");
					System.out.print(map.get("ROOM_NO")+"\t");
					System.out.print(map.get("SUB_NAME")+"\t");
					System.out.print(map.get("SUB_CODE")+"\t");
					System.out.print(map.get("DEPT_NO")+"\t");
					System.out.print(map.get("DEPT_NAME")+"\t");
					System.out.print(map.get("room_name")+"\t");
					System.out.print(map.get("name")+"\t");
					
					System.out.println();			
		}
					
	}


	@Override
	public void findByPName() {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
		System.out.println("������ �˻�...");
		
		String pname;
		System.out.print("�˻��� ������ ? ");
		try {
			pname = br.readLine();
			List<HashMap<String, Object>> list=dao.findByPname(pname);
			
			if(list.size()==0) {
				System.out.println("�ش� �������� �����ϴ�.");
				return;
			}
			Iterator<HashMap<String, Object>> it=list.iterator();
			
			while(it.hasNext()) {
				HashMap<String, Object> map=it.next();
						System.out.print(map.get("LECTURE_NO")+"\t");
						System.out.print(map.get("DIVISION")+"\t");
						System.out.print(map.get("MKYEAR")+"\t");
						System.out.print(map.get("SEMESTER")+"\t");
						System.out.print(map.get("DAY")+"\t");
						System.out.print(map.get("STIME")+"\t");
						System.out.print(map.get("ETIME")+"\t");
						System.out.print(map.get("CREDIT")+"\t");
						System.out.print(map.get("COUNT")+"\t");
						System.out.print(map.get("PROFESSOR_NO")+"\t");
						System.out.print(map.get("SUB_NO")+"\t");
						System.out.print(map.get("ROOM_NO")+"\t");
						System.out.print(map.get("SUB_NAME")+"\t");
						System.out.print(map.get("SUB_CODE")+"\t");
						System.out.print(map.get("DEPT_NO")+"\t");
						System.out.print(map.get("DEPT_NAME")+"\t");
						System.out.print(map.get("room_name")+"\t");
						System.out.print(map.get("name")+"\t");
						
						System.out.println();
						
		}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
						
	}
		
}
