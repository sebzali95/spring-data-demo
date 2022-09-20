package az.springdata.demo.springdatademo.repository;

import az.springdata.demo.springdatademo.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByName(String name);

    List<Employee> findByNameAndSurname(String name, String surname);

    List<Employee> findByNameOrSurname(String name, String surname);


    @Query("select e from Employee e where e.age> :age and e.salary< :salary")
    List<Employee> findSome(
            @Param("age") int age,
            @Param("salary") double salary);


    List<Employee> findByOrderByNameAsc();

    List<Employee> findTop10ByOrderByIdDesc();

    @Modifying(clearAutomatically = true)
    @Query("update Employee e set e.salary=e.salary*2 where e.name=:name")
    void updateEmpByName(@Param("name") String name);
}
