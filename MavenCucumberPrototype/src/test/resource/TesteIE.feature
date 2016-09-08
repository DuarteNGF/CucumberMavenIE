@tag
Feature: Fazer Login/Logout na aplicação Smile

  @tag
  Scenario: Fazer Login com dados válidos
    Given Abrir browser
    When Fazer login
    And Escolher link
    And Fazer logout
    Then Fechar browser

  @tag
  Scenario: Fazer Login com dados inválidos válidos
    Given Abrir browser
    When Fazer login com dados invalidos
    And Validar mensagem de insucesso
    Then Fechar browser
