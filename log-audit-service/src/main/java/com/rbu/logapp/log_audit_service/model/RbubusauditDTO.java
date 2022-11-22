package com.rbu.logapp.log_audit_service.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RbubusauditDTO {

    private Long id;

    @NotNull
    @Size(max = 5000)
    private String description;
    @NotNull
    @Size(max = 10)
    private String problemtype;

}
