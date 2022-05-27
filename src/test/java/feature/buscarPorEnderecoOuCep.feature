#language: pt

Funcionalidade: Busca por endereço ou CEP
  Como um usuário
  Gostaria de procurar um Endereço ou CEP
  Para que eu possa encontrar um endereço ou CEP

  Contexto:
    Dado que estou na página de busca por CEP ou endereço

  Esquema do Cenario: Buscar por um endereço pelo CEP válido
    E informo o CEP "<cep>"
    E o tipo do cep como "<tipo>"
    Quando clico em buscar
    Então visualizo o endereço "<endereco>"

    Exemplos:
      | cep      | tipo                     | endereco             |
      | 93280290 | Localidade/Logradouro    | Rua Passo Fundo      |
      | 23085990 | Caixa Postal Comunitária | Rua Duarte Nunes     |
      | 72115944 | Grande Usuário           | CNB 12 Lote 11/12    |
      | 93260180 | Todos                    | Rua Dom Feliciano    |
      | 41705970 | Unidade Operacional      | Rua Simões Filho, 12 |

  Esquema do Cenário:Buscar por um CEP com um endereço válido
    E informo o endereço "<endereco>"
    E o tipo do cep como "<tipo>"
    Quando clico em buscar
    Então visualiza uma lista de endereços com nomes semelhantes a "<endereco>" com seus respectivos CEPS

    Exemplos:
      | endereco             | tipo                     |
      | Rua Passo Fundo      | Unidade Operacional      |
      | Rua Duarte Nunes     | Caixa Postal Comunitária |
      | CNB 12 Lote 11/12    | Grande Usuário           |
      | Rua Simões Filho, 12 | Unidade Operacional      |
      | Rua Dom Feliciano    | Todos                    |

  Cenario: Deve validar campo obrigatório
    E não informo um CEP ou endereço
    Quando clico em buscar
    Então retorna a mensagem "Preencha este campo."

  Cenário: Deve validar valor mínimo para rua
    E preencho um  campo apenas com "1"
    Quando clico em buscar
    Então retorna mensagem de alerta "Informe o Endereço com no mínimo 2(dois) caracteres!"

  Cenário: Pesquisa por CEP e faz uma nova busca
    E informo o CEP "93280290"
    E o tipo do cep como "Todos"
    E clico em buscar
    E visualizo o endereço "Rua Passo Fundo"
    Quando seleciono Nova Busca
    Então volto para página inicial

  Cenário: Pesquisar por um CEP inexistente
    E informo o CEP "00000000"
    Quando clico  em buscar
    Então aparece uma mensagem informando "Não há dados a serem exibidos"

  Cenário: Pesquisar por um Endereço inexistente
    E informo o endereço "Não Existes"
    Quando clico  em buscar
    Então retorna uma mensagem informando "Não há dados a serem exibidos"










