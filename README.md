# farmbits

CRUD passando o objeto no formato json 

{ "atributo1":"valor1",
  "atributo2" : "valor2"
}

id de cada entidade gerado automaticamente;


Para adicionar fornecedores para um produto cadastrar um produto indicando seu fornecedor em " " podendo haver mais de um;

Ex:

{    "productName": "name",
    "description": "description",
    "price": "0.5",
    "discount": "20",
    "category":{
        "id":"33"
    },
    "providers": [     
        {
            "idProvider": "1"
        }

    ]
}

Para alterar categoria do produto ir no path "/api/v1/product",passar como parametro o id do produto que deseja alterar
e passar o objeto com o id da categoria já existente. 

Ex: /api/v1/product?id=1

{
    "category": {
        "id": "33"
    }
}


Listar produtos por categoria ir no path "/api/v1/category" e passar como parametro o id da categoria da qual deseja listar os produtos.

Ex:
/api/v1/category?id=1

Listar produtos por fornecedor ir no path "l/api/v1/product/provider" e passar como parametro o id do fornecedor do qual
deseja listar os produtos. 

Ex:

api/v1/product/provider?id=1

Para listar os produtos com desconto superior a 30% ir no path api/v1/product/discount


