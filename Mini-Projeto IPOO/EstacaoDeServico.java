

public class EstacaoDeServico//classe cisterna 
{
    
    private String nome;// atributo nome
    private Dispensador dispensador1;//atributo dispensador1
    private Dispensador dispensador2;//atributo dispensador2
    private int identificacao;//identifica o dispensador 1 ou 2
    private Deposito depositoGasolina95;//atributo depositogasolina95 da classe deposito
    private Deposito depositoGasolina98;//atributo depositogasolina98 da classe deposito
    private Deposito depositoGasoleo;//atributo depositogasoleo da classe deposito
    private CamiaoCisterna camiao;//atributo camiao da classe camiaoCisterna
    

    
    

    
    public EstacaoDeServico(String nome)//cria uma estaçao que pede como parametros o seu nome
    {
       if (nome!= null){//valida o nome
       this.nome=nome;}
       depositoGasolina95 =new Deposito(1, "Gasolina95");//cria novo deposito gasolina 95 identificador1
       depositoGasolina98= new Deposito(2, "Gasolina98");//cria novo deposito gasolina 98 identificador2
       depositoGasoleo= new Deposito(3, "Gasoleo");//cria novo deposito gasoleo identificador3
       dispensador1 = new Dispensador(1, depositoGasolina95, depositoGasolina98, depositoGasoleo);//cria dispennsador 1
       dispensador2 = new Dispensador(2, depositoGasolina95, depositoGasolina98, depositoGasoleo);//cria dispennsador 2
       
    }
    
   
    public void selecionarNome(String nome)//metodo para selecionar o nome da estaçao se o quisermos mudar
    {
     if(nome!= null)//validaçao do nome
     {
         this.nome=nome;
        }else
        {
            this.nome="Nome Nao Esecificado";
        }
     
     System.out.println("Estação :"+this.nome);
    }
    
    public boolean abastecerVeiculos()//metodo para abastecer o veiculos 
    {
        if (identificacao ==1)//se for o dispensador 1
        {
          if(dispensador1.abastecer()){//abastece com o metodo implementado no dispensador
          dispensador1.bloquear();//e bloqueia-o
          return true;}//retorna abastecido
        }
        if (identificacao ==2)//se for o dispensador 2
        {
          if(dispensador2.abastecer()){//abastece com o metodo implementado no dispensador
          dispensador2.bloquear();//e bloqueia-o
          return true;}//retorna abastecido
        }
        return false;// se não retorna como nao abastecido
    }
    public void escolhaDeAbastecimento(int identificador, double combustivelParaRetirar, int identificacao)
    {//metodo que recebe como parametro o identificaçao do dispensador, o valor do combustivel a retirar e o identificador de combustivel
        if(identificacao<1 || identificacao>2){//validaçao
       System.out.println("selecione um dispensador entre 1 a 2 ");}// txt erro
       else
       {
        
           this.identificacao = identificacao;
            
       }
        if (identificacao ==1)//se for o dispensador1
        {
          dispensador1.selecionarCombustivel(identificador);//vai ao dispensador 1 e seleciona entre os 3 combustiveis existentes(identificador)
        }
        if (identificacao ==2)//se for o dispensador2
        {
          dispensador2.selecionarCombustivel(identificador);//vai ao dispensador 2 e seleciona entre os 3 combustiveis existentes(identificador)
        }
        if (identificacao ==1)//se for o dispensador1 
        {
          dispensador1.definirCombustivelParaRetirar(combustivelParaRetirar);//vai ao dispensador 1 e define o valore de combustivel a retirar com o parametro (double combustivelParaRetirar)
        }
        if (identificacao ==2)//se for o dispensador2
        {
          dispensador2.definirCombustivelParaRetirar(combustivelParaRetirar);//vai ao dispensador 2 e define o valore de combustivel a retirar com o parametro (double combustivelParaRetirar)
        }
         if (identificacao ==1)//se for o dispensador1
        {
          dispensador1.bloquear();//bloqueia para finalizar a escolha
        }else//se for o dispensador2
        {
          dispensador2.bloquear();//se for o dispensador2 bloqueia para finalizar a escolha
        }
    }
    public boolean abastecerDeposito(CamiaoCisterna camiao)//abastecer o deposito
    {
        this.camiao = camiao;//variavel local
        double quantidadeAReabastecer;//variavel local
        if(camiao.getIdentificador() == depositoGasolina95.getIdentificador())//se o identificador de combustivel do camiao for igual ao do deposito
        {
            depositoGasolina95.bloquear();//deposito desbloqueia 
            quantidadeAReabastecer = camiao.retirarCombustivel(camiao.getNivelAtual());//camiao com o eu nivel de combustivel
            depositoGasolina95.inserirCombustivel(quantidadeAReabastecer);//insere o combustivel no deposito
            depositoGasolina95.bloquear();//e bloqueia 
            return true;//abastece o deposito
        }
        if(camiao.getIdentificador() == depositoGasolina98.getIdentificador())//se o identificador de combustivel do camiao for igual ao do deposito
        {
            depositoGasolina98.bloquear();//deposito desbloqueia 
            quantidadeAReabastecer = camiao.retirarCombustivel(camiao.getNivelAtual());//camiao com o eu nivel de combustivel
            depositoGasolina98.inserirCombustivel(quantidadeAReabastecer);//insere o combustivel no deposito
            depositoGasolina98.bloquear();//e bloqueia 
            return true;//abastece o deposito
        }
        if(camiao.getIdentificador() == depositoGasoleo.getIdentificador())//se o identificador de combustivel do camiao for igual ao do deposito
        {
            depositoGasoleo.bloquear();//deposito desbloqueia 
            quantidadeAReabastecer = camiao.retirarCombustivel(camiao.getNivelAtual());//camiao com o eu nivel de combustivel
            depositoGasoleo.inserirCombustivel(quantidadeAReabastecer);//insere o combustivel no deposito
            depositoGasoleo.bloquear();//e bloqueia 
            return true;//abastece o deposito
        }
        return false;//caso contrario nao abastece 
    }
    public void Informacao()//metodo que nos dá todas as informaçoes implementadas em todas as classes
    {
        System.out.println(dispensador1.mostrador());
        System.out.println(dispensador2.mostrador());
        System.out.println(depositoGasolina95.getInformacao());
        System.out.println(depositoGasolina98.getInformacao());
        System.out.println(depositoGasolina98.getInformacao());
        
    }
}



   