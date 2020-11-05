package DAO;

import models.Departments;
import models.Employee;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

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
        return null;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public void addEmployeeDepartment(Employee employee, Departments departments) {

    }

    @Override
    public List<Departments> getAllDepartmentOfEmployees(int employeeId) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
