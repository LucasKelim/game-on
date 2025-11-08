\# Game On



Projeto final em Java na matéria de POO do curso de Ciência da Computação.



O objetivo desse projeto é realizar um pequeno e-commerce de artigos esportivos. As principais funcionalidades são: Como administrador, poder manter produtos, controle de estoque e análise de produtos mais vendidas. Como cliente, poder visualizar e filtrar produtos, adicionar itens no carrinho e realizar a compra desses itens.



\### Regras de Negócio



\- Login de administradores para

&nbsp; - Controle de produtos

&nbsp; - Controle de Estoque

&nbsp; - Análise de produtos mais vendidas

\- Login de clientes para

&nbsp; - Visualizar e filtrar produtos

&nbsp; - Adicionar produtos no carrinho e realizar compras



\### Diagrama UML



```

@startuml

abstract class Usuario {

&nbsp;   -id : int

&nbsp;   -nome : String

&nbsp;   -email : Email

&nbsp;   -senha : Senha

&nbsp;   -criado\_em : DateTime

}



class Admin {

&nbsp;   -id : int

}



class Cliente {

&nbsp;   -cpf : String

&nbsp;   -telefone : String

&nbsp;   -asaasCliente : String

}



class Produto {

&nbsp;   -id : int

&nbsp;   -nome : String

&nbsp;   -descricao : String

&nbsp;   -preco : double

&nbsp;   -estoque : int

&nbsp;   -status : bool

&nbsp;   -admin : Admin

&nbsp;   -criado\_em : DateTime

}



class Movimentacao {

&nbsp;   -id : int

&nbsp;   -tipo : TipoMovimentacao

&nbsp;   -quantidade : int

&nbsp;   -produto : Produto

&nbsp;   -criado\_em : DateTime

}



class Carrinho {

&nbsp;   -id : int

&nbsp;   -cliente : Cliente

&nbsp;   -produtos : List<CarrinhoProduto>

&nbsp;   +adicionarProduto(produto : Produto): bool

&nbsp;   +listarProdutos(): List<CarrinhoProduto>

&nbsp;   -criado\_em : DateTime

}



class CarrinhoProduto {

&nbsp;   -id : int

&nbsp;   -quantidade : int

&nbsp;   -produto : Produto

&nbsp;   -criado\_em : DateTime

}



class Ordem {

&nbsp;   -id : int

&nbsp;   -status : OrdemStatus

&nbsp;   -metodoPagamento : MetodoPagamento

&nbsp;   -valorTotal : double

&nbsp;   -cliente : Cliente

&nbsp;   -endereco : Endereco

&nbsp;   -asaasOrdem : String

&nbsp;   -criado\_em : DateTime

}



class OrdemProduto {

&nbsp;   -id : int

&nbsp;   -quantidade : int

&nbsp;   -ordem : Ordem

&nbsp;   -produto : Produto

&nbsp;   -criado\_em : DateTime

}



class Endereco {

&nbsp;   -id : int

&nbsp;   -logradouro : String

&nbsp;   -numero : String?

&nbsp;   -bairro : String

&nbsp;   -cidade : String

&nbsp;   -codigoPostal : String

&nbsp;   -estado : String

&nbsp;   -pais : String

&nbsp;   -cliente : Cliente

&nbsp;   -criado\_em : DateTime

}



interface MetodoPagamento {

&nbsp;   processarPagamento(ordem : Ordem) : bool

&nbsp;   descricao() : String

}



enum TipoMovimentacao {

&nbsp;   ENTRADA

&nbsp;   SAIDA

&nbsp;   AJUSTE

}



enum OrdemStatus {

&nbsp;   PENDENTE

&nbsp;   PAGO

&nbsp;   CANCELADO

}



Usuario <|-- Cliente

Usuario <|-- Admin



Endereco "\*" \*-- "1" Cliente



Carrinho "0..1" \*-- "1" Cliente



Produto <.. Carrinho



CarrinhoProduto "1..\*" \*-- "1" Carrinho

CarrinhoProduto "\*" \*-- "1" Produto



Produto "\*" o-- "0..1" Admin



OrdemProduto "\*" \*-- "1" Ordem

OrdemProduto "\*" \*-- "1" Produto



Ordem "\*" \*-- "1" Endereco

Ordem -- OrdemStatus

Ordem -- MetodoPagamento



Movimentacao "\*" \*-- "1" Produto

Movimentacao -- TipoMovimentacao

@enduml

```

