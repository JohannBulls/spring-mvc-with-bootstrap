package co.edu.escuelaing.cvds.lab7.repository;

import co.edu.escuelaing.cvds.lab7.model.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, String> {
    List<Configuration> findByPropiedad(String propiedad);

    @Query("SELECT c.completed, COUNT(c) FROM Configuration c GROUP BY c.completed")
    List<Object[]> countConfigurationsGroupedByCompleted();
}
