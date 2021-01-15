import React from 'react';
import { Link, useParams } from 'react-router-dom';
import './styles.scss';
import { ReactComponent as ArrowIcon } from '../../../../core/assets/images/arrow.svg';
import { ReactComponent as ProductImage } from '../../../../core/assets/images/product.svg';
import ProductPrice from '../../../../core/components/ProductPrice';

type ParamsType = {
    productsId: string;
}

const ProductDetails = () => {
    const { productsId } = useParams<ParamsType>();
    console.log(productsId);

    return (
        <div className="products-details-container">
            <div className="card-base border-radius-20 product-details">

                <Link to="/products" className="products-details-goback">
                    <ArrowIcon className="icon-goback"/>
                    <h1 className="text-goback">
                        Voltar
                    </h1>
                
                </Link>
                <div className="row">
                    <div className="col-6 pr-5">
                        <div className="products-details-card text-center">
                            <ProductImage className="products-details-image"/>

                        </div>
                        <h1 className="products-details-name">
                            Computador Desktop - Intel Core <br/> i7
                        </h1>
                        <ProductPrice price="3.779,00"/>
                        
                    </div>
                    <div className="col-6 products-details-card" >
                        <h1 className="product-description-title">
                            Descrição do produto
                        </h1>
                        <p className="product-description-text">
                        Seja um mestre em multitarefas com a capacidade para exibir <br /> quatro aplicativos simultâneos na tela. A tela está ficando  <br /> abarrotada? Crie áreas de trabalho virtuais para obter mais <br/> espaço e trabalhar com os itens que você deseja. Além disso, <br/> todas as notificações e principais configurações são reunidas <br/> em uma única tela de fácil acesso.

                        </p>
                    </div>

                    

                </div>

            </div>    
            

        </div>
    );
}

export default ProductDetails;