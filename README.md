# ProjetoIntegrador2

RF
1. O sistema deverá possuir uma interface para acompanhar a posição dos aviões
2. Os aviões e suas rotas deverão ser lidas a partir de um arquivo .TXT contido na pasta
3. A leitura dos aviões será feita por uma thread rodando a cada três segundos.

RNF
1. O sistema será desenvolvido em Java

RN
1. A única situação de emergência a ser considerada será a falta de combustível de um avião
2. O avião receberá uma rota assim que chegar no perímetro do aeroporto
3. O avião deverá ter as segiuntes caract.: capacidade atual de combustível, modelo do avião, média de consumo, velocidade de pouso, 
	velocidade atual e score
4. O score é obtido através da subtração de quanto o avião pode voar por quanto ele tem para voar.
5. A velocidade no ar, média, do avião é de 247,222m/s
6. A velocidade de pouso é entre 105,556m/s a 66,6667 m/s
7. A velocidade do avião no chão é entre 9,72222 e 16,6667 m/s
8. O aereporto possuirá somente uma pista de pouso
9. O aeporto suporta até 10 aviões aguardando para pousar
10. A pista de pouso possuirá 3000 metros de comprimento
11. Velocidade mínima no ar é de 66,6667m/s
12. O fim de uma rota de aproximação é a entrada de uma rota de pouso/circular
13. Uma rota terá as coordeadas de entrada, saída, velocidades de entrada/saída e um tamanho
14. O score dos aviões deverá ser recalculado a cada leitura (entrada) de um novo avião. Este processo deve ser executado a todo momento em segundo plano. Obs: provavelmente a tela será atualizada neste momento também...
15. A altitude de cruzeiro é de 9200m á 12200m.
16. A velocidade de cruzeiro é acima de 225m/s.
 

Observações:
Os mesmos níveis de voo (300, 320, 340, etc.) são usados ​​para voos no sentido oeste, enquanto que níveis de voo ímpares (310, 330, 350 etc.) são para voos para o leste. Isso significa que há pelo menos 300 metros de folga entre os aviões que voam na mesma via em sentidos diferentes. 

Links úteis:
https://en.wikipedia.org/wiki/Flight_planning
https://en.wikipedia.org/wiki/Airway_(aviation)
https://www.kaspersky.com.br/blog/rodovias-no-ceu-como-funciona-o-roteamento-de-aeronaves/5281/
http://www.agenciaabear.com.br/destaque-1/curiosidade-voce-tem-ideia-de-quanto-combustivel-um-aviao-gasta-em-um-voo/