package com.rbu.logapp.log_audit_service.controller;

import com.rbu.logapp.log_audit_service.model.RbubusauditDTO;
import com.rbu.logapp.log_audit_service.service.RbubusauditService;
import com.rbu.logapp.log_audit_service.util.WebUtils;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/rbubusaudits")
public class RbubusauditController {

    private final RbubusauditService rbubusauditService;

    public RbubusauditController(final RbubusauditService rbubusauditService) {
        this.rbubusauditService = rbubusauditService;
    }

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("rbubusaudits", rbubusauditService.findAll());
        return "rbubusaudit/list";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("rbubusaudit") final RbubusauditDTO rbubusauditDTO) {
        return "rbubusaudit/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("rbubusaudit") @Valid final RbubusauditDTO rbubusauditDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "rbubusaudit/add";
        }
        rbubusauditService.create(rbubusauditDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("rbubusaudit.create.success"));
        return "redirect:/rbubusaudits";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable final Long id, final Model model) {
        model.addAttribute("rbubusaudit", rbubusauditService.get(id));
        return "rbubusaudit/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable final Long id,
            @ModelAttribute("rbubusaudit") @Valid final RbubusauditDTO rbubusauditDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "rbubusaudit/edit";
        }
        rbubusauditService.update(id, rbubusauditDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("rbubusaudit.update.success"));
        return "redirect:/rbubusaudits";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable final Long id, final RedirectAttributes redirectAttributes) {
        rbubusauditService.delete(id);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("rbubusaudit.delete.success"));
        return "redirect:/rbubusaudits";
    }

}
