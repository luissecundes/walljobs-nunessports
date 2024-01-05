import React, { useState, useEffect } from 'react';

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
    <div>
      <h1>Produtos</h1>
      <ul>
        {productList.map((product) => (
          <li key={product.id}>
            <strong>{product.name}</strong> - {product.description} - R${product.price.toFixed(2)}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Products;
