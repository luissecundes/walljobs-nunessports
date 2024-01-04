package com.walljobs.nunessports.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walljobs.nunessports.entities.NunesSportsProduct;
import com.walljobs.nunessports.services.NunesSportsProductService;

@RestController
@RequestMapping(value = "/products")
public class NunesSportsProductController {

	@Autowired
	private NunesSportsProductService nunesSportsProductService;

	@GetMapping
	public List<NunesSportsProduct> findall() {
		var result = nunesSportsProductService.findAll();
		return result;
	}

	@GetMapping(value = "/{id}")
	public NunesSportsProduct findById(@PathVariable Long id) {
		NunesSportsProduct result = nunesSportsProductService.findById(id);
		return result;
	}

	@PostMapping
    public ResponseEntity<String> save(@RequestBody NunesSportsProduct product) {
        nunesSportsProductService.save(product);
        return new ResponseEntity<>("Produto salvo com sucesso!", HttpStatus.CREATED);
    }

	 @PutMapping(value = "/{id}")
	    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody NunesSportsProduct updatedProduct) {
	        NunesSportsProduct updated = nunesSportsProductService.update(id, updatedProduct);
	        if (updated != null) {
	            return new ResponseEntity<>("Produto atualizado com sucesso!", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Produto não encontrado.", HttpStatus.NOT_FOUND);
	        }
	    }

	 @DeleteMapping(value = "/{id}")
	    public ResponseEntity<String> delete(@PathVariable Long id) {
	        nunesSportsProductService.delete(id);
	        return new ResponseEntity<>("Produto excluído com sucesso!", HttpStatus.OK);
	    }

}
