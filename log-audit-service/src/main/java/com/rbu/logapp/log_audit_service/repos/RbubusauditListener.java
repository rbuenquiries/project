package com.rbu.logapp.log_audit_service.repos;

import com.rbu.logapp.log_audit_service.domain.Rbubusaudit;
import com.rbu.logapp.log_audit_service.service.PrimarySequenceService;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


@Component
public class RbubusauditListener extends AbstractMongoEventListener<Rbubusaudit> {

    private final PrimarySequenceService primarySequenceService;

    public RbubusauditListener(final PrimarySequenceService primarySequenceService) {
        this.primarySequenceService = primarySequenceService;
    }

    @Override
    public void onBeforeConvert(final BeforeConvertEvent<Rbubusaudit> event) {
        if (event.getSource().getId() == null) {
            event.getSource().setId(primarySequenceService.getNextValue());
        }
    }

}
