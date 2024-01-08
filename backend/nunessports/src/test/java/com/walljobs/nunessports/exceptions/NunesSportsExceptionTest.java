package com.walljobs.nunessports.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.walljobs.nunessports.exceptions.NunesSportsException;

public class NunesSportsExceptionTest {

    @Test
    public void testProductsNotFoundException() {
        NunesSportsException.ProductsNotFoundException exception = new NunesSportsException.ProductsNotFoundException();
        assertEquals("Não foi possível encontrar a lista de produtos.", exception.getMessage());
    }

    @Test
    public void testProductsNotFoundIdException() {
        long productId = 1L;
        NunesSportsException.ProductsNotFoundIdException exception = new NunesSportsException.ProductsNotFoundIdException(productId);
        assertEquals("Não foi possível encontrar a lista de produtos.", exception.getMessage());
    }

    @Test
    public void testProductNotSavedException() {
        NunesSportsException.ProductNotSavedException exception = new NunesSportsException.ProductNotSavedException();
        assertEquals("Não foi possível salvar o produto na base de dados.", exception.getMessage());
    }

    @Test
    public void testProductNotUpdatedException() {
        long productId = 1L;
        NunesSportsException.ProductNotUpdatedException exception = new NunesSportsException.ProductNotUpdatedException(productId);
        assertEquals("Não foi possível atualizar o produto com ID 1.", exception.getMessage());
    }

    @Test
    public void testProductNotDeletedException() {
        long productId = 1L;
        NunesSportsException.ProductNotDeletedException exception = new NunesSportsException.ProductNotDeletedException(productId);
        assertEquals("Não foi possível excluir o produto com ID: 1.", exception.getMessage());
    }
}
