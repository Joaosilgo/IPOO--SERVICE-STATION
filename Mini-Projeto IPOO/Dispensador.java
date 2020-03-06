public class Dispensador//classe dispensador
{
    private int identificacao; // identificaçao do dispensador
    private String mostrador;// atributo mostrador vai ser utilizado
    private boolean estaBloqueado;//atributo booleano para saber se está bloqueado ou não
    private Deposito depositoGasolina95;//atributo gasolina 95 da classe do deposito
    private Deposito depositoGasolina98;//atributo gasolina 8 da classe do deposito
    private Deposito depositoGasoleo;//atributo gasoleo da classe do deposito
    private int identificador;// tipo de combustivel 1 para Gasolina95, 2 para Gasolina98 e 3 para Gasoleo
    private double combustivelParaRetirar;//atributo combustivel para retirar do dispensador
   
     
    public Dispensador(int identificacao, Deposito gasolina95, Deposito gasolina98, Deposito gasoleo)//contrutor como parametro indentificaçaodo dispensador
    {
        depositoGasolina95 =gasolina95;
        depositoGasolina98= gasolina98;
        depositoGasoleo= gasoleo;
        this.identificacao = identificacao;// identificaçao do dispensador selecionado
        this.estaBloqueado = false;//começa desbloqueado
        this.identificador = 1;//como têm de estar um combustivel selecionado começa co a gasolina 95
        depositoGasolina95.bloquear();//desbloqueia o deposito da gasolina 95
    }
    public void selecionarCombustivel (int identificador)//metodo que seleciona combustivel recebe omo parametro o idenidicador, visto que têm de ter um selecionado,
    {
        if(identificador<1 || identificador > 3)//validaçao(têm de ser entre um destes )
        {
            System.out.println("Selecione um Deposito entre 1(Gasolina95), 2(Gasolina98) e 3(Gasoleo)");//txt erro
        }else//se passou validação
        {//seleciona o pretendido e desbloqueia-o e bloqueia os retantes caso queiramos mudar
           if(this.identificador == 1)
           {
               depositoGasolina95.bloquear();
           }
           if(this.identificador == 2)
           {
               depositoGasolina98.bloquear();
           }
           if(this.identificador == 3)
           {
               depositoGasoleo.bloquear();
           }
           this.identificador = identificador;
            if(identificador == 1)
           {
               depositoGasolina95.bloquear();
           }
           if(identificador == 2)
           {
               depositoGasolina98.bloquear();
           }
           if(identificador == 3)
           {
               depositoGasoleo.bloquear();
           }
        }
    }
    public void bloquear()//bloquei e desbloqueia o dispensador
    {
        if(estaBloqueado == true)//se estiver bloueado 
        
        {estaBloqueado = false;}//desbloqueia
        
        else//se estiver desbloqueado
        
        {estaBloqueado = true;}//bloqueia
    }
    public void definirCombustivelParaRetirar( double combustivelParaRetirar)//seleciona o valor combustivel a retirar e faz todas as validaçoes neçessarias
    {
        if (estaBloqueado)
        {
            System.out.println("O dispensador esta bloqueado");
        }else if (combustivelParaRetirar <= 0)
        {
            System.out.println("tem de ser um valor maior que 0");
        }else
        {
            this.combustivelParaRetirar = combustivelParaRetirar;
            
        }
    }
    public boolean abastecer()//metodo para abastecer
    {
        if(this.combustivelParaRetirar == 0)//faz validaçoes quanto ao valor a retirar
        {
            System.out.println("selecione primeiro quanto vai retirar");
            return false;//nao abastece 
        }else
        {
            if(identificador == 1)//se for o indentificador 1 (gasolina 95)
            {
                depositoGasolina95.bloquear();
               if(depositoGasolina95.retirarCombustivel(this.combustivelParaRetirar)> 0){//retira combustivel do deposito  com o valor selecionado no metodo anterior
               combustivelParaRetirar=0;
               depositoGasolina95.bloquear();//volta a colocar o valor do combustivel que queremos retirar a zero
               return true;}//retorna true (abasteceu)
            }
            if(identificador == 2)//se for o indentificador 2 (gasolina 98)
            {
                depositoGasolina98.bloquear();
               if (depositoGasolina98.retirarCombustivel(this.combustivelParaRetirar)>0){//retira combustivel do deposito  com o valor selecionado no metodo anterior
               combustivelParaRetirar=0;
               depositoGasolina98.bloquear();//volta a colocar o valor do combustivel que queremos retirar a zero
               return true;}//retorna true (abasteceu)
            }
            if(identificador == 3)//se for o indentificador 3 (gasoleo)
            {
                depositoGasoleo.bloquear();
               if(depositoGasoleo.retirarCombustivel(this.combustivelParaRetirar)>0){//retira combustivel do deposito  com o valor selecionado no metodo anterior
               combustivelParaRetirar=0;
               depositoGasoleo.bloquear();//volta a colocar o valor do combustivel que queremos retirar a zero
               return true;}//retorna true (abasteceu)
            }
        }
        return false;//caso contrario nao abasteceu
    }
    public String mostrador()//retorna todas as informaçoes do dispensador(nº dispensador, se esta ou não bloqueado, o combustivel selecionado e o combustivel a retirar)
    {
        String mostrador = "";
        mostrador += "*****************Dispensador numero " + identificacao+"*************************";
        if(estaBloqueado == true){
        mostrador += "\n*****************Dispensador Bloqueado********************";}
        else{
        mostrador +="\n****************Dispensador Desbloqueado******************";}
        mostrador +="\n***********************************************************";
        mostrador +="\n****************COMBUSTIVEL SELECIONADO*********************";
        if(identificador==1)
        {
        mostrador +="\n*********************Gasolina 95****************************";
        }
        if(identificador==2)
        {
        mostrador +="\n*********************Gasolina 98****************************";
        }
        if(identificador==3)
        {
        mostrador +="\n**********************Gasoleo*******************************";
        }
        mostrador +="\n************************************************************";
        mostrador +="\n*****************Combustivel A Retirar**********************";
        mostrador +="\n*******************************"+combustivelParaRetirar + "Litros *******************************";
        return mostrador;
    }
    
}

   