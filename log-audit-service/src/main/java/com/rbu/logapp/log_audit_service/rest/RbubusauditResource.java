package com.rbu.logapp.log_audit_service.rest;

import com.rbu.logapp.log_audit_service.model.RbubusauditDTO;
import com.rbu.logapp.log_audit_service.service.LogService;
import com.rbu.logapp.log_audit_service.service.RbubusauditService;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/rbubusaudits", produces = MediaType.APPLICATION_JSON_VALUE)
public class RbubusauditResource {
	@Autowired
	private LogService logService;
    private final RbubusauditService rbubusauditService;

    public RbubusauditResource(final RbubusauditService rbubusauditService) {
        this.rbubusauditService = rbubusauditService;
    }

    @GetMapping
    public ResponseEntity<List<RbubusauditDTO>> getAllRbubusaudits() {
        return ResponseEntity.ok(rbubusauditService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RbubusauditDTO> getRbubusaudit(@PathVariable final Long id) {
        return ResponseEntity.ok(rbubusauditService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createRbubusaudit(
            @RequestBody @Valid final RbubusauditDTO rbubusauditDTO) {
    	logService.auditlogintofile(rbubusauditDTO.getProblemtype(),rbubusauditDTO.getDescription());
        return new ResponseEntity<>(rbubusauditService.create(rbubusauditDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRbubusaudit(@PathVariable final Long id,
            @RequestBody @Valid final RbubusauditDTO rbubusauditDTO) {
        rbubusauditService.update(id, rbubusauditDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRbubusaudit(@PathVariable final Long id) {
        rbubusauditService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
