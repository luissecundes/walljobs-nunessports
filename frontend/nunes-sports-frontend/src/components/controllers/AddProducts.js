import { useNavigate } from 'react-router-dom';
import styles from './AddProducts.module.css';
import ProductForm from '../forms/ProductForm';

function AddProducts() {
  const navigate = useNavigate();

  const handleProductSubmit = async (product) => {
    try {
      const response = await createProduct(product);
      console.log(response);
      navigate('/products');    } catch (error) {
      console.error(error);
    }
  };

  const createProduct = async (product) => {
    const requestOptions = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        name: product.name,
        description: product.description,
        price: product.price,
      }),
    };

    const response = await fetch('http://localhost:8080/products', requestOptions);

    const contentType = response.headers.get('content-type');
    if (contentType && contentType.includes('application/json')) {
      const result = await response.json();

      return result;
    } else {
      return response.text();
    }
  };

  return (
    <div className={styles.addproducts_container}>
      <h1>Adicionar Produto</h1>
      <p>Preencha os dados para adicionar o produto</p>
      <ProductForm handleSubmit={handleProductSubmit} btnText="Adicionar Produto" />
    </div>
  );
}

export default AddProducts;
