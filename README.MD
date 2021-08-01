# MyMinesweeper

Uma nova pegada no famosíssimo jogo de lógica do Windows 95, Campo Minado.

![Jogo MyMinesweeper](https://raw.githubusercontent.com/BillVGN/MyMinesweeper/master/src/resources/MyMinesweeper.png)

### Algumas escolhas quanto a lógica...

No MyMinesweeper, cada célula é autoconsciente. Elas são todas interligadas, cada célula conecta-se com
oito outras células, formando o que chamo de perímetro. Algumas possuirão menor número de conexões devido
a sua posição no topo ou fundo do campo, assim como nas laterais.

### O Perímetro
![O Perímetro](https://raw.githubusercontent.com/BillVGN/MyMinesweeper/master/src/resources/perimetro.png)

Com essa disposição, toda a lógica percorre as células e seus perímetros diretamente, sem necessidade
de uma representação do campo em separado.

Ainda existe a intenção de implementar um sistema de semi-inteligência artificial para que cada célula, 
sabendo do que acontece ao redor de si mesma, possa dar dicas e até mesmo ajudar diretamente o jogador 
quando acontecem os temíveis travamentos onde a lógica permite mais de uma possível alternativa, como a
figura a seguir demonstra.

![Travamento Lógico](https://raw.githubusercontent.com/BillVGN/MyMinesweeper/master/src/resources/exemplo-travamento-logico.png)

Atualmente, o jogo ainda encontra-se em fase pré-alpha. Muitos bugs podem (e devem) aparecer. O código 
ainda está mal formatado, mas funcional. Não existe vitória per se, mas já é possível jogar e desvendar 
o campo inteiro.

### Como jogar e comandos úteis

* Clique com o mouse esquerdo em qualquer célula e ela revelará seu conteúdo. Não se preocupe! O primeiro
clique sempre abrirá o campo para permitir prosseguir sem precisar adivinhar. De nada! ;-D
* Para marcar uma célula com a bandeira de (possível) mina, clique com o botão direito uma única vez sobre
a célula. Ao clicar novamente, um símbolo de interrogação marca uma célula duvidosa. Um terceiro clique
volta a célula ao seu estágio original.
* Quando houver certeza (cuidado!) com o número de minas ao redor de uma célula numerada, você poderá revelar
seu perímetro clicando com o botão do meio sobre a célula. Atente-se que apenas a célula que tiver o número
de bandeiras igual ao seu número apresentado fará a revelação de todo seu perímetro. Porém se uma célula do 
perímetro for marcada de maneira errada totalizando o número de minas pretendida, você pode revelar uma mina
sem querer e perder o jogo!

Se revelar uma mina diretamente, ou pela revelação do perímetro de uma célula, o jogo acaba e mostra todas as
células com minas, assim também como todas as células que foram marcadas de maneira errada.

Bom divertimento, pessoal! XD