//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package io.swagger;

import io.swagger.model.Employee;
import io.swagger.model.Employees;
import java.util.Iterator;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
@Service
public class HRService {
    private static final Logger log = LoggerFactory.getLogger(HRService.class);
    Employees employees = new Employees();

    public HRService() {
    }

    public Employees getEmployees() {
        return this.employees;
    }

    public Employee getEmployeeId(int id) {
        Iterator var2 = this.employees.iterator();
        Employee employee;
        do {
            if (!var2.hasNext()) {
                return null;
            }
            employee = (Employee)var2.next();
        } while(employee.getId() != id);
        return employee;
    }

    public boolean setEmployees(Employee employee) {
        boolean check = false;
        boolean response = false;
        if(employee.getId()!=null) {
            for (int i = 0; i < employees.size(); i++) {
                Employee emp = employees.get(i);
//            System.out.println(emp.getId());
//            System.out.println(employee.getId());
                if (emp.getId().equals(employee.getId())) {
                    check = true;
                    log.info("Id indisponível!");
                }
            }
            if (!check) {
                log.info("Employee adicionado!");
                this.employees.add(employee);
                response = true;
            } else {
                log.info("Employee já existente!");
                response = false;
            }
        }else{
            log.info("id is null");
        }
        return response;
    }


    public Optional<Employee> deleteEmployees(int id) {
        Employee employeeclone = null;
        Iterator var3 = this.employees.iterator();
        while(var3.hasNext()) {
            Employee employee = (Employee)var3.next();
            if (employee.getId() == id) {
                log.info("Found employee with id:" + id);
                log.info("Employee Name:" + employee.getEmployeeName());
                employeeclone = employee;
                break;
            }
        }

        if (employeeclone != null) {
            this.employees.remove(employeeclone);
            log.info("Employee successfully deleted");
        } else {
            log.info("Employee not found! There's nothing to remove.");
        }

        return Optional.ofNullable(employeeclone);
    }
}
