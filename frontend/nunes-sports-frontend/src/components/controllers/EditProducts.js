// EditProducts.jsx
import { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import styles from './EditProducts.module.css';
import ProductEditForm from '../forms/ProductEditForm';

function EditProducts() {
  const navigate = useNavigate();
  const { productId } = useParams();

  const handleEditSubmit = async (product) => {
    try {
      const response = await updateProduct(productId, product);
      console.log(response);
      navigate('/products'); 
    } catch (error) {
      console.error(error);
    }
  };

  const updateProduct = async (productId, updatedProduct) => {
    const requestOptions = {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(updatedProduct),
    };

    const response = await fetch(`http://localhost:8080/products/${productId}`, requestOptions);

    const contentType = response.headers.get('content-type');
    if (contentType && contentType.includes('application/json')) {
      return response.json();
    } else {
      return response.text();
    }
  };

  return (
    <div className={styles.editproducts_container}>
      <h1>Editar Produto</h1>
      <ProductEditForm handleSubmit={handleEditSubmit} btnText="Salvar Edição" productId={productId} />
    </div>
  );
}

export default EditProducts;