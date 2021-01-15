import React from 'react';
import { Link } from 'react-router-dom';
import ProductsCard from './components/ProductsCard';
import './styles.scss';

const Catalog = () => {
    return (
        <div className="catalog-container">
            <h1 className="catalog-title">
            Catálogo de produtos
            </h1>
            <div className="catalog-products">
                <Link to="/products/1"><ProductsCard /></Link>
                <Link to="/products/2"><ProductsCard /></Link>
                <Link to="/products/3"><ProductsCard /></Link>
                <Link to="/products/4"><ProductsCard /></Link>
                <Link to="/products/5"><ProductsCard /></Link>
                <Link to="/products/6"><ProductsCard /></Link>
                <Link to="/products/7"><ProductsCard /></Link>
                <Link to="/products/8"><ProductsCard /></Link>
                <Link to="/products/9"><ProductsCard /></Link>
                

            </div>
        </div>
       

    );
}

export default Catalog;