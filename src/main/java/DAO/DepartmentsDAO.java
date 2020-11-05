package DAO;

import models.Departments;
import models.Employee;
import models.News;

import java.util.List;

public interface DepartmentsDAO {

    void add(Departments departments);

    List<Departments>getAllDepartments();

    void addDepartmentEmployees(Departments departments, Employee employee);
    List<Employee>getAllEmployeesToDepartment(int id);

    Departments findById(int id);
    List<News>getAllNews(int id);

    void deleteById(int id);
    void clearAll();
}
