package javaFI.newjava8;

public class StudentDemoDto {

    private int sId;
    private String sName;
    private String sAddress;

    public StudentDemoDto(int sId, String sName, String sAddress) {
        this.sId = sId;
        this.sName = sName;
        this.sAddress = sAddress;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    @Override
    public String toString() {
        return "\nStudentDemoDto{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sAddress='" + sAddress + '\'' +
                '}';
    }
}
