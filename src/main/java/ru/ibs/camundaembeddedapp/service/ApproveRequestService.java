package ru.ibs.camundaembeddedapp.service;

public interface ApproveRequestService {
    Long create(Long entityId, String username, String comment);
    void update(Long entityId, String approver, Boolean isApproved);
}
