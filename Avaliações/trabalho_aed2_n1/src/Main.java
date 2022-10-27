/* Autor: José Gabriel Vieira de Souza

-------------------------------------------------------------------------------------------------------------------------------------
Problema escolhido:Jogando Cartas Fora
Dada uma pilha de n cartas enumeradas de 1 ate n com a cara 1 na base. A seguinte operação é realizada quando tiver 2 ou mais cartas
  -Jogue fora a carta do topo e mova a próxima carta para a base da pilha.
  -Sua tarefa é encontrar a sequência de cartas descartdas e a ultima carta remanescente.
  -Cada linha de entrada (exceção da ultima) contém um número N <= 50. A última linha contém 0 e não deve ser processada
  -Cada número de entrada produz duas linhas de saida. A primeira linha apresenta a sequência de cartas descartadas e a segunda linha
   apresenta a carta remaenscente.
--------------------------------------------------------------------------------------------------------------------------------------
 */

import java.util.*; //Importação de bibliotecas java

public class Main { //Classe principal
    static Deque<Integer> cardsDeck= new LinkedList<>(); //Declaração de interface do tipo Deque, parecida com a Queue porém posso manipular a entrada no fim e no começo da lista.
    static LinkedList<Integer> discardedCards = new LinkedList<>(); //Uso de uma linked list para as cartas que serão descartadas da lista principal.
    public static void main(String[] args) { //Metodo principal
        Scanner input = new Scanner(System.in); //Scanner
        int varControl00 = input.nextInt(); //Utilizo essa variavel no metodo for a seguir, para determinar o número de cartas a serem colocadas no baralho.

        if (varControl00 == 0) { //If para caso o valor de input seja 0
            System.exit(0);
        } else {
            /*
        Neste bloco FOR, eu manipulo o baralho principal da seguinte forma, adiciono a ele a quantidade de cartas informadas na variavel (varControl00), ele funciona de maneira decrescente
        a carta adicionada é sempre maior que a carta a ser adicionada depois dele.
            LINHA 32: Adiciona a lista seus dados de acordo com o indice n.
        */
            for (int i = 0, n = varControl00; n > i; n--) {
                cardsDeck.add(n);
            }
        /*
        Neste bloco While eu manipulo o baralho principal, onde se a quantidade de cartas no baralho for maior do que 1 eu realizo as seguintes mudanças:
            Linha 40: Removo a carta do topo e a adiciono as cartas descartadas.
            Linha 41: Removo a carta que agora esta no topo e adiciono ao fim do baralho.
         */
            while (cardsDeck.size() > 1) {
                discardedCards.add(cardsDeck.pollLast());
                cardsDeck.addFirst(cardsDeck.pollLast());
            }
        }
            System.out.println("Discarded Cards: "+discardedCards.toString().replace("[", "").replace("]", "")); //print das cartas descartadas utilizando .replace para substituir [] por espaços vazios.
            System.out.println("Remaining Card: "+cardsDeck.toString().replace("[", "").replace("]", "")); //Print do baralho principal utilizando o mesmo .replace acima
    }
}