package DAO;

import models.Departments;
import models.Employee;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oEmployeeDAO implements EmployeeDAO {

    private final Sql2o sql2o;
    public Sql2oEmployeeDAO(Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
    public void add(Employee employee) {
        String sql = "INSERT INTO employees(name, employeePosition, role, department) VALUES (:name, :employeePosition, :role, :department)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(employee)
                    .executeUpdate()
                    .getKey();
            employee.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql).executeAndFetch(Employee.class);
        }
    }

    @Override
    public Employee findById(int id) {
        String sql = "SELECT * FROM employees WHERE id = :id";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Employee.class);
        }
    }

    @Override
    public void addEmployeeDepartment(Employee employee, Departments departments) {
        String sql = "INSERT INTO departmentEmployees(departmentId, employeeId) VALUES (:departmentId, :employeeId)";
        try (Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("departmentId", departments.getId())
                    .addParameter("employeeId", employee.getId())
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Departments> getAllDepartmentOfEmployees(int employeeId) {
        ArrayList<Departments> allDepartments = new ArrayList<>();
        String join = "SELECT departmentId FROM departmentEmployees WHERE employeeId = :employeeId";
        try (Connection con = sql2o.open()){
            List<Integer> allDepartmentIds = con.createQuery(join)
                    .addParameter("employeeId", employeeId)
                    .executeAndFetch(Integer.class);
            for(Integer departmentId : allDepartmentIds){
                String departmentQuery = "SELECT * FROM departments WHERE id = :departmentId";
                allDepartments.add(con.createQuery(departmentQuery)
                .addParameter("departmentId", departmentId)
                .executeAndFetchFirst(Departments.class));
            }
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
        return allDepartments;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM employees WHERE id =:id";
        try (Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM employees";
        try (Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
