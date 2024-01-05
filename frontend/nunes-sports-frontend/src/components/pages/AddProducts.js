import styles from './AddProducts.module.css'
import ProductForm from '../products/ProductForm'

function AddProducts() {
  return  (
    <div className={styles.addproducts_container}>
      <h1>Adicionar Produto</h1>
      <p>Preencha os dados para adicionar o produto</p>
      <ProductForm btnText="Adicionar Produto"/>
    </div>
    )
}

export default AddProducts