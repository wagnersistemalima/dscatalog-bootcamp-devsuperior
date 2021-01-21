import React from 'react';
import { ReactComponent as ArrowIcon } from 'core/assets/images/arrow.svg';
import './styles.scss';
import { generationList } from 'core/utilis/list';

type Props = {
    totalPages: number;
    activePage: number;                                 // pagina ativa
    onChange: (item: number) => void;
}

const Pagination = ({totalPages, activePage, onChange}: Props) => {

    // logica do componente
    const items = generationList(totalPages);
    const previousClass = totalPages > 0 && activePage > 0 ? 'page-active' : 'page-inactive';
    const nextClass = (activePage + 1) < totalPages ? 'page-active' : 'page-inactive';
    return (
        <div className="pagination-container">
            <ArrowIcon                                          // componente < paginação
            
                className= {`pagination-previous ${previousClass}`}
                onClick = {() => onChange(activePage - 1)}
                
            />
            {items.map(item => (
                <div 
                key = {item}
                className={`pagination-item ${item === activePage ? 'active' : ''}`} 
                onClick = {() => onChange(item)}
                
                >

                {item }

                </div>
            ))}
            
            
            <ArrowIcon 
                className={`pagination-next ${nextClass}`}
                onClick = {() => onChange(activePage + 1)}
                
            />

        </div>
    );
}

export default Pagination;