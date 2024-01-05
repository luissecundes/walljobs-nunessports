import React, { useState, useEffect } from 'react';
import styles from './Product.module.css'

function Products() {
  const [productList, setProductList] = useState([]);

  useEffect(() => {
    // Função para buscar a lista de produtos do servidor
    const fetchProducts = async () => {
      try {
        const response = await fetch('http://localhost:8080/products');
        const data = await response.json();
        setProductList(data);
      } catch (error) {
        console.error('Erro ao buscar produtos:', error);
      }
    };

    // Chame a função de busca ao montar o componente
    fetchProducts();
  }, []); // O segundo parâmetro [] assegura que o useEffect só será chamado na montagem inicial

  return (
    <div className={styles.Products}>
      <h1 className={styles.ProductsTitle}>Produtos</h1>
      <table className={styles.ProductsTable}>
        <thead>
          <tr>
            <th>Nome do Produto</th>
            <th>Descrição do Produto</th>
            <th>Preço do Produto</th>
          </tr>
        </thead>
        <tbody>
          {productList.map((product) => (
            <tr key={product.id} className={styles.ProductItem}>
              <td className={styles.ProductName}>{product.name}</td>
              <td className={styles.ProductDescription}>{product.description}</td>
              <td>R${product.price.toFixed(2)}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Products;
