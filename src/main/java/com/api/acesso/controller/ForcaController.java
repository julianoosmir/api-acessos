package com.api.acesso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.acesso.entity.Forca;
import com.api.acesso.service.ForcaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/forca")
public class ForcaController {

    @Autowired
    private ForcaService forcaService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('PLAYER')")
    public Forca getForca(@PathVariable Long id) {
        return forcaService.forcaById(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER') or hasAuthority('PLAYER')")
    public List<Forca> getAll() {
        return this.forcaService.getForcas();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Forca salvar(@RequestBody Forca forca) throws Exception {
        return this.forcaService.save(forca);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Forca alterar(@RequestBody Forca forca) throws Exception {
        return this.forcaService.save(forca);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void testDelete(@PathVariable Long id) {
        this.forcaService.delete(id);
    }
}
