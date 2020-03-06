

public class Deposito//classe deposito
{
    
    private int identificador;//atributo que identifica o deposito
    private Cisterna cisterna;//atributo da classe cisterna 
    private double totalCombustivelRetirados;//atributo para o total de combustivel retirado
    private double totalCombustivelInserido;;//atributo para o total de combustivel inserido
    private boolean estaBloqueado;//atributo booleano para saber se está bloqueado ou não
    private CamiaoCisterna camiao;// atributo camiao da classe CamiaoCisterna

    
    public Deposito(int identificador, String tipoCombustivel, double capacidadeMaxima )
    {//construtor que recebe como parametros o identificador, o tipo de combustivel e a sua capacidade maxima
        if(capacidadeMaxima>0)//validações
        {//se a capacidade for superiora zero cria uma cisterna que recebe como parametros o tipo de combustivel e a capacidade maxima que selecionamos
            cisterna = new Cisterna(tipoCombustivel, capacidadeMaxima);
        }else//se não for suoerior a zero cria tambem uma cisterna com o tipo de combustivel que selecionamos mas com a capacidade maxima de 0
        {
            cisterna = new Cisterna(tipoCombustivel, 0);
        }
        estaBloqueado = true;//começa bloqueado
        totalCombustivelRetirados =0;//o total de combustivel retirado é zero porque ainda nao retiramos combustivel
        totalCombustivelInserido=0;//o total de combustivel inseris é zero porque ainda nao inserimos combustivel
        this.identificador = identificador;//o identificador é o que selecionamos
        
    }
    public Deposito(int identificador, String tipoCombustivel)//2º construtor 
    {
        cisterna = new Cisterna(tipoCombustivel, 0);// cria uma cisterna com o tipo de combustivel selecionado e capacidade maxima igual a zero
        estaBloqueado = true;//inicia-se bloqueado
        totalCombustivelRetirados =0;//o total de combustivel retirado é zero porque ainda nao retiramos combustivel
        totalCombustivelInserido=0;//o total de combustivel inseris é zero porque ainda nao inserimos combustivel
        this.identificador = identificador;//o identificador é o que selecionamos
        
    }
    public Deposito(String tipoCombustivel, double capacidadeMaxima, int identificador )//3º construtor 
    {
        if(capacidadeMaxima>0)//validaçoes iguais ao primeiro
        {
            cisterna = new Cisterna(capacidadeMaxima, tipoCombustivel);//cria uma nova cisterna
        }else
        {
            cisterna = new Cisterna(0, tipoCombustivel);
        }
        estaBloqueado = true;
        totalCombustivelRetirados =0;
        totalCombustivelInserido=0;
        this.identificador = identificador;
        
    }
    public int getIdentificador()//metodo seletor que retorna o identificador
    {
        return identificador;
    }
    public double getTotalCombustivelRetirados()//metodo seletor que retorna o total de combustivel retirado
    {
        return totalCombustivelRetirados;
    }
    public double getTotalCombustivelInserido()//metodo seletor que retorna o total de combustivel inserido
    {
        return totalCombustivelInserido;
    }
    public boolean isBloqueado()//metodo bolleano que nos retorna (true or false), esta bloqueado ou debloqueado respetivamente
    {
        return estaBloqueado;
    }
    public Cisterna getCisterna()//metodo que retorna a cisterna 
    {
        Cisterna cisternaCopia = new Cisterna(cisterna.getTipoCombustivel(),getCapacidadeMaxima());//recebe como parametros o tipo de combustivel e a capacidade maxima que ja foram criados 
        return cisternaCopia;
    }
    public void bloquear()//metodo que nos bloqueia ou desbloqueia o deposito
    {
        estaBloqueado = !estaBloqueado;
    }
    public String getTipoCombustivel()//retorna o tipo de combustivel que esta na cisterna
    {
        return cisterna.getTipoCombustivel();
    }
    public double getCapacidadeMaxima()//retorna o valor da capacidade maxima da cisterna
    {
        return cisterna.getCapacidadeMaxima();
    }
    public double getNivelAtual()//retorna valor do nivel actual de comustivel da cisterna
    {
        return cisterna.getNivelAtual();
    }
    public String getInformacao()//metodo que nos retorna a informaçao(indentificador , total de combutivel retirados, total de combustivel inseridos se está ou não bloqueado e as indormaçoes da cisterna )
    {
        return "Identificador: " + identificador
        + " \nTotal de Litros Retirados: " + totalCombustivelRetirados
        + "\nTotal de Litros Inseridos: " + totalCombustivelInserido
        + " \nBloqueado: " + estaBloqueado 
        + "\n " + cisterna.informacao();
    }
    public String getInformacaoCamiao()//retorna informaçao do camião
    {
        return "Marca: "+ camiao.getMarca()+"Identificador: " + identificador
        + " Total de Litros Retirados: " + totalCombustivelRetirados
        + " Total de Litros Inseridos: " + totalCombustivelInserido
        + " Bloqueado: " + estaBloqueado 
        + " " + cisterna.informacao();
    }
    public double retirarCombustivel(double combustivelARetirar)//metodo que nos retira combustivel recebe como parametro o valor que queremos retirar
    {
        if(estaBloqueado == true)//validaçao pis só dá se estiver desbloqueado
        {
            System.out.println("O deposito esta bloqueado");//txt erro
            return 0;//retorna 0
        }else if(cisterna.isVazia() == true)//a cisterna não pode estar vazia
        {
            System.out.println("O deposito esta vazio");//txt erro
            return 0;//retorna 0
        }else//se passar todas as validaçoes retira combustivel
        {
            double combustivelRetirado = cisterna.retirarCombustivel(combustivelARetirar);//metodo ja criada na cisterna 
            totalCombustivelRetirados = totalCombustivelRetirados + combustivelRetirado;// actualiza o tottal de combustivel retirado
            return combustivelRetirado;// retorna o valor que oi retirado
        }
    }
    public double inserirCombustivel(double combustivelAInserir)//metodo que nos insere combustivel recebe como parametro o valor que queremos inserir
    {//faz as validaçoes neçessarias como o metodo anterior 
        if(estaBloqueado == true)//não pode estar bloqueado
        {
            System.out.println("O deposito esta bloqueado");//txt erro
            return 0;
        }else if(cisterna.isCheia() == true)//não pode estar cheio
        {
            System.out.println("O deposito esta cheio");//txt erro
            return 0;
        }else//se passarem todas as validaçoes insere combustivel
        {
            double combustivelInserido = cisterna.inserirCombustivel(combustivelAInserir);
            totalCombustivelInserido = totalCombustivelInserido + combustivelInserido;//actualiza o total de combustivel inserido
            return combustivelInserido;//retorna valor inserido
        }
    }
}
