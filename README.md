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

### Diagrama Entidade Relacionamento

```sql
create database gameon;

use gameon;

create table usuario (
	id int unsigned primary key auto_increment,
    nome varchar(255) not null,
    email varchar(255) not null,
    senha varchar(255) not null,
    criadoEm timestamp default current_timestamp
);

create table admin (
	id int unsigned primary key,
    foreign key (id) references usuario (id)
);

create table produto (
	id int unsigned primary key auto_increment,
    nome varchar(255) not null,
    descricao varchar(255) not null,
    preco double not null,
    estoque int unsigned not null,
    status bool not null,
    admin int unsigned,
    criadoEm timestamp default current_timestamp,
    foreign key (admin) references admin (id)
);

create table cliente (
	id int unsigned primary key,
    cpf varchar(255) not null unique,
    telefone varchar(255) not null unique,
    asaasCliente varchar(255) not null unique,
    foreign key (id) references usuario (id)
);

create table endereco (
	id int unsigned primary key auto_increment,
    longradouro varchar(255) not null,
    numero int,
    bairro varchar(255) not null,
    cidade varchar(255) not null,
    cep varchar(255) not null,
    estado varchar(255) not null,
    cliente int unsigned not null,
    criadoEm timestamp default current_timestamp,
    foreign key (cliente) references cliente (id)
);

create table carrinho_produto (
	produto int unsigned not null,
    cliente int unsigned not null,
    quantidade int unsigned not null,
    criadoEm timestamp default current_timestamp,
    primary key (produto, cliente),
    foreign key (produto) references produto (id),
    foreign key (cliente) references cliente (id)
);

create table ordem (
	id int unsigned primary key auto_increment,
    status enum('PENDENTE', 'PAGO', 'ENVIADO', 'ENTREGUE', 'CANCELADO') default 'PENDENTE',
    metodoPagamento varchar(255) not null,
    valorTotal double not null,
    endereco int unsigned not null,
    asaasOrdem varchar(255),
    criadoEm timestamp default current_timestamp,
    foreign key (endereco) references endereco (id)
);

create table ordem_produto (
	ordem int unsigned not null,
    produto int unsigned not null,
    quantidade int unsigned not null,
    criadoEm timestamp default current_timestamp,
    primary key (ordem, produto),
    foreign key (ordem) references ordem (id),
    foreign key (produto) references produto (id)
);

create table movimentacao (
	id int unsigned primary key auto_increment,
    tipo enum('SAIDA', 'ENTRADA', 'AJUSTE') default 'SAIDA',
    quantidade int unsigned not null,
    criadoEm timestamp default current_timestamp
);
```

### Diagrama de Classe

```
@startuml

abstract class Usuario {
    -id : int
    -nome : String
    -email : Email
    -senha : Senha
    -criadoEm : LocalDateTime
}



class Admin {

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
    -status : boolean
    -admin : Admin
    -criadoEm : LocalDateTime
}



class Movimentacao {
    -id : int
    -tipo : TipoMovimentacao
    -quantidade : int
    -produto : Produto
    -criadoEm : LocalDateTime
}



class Carrinho {
    -id : int
    -cliente : Cliente
    -produtos : List<CarrinhoProduto>
    +adicionarProduto(produto : Produto): boolean
    +listarProdutos(): List<CarrinhoProduto>
    -criadoEm : LocalDateTime
}



class CarrinhoProduto {
    -id : int
    -quantidade : int
    -produto : Produto
    -criadoEm : LocalDateTime
}



class Ordem {
    -id : int
    -status : OrdemStatus
    -metodoPagamento : MetodoPagamento
    -valorTotal : double
    -cliente : Cliente
    -endereco : Endereco
    -asaasOrdem : String
    -criadoEm : LocalDateTime
}



class OrdemProduto {
    -id : int
    -quantidade : int
    -ordem : Ordem
    -produto : Produto
    -criadoEm : LocalDateTime
}



class Endereco {
    -id : int
    -cep : String
    -estado : String
    -cidade : String
    -bairro : String
    -logradouro : String
    -numero : int?
    -cliente : Cliente
    -criadoEm : LocalDateTime
}



interface MetodoPagamento {
    processarPagamento(ordem : Ordem) : boolean
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
