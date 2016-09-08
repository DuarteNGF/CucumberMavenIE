Feature: Testar o formulario de conctatos do OLX

  @Web
  Scenario Outline: Verificar o link de como funciona
    Given Entrar no site do olx
    When Clicar no link dos <Link>
    Then Validar a mensagem de sucesso OLX <Title>
    And Fechar o browser

    Examples: 
      | Link                                                               | Title |
      | ".//*[@id='lastwrapper']/div/div[2]/div[1]/div[3]/ul/li[4]/a/span" | "OLX" |
      | ".//*[@id='lastwrapper']/div/div[2]/div[1]/div[2]/ul/li[1]/a/span" | "OLX" |
