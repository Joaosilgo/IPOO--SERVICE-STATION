
public class Cisterna//classe citerna
{
    private double capacidadeMaxima;//atributo capacidade maxima
    private double nivelAtual;//atributo nivel atual
    private String tipoCombustivel;//atributo tipo de combustivel
    
    public Cisterna(String tipoCombustivel, double capacidadeMaxima)
    {//contrutor recebe como parametros o tipo de combustivel e a capacidade maxima
        if(capacidadeMaxima <= 0)//validações
        {
            this.capacidadeMaxima = 1000.00;// se for inferior ou igual a recebe 1000
        }else
        {
            this.capacidadeMaxima = capacidadeMaxima;//se não a capacidade é igual á que selecionamos
        }
        nivelAtual = 0;//nivel atual é 0
        if(tipoCombustivel != null)//validação tipo de combustivel
        {
            this.tipoCombustivel = tipoCombustivel;// se for difrente de null recebe o que selecionamos
        }else
        {
            this.tipoCombustivel = "Não Especificado";//caso contrario é nao especificado    
        }
    }
    public Cisterna( double capacidadeMaxima, String tipoCombustivel)//2º construtor recebe como parametros a capacidade maxima e o tipo de combustivel
    {//iremos utilizar noutra classe
        if(capacidadeMaxima <= 0)//validamos como o construtor anterior
        {
            this.capacidadeMaxima = 1000.00;
        }else
        {
            this.capacidadeMaxima = capacidadeMaxima;
        }
        nivelAtual = this.capacidadeMaxima;//e o nivel atual fica como a capacidade maxima (fica cheio)
        if(tipoCombustivel != null)// validaçao tipo combustivel
        {
            this.tipoCombustivel = tipoCombustivel;
        }else
        {
            this.tipoCombustivel = "Não Especificado";        
        }
    }

    public double getCapacidadeMaxima()// metodo selector que retorna a capacidade maxima em double
    {
        return capacidadeMaxima;
    }
    public double getNivelAtual()// metodo selector que retorna o nivel atual em double
    {
        return nivelAtual;
    }
    public String getTipoCombustivel()// metodo selector que retorna o tipo de combustivel em String
    {
        return tipoCombustivel;
    }
    public boolean isCheia()//metodo boleano para saber se a cisterna esta cheia,retorna valores (true or false)
    {
        if(capacidadeMaxima == nivelAtual)//se a capacidade for igual ao nivel atual é porque está cheia
        {
            return true;//retorna true para a condiçao de cima
        }else
        {
            return false;//se não retorna false porque não está cheia
        }
    }
     public boolean isVazia()//metodo boleano para saber se a cisterna esta vazia,retorna valores (true or false)
    {
        if(nivelAtual == 0)//se o nivel atual for zero é porque esta vazia 
        {
            return true;// retorna true
        }else//se nao retorna false porque nao esta vazia
        {
            return false;
        }
    }
    public String informacao()//metodo que retorna toda a informaçao da cisterna (tipo de combustivel, capacidade maxima e o nivel atual)
    {
        return "Na Cisterna está Combustivel do tipo: " + tipoCombustivel 
        + "\n Capacidade maxima: " + capacidadeMaxima 
        + "\n Nivel Atual: " + nivelAtual;
    }
    public double retirarCombustivel(double combustivelARetirar)// metodo que reira combustivel da cisterna com condiçoes, este recebe como parametros o combustivel que queremos retirar
    {
        if( nivelAtual-combustivelARetirar >= 0.0)//se houver combustivel suficiente 
        {
            nivelAtual=nivelAtual-combustivelARetirar;//o nivel atual actualizase sobre o que se retirou
            return combustivelARetirar;// retorna o combustivel retirado
        }
        else{//caso contraio 
            double combustivelRetirado = nivelAtual;//variavel local onde retirado fica como o nivel atual
            nivelAtual = 0;//passamos o nivel atual a zero
            return combustivelRetirado;//retorna o combustivel retirado que é zero
        }
               
    }
    public double inserirCombustivel(double combustivelAInserir)//metodo para inserir combustivel
    {
        if (nivelAtual+combustivelAInserir>capacidadeMaxima)//se passar da capcidade maxima
        { double combustivelInserido = capacidadeMaxima - nivelAtual;//variavel local
          nivelAtual = capacidadeMaxima;
          return combustivelInserido;// so repõe a capacidade suficiente para encher termos a capacidade maxima
        }
        else{//se não passar da capcidade maxima
            nivelAtual=nivelAtual+combustivelAInserir;//actualiza o nivel atual para em funçao ao que se inserio
            return combustivelAInserir;//retorna o que inserimos 
        }
            
    }
    
}
