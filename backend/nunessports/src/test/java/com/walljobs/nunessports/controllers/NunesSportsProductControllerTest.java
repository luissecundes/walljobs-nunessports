package com.walljobs.nunessports.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.walljobs.nunessports.entities.NunesSportsProduct;
import com.walljobs.nunessports.exceptions.NunesSportsException;
import com.walljobs.nunessports.services.NunesSportsProductService;

@ExtendWith(MockitoExtension.class)
public class NunesSportsProductControllerTest {

    @Mock
    private NunesSportsProductService productService;

    @InjectMocks
    private NunesSportsProductController productController;

    @Test
    public void testFindAllSuccess() {
        when(productService.findAll()).thenReturn(Arrays.asList(new NunesSportsProduct(), new NunesSportsProduct()));
        ResponseEntity<?> response = productController.findAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void testFindAllNotFound() {
        when(productService.findAll()).thenThrow(new NunesSportsException.ProductsNotFoundException());
        ResponseEntity<?> response = productController.findAll();
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Não foi possível encontrar a lista de produtos.", response.getBody());
    }

    @Test
    public void testFindByIdSuccess() {
        when(productService.findById(1L)).thenReturn(new NunesSportsProduct());
        ResponseEntity<?> response = productController.findById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void testFindByIdNotFound() {
        when(productService.findById(1L)).thenThrow(new NunesSportsException.ProductsNotFoundIdException(1L));

        ResponseEntity<?> response = productController.findById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Não foi possível encontrar o produto com ID 1.", response.getBody());
    }


}
