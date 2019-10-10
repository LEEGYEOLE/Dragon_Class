package sya.gyeoukgyung.lecture;
/**
 * �������� 
 */
public class LectureDTO {
	private int lectureNo;		//���� ��ȣ
	private	String division;	//�̼�����
	private	String mkYear;		//��������
	private int semester;		//�б�
	private	String cDay;		//��������
	private	String startTime;	//���۽ð�
	private	String endTime;		//����ð�
	private int credit;		//����
	private int count;		//����
	private int professorNo;	//������ȣ 
	private int subNo;		//�����ȣ 
	private int roomNo;		//���ǽǹ�ȣ 
	
	public LectureDTO() {
	}

	public LectureDTO(int lectureNo, String division, String mkYear, int semester, String cDay, String startTime,
			String endTime, int credit, int count, int professorNo, int subNo, int roomNo) {
		this.lectureNo = lectureNo;
		this.division = division;
		this.mkYear = mkYear;
		this.semester = semester;
		this.cDay = cDay;
		this.startTime = startTime;
		this.endTime = endTime;
		this.credit = credit;
		this.count = count;
		this.professorNo = professorNo;
		this.subNo = subNo;
		this.roomNo = roomNo;
	}

	public int getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getMkYear() {
		return mkYear;
	}

	public void setMkYear(String mkYear) {
		this.mkYear = mkYear;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getCDay() {
		return cDay;
	}

	public void setCDay(String cDay) {
		this.cDay = cDay;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getProfessorNo() {
		return professorNo;
	}

	public void setProfessorNo(int professorNo) {
		this.professorNo = professorNo;
	}

	public int getSubNo() {
		return subNo;
	}

	public void setSubNo(int subNo) {
		this.subNo = subNo;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	@Override
	public String toString() {
		return "LectureDTO [lectureNo=" + lectureNo + ", division=" + division + ", mkYear=" + mkYear + ", semester="
				+ semester + ", cDay=" + cDay + ", startTime=" + startTime + ", endTime=" + endTime + ", credit=" + credit
				+ ", count=" + count + ", professorNo=" + professorNo + ", subNo=" + subNo + ", roomNo=" + roomNo + "]";
	}
}
