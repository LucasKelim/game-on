# Game On
Projeto final em Java na matéria de POO do curso de Ciência da Computação.

O objetivo desse projeto é realizar um pequeno e-commerce de artigos esportivos. As principais funcionalidades são: Como administrador, poder manter produtos, controle de estoque e análise de produtos mais vendidas. Como cliente, poder visualizar e filtrar produtos, adicionar itens no carrinho e realizar a compra desses itens.

### Regras de Negócio
- Login de administradores para
  - Controle de produtos
  - Controle de Estoque
  - Análise de produtos mais vendidas
- Login de clientes para
  - Visualizar e filtrar produtos
  - Adicionar produtos no carrinho e realizar compras

### Diagrama UML
```
@startuml
class Usuario {
    -id
    -nome
    -email
    -senha
}

class Admin {
    
}

class Cliente {
    -cpf
    -telefone
}

class Produto {
    -id
    -nome
    -descricao
    -preco
    -estoque
}

class Inventario {

}
@enduml
```