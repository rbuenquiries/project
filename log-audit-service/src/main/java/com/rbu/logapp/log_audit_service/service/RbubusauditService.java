package com.rbu.logapp.log_audit_service.service;

import com.rbu.logapp.log_audit_service.domain.Rbubusaudit;
import com.rbu.logapp.log_audit_service.model.RbubusauditDTO;
import com.rbu.logapp.log_audit_service.repos.RbubusauditRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class RbubusauditService {

    private final RbubusauditRepository rbubusauditRepository;

    public RbubusauditService(final RbubusauditRepository rbubusauditRepository) {
        this.rbubusauditRepository = rbubusauditRepository;
    }

    public List<RbubusauditDTO> findAll() {
        return rbubusauditRepository.findAll(Sort.by("id"))
                .stream()
                .map(rbubusaudit -> mapToDTO(rbubusaudit, new RbubusauditDTO()))
                .collect(Collectors.toList());
    }

    public RbubusauditDTO get(final Long id) {
        return rbubusauditRepository.findById(id)
                .map(rbubusaudit -> mapToDTO(rbubusaudit, new RbubusauditDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final RbubusauditDTO rbubusauditDTO) {
        final Rbubusaudit rbubusaudit = new Rbubusaudit();
        mapToEntity(rbubusauditDTO, rbubusaudit);
        return rbubusauditRepository.save(rbubusaudit).getId();
    }

    public void update(final Long id, final RbubusauditDTO rbubusauditDTO) {
        final Rbubusaudit rbubusaudit = rbubusauditRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(rbubusauditDTO, rbubusaudit);
        rbubusauditRepository.save(rbubusaudit);
    }

    public void delete(final Long id) {
        rbubusauditRepository.deleteById(id);
    }

    private RbubusauditDTO mapToDTO(final Rbubusaudit rbubusaudit,
            final RbubusauditDTO rbubusauditDTO) {
        rbubusauditDTO.setId(rbubusaudit.getId());
        rbubusauditDTO.setDescription(rbubusaudit.getDescription());
        rbubusauditDTO.setProblemtype(rbubusaudit.getProblemtype());
        return rbubusauditDTO;
    }

    private Rbubusaudit mapToEntity(final RbubusauditDTO rbubusauditDTO,
            final Rbubusaudit rbubusaudit) {
    	rbubusaudit.setProblemtype(rbubusauditDTO.getProblemtype());
        rbubusaudit.setDescription(rbubusauditDTO.getDescription());
        return rbubusaudit;
    }

}
