# Requisitos

- Java 8+ JDK deve estar instalado
- Maven deve estar instalado e configurado no path da aplicação
- Ter navegador Chrome ou Edge ou Firefox instalado

# Escolher o navegador para rodar os testes

- Vá pasta "core"
- Selecione "propriedades"
- Em "public static browsers browser = browsers.NavegadorDesejado;" modifique ".NavegadorDesejado" para o navegador que
  deseja
  
    - Exemplos:
      - CHROME: public static browsers browser = browsers.CHROME; 
      - FIREFOX: public static browsers browser = browsers.FIREFOX; 
      - EDGE: public static browsers browser = browsers.EDGE;

#Como rodar os testes (utilize a IDEA de sua escolha)
- Vá na pasta runner
- Na classe Runner
- Execute para rodar todos  os testes
