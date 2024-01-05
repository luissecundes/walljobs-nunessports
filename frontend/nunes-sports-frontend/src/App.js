import React from 'react';
import './index.css';
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import Home from './components/pages/Home'
import Company from './components/pages/Company'
import Products from './components/pages/Products'
import Container from './components/layouts/Container'
import Navbar from './components/layouts/Navbar'
import Footer from './components/layouts/Footer'
import AddProducts from './components/pages/AddProducts';

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<Container customClass="min-height"><Home /> </Container>} />
        <Route path="/products" element={<Container customClass="min-height"> <Products /></Container>} />
        <Route path="/company" element={<Container customClass="min-height"> <Company /></Container>} />
        <Route path="/addproducts" element={<Container customClass="min-height"> <AddProducts /></Container>} />
      </Routes>
      <Footer/>
    </Router>
  );
}

export default App;
