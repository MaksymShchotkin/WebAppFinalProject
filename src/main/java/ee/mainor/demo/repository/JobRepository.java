package ee.mainor.demo.repository;

import ee.mainor.demo.model.Employee;
import ee.mainor.demo.model.Job;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobRepository extends CrudRepository<Job, Long> {

    List<Job> findAll();

//    List<Product> findAllByName(String name);


    @Query("""
            select * from job where name = :name;
            """)
    List<Job> findAllByName(String name);

    @Query("""
            select * from job where name = :name;
            """)
    Job findByName(String name);
}
