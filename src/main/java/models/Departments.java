package models;

public class Departments {

    private int id;
    private String departmentName;
    private String departmentDesc;
    private int departmentNo;

    public Departments(String departmentName, String departmentDesc, int departmentNo) {
        this.departmentName = departmentName;
        this.departmentDesc = departmentDesc;
        this.departmentNo = departmentNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }

    public int getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(int departmentNo) {
        this.departmentNo = departmentNo;
    }
}
