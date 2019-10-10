package sya.gyeoukgyung.room;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class RoomImpl implements Room{
	private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	private RoomDAO dao = new RoomDAOImpl();
	
	/**
	 * �� ������ ����ϴ� �޼ҵ�
	 * -������
	 */
	@Override
	public void insertRoom() {
		System.out.println("\n�� ���...");
		
		try {
			RoomDTO dto=new RoomDTO();
			
			System.out.print("����ϰ��� �ϴ� ���̸��� �Է��Ͻÿ� : ");
			dto.setRoomName(br.readLine().trim());	
			
			System.out.print("����ϰ��� �ϴ� ���� �ǹ����� �Է��Ͻÿ� : ");
			dto.setBuildingName(br.readLine().trim());

			int result = dao.insertRoom(dto);
			if(result>=1)
				System.out.println("�� ��Ͽ� �����߽��ϴ�!");
			else
				System.out.println("�� ��Ͽ� �����߽��ϴ�...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
	}
	
	/**
	 * �� ������ �����ϴ� �޼ҵ�
	 * -������
	 */
	@Override
	public void deleteRoom() {
		System.out.println("\n�� ����...");
		
		try {
			int num;
			
			// ���� ��ü ����Ʈ�� �����ش�
			System.out.println("\n�� ��ü ���...");
			List<RoomDTO> list=dao.listRoom();
			for(int i=0; i<list.size(); i++) {
				RoomDTO dto=list.get(i);
				System.out.print(i+"\t");
				System.out.print(dto.getRoomName()+"\t");
				System.out.println(dto.getBuildingName());
			}
			
			// �� ���� ���Ƿ� �� ��ȣ�� �Է��Ͽ� �����ϰ��� �ϴ� ���� �����Ѵ�.
			do {
				System.out.print("�����ϰ��� �ϴ� ���� ��ȣ�� �Է��Ͻÿ� : ");
				num=Integer.parseInt(br.readLine());
			} while(num>list.size()||num<0);
			
		
			int result=dao.deleteRoom(list.get(num).getRoomNo());
			
			if(result>=1) {
				System.out.println("�� ������ �����߽��ϴ�!");
			} else {
				System.out.println("�� ������ �����߽��ϴ�...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		
	}
	
	/**
	 * �� ������ ��ü ����ϴ� �޼ҵ�
	 * -������
	 */
	@Override
	public void listRoom() {
		System.out.println("\n�� ��ü ���...");
		
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
		System.out.println("\n�� �̸����� �� �˻�...");
		
		try {
			String roomName;
			
			System.out.print("ã�����ϴ� ���� �̸��� �Է��Ͻÿ� : ");
			roomName=br.readLine();
			
			List<RoomDTO> list=dao.findByRoomName(roomName);
			if(list.size()==0) {
				System.out.println("��ϵ� ���� �����ϴ�...");
				return;
			}
			
			System.out.println("\n�˻��� ��...");
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
