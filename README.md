# Relatório Mini-Projeto 1
## Introdução á Programação Orientada por Objetos
## Ano Letivo: 2015/2016
## Estação de Serviço

[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/Joaosilgo/IPOO-SERVICE-STATION)

### Hugo Pereira nº 150 221 038
### João Gomes nº 150 221 001


## Introdução
O projeto consistirá no desenvolvimento de uma aplicação que permite gerir e controlar todos os componentes aplicados de uma Estação de Serviço, utilizando uma linguagem java e a programação orientada por objetos (POO), a aplicação faz o controlo dos seus dispensadores de combustíveis (bombas) tendo cada um 3 depósitos de combustível diferente nomeadamente (gasolina 95, gasolina 98, gasóleo), o objetivo deste projeto é essencialmente programar baseando-se o na composição e interação entre diversas unidades designadas de objetos


## Desenvolvimento
O programa foi desenvolvido utilizando a linguagem Java, colocando em prática os seus conceitos fundamentais do paradigma de Programação Orientada por Objetos, utilizando as regras de codificação convencionais do java nomeadamente notação camelCase, para todos os nomes dos métodos e os seus parâmetros sejam de variável local ou atributos definidos, e também utilizamos a notação PascalCase para identificar todos os nomes das classes. A implementação deste programa consiste em cinco entidades que se convergem entre si para representar os elementos, estes são:

A cisterna onde é armazenado os nossos combustíveis respetivos.

O depósito que contém a cisterna que gere a colocação e a remoção de combustível nesta mesma.

Os dispensadores de combustível que servem de bombas para o abastecimento de veículos. 

E têm como metodologia selecionar o combustível definido, que ligados aos depósitos do determinado tipo de combustíveis têm como objetivo abastecer um veículo.

O camião cisterna tem como objetivo o reabastecimento dos depósitos de combustível e por fim a Estaçao de Serviço que é responsável por gerir e controlar todos os dispensadores e depósitos e também é responsável por controlar o reabastecimento dos depósitos.
Todas estas entidades são classes definidas do nosso programa para poder explicar como funcionam vou definir e explicar uma a uma segundo a sua metodologia e objetivos bem como se ligam e se orientam com as outras classes.


### Classe Cisterna
Na classe Cisterna implementamos atributos para a capacidade Máxima, nível atual e tipo de combustível, criamos um construtor que recebe como parâmetros o tipo de combustível e a capacidade Máxima, neste caso tivemos de validar estes dois parâmetros e colocamos nível atual a 0, o segundo construtor recebe como parâmetros a capacidade máxima e o tipo de combustível nesta também validamos tudo, implementamos também métodos para nos dizer se a cisterna estava cheia ou vazia e para nos devolver o nível atual, implementamos métodos seletores para todos os atributos criados, criamos um método para nos devolver informação acerca do tipo de combustível da cisterna da capacidade e do nível atual, implementamos também métodos para inserir e retirar combustível á cisterna, estes métodos verificam o nível de combustível para verificarem se podem ou não retirar combustível da cisterna, devolvendo sempre o nível da mesma.


### Classe Deposito
A classe deposito recebe como atributos o indentificador o total de combustível retirado e o total de combustível inserido recebe também um atributos booleano para saber se esta bloqueado ou não, e recebe um atributo da classe cisterna para podermos retirar métodos da mesma e recebe ainda um camião da classe CamiaoCisterna que vai servir para guardar informação deste, nesta classe implementamos 3 construtores, um deles pede nos o identificador o tipo de combustível e a capacidade máxima, neste caso tivemos de validar a capacidade máxima para receber valores positivos, este começa bloqueado e sem com o total de combustível retirado e inserido a 0, o segundo construtor pede nos como parâmetros o identificador e o tipo de combustível, este cria-nos uma nova cisterna inicia-se bloqueado e com o total de combustível retirado e inserido a 0. Quanto á metodologia implementamos métodos seletores para todos os parâmetros implementados retiramos então esta informação da cisterna já criada, tem um método para bloquear e desbloquear, construímos também os métodos para retirar e inserir combustível que fazem as validações necessárias para o fazer neste caso se está bloqueado ou se a cisterna está cheia ou vazia, por último implementamos um método para nos retornar todas as informações necessárias sendo elas o indentificador, o total de combustível inserido ou retirado, se esta bloqueado ou não e as informações que já tínhamos implementado na cisterna.

### Classe CamiaoCisterna
A classe CamiaoCisterna recebe como atributos a marca e a classe deposito que já foi criada anteriormente, implementamos um construtor que recebe como parâmetros a marca, tipo de combustível, e a capacidade máxima, neste validamos a marca e criamos um depósito para o camião que recebe métodos seletores para todos os atributos criados, o objectico deste é abastecer os depósitos.


### Classe DispensadorDeCombustivel
Esta classe recebe como atributos a identificação um mostrador o identificador do combustível o combustível a retirar e atributos da classe deposito, também recebe atributos para bloquear e desbloquear. Foi implementado um construtor que começa com um combustível selecionado e desbloqueia-o, o construtor também tem identificação. Na metodologia implementamos um método que seleciona um indentificador de combustível visto que tem de estar sempre um selecionado ao selecionar um desbloqueia-o automaticamente e bloqueia os restantes, também temos um método para bloquear e desbloquear o dispensador. Implementamos também um método para abastecer que abastece os veículos com a quantidade de combustível pretendida, nesta classe também temos um mostrador que nos dá a informação sobre o combustível e o dispensador.
### Classe EstacaoDeServico
Esta classe têm um papel importante no programa pois é ela que cria todos os elementos propícios para o objetivo que desejamos. Nesta implementamos o atributo nome atributos dispensadores a identificação do dispensador e os depósitos tem também o atributo camião cisterna. Esta classe tem um construtor que pede como parâmetros o seu nome, valida este e cria 3 depósitos, em função aos 3 combustíveis que existem, este construtor também cria 2 dispensadores, possui métodos para abastecer e para ser abastecido pelo camiaoCisterna e tem também todas as informações recorrentes a todo o código para podermos controlar e gerir tudo a partir da Estação.

## Conclusão
Neste projeto tivemos como objetivo gerir e controlar uma estação de serviço de modo em que a sua implementação surgisse de uma composição de classes orientadas entre sí de modo a que todas as classes se ligassem num modo orientado na gestão de todas as suas entidades, Surgiu nos alguns obstáculos na forma de implementação para cumprir todos os objetivos pretendidos, isto referente á analise e compreensão do enunciado, visto que este estava pouco esclarecedor.
