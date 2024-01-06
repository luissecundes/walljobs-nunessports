import React from 'react';
import styles from './ProductTable.module.css';

function ProductTable({ productList }) {
  return (
    <table className={styles.ProductsTable}>
      <thead>
        <tr className={styles.titles}>
          <th>Nome do Produto</th>
          <th>Descrição do Produto</th>
          <th>Valor</th>
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
  );
}

export default ProductTable;
