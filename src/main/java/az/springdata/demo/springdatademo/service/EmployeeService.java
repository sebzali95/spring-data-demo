package az.springdata.demo.springdatademo.service;

import az.springdata.demo.springdatademo.model.Address;
import az.springdata.demo.springdatademo.model.Employee;
import az.springdata.demo.springdatademo.repository.AddressRepository;
import az.springdata.demo.springdatademo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;

    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> getEmployeesByNameAndSurname(String name, String surname) {
        return employeeRepository.findByNameAndSurname(name, surname);
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with given id"));
    }

    public void insert(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    public void update(Employee employee, Address address) {
        addressRepository.save(address);

        if (employee.getId() <= 0) {
            throw new IllegalArgumentException("id can not be empty");
        }
        employeeRepository.save(employee);
    }

    public void delete(long id) {
        employeeRepository.deleteById(id);
    }
}
