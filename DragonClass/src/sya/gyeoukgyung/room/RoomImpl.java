package sya.gyeoukgyung.room;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class RoomImpl implements Room{
	private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	private RoomDAO dao = new RoomDAOImpl();
	
	/**
	 * 방 정보를 등록하는 메소드
	 * -관리자
	 */
	@Override
	public void insertRoom() {
		System.out.println("\n방 등록...");
		
		try {
			RoomDTO dto=new RoomDTO();
			
			System.out.print("등록하고자 하는 방이름을 입력하시오 : ");
			dto.setRoomName(br.readLine().trim());	
			
			System.out.print("등록하고자 하는 방의 건물명을 입력하시오 : ");
			dto.setBuildingName(br.readLine().trim());

			int result = dao.insertRoom(dto);
			if(result>=1)
				System.out.println("방 등록에 성공했습니다!");
			else
				System.out.println("방 등록에 실패했습니다...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
	}
	
	/**
	 * 방 정보를 삭제하는 메소드
	 * -관리자
	 */
	@Override
	public void deleteRoom() {
		System.out.println("\n방 삭제...");
		
		try {
			int num;
			
			// 방의 전체 리스트를 보여준다
			System.out.println("\n방 전체 출력...");
			List<RoomDTO> list=dao.listRoom();
			for(int i=0; i<list.size(); i++) {
				RoomDTO dto=list.get(i);
				System.out.print(i+"\t");
				System.out.print(dto.getRoomName()+"\t");
				System.out.println(dto.getBuildingName());
			}
			
			// 그 다음 임의로 준 번호를 입력하여 삭제하고자 하는 방을 선택한다.
			do {
				System.out.print("삭제하고자 하는 방의 번호를 입력하시오 : ");
				num=Integer.parseInt(br.readLine());
			} while(num>list.size()||num<0);
			
		
			int result=dao.deleteRoom(list.get(num).getRoomNo());
			
			if(result>=1) {
				System.out.println("방 삭제에 성공했습니다!");
			} else {
				System.out.println("방 삭제에 실패했습니다...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		
	}
	
	/**
	 * 방 정보를 전체 출력하는 메소드
	 * -관리자
	 */
	@Override
	public void listRoom() {
		System.out.println("\n방 전체 출력...");
		
		List<RoomDTO> list=dao.listRoom();
		for(RoomDTO dto : list) {
			System.out.print(dto.getRoomNo()+"\t");
			System.out.print(dto.getRoomName()+"\t");
			System.out.println(dto.getBuildingName());
		}
		System.out.println();
		
	}

	@Override
	public void findByRoomName() {
		System.out.println("\n방 이름으로 방 검색...");
		
		try {
			String roomName;
			
			System.out.print("찾고자하는 방의 이름을 입력하시오 : ");
			roomName=br.readLine();
			
			List<RoomDTO> list=dao.findByRoomName(roomName);
			if(list.size()==0) {
				System.out.println("등록된 방이 없습니다...");
				return;
			}
			
			System.out.println("\n검색된 방...");
			for(RoomDTO dto : list) {
				System.out.print(dto.getRoomNo()+"\t");
				System.out.print(dto.getRoomName()+"\t");
				System.out.println(dto.getBuildingName());
			}
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
