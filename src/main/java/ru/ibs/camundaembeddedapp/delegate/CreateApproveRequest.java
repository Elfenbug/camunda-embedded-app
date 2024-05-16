package ru.ibs.camundaembeddedapp.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.ibs.camundaembeddedapp.config.ProcessVariableConstants;
import ru.ibs.camundaembeddedapp.service.ApproveRequestService;

@Component
public class CreateApproveRequest implements JavaDelegate {
    private final ApproveRequestService approveRequestService;

    public CreateApproveRequest(ApproveRequestService approveRequestService) {
        this.approveRequestService = approveRequestService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String username = (String) delegateExecution.getVariable(ProcessVariableConstants.USERNAME);
        String comment = (String) delegateExecution.getVariable(ProcessVariableConstants.COMMENT);
        Long entityId = (Long) delegateExecution.getVariable(ProcessVariableConstants.ENTITY_ID);

        Long id = approveRequestService.create(entityId, username, comment);

        delegateExecution.setVariable(ProcessVariableConstants.ID, id);
    }
}
