package com.rbu.logapp.log_audit_service.repos;

import com.rbu.logapp.log_audit_service.domain.Rbubusaudit;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RbubusauditRepository extends MongoRepository<Rbubusaudit, Long> {
}
