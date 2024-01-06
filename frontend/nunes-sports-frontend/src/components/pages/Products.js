import React, { useState, useEffect } from 'react';
import styles from './Product.module.css';  
import ProductTable from './ProductTable';
import DeleteProductsDialog from '../modal/DeleteProductsDialog';  
import { useNavigate } from 'react-router-dom';

function Products() {
  const [productList, setProductList] = useState([]);
  const [selectedProductId, setSelectedProductId] = useState(null);
  const [deleteDialogOpen, setDeleteDialogOpen] = useState(false); // Estado para controlar a abertura do modal
  const navigate = useNavigate(); // Adicionando o hook useNavigate

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

  const handleDelete = (productId) => {
    setSelectedProductId(productId);
    setDeleteDialogOpen(true);
  };

  const handleDeleteConfirmed = async () => {
    try {
      const response = await fetch(`http://localhost:8080/products/${selectedProductId}`, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json',
        },
      });

      if (response.ok) {
        console.log('Produto excluído com sucesso.');
        const updatedProducts = productList.filter((product) => product.id !== selectedProductId);
        setProductList(updatedProducts);
      } else {
        console.error('Erro ao excluir o produto:', response.statusText);
      }
    } catch (error) {
      console.error('Erro ao excluir o produto:', error);
    } finally {
      setDeleteDialogOpen(false);
    }
  };

  const handleDeleteCancelled = () => {
    setDeleteDialogOpen(false);
  };

  const handleEdit = (productId) => {
    navigate(`/producteditform/${productId}`);
  };

  return (
    <div className={styles.Products}>
      <h1 className={styles.ProductsTitle}>Lista de Produtos</h1>
      <ProductTable productList={productList} onDelete={handleDelete} onEdit={handleEdit} />

      <DeleteProductsDialog
        open={deleteDialogOpen}
        onClose={handleDeleteCancelled}
        onConfirm={handleDeleteConfirmed}
        title="Excluir Produto"
        message="Tem certeza que deseja excluir este produto?"
      />
    </div>
  );
}

export default Products;
