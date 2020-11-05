package DAO;

import models.Departments;
import models.Employee;

import java.util.List;

public interface EmployeeDAO {
    void add(Employee employee);

    List<Employee>getAllEmployees();
    Employee findById(int id);

    void addEmployeeDepartment(Employee employee, Departments departments);
    List<Departments>getAllDepartmentOfEmployees(int employeeId);

    void deleteById(int id);

    void clearAll();
}
