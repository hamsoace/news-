package DAO;

import models.Departments;
import models.Employee;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentsDAO implements DepartmentsDAO{

    private final Sql2o sql2o;

    public Sql2oDepartmentsDAO(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Departments departments){
        String sql = "INSERT INTO departments (departmentName, departmentDesc, departmentEmployees) VALUES (:departmentName, :departmentDesc, :departmentEmployees)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true).bind(departments)
                    .executeUpdate().getKey();
            departments.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Departments> getAllDepartments() {
        String sql = "SELECT * FROM departments";
        try (Connection con = sql2o.open()){
         return con.createQuery(sql).executeAndFetch(Departments.class);
        }
    }

    @Override
    public void addDepartmentEmployees(Departments departments, Employee employee) {

    }

    @Override
    public List<Employee> getAllEmployeesToDepartment(int id) {
        return null;
    }

    @Override
    public Departments findById(int id) {
        return null;
    }

    @Override
    public List<News> getAllNews(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
