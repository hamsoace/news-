package models;

import java.util.Objects;

public class Departments {

    private int id;
    private String departmentName;
    private String departmentDesc;
    private int departmentEmployees;


    public Departments(String departmentName, String departmentDesc, int departmentEmployees) {
        this.departmentName = departmentName;
        this.departmentDesc = departmentDesc;
        this.departmentEmployees = departmentEmployees;
    }

    @Override
    public int hashCode(){
        return Objects.hash(departmentName, departmentDesc, departmentEmployees, id);
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

    public int getDepartmentEmployees() {
        return departmentEmployees;
    }

    public void setDepartmentEmployees(int departmentEmployees) {
        this.departmentEmployees = departmentEmployees;
    }
}
