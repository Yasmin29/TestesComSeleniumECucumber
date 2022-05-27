#language: pt

Funcionalidade: Fazer a busca Por Localidade / Logradouro
  Como um usuário
  Gostaria de procurar procurar um endereço
  Para que eu possa encontrar o CEP deste endereço

  Contexto:
    Dado que estou na página de busca por CEP

  Esquema do Cenário: Buscar por um CEP preenchendo "<complemento>"
    E preencho o campo UF com "<UF>"
    E preencho o campo localidade com "<Localidade>"
    E preencho o campo tipo com "<Tipo>"
    E preencho o campo logradouro com "<Logradouro>"
    E preencho o campo NumeroLoteAptoCasa com "<NLoteAptoCasa>"
    Quando clico  em buscar
    Então visualizo o CEP do endereço "<CEP>"

    Exemplos:
      | complemento                        | UF | Localidade | Tipo  | Logradouro  | NLoteAptoCasa | CEP       |
      | todos  os campos com dados validos | RS | Esteio     | Rua   | Passo Fundo | casa 101      | 93280-290 |
      | apenas campos obrigatorios         | RS | Esteio     | Todos | Passo Fundo |               | 93280-290 |

  Esquema do Cenário:Validar campos obrigatórios "<complemento>"
    E preencho o campo UF com "<UF>"
    E preencho o campo localidade com "<Localidade>"
    E preencho o campo tipo com "<Tipo>"
    E preencho o campo logradouro com "<Logradouro>"
    E preencho o campo NumeroLoteAptoCasa com "<NLoteAptoCasa>"
    Quando clico  em buscar
    Então visualizo a mensagem de erro "<Mensagem>"

    Exemplos:
      | complemento                            | UF        | Localidade | Tipo  | Logradouro       | NLoteAptoCasa | Mensagem                                                      |
      | quando nao preenche nenhum campo       | Selecione |            | Todos |                  |               | Selecione a UF!                                               |
      | quando nao preenche o campo UF         | Selecione | Esteio     | Lagoa | Rua Padre Claret | Casa          | Selecione a UF!                                               |
      | quando nao preenche o campo Localidade | RS        |            | Lagoa | Rua Padre Claret | Casa          | Informe o nome completo da Cidade/Município/Distrito/Povoado! |
      | quando nao preenche o campo Logradouro | RS        | Esteio     | Lagoa |                  |               | Informe o nome do Logradouro!                                 |

  Cenário: Pesquisar por Cidade e Rua inválidas
    E preencho o campo UF com "TO"
    E preencho o campo localidade com "Esteio"
    E preencho o campo logradouro com "Passo fundo"
    Quando clico  em buscar
    Então aparece uma mensagem informando "Não há dados a serem exibidos"













