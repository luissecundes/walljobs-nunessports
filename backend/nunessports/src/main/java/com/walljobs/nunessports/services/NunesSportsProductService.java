package com.walljobs.nunessports.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.walljobs.nunessports.entities.NunesSportsProduct;
import com.walljobs.nunessports.repositories.NunesSportsProductRepository;

@Service
public class NunesSportsProductService {

	@Autowired
	private NunesSportsProductRepository nunesSportsProductRepository;
	
	public List<NunesSportsProduct> findAll(){
		var result = nunesSportsProductRepository.findAll();
		return result;
	}
	
	public NunesSportsProduct findById(Long id) {
		NunesSportsProduct result = nunesSportsProductRepository.findById(id).get();
		return result;
	} 
	
	  public NunesSportsProduct save(NunesSportsProduct product) {
	        return nunesSportsProductRepository.save(product);
	    }
	  
	  public NunesSportsProduct update(Long id, NunesSportsProduct updatedProduct) {
	        if (nunesSportsProductRepository.existsById(id)) {
	            updatedProduct.setId(id);
	            return nunesSportsProductRepository.save(updatedProduct);
	        } else {
	            return null;
	        }
	    }
	  
	  public void delete(Long id) {
	        nunesSportsProductRepository.deleteById(id);
	    }
}
