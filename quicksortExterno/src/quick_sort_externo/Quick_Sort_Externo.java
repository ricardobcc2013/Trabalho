/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quick_sort_externo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author WiIsmar
 */
public class Quick_Sort_Externo {
    int i, j;
    List<Integer> arquivo;

    public Quick_Sort_Externo(List<Integer> arquivo) {
        this.arquivo = arquivo;
    }
    
    public void adicionaArea(int valor, List<Integer> area) {
        area.add(valor);
        Collections.sort(area);
    }

    public void particao(int esq, int dir) {
        int LimSup, LimInf, Ei, Es, Ls, Li, aux;
        List<Integer> area = new ArrayList<>();
        boolean teste = true;
        LimInf = -1000;
        LimSup = 1000;
        Li = Ei = esq;
        Ls = Es = dir;
        i = esq - 1;
        j = dir + 1;
        while (Ls >= Li) {
            if (area.size() < 2) {
                if (teste) {
                    adicionaArea(arquivo.get(Ls), area);
                    Ls--;
                    teste = false;
                } else {
                    adicionaArea(arquivo.get(Li), area);
                    Li++;
                    teste = true;
                }
                continue;
            }
            if (Ls == Es) {
                aux = arquivo.get(Ls);
                Ls--;
                teste = false;
            } else {
                if (Li == Ei) {
                    aux = arquivo.get(Li);
                    Li++;
                    teste = true;
                } else {
                    if (teste) {
                        aux = arquivo.get(Ls);
                        Ls--;
                        teste = false;
                    } else {
                        aux = arquivo.get(Li);
                        Li++;
                        teste = true;
                    }
                }
            }
            if(aux > LimSup){
                j = Es;
                arquivo.remove(Es);
                arquivo.add(Es, aux);
                Es--;
                continue;
            }
            if(aux < LimInf){
                i = Ei;
                arquivo.remove(Ei);
                arquivo.add(Ei, aux);
                Ei++;
                continue;
            }
            adicionaArea(aux, area);
            if(Ei - esq < dir - Es){
                arquivo.remove(Ei);
                arquivo.add(Ei, area.get(0));
                Ei++;
                LimInf = area.get(0);
                area.remove(0);
            }else{
                arquivo.remove(Es);
                arquivo.add(Es, area.get(area.size() - 1));
                Es--;
                LimSup = area.get(area.size() - 1);
                area.remove(area.size() - 1);
            }
        }
        int k = 0;
        while(Ei <= Es){
            arquivo.remove(Ei);
            arquivo.add(Ei, area.get(k));
            k++;
            Ei++;
        }
    }
    
    public void quickSort(int esq, int dir){
        if(dir - esq >= 1){
            particao(esq, dir);
            if(i - esq  < dir - j){
                quickSort(esq, i);
                quickSort(j, dir);
            }else{
                quickSort(j, dir);
                quickSort(esq, i);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> arquivos = new ArrayList<>();
        arquivos.add(5);
        arquivos.add(3);
        arquivos.add(10);
        arquivos.add(6);
        arquivos.add(1);
        arquivos.add(7);
        arquivos.add(4);
        arquivos.add(-1);
        arquivos.add(8);
        Quick_Sort_Externo a = new Quick_Sort_Externo(arquivos);
        a.quickSort(0, arquivos.size() - 1);
        for (int i = 0; i < arquivos.size(); i++) {
            System.out.println(arquivos.get(i));
        }
    }
}
