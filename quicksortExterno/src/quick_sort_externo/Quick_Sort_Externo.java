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
    List<String> saida;
    String retorno;

    public List<Integer> getArquivo() {
        return arquivo;
    }

    public List<String> getSaida() {
        return saida;
    }

    public void setArquivo(List<Integer> arquivo) {
        this.arquivo = arquivo;
    }

    public Quick_Sort_Externo() {
        arquivo = new ArrayList<>();
        saida = new ArrayList<>();
    }

    public String getRetorno() {
        return retorno;
    }

    public boolean Exist(int valor) {
        for (int k = 0; k < arquivo.size(); k++) {
            if (arquivo.get(k) == valor) {
                return true;
            }
        }
        return false;
    }

    public void adicionaArea(int valor, List<Integer> area) {
        area.add(valor);
        Collections.sort(area);
    }

    public String ToString2(int LimSup, int LimInf, int Ei, int Es, int Ls, int Li, List<Integer> area, int i, int j) {
        String result = "";
        for (int k = 0; k < arquivo.size(); k++) {
            result = result + " " + arquivo.get(k);
        }
        result = result + "%";
        for (int k = 0; k < area.size(); k++) {
            result = result + " " + area.get(k);
        }
        result = result + "#LimSup:" + LimSup + " LimInf:" + LimInf + " Es: " + Es + " Ei:" + Ei + " Ls:" + Ls + " Li:" + Li + " I:" + i + " J:" + j;
        return result;
    }

    public void particao(int esq, int dir) {
        int aux, LimSup, LimInf, Ei, Es, Ls, Li;
        List<Integer> area = new ArrayList<>();
        retorno = "";
        boolean teste = true;
        LimInf = -1000;
        LimSup = 1000;
        Li = Ei = esq;
        Ls = Es = dir;
        i = esq - 1;
        j = dir + 1;
        retorno = ToString2(LimSup, LimInf, Ei, Es, Ls, Li, area, i, j);
        saida.add(retorno);
        while (Ls >= Li) {
            if (area.size() < 2) {
                if (teste) {
                    adicionaArea(arquivo.get(Ls), area);
                    Ls--;
                    teste = false;
                    retorno = ToString2(LimSup, LimInf, Ei, Es, Ls, Li, area, i, j);
                    saida.add(retorno);
                } else {
                    adicionaArea(arquivo.get(Li), area);
                    Li++;
                    teste = true;
                    retorno = ToString2(LimSup, LimInf, Ei, Es, Ls, Li, area, i, j);
                    saida.add(retorno);
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
            if (aux > LimSup) {
                j = Es;
                arquivo.remove(Es);
                arquivo.add(Es, aux);
                Es--;
                retorno = ToString2(LimSup, LimInf, Ei, Es, Ls, Li, area, i, j);
                saida.add(retorno);
                continue;
            }
            if (aux < LimInf) {
                i = Ei;
                arquivo.remove(Ei);
                arquivo.add(Ei, aux);
                Ei++;
                retorno = ToString2(LimSup, LimInf, Ei, Es, Ls, Li, area, i, j);
                saida.add(retorno);
                continue;
            }
            adicionaArea(aux, area);
            retorno = ToString2(LimSup, LimInf, Ei, Es, Ls, Li, area, i, j);
            saida.add(retorno);
            if (Ei - esq < dir - Es) {
                arquivo.remove(Ei);
                arquivo.add(Ei, area.get(0));
                Ei++;
                LimInf = area.get(0);
                area.remove(0);
                retorno = ToString2(LimSup, LimInf, Ei, Es, Ls, Li, area, i, j);
                saida.add(retorno);
            } else {
                arquivo.remove(Es);
                arquivo.add(Es, area.get(area.size() - 1));
                Es--;
                LimSup = area.get(area.size() - 1);
                area.remove(area.size() - 1);
                retorno = ToString2(LimSup, LimInf, Ei, Es, Ls, Li, area, i, j);
                saida.add(retorno);
            }
        }
        int k = 0;
        while (Ei <= Es) {
            arquivo.remove(Ei);
            arquivo.add(Ei, area.get(k));
            k++;
            Ei++;
        }
        for (int l = 0; l < area.size(); l++) {
            area.remove(l);
        }
        retorno = ToString2(LimSup, LimInf, Ei, Es, Ls, Li, area, i, j);
        saida.add(retorno);
    }

    public void quickSort(int esq, int dir) {
        if (dir - esq >= 1) {
            particao(esq, dir);
            if (i - esq < dir - j) {
                quickSort(esq, i);
                quickSort(j, dir);
            } else {
                quickSort(j, dir);
                quickSort(esq, i);
            }
        }
    }
}
