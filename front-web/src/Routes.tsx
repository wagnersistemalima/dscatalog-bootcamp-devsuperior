import React from 'react';
import {BrowserRouter, Switch, Route, Redirect } from 'react-router-dom'
import Navbar from './core/components/Navbar';
import Admin from './pages/Admin';
import Catalog from './pages/Catalog';
import ProductDetails from './pages/Catalog/components/ProductDetails';
import Home from './pages/Home';

const Routes = () => {
    return (
        <div>
            <BrowserRouter>
                <Navbar />
                <Switch>
                    <Route path="/" exact>
                        <Home />

                    </Route>

                    <Route path="/products" exact>
                        <Catalog />

                    </Route>

                    <Route path="/products/:productsId">
                        <ProductDetails />

                    </Route>

                    <Redirect from = "/admin" to = "/admin/products" exact/>
                    <Route path="/admin">
                        
                        <Admin />
                    </Route>

                </Switch>
            </BrowserRouter>
        </div>
    );
}

export default Routes;