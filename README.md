# Pontos de Interesse por GPS (POIs)

Implementação do desafio [Pontos de Interesse por GPS](https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md), do repositório backend-br.

## Stack
- Java
- Spring boot
- MongoDB

## Problema
A XY Lda. é uma empresa especializada na produção de excelentes recetores GPS (Global Positioning System). A administração está empenhada em lançar um dispositivo inovador que promete auxiliar pessoas na localização de pontos de interesse (POIs) e precisa muito da tua ajuda. Foste contratado para desenvolver a plataforma que fornecerá toda a inteligência ao dispositivo! Esta plataforma deve ser baseada em serviços REST, de forma a flexibilizar a integração.

#### Regras
- Criar POIs, com 3 atributos: Nome do POI, coordenada X (número inteiro não negativo) e coordenada Y (número inteiro não negativo). Os POIs devem ser guardados numa base de dados.
- Listar todos os POIs criados.
- Listar todos os POIs por proximidade. Receberá uma coordenada X e uma coordenada Y, especificando um ponto de referência, bem como uma distância máxima (dmax) em metros. Deverá retornar todos os POIs da base de dados que estejam a uma distância menor ou igual a d-max a partir do ponto de referência.

#### Exemplo de Base de Dados
Considere a seguinte base de dados de POIs:

- 'Lanchonete' (x=27, y=12)
- 'Posto' (x=31, y=18)
- 'Joalheria' (x=15, y=12)
- 'Floricultura' (x=19, y=21)
- 'Pub' (x=12, y=8)
- 'Supermercado' (x=23, y=6)
- 'Churrascaria' (x=28, y=2)

#### Exemplo de Uso
Dado o ponto de referência (x=20, y=10) indicado pelo receptor GPS, e uma distância máxima de 10 metros, o serviço deve retornar os seguintes POIs:
- Lanchonete
- Joalheria
- Pub
- Supermercado


## Endpoints
### Criar POI
Criar um ponto de interesse.

**[POST]** `{{host}}/api/poi/create`

**Body**
| Campo      | Tipo | Descrição                           | Obrigatório |
|:---------------|:----:|:------------------------------------|:-----------:|
| `name`     | string  | Nome do ponto de interesse.         |     Não     |  
| `x` | double  | Coordenada X do ponto de interesse. |     Não     |             
| `y` | double  | Coordenada Y do ponto de interesse. |     Não     |
        
```json
{
    "name": "Churrascaria",
    "x": 28.00,
    "y": 2.00
}
```

**Response**

201 Created
```json
{
    "name": "Churrascaria",
    "x": 28.00,
    "y": 2.00
}
```


### Listar POIs
Listar todos os pontos de interesse.

**[GET]** `{{host}}/api/poi/all`

**Response**

200 OK
```json
{
    "name": "Churrascaria",
    "x": 28.00,
    "y": 2.00
}
```


### Listar POIs por proximidade
Dado um ponte de referência (`x` e `y`), lista todos os pontos de interesse que estejam a uma distância menor ou igual a `dmax`.

**[GET]** `{{host}}/api/poi/distance?x=20&y=10&dmax=10`

**Request**
| Parâmetro      | Tipo | Descrição                           | Obrigatório |
|:---------------|:----:|:------------------------------------|:-----------:|
| `x` | double  | Coordenada X do ponto de interesse. |     Não     |             
| `y` | double  | Coordenada Y do ponto de interesse. |     Não     |
| `dmax`     | double  | Distância máxima em metros.         |     Não     |             

**Response**

200 OK
```json
{
    "name": "Churrascaria",
    "x": 28.00,
    "y": 2.00
}
```
