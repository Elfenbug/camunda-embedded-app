package ru.ibs.camundaembeddedapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.camundaembeddedapp.domain.ApproveRequest;

import java.util.Optional;

public interface ApproveRequestRepository extends JpaRepository<ApproveRequest, Long> {
    Optional<ApproveRequest> findAllByEntityId(Long entityId);
}
