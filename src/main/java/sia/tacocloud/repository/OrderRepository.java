package sia.tacocloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import sia.tacocloud.domain.Oreder;

@Repository
public interface OrderRepository extends CrudRepository<Oreder, Long> {
    List<Oreder> findByZip(String zip);
}
