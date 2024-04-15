package ee.mainor.demo.repository;

import ee.mainor.demo.model.Employee;
import ee.mainor.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findAll();

//    List<Product> findAllByName(String name);


    @Query("""
            select * from employee where name = :name;
            """)
    List<Employee> findAllByName(String name);

}
