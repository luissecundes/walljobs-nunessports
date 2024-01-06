import { useState } from "react";
import styles from "./ProductForm.module.css";
import Input from "../form/Input";
import SubmitButton from "../form/SubmitButton";

function ProductForm({ handleSubmit, btnText, productData }) {
  const [product, setProduct] = useState(productData || {});

  const submit = (e) => {
    e.preventDefault();
    handleSubmit(product);
  };

  const handleChange = (e) => {
    setProduct({ ...product, [e.target.name]: e.target.value });
  };

  return (
    <form onSubmit={submit} className={styles.form}>
      <Input
        type="text"
        text="Nome do Produto"
        placeholder="Insira o nome do produto"
        handleOnChange={handleChange}
        value={product.name || ""}
        name="name"
      />
      <Input
        type="text"
        text="Descrição do Produto"
        placeholder="Insira a descrição do produto"
        handleOnChange={handleChange}
        value={product.description || ""}
        name="description"
      />
      <Input
        type="number"
        text="Preço do Produto"
        placeholder="Insira o preço do produto"
        handleOnChange={handleChange}
        value={product.price || ""}
        name="price"
      />
      <SubmitButton text={btnText} />
    </form>
  );
}

export default ProductForm;
