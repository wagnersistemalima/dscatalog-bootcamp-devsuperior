import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { ProductResponse } from '../../core/types/Products';
import { makeRequest } from '../../core/utilis/request';
import ProductCardLoader from './components/Loaders/ProductCardLoader';
import ProductsCard from './components/ProductsCard';
import './styles.scss';

const Catalog = () => {

    // limitaçoes 
    // verboso , não tem suporte nativo para ler o progresso de upload de arquivos, nao tem suporte nativo para enviar query em strings

    // Quando a lista de produtos estiver disponivel, popular um estado no componente,
    // e listar os produtos dinamicamente

    const [productsResponse, setProductResponse ] = useState<ProductResponse>();

    // status
    const [isLoading, setIsLoading] = useState(false)

    console.log(productsResponse);

    // Quando o componente iniciar, buscar a lista de produtos

    useEffect(() => {
        const params = {
            page: 0,
            linesPerPage: 12
        }

        // iniciar o loader
        setIsLoading(true);
        makeRequest({url: '/products', params })
        .then(response => setProductResponse(response.data))
        .finally(() => {
            // finalizar o loader
            setIsLoading(false);
        })

    }, []);

    return (
        <div className="catalog-container">
            <h1 className="catalog-title">
            Catálogo de produtos
            </h1>
            <div className="catalog-products">
                {isLoading ? <ProductCardLoader /> : (
                    productsResponse?.content.map(product => (
                        <Link to={`/products/${product.id}`} key={product.id}>
                            
                            <ProductsCard product = {product}/>
                            
                        </Link>
                    ))
                )}
                
            </div>
        </div>
       
    );
}

export default Catalog;