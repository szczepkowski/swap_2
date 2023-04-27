package pl.waw.great.swap.repository;

import pl.waw.great.swap.domain.Scan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScanRepository extends CrudRepository<Scan, String> {

    Scan findByEan(String ean);
}
