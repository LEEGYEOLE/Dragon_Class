package sya.gyeoukgyung.department;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class DepartmentImpl implements Department{
	private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	private DepartmentDAO dao=new DepartmentDAOImpl();
	
	/**
	 * 학과 정보를 등록하는 메소드
	 * -관리자
	 */
	@Override
	public void insertDepartment() {
		System.out.println("\n학과 등록...");
		
		try {
			List<DepartmentDTO> list=null;
			DepartmentDTO dto=new DepartmentDTO();
			
			System.out.print("등록하고자 하는 학과명을 입력하시오 : ");
			dto.setDeptName(br.readLine().trim());
			list=dao.findByDeptName(dto.getDeptName());
			if(list.size()!=0) {
				System.out.println("이미 등록된 학과가 있습니다...");
				return;
			}
			
			int result=dao.insertDepartment(dto);
			if(result>=1) {
				System.out.println("학과 등록에 성공했습니다!");
			} else {
				System.out.println("학과 등록에 실패했습니다...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 학과 정보를 수정하는 메소드
	 * -관리자
	 */
	@Override
	public void updateDepartment() {
		System.out.println("\n학과 수정...");
		
		try {
			int num;
			String deptName;
			
			System.out.print("수정할 학과명을 입력하시오 : ");
			deptName=br.readLine();
			
			// 먼저 입력한 학과명이 포함된 리스트를 전부 보여준다.
			List<DepartmentDTO> list=dao.findByDeptName(deptName);
			if(list.size()==0) {
				System.out.println("등록된 학과가 아닙니다.");
				return;
			}
			
			// 학과가 검색되면 먼저 검색된 학과와 임의로 부여해준 번호를 전부 보여준다.
			System.out.println("\n검색된 학과...");
			for(int i=0; i<list.size(); i++) {
				DepartmentDTO dto=list.get(i);
				System.out.print(i+"\t");
				System.out.println(dto.getDeptName());
			}
			
			// 그 다음 임의로 준 번호를 입력하여 수정하고자 하는 학과를 선택한다.
			do {
				System.out.print("수정하고 싶은 학과의 번호를 입력하시오 : ");
				num=Integer.parseInt(br.readLine());
			} while(num>list.size()||num<0);
			
			System.out.print("수정하려는 학과이름을 정확히 입력하시오 : ");
			list.get(num).setDeptName(br.readLine());
			
			int result=dao.updateDepartment(list.get(num));
			
			if(result>=1) {
				System.out.println("학과명 수정에 성공했습니다!");
			} else {
				System.out.println("학과명 수정에 실패했습니다...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	
	/**
	 * 학과 정보를 삭제하는 메소드
	 * -관리자
	 */
	@Override
	public void deleteDepartment() {
		System.out.println("\n학과 삭제...");
		
		try {
			String deptName;
			int num;
			
			System.out.print("삭제할 학과명을 입력하시오 : ");
			deptName=br.readLine();
			
			// 먼저 입력한 학과명이 포함된 리스트를 전부 보여준다.
			List<DepartmentDTO> list=dao.findByDeptName(deptName);
			if(list.size()==0) {
				System.out.println("검색된 학과가 없습니다.");
				return;
			}
			
			// 학과가 검색되면 먼저 검색된 학과와 임의로 부여해준 번호를 전부 보여준다.
			System.out.println("\n검색된 학과...");
			for(int i=0; i<list.size(); i++) {
				DepartmentDTO dto=list.get(i);
				System.out.print(i+"\t");
				System.out.println(dto.getDeptName());
			}
			
			// 그 다음 임의로 준 번호를 입력하여 삭제하고자 하는 학과를 선택한다.
			do {
				System.out.print("삭제하고 싶은 학과의 번호를 입력하시오 : ");
				num=Integer.parseInt(br.readLine());
			} while(num>list.size()||num<0);
			
			
			int result=dao.deleteDepartment(list.get(num).getDeptNo());
			
			if(result>=1) {
				System.out.println("학과 삭제에 성공했습니다!");
			} else {
				System.out.println("학과 삭제에 실패했습니다...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	
	/**
	 * 학과 정보를 전체 출력하는 메소드
	 * -관리자
	 */
	@Override
	public void listDepartment() {
		System.out.println("\n학과 전체 출력...");
		
		List<DepartmentDTO> list=dao.listDepartment();
		for(DepartmentDTO dto : list) {
			System.out.print(dto.getDeptNo()+"\t");
			System.out.println(dto.getDeptName());
		}
		System.out.println();
		
	}

	
}
