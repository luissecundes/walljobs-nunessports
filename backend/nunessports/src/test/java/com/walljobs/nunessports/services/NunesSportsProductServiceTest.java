package com.walljobs.nunessports.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.walljobs.nunessports.entities.NunesSportsProduct;
import com.walljobs.nunessports.repositories.NunesSportsProductRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class) 
public class NunesSportsProductServiceTest {

    @Mock
    private NunesSportsProductRepository productRepository;

    @InjectMocks
    private NunesSportsProductService productService;

    @Test
    public void testFindAll() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(new NunesSportsProduct(), new NunesSportsProduct()));
        List<NunesSportsProduct> result = productService.findAll();
        assertEquals(2, result.size());
    }
    
    @Test
    public void testFindAllEmptyList() {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());
        List<NunesSportsProduct> result = productService.findAll();
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    public void testFindById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(new NunesSportsProduct()));

        NunesSportsProduct result = productService.findById(1L);
        assertNotNull(result);
    }

    @Test
    public void testSave() {
        when(productRepository.save(any(NunesSportsProduct.class))).thenReturn(new NunesSportsProduct());
        NunesSportsProduct result = productService.save(new NunesSportsProduct());
        assertNotNull(result);
    }
    
    @Test
    public void testSaveVerifyRepositoryCall() {
        NunesSportsProduct productToSave = new NunesSportsProduct();
        productService.save(productToSave);
        verify(productRepository, times(1)).save(productToSave);
    }


    @Test
    public void testUpdate() {
        when(productRepository.existsById(1L)).thenReturn(true);
        when(productRepository.save(any(NunesSportsProduct.class))).thenReturn(new NunesSportsProduct());
        NunesSportsProduct result = productService.update(1L, new NunesSportsProduct());
        assertNotNull(result);
    }
    
    @Test
    public void testUpdateNotFound() {
        when(productRepository.existsById(1L)).thenReturn(false);
        NunesSportsProduct result = productService.update(1L, new NunesSportsProduct());
        assertNull(result);
    }

    @Test
    public void testDelete() {
        productService.delete(1L);
        verify(productRepository, times(1)).deleteById(1L);
    }
    
    @Test
    public void testDeleteVerifyRepositoryCall() {
        productService.delete(1L);
        verify(productRepository, times(1)).deleteById(1L);
    }
}
