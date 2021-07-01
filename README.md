# Sistema Supervisorio Java Web

##Instalação Física

Para realizar a instalação física envolvendo o arduino, seguir o esquema abaixo*:

<img src="https://github.com/KalleoLeandro/Sistema-supervisorio-Java/blob/672689551e9ddc7d94b973354b83272b0cd353f6/esquema.png">


*Para os leds usar resistores de 330 ohms


##Importação projeto

Importar em sua IDE o projeto Maven Java Primefaces deste projeto.

Usando como base o IDE Eclipse, clicar em Import -> Exist Maven Projects

Clicar em cima do projeto e escolher as opções Maven -> Update Project para puxar as bibliotecas de dependêcias

##IMPORTANTE!!!

Existe um pequeno problema neste projeto(aberto a soluções), onde ao sair do sistema e fechar o projeto, a Thread em questão não reabre. Com isso o sistema ao ser fechado só funciona novamente ao resetar o arduino e
reiniciar o servidor.



