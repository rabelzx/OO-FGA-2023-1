/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoOO;

/**
 *
 * @author breno
 */
public class Valores {
    private float fracao, hora_cheia,   
                  diurna, noturna,
                  mensalista, evento,
                  retorno, desHora;
    
    public Valores(){}

    public Valores(float fracao, float diurna,float desNoturno, float mensalista, float evento, float retorno, float desHora) {
        this.fracao = fracao;
        this.diurna = diurna;
        this.mensalista = mensalista;
        this.evento = evento;
        this.retorno = retorno;
        this.desHora = desHora;
        this.hora_cheia = calcHoraC();
        this.noturna = calcDiariaNoturna();
    }

    public float getFracao() {
        return fracao;
    }

    public void setFracao(float fracao) {
        this.fracao = fracao;
    }

    public float getHora_cheia() {
        return hora_cheia;
    }

    public void setHora_cheia(float hora_cheia) {
        this.hora_cheia = hora_cheia;
    }

    public float getDiurna() {
        return diurna;
    }

    public void setDiurna(float diurna) {
        this.diurna = diurna;
    }

    public float getNoturna() {
        return noturna;
    }

    public void setNoturna(float noturna) {
        this.noturna = noturna;
    }

    public float getMensalista() {
        return mensalista;
    }

    public void setMensalista(float mensalista) {
        this.mensalista = mensalista;
    }

    public float getEvento() {
        return evento;
    }

    public void setEvento(float evento) {
        this.evento = evento;
    }

    public float getRetorno() {
        return retorno;
    }

    public void setRetorno(float retorno) {
        this.retorno = retorno;
    }

    public float getDesHora() {
        return desHora;
    }

    public void setDesHora(float desHora) {
        this.desHora = desHora;
    }
    
    public float calcHoraC(){
        return 4*fracao*desHora;
    }
    
    public float calcDiariaNoturna(){
        return diurna*desHora;
    }
}
