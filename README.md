# Game On

Projeto final em Java na matéria de POO do curso de Ciência da Computação.

O objetivo desse projeto é realizar um pequeno e-commerce de artigos esportivos. As principais funcionalidades são: Como administrador, poder manter produtos, controle de estoque e análise de produtos mais vendidas. Como cliente, poder visualizar e filtrar produtos, adicionar itens no carrinho e realizar a compra desses itens.

### Regras de Negócio

Login de administradores para

- Controle de produtos
- Controle de Estoque
- Análise de produtos mais vendidas

Login de clientes para

- Visualizar e filtrar produtos
- Adicionar produtos no carrinho e realizar compras

### Diagrama UML

```
@startuml

abstract class Usuario {
    -id : int
    -nome : String
    -email : Email
    -senha : Senha
    -criadoEm : DateTime
}



class Admin {
    -id : int
}



class Cliente {
    -cpf : String
    -telefone : String
    -asaasCliente : String
}



class Produto {
    -id : int
    -nome : String
    -descricao : String
    -preco : double
    -estoque : int
    -status : bool
    -admin : Admin
    -criadoEm : DateTime
}



class Movimentacao {
    -id : int
    -tipo : TipoMovimentacao
    -quantidade : int
    -produto : Produto
    -criadoEm : DateTime
}



class Carrinho {
    -id : int
    -cliente : Cliente
    -produtos : List<CarrinhoProduto>
    +adicionarProduto(produto : Produto): bool
    +listarProdutos(): List<CarrinhoProduto>
    -criadoEm : DateTime
}



class CarrinhoProduto {
    -id : int
    -quantidade : int
    -produto : Produto
    -criadoEm : DateTime
}



class Ordem {
    -id : int
    -status : OrdemStatus
    -metodoPagamento : MetodoPagamento
    -valorTotal : double
    -cliente : Cliente
    -endereco : Endereco
    -asaasOrdem : String
    -criadoEm : DateTime
}



class OrdemProduto {
    -id : int
    -quantidade : int
    -ordem : Ordem
    -produto : Produto
    -criadoEm : DateTime
}



class Endereco {
    -id : int
    -logradouro : String
    -numero : String?
    -bairro : String
    -cidade : String
    -codigoPostal : String
    -estado : String
    -pais : String
    -cliente : Cliente
    -criadoEm : DateTime
}



interface MetodoPagamento {
    processarPagamento(ordem : Ordem) : bool
    descricao() : String
}



enum TipoMovimentacao {
    ENTRADA
    SAIDA
    AJUSTE
}



enum OrdemStatus {
    PENDENTE
    PAGO
    CANCELADO
}



Usuario <|-- Cliente
Usuario <|-- Admin

Endereco "*" *-- "1" Cliente

Carrinho "0..1" *-- "1" Cliente

Produto <.. Carrinho

CarrinhoProduto "1..*" *-- "1" Carrinho
CarrinhoProduto "*" *-- "1" Produto

Produto "*" o-- "0..1" Admin

OrdemProduto "*" *-- "1" Ordem
OrdemProduto "*" *-- "1" Produto

Ordem "*" *-- "1" Endereco
Ordem -- OrdemStatus
Ordem -- MetodoPagamento

Movimentacao "*" *-- "1" Produto
Movimentacao -- TipoMovimentacao
@enduml
```
