package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class asdf {
	public static void main(String[] args) {
//		EmployeeDTO dto = new EmployeeDTO();
//		StudentDTO dto1 = new StudentDTO();
//		dto.setInfoNo(1);
//
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("employee", dto);
//		map.put("student", dto1);
//
//		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
//		list.add(map);
//
//		EmployeeDTO e = (EmployeeDTO) list.get(0).get("employee");
//		StudentDTO s = (StudentDTO) list.get(0).get("student");
//		System.out.println(e.getInfoNo());

		// list.add((Object) dto);
//		list.add((Object) dto1);
//		EmployeeDTO o = (EmployeeDTO) list.get(0);
//		System.out.println(o.getInfoNo());
		
		
//		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		
//		while(rs.next()) {
//			map = new HashMap<String, Object>();
//			map.put("info_no", String.valueOf(rs.getInt("info_no")));
//			//put으로 가져온 컬럼 맵에 다 넣기, 컬럼의 개수만큼 맵에 풋
//		
//			//마지막에 리스트에 맵 넣기
//			list.add(map);
//		}//와일문 끝.
		
		//리스트 리턴
//
		String rrn = "951127-2422442";
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
		System.out.println(birthStr);
//
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.KOREAN);
//		try {
//			Date birthDay = sdf.parse(birthStr);
//			System.out.println(birthDay);
//		} catch (ParseException e) {
//		}

	}
}
