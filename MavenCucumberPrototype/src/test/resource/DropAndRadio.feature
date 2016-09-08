Feature: Aula_11 selecionar radio bottons e dropdown
@drop
Scenario: Selecionar um dropdown
Given Entrar na pagina de testes cucumber
When Ir ao link "Adoption"
Then Selecionar dropdown e escolher "Today"
Then Fechar o browser2
@drop
Scenario: Selecionar radio botoes
Given Entrar na pagina de testes cucumber
When Ir ao link "Contact"
Then Prencher formulario
Then Fechar o browser2