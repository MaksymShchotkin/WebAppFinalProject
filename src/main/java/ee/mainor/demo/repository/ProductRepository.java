package ee.mainor.demo.repository;

import ee.mainor.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();

//    List<Product> findAllByName(String name);


    @Query("""
            select * from product where name = :name;
            """)
    List<Product> findAllByName(String name);

}
