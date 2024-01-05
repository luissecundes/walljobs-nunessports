import { useState, useEffect } from 'react'

import styles from './ProductForm.module.css'
import Input from '../form/Input'
import SubmitButton from '../form/SubmitButton'


function Productform({ btnText }) {

  const [products, setProducts] = useState([])

  useEffect(() => {
    fetch("http://localhost:8080/products", {
      method: "GET",
      headers: {
        'Content-Type': 'application/json',
      },
    })
      .then((resp) => resp.json())
      .then((data) => {
        setProducts(data)
      })
      .catch((err) => console.log(err))
  }, [])

  return (
    <form className={styles.form}>
      <Input type="text" text="Nome do Produto" placeholder="Insira o nome do produto" />
      <Input type="text" text="Descrição do Produto" placeholder="Insira a descrição do produto" />
      <Input type="number" text="Preço do Produto" placeholder="Insira o preço do produto" />
      <SubmitButton text={btnText} />
    </form>
  )
}

export default Productform