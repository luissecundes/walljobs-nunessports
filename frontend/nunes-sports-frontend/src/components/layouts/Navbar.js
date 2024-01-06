import { Link } from 'react-router-dom'
import Container from './Container'
import styles from './Navbar.module.css'
import logo from '../../img/logo.png'

function Navbar() {
  return (
    <nav className={styles.navbar}>
      <Container>
        <Link to="/"><img className={styles.logo} src={logo} alt="Logo"></img></Link>
        <ul className={styles.list}>
          <li className={styles.item}><Link to="/">Home</Link></li>
          <li className={styles.item}> <Link to="/products">Produtos</Link></li>
          <li className={styles.item}><Link to="/company">Sobre nós</Link></li>
          <li className={styles.item}><Link to="/addproducts">Adicionar Produtos</Link></li>
        </ul>
      </Container>
    </nav>
  )
}

export default Navbar