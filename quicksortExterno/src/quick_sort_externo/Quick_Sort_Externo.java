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
    List<Integer> arquivo;

    public Quick_Sort_Externo(List<Integer> arquivo) {
       this.arquivo = arquivo;
    }
    
    public void adicionaArea(int valor, List<Integer> area){
        area.add(valor);
        Collections.sort(area);
    }
   
    public void ordena(int esq, int dir){
        int i, j, LimSup, LimInf, Ei, Es, Ls, Li,A1, A2, cont, aux;
        List<Integer> area = new ArrayList<>();
        boolean teste = true;
        A1 = A2 = cont = 0;
        i = esq - 1;
        j = dir + 1;
        Li = Ei = esq;
        Ls = Es = dir;
        LimInf = -1000;
        LimSup = 1000;
        while(Li <= Ls){
            if(cont < 2){
                if(teste){
                    adicionaArea(arquivo.get(Ls), area);
                    Ls--;
                    teste = false;
                }else{
                    adicionaArea(arquivo.get(Li), area);
                    Li++;
                    teste = true;
                }
                cont++;
            }
            if(cont == 2 && Li <= Ls){
                if(teste){
                    aux = arquivo.get(Ls);
                    teste = false;
                }else{
                    aux = arquivo.get(Li);
                    teste = true;
                }
                if(aux < LimInf){
                    i = Ei;
                    arquivo.add(i, aux);
                    Ei++;
                    A1++;
                }else{
                    if(aux > LimSup){
                        j = Es;
                        arquivo.add(j, aux);
                        Es--;
                        A2++;
                    }else{
                        adicionaArea(aux, area);
                        if(teste){
                            Ls--;
                            teste = false;
                        }else{
                            Li++;
                            teste = true;
                        }
                        cont++;
                    }
                }
            }
            if(cont == 3){
                if(A1 < A2){
                    arquivo.add(Ei, area.get(0));
                    area.remove(0);
                    Ei++;
                }else{
                    arquivo.add(Es, area.get(2));
                    area.remove(2);
                    Es--;
                }
                cont--;
            }
        }
        for (int k = 0; k < arquivo.size(); k++) {
            System.out.print(arquivo.get(k)+" ");
        }
        System.out.println("");
        for (int k = 0; k < area.size(); k++) {
            arquivo.add(Ei, area.get(k));
            Ei++;
        }
        if(Ei < arquivo.size()){
            ordena(0, i);
            ordena(j, arquivo.size() -1);
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
        Quick_Sort_Externo a = new Quick_Sort_Externo(arquivos);
        a.ordena(0, 6);
    }
}
