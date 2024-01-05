import React from 'react';
import './index.css';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom'
import Home from './components/pages/Home'
import Company from './components/pages/Company'
import Products from './components/pages/Products'
import Container from './components/layouts/Container'

function App() {
  return (
    <Router>
      <div>
        <Link to="/">Home</Link>
        <Link to="/products">Produtos</Link>
        <Link to="/company">Sobre nós</Link>
      </div>
      <Routes>
        <Route path="/" element={<Container customClass="min-height"><Home /> </Container>} />
        <Route path="/products" element={<Container> <Products /></Container>} />
        <Route path="/company" element={<Container> <Company /></Container>} />
      </Routes>
      <p>Footer</p>
    </Router>
  );
}

export default App;
