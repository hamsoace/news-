package DAO;

import models.Departments;
import models.Employee;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
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
        String sql = "INSERT INTO departmentsEmployees(departmentId, employeeId) VALUES (:departmentId, :employeeId)";
        try (Connection con = sql2o.open()){
            con.createQuery(sql).addParameter("departmentId", departments.getId())
                    .addParameter("employeeId", employee.getId())
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Employee> getAllEmployeesToDepartment(int id) {
        ArrayList<Employee> allEmployees = new ArrayList<>();
        String join = "SELECT employeeId FROM departmentEmployees WHERE departmentId = :departmentId";
        try(Connection con = sql2o.open()){
            List<Integer>allEmployeeId = con.createQuery(join)
                    .addParameter("departmentId", id)
                    .executeAndFetch(Integer.class);
            for (Integer employeeId: allEmployeeId){
                String employeeQuery = "SELECT * FROM employees WHERE id= :employeeId";
                allEmployees.add(con.createQuery(employeeQuery)
                .addParameter("employeeId", employeeId)
                .executeAndFetchFirst(Employee.class));
            }
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
        return allEmployees;
    }

    @Override
    public Departments findById(int id) {
        String sql = "SELECT * FROM departments WHERE id = :id";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Departments.class);
        }
    }

    @Override
    public List<News> getAllNews(int id) {
        String sql = "SELECT * FROM news WHERE departmentId = :departmentId";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("departmentId", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM departments WHERE id = :id";
        String delete = "DELETE FROM departmentEmployees"
    }

    @Override
    public void clearAll() {

    }
}
