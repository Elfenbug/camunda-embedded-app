package ru.ibs.camundaembeddedapp.service;

import org.springframework.stereotype.Service;
import ru.ibs.camundaembeddedapp.domain.ApproveRequest;
import ru.ibs.camundaembeddedapp.repository.ApproveRequestRepository;

import java.util.Optional;

@Service
public class ApproveRequestServiceImpl implements ApproveRequestService {

    private final ApproveRequestRepository approveRequestRepository;

    public ApproveRequestServiceImpl(ApproveRequestRepository approveRequestRepository) {
        this.approveRequestRepository = approveRequestRepository;
    }

    @Override
    public Long create(Long entityId, String username, String comment) {
        ApproveRequest approveRequest = new ApproveRequest();
        approveRequest.setEntityId(entityId);
        approveRequest.setUsername(username);
        approveRequest.setComment(comment);

        return approveRequestRepository.save(approveRequest).getId();
    }

    @Override
    public void update(Long entityId, String approver, Boolean isApproved) {
        Optional<ApproveRequest> accessRequestOpt = approveRequestRepository.findAllByEntityId(entityId);
        if (accessRequestOpt.isPresent()) {
            ApproveRequest approveRequest = accessRequestOpt.get();
            approveRequest.setApprover(approver);
            approveRequest.setApproved(isApproved);
            approveRequestRepository.saveAndFlush(approveRequest);
        }

    }
}
