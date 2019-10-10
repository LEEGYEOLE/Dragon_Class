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
		
		System.out.println("\n강의 등록..");
		try {
			LectureDTO dto=new LectureDTO();
			
			System.out.print("이수구분 ?");
			dto.setDivision(br.readLine());
						
			System.out.print("개설연도 ?");
			dto.setMkYear(br.readLine().trim());
						
			System.out.print("학기 ?");
			dto.setSemester(Integer.parseInt(br.readLine()));
						
			System.out.print("수업요일 ?");
			dto.setCDay(br.readLine());
						
			System.out.print("시작시간 ?");
			dto.setStartTime(br.readLine());
						
			System.out.print("종료시간 ?");
			dto.setEndTime(br.readLine());
						
			System.out.print("학점 ?");
			dto.setCredit(Integer.parseInt(br.readLine()));
						
			System.out.print("정원 ?");
			dto.setCount(Integer.parseInt(br.readLine()));
						
			System.out.print("교수번호 ?");
			dto.setProfessorNo(Integer.parseInt(br.readLine().trim()));
						
			System.out.print("과목번호 ?");
			dto.setSubNo(Integer.parseInt(br.readLine()));
						
			System.out.print("강의실번호 ?");
			dto.setRoomNo(Integer.parseInt(br.readLine()));
			
			int result = dao.insertLecture(dto);
			if(result>=1)
				System.out.println("강의 등록 성공...");
			else
				System.out.println("강의 등록 실패...");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		System.out.println();
		
	}
		
	

	@Override
	public void deleteLecture() {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int lecNo;
		System.out.println("강의 삭제...");
		
		try {
		System.out.print("삭제할 강의 ? [강의번호] ");
		lecNo= Integer.parseInt(br.readLine());
		
		int result = dao.deleteLecture(lecNo);
		
		if(result>=1)
			System.out.println("강의 삭제 성공...");
		else
			System.out.println("강의 삭제 실패...");
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		System.out.println();
		
	}
		
	

	@Override
	public void findByDept() {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("학과명 검색...");
		
		String dept;
		System.out.print("검색할 학과명 ? ");
		try {
			dept = br.readLine();
			List<HashMap<String, Object>> list=dao.findByDept(dept);
			
			if(list.size()==0) {
				System.out.println("해당 학과가 없습니다.");
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
		
		System.out.println("이수구분 검색...");
		
		String div;
		System.out.print("검색할 이수구분 [선택/필수] ? ");
		try {
			div = br.readLine();
			List<HashMap<String, Object>> list=dao.findByDivision(div);
			
			if(list.size()==0) {
				System.out.println("해당 이수구분이 없습니다.");
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
				
		System.out.println("과목코드명 검색...");
		
		String Code;
		System.out.print("검색할 과목코드 ? ");
		try {
			Code = br.readLine();
			List<HashMap<String, Object>> list=dao.findByCode(Code);
			
			if(list.size()==0) {
				System.out.println("해당 과목코드가 없습니다.");
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
				
		System.out.println("과목명 검색...");
		
		String lecName;
		System.out.print("검색할 과목명 ? ");
		try {
			lecName = br.readLine();
			List<HashMap<String, Object>> list=dao.findByLecName(lecName);
			
			if(list.size()==0) {
				System.out.println("해당 과목명이 없습니다.");
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
		System.out.println("\n전체 리스트...");
		
		List<HashMap<String, Object>> list=dao.listLecture();
		
		if(list.size()==0) {
			System.out.println("등록된 정보가 없습니다.");
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
			
		System.out.println("교수명 검색...");
		
		String pname;
		System.out.print("검색할 교수명 ? ");
		try {
			pname = br.readLine();
			List<HashMap<String, Object>> list=dao.findByPname(pname);
			
			if(list.size()==0) {
				System.out.println("해당 교수명이 없습니다.");
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
