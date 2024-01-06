// ProductTable.jsx
import React from 'react';
import styles from './ProductTable.module.css';
import DeleteButton from '../buttons/DeleteButton';
import EditButton from '../buttons/EditButton';

function ProductTable({ productList, onDelete, onEdit }) {
  return (
    <table className={styles.ProductsTable}>
      <thead>
        <tr className={styles.titles}>
          <th>Nome do Produto</th>
          <th>Descrição do Produto</th>
          <th>Valor</th>
          <th>Ações</th>
        </tr>
      </thead>
      <tbody>
        {productList.map((product) => (
          <tr key={product.id} className={styles.ProductItem}>
            <td className={styles.ProductName}>{product.name}</td>
            <td className={styles.ProductDescription}>{product.description}</td>
            <td>R${product.price.toFixed(2)}</td>
            <td>
              <DeleteButton onClick={() => onDelete(product.id)} />
              <EditButton onClick={() => onEdit(product.id)} />
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default ProductTable;
