/*+-------------------------------------------------------------+
 | UNIFAL – Universidade Federal de Alfenas. |
 | BACHARELADO EM CIENCIA DA COMPUTACAO. |
 | Atividade.: 1 - Simulador QuickSort Externo |
 | Disciplina: Estrutura de Dados II |
 | Professor.: Luiz Eduardo da Silva |
 | Aluno(s)..: Àlisson José Oliveira de Faria 2013.1.08.002|
 |             José Renato de Souza
 | Data......: 24/11/2014|
 +-------------------------------------------------------------+*/

import controle.Controle;
import interfaceGrafica.Interfa_quick;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WiIsmar
 */
public class Main {
    public static void main(String[] args) {
        Controle c = new Controle();

        new Interfa_quick(c).setVisible(true);
    }
}
