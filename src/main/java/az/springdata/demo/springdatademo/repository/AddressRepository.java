package az.springdata.demo.springdatademo.repository;

import az.springdata.demo.springdatademo.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Integer> {
}
