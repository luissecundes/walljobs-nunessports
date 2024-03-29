package com.walljobs.nunessports.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walljobs.nunessports.entities.NunesSportsProduct;
import com.walljobs.nunessports.exceptions.NunesSportsException;
import com.walljobs.nunessports.services.NunesSportsProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/products")
public class NunesSportsProductController {

    @Autowired
    private NunesSportsProductService nunesSportsProductService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            List<NunesSportsProduct> result = nunesSportsProductService.findAll();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NunesSportsException.ProductsNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            NunesSportsProduct result = nunesSportsProductService.findById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (NunesSportsException.ProductsNotFoundIdException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody NunesSportsProduct product) {
        try {
            nunesSportsProductService.save(product);
            return new ResponseEntity<>("Produto salvo com sucesso!", HttpStatus.CREATED);
        } catch (NunesSportsException.ProductNotSavedException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody NunesSportsProduct updatedProduct) {
        try {
            NunesSportsProduct updated = nunesSportsProductService.update(id, updatedProduct);
            if (updated != null) {
                return new ResponseEntity<>("Produto atualizado com sucesso!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Produto não encontrado.", HttpStatus.NOT_FOUND);
            }
        } catch (NunesSportsException.ProductNotUpdatedException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            nunesSportsProductService.delete(id);
            return new ResponseEntity<>("Produto excluído com sucesso!", HttpStatus.OK);
        } catch (NunesSportsException.ProductNotDeletedException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
