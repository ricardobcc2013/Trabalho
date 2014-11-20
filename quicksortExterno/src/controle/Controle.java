/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import quick_sort_externo.Quick_Sort_Externo;

/**
 *
 * @author WiIsmar
 */
public class Controle {

    Quick_Sort_Externo b;
    int controlesaida;

    public Controle() {
        b = new Quick_Sort_Externo();
    }

    public int Isnumber(String s) {
        try {
            int i = Integer.parseInt(s);
            if (i < -1000 || i > 1000) {
                return -1;
            }
            return 0;
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    public boolean adicionaArquivo(int valor) {
        if (b.Exist(valor)) {
            return false;
        }
        b.getArquivo().add(valor);
        return true;
    }

    public String tratarEntradaArquivo(String s) {
        int t = Isnumber(s);
        if (t == 0) {
            t = Integer.parseInt(s);
            if (adicionaArquivo(t)) {
                return "Número " + t + " Inserido";
            }
            return "Número já existente!";
        } else if (t == -1) {
            return "Requer numero menor que 1000 ou maior que -1000";
        } else {
            return "Digite apenas números!";
        }
    }

    public boolean tratarExecutar() {
        if (b.getArquivo().size() < 3) {
            return false;
        }
        b.quickSort(0, b.getArquivo().size() - 1);
        return true;
    }
    
    public void incrementaCont(){
        controlesaida++;
    }

    public String tratarSaidaArquivo() {
        String result = b.getSaida().get(controlesaida);
        return result.substring(0, result.indexOf("%"));
    }
    
    public String tratarSaidaMemoria(){
        String result = b.getSaida().get(controlesaida);
        return result.substring(result.indexOf("%")+ 1, result.indexOf("#"));
    }
    
    public String tratarSaidaVariaveis(){
        String result = b.getSaida().get(controlesaida);
        return result.substring(result.indexOf("#")+ 1, result.length());
    }
    
    public boolean Itsover(){
        if(b.getSaida().size() > controlesaida )
            return true;
        return false;
    }

}
