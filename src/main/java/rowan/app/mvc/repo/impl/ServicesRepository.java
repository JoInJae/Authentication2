package rowan.app.mvc.repo.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rowan.app.data.vo.Services;

import java.util.Optional;

@Repository
public interface ServicesRepository extends JpaRepository<Services, String> {

    Optional<Services> getByName(String name);
    boolean existByType(String type);

}
