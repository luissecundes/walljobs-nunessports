import styles from './Home.module.css'
import savings from '../../img/savings.png'
import LinkButton from '../layouts/LinkButton';

function Home() {
  return (
    <section className={styles.home_container}>
      <h1>Bem-vindo à <span>Nunes Sports</span></h1>
      <p>Gerencie aqui os seus produtos!</p>
      <LinkButton to="/addproducts" text="Adicionar Produto" />
      <img src={savings} alt='Nunes Sports'></img>
    </section>
  );
}

export default Home