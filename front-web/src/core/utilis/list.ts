// gerador de lista dinamica 

export const generationList = (amount: number) => {
    return (
        Array.from(Array(amount).keys())
    );
}