package sya.gyeoukgyung.subject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

public class SubjectImpl implements Subject{
	private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	private SubjectDAO dao=new SubjectDAOImpl();
	
	/**
	 * 과목 정보를 등록하는 메소드
	 * -관리자
	 */
	@Override
	public void insertSubject() {
		System.out.println("\n과목 등록...");
		
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
			
			System.out.print("등록하고자 하는 과목명을 입력하시오 : ");
			dto.setSubName(br.readLine().trim());
			list2=dao.findBySubName(dto.getSubName());
			if(list2.size()!=0) {
				System.out.println("이미 등록된 과목명입니다...");
				return;
			}
			
			System.out.print("등록하고자 하는 과목의 과목코드를 입력하시오 : ");
			dto.setSubCode(br.readLine().trim());
			list2=null;
			list2=dao.findBySubCode(dto.getSubCode());
			if(list2.size()!=0) {
				System.out.println("이미 등록된 과목코드입니다...");
				return;
			}
			
			System.out.print("등록하고자 하는 과목의 학과번호를 입력하시오 : ");
			dto.setDeptNo(Integer.parseInt(br.readLine()));
			list2=null;
			list2=dao.findByDept(dto.getDeptNo());
			if(list2.size()==0) {
				System.out.println("존재하지 않는 학과번호입니다...");
				return;
			}
			
			int result=dao.insertSubject(dto);
			if(result>=1) {
				System.out.println("과목 등록에 성공했습니다!");
			} else {
				System.out.println("과목 등록에 실패했습니다...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 과목 정보를 삭제하는 메소드
	 * -관리자
	 */
	@Override
	public void deleteSubject() {
		System.out.println("\n과목 삭제...");
		
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
			
			System.out.print("삭제하고자 하는 과목의 과목번호를 입력하시오 : ");
			dto.setSubNo(Integer.parseInt(br.readLine()));
			
			list2=dao.findBySubNo(dto.getSubNo());
			if(list2.size()==0) {
				System.out.println("존재하지 않는 과목번호입니다...");
				return;
			}
		
			
			int result=dao.deleteSubject(dto.getSubNo());
			if(result>=1) {
				System.out.println("과목 삭제에 성공했습니다!");
			} else {
				System.out.println("과목 삭제에 실패했습니다...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 과목 정보를 과목명으로 검색하는 메소드
	 * -관리자
	 */
	@Override
	public void findBySubName() {
		System.out.println("\n과목명으로 과목 찾기...");
		
		
		try {
			String subName;
			
			System.out.print("찾고자하는 과목의 과목명을 입력하시오 : ");
			subName=br.readLine();
			
			List<HashMap<String, Object>> list=dao.findBySubName(subName);
			if(list.size()==0) {
				System.out.println("등록된 과목이 아닙니다.");
				return;
			}
			
			System.out.println("\n검색된 과목...");
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
	 * 과목 정보를 과목코드로 검색하는 메소드
	 * -관리자
	 */
	@Override
	public void findBySubCode() {
		System.out.println("\n과목코드로 과목 찾기...");
		
		
		try {
			String subCode;
			
			System.out.print("찾고자하는 과목의 과목코드를 입력하시오 : ");
			subCode=br.readLine();
			
			List<HashMap<String, Object>> list=dao.findBySubCode(subCode);
			if(list.size()==0) {
				System.out.println("등록된 과목이 아닙니다.");
				return;
			}
			
			System.out.println("\n검색된 과목...");
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
	 * 과목 정보를 전체 출력하는 메소드
	 * -관리자
	 */
	@Override
	public void listSubject() {
		System.out.println("\n과목 전체 출력...");
		
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
	 * 과목 정보를 전공번호로 검색하는 메소드
	 * -관리자
	 */
	@Override
	public void findByDept() {
		System.out.println("\n전공번호로 과목 찾기...");
		
		
		try {
			String deptNo;
			
			System.out.print("찾고자하는 과목의 전공번호를 입력하시오 : ");
			deptNo=br.readLine();
			
			List<HashMap<String, Object>> list=dao.findByDept(Integer.parseInt(deptNo));
			if(list.size()==0) {
				System.out.println("등록된 학과가 아닙니다.");
				return;
			}
			
			System.out.println("\n검색된 과목...");
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
	 * 과목 정보를 과목번호로 검색하는 메소드
	 * -관리자
	 */
	@Override
	public void findBySubNo() {
		System.out.println("\n과목번호로 과목 찾기...");
		
		
		try {
			String subNo;
			
			System.out.print("찾고자하는 과목의 전공번호를 입력하시오 : ");
			subNo=br.readLine();
			
			List<HashMap<String, Object>> list=dao.findBySubNo(Integer.parseInt(subNo));
			if(list.size()==0) {
				System.out.println("등록된 과목번호가 아닙니다.");
				return;
			}
			
			System.out.println("\n검색된 과목...");
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

