import styles from './ProductForm.module.css'
import Input from '../form/Input'
import SubmitButton from '../form/SubmitButton'


function Productform({btnText}) {
  return (
    <form className={styles.form}>      
      <Input type="text" text="Nome do Produto" placeholder="Insira o nome do produto"/>
      <Input type="text" text="Descrição do Produto" placeholder="Insira a descrição do produto"/>
      <Input type="number" text="Preço do Produto" placeholder="Insira o preço do produto"/>
      <SubmitButton text={btnText}/>
    </form>
  )
}

export default Productform