import React from 'react';
import ProductsCard from './components/ProductsCard';
import './styles.scss';

const Catalog = () => {
    return (
        <div className="catalog-container">
            <h1 className="catalog-title">
            Catálogo de produtos
            </h1>
            <div className="catalog-products">
                <ProductsCard />
                <ProductsCard />
                <ProductsCard />
                <ProductsCard />
                <ProductsCard />
                <ProductsCard />
                <ProductsCard />
                <ProductsCard />
                <ProductsCard />

            </div>
        </div>
       

    );
}

export default Catalog;