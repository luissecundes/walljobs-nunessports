// Products.js
import React, { useState, useEffect } from 'react';
import styles from './Product.module.css';  
import ProductTable from './ProductTable';

function Products() {
  const [productList, setProductList] = useState([]);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await fetch('http://localhost:8080/products');
        const data = await response.json();
        setProductList(data);
      } catch (error) {
        console.error('Erro ao buscar produtos:', error);
      }
    };

    fetchProducts();
  }, []); 

  return (
    <div className={styles.Products}>
      <h1 className={styles.ProductsTitle}>Lista de Produtos</h1>
      <ProductTable productList={productList} />
    </div>
  );
}

export default Products;
