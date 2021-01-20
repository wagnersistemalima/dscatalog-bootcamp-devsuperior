import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import './styles.scss';
import { ReactComponent as ArrowIcon } from '../../../../core/assets/images/arrow.svg';
import ProductPrice from '../../../../core/components/ProductPrice';
import { makeRequest } from '../../../../core/utilis/request';
import { Product } from '../../../../core/types/Products';
import ProductInfoLoader from '../Loaders/ProductInfoLoader';
import ProductDescriptionLoader from '../Loaders/ProductDescriptionLoader';

type ParamsType = {
    productsId: string;
}

const ProductDetails = () => {
    const { productsId } = useParams<ParamsType>();
    const [product, setProduct] = useState<Product>();
    const [isLoading, setIsLoading] = useState(false)

    console.log(isLoading);

    useEffect(() => {
        // inicio da request
        setIsLoading(true);
        makeRequest({ url: `/products/${productsId}` })
            .then(response => setProduct(response.data))
            // fim da request
            .finally(() => setIsLoading(false));

    }, [productsId]);

    return (
        <div className="products-details-container">
            <div className="card-base border-radius-20 product-details">

                <Link to="/products" className="products-details-goback">
                    <ArrowIcon className="icon-goback" />
                    <h1 className="text-goback">
                        Voltar
                    </h1>

                </Link>
                <div className="row">
                    <div className="col-6 pr-5">
                        {isLoading ? <ProductInfoLoader /> : (
                            <>
                                <div className="products-details-card text-center">
                                    <img src={product?.imgUrl} alt={product?.name} className="products-details-image" />

                                </div>
                                <h1 className="products-details-name">
                                    {product?.name}
                                </h1>
                                {product?.price && <ProductPrice price={product?.price} />}

                            </>
                        )}

                    </div>
                    <div className="col-6 products-details-card" >
                        {isLoading ? <ProductDescriptionLoader /> : (
                            <>

                                <h1 className="product-description-title">
                                    Descrição do produto
                                </h1>
                                <p className="product-description-text">
                                    {product?.description}

                                </p>

                            </>
                        )}

                    </div>



                </div>

            </div>


        </div>
    );
}

export default ProductDetails;