package ru.ibs.camundaembeddedapp.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.ibs.camundaembeddedapp.config.ProcessVariableConstants;
import ru.ibs.camundaembeddedapp.service.ApproveRequestService;

@Component
public class UpdateApproveRequest implements JavaDelegate {

    private final ApproveRequestService approveRequestService;

    public UpdateApproveRequest(ApproveRequestService approveRequestService) {
        this.approveRequestService = approveRequestService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long entityId = (Long) delegateExecution.getVariable(ProcessVariableConstants.ENTITY_ID);
        String approver = (String) delegateExecution.getVariable(ProcessVariableConstants.APPROVER);
        Boolean isApproved = (Boolean) delegateExecution.getVariable(ProcessVariableConstants.IS_APPROVED);

        approveRequestService.update(entityId, approver, isApproved);
    }
}
