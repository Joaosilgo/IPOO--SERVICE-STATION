public class CamiaoCisterna
{
    private String marca;//atributo marca camiao
    private Deposito deposito;//atributo deposito da classe deposito
    public CamiaoCisterna(String marca, int tipoCombustivel, double capacidadeMaxima)//construtor camiaotem como parametros a marca o tipo de combustivel e a capacidae maxima
    {
        if (marca != null)//validaçao da marca
        {
            this.marca= marca;
        }else
        {
            this.marca = "Não Especificado";
        }
        if (tipoCombustivel ==1){
            deposito = new Deposito( "Gasolina95",capacidadeMaxima, tipoCombustivel);//cria um deposito do camiao
        }
        if (tipoCombustivel ==2){
            deposito = new Deposito( "Gasolina98",capacidadeMaxima, tipoCombustivel);//cria um deposito do camiao
        }
        if (tipoCombustivel ==3){
            deposito = new Deposito( "Gasoleo",capacidadeMaxima, tipoCombustivel);//cria um deposito do camiao
        }
    }
    public String getMarca()//retorna a marca do camiao
    {
        return marca;
    }
     public double getTotalCombustivelRetirados()//da-nos o total de combustivel retirados do deposito
    {
        return deposito.getTotalCombustivelRetirados();
    }
    public int getIdentificador()
    {
        return deposito.getIdentificador();//retorna nos o tipo de combustivel como identficador 1,2,3(gasolina95, 96, gasoleo)
    }
    public boolean isBloqueado()
    {
        return deposito.isBloqueado();//retorna nos se esta ou nao bloqueado o deposito
    }
    public void bloquear()
    {
        deposito.bloquear();//bloqueia o deposito
    }
     public String getTipoCombustivel()
    {
        return deposito.getTipoCombustivel();//da-nos o tipo de combustivel em string do deposito
    }
    public double getCapacidadeMaxima()
    {
        return deposito.getCapacidadeMaxima();//da-nos a capacidade maxima do deposito
    }
     public double getNivelAtual()
    {
        return deposito.getNivelAtual();//retorna nivel atual do deposito
    }
     public Cisterna getCisterna()
    {
        return deposito.getCisterna();//retorna-os a cisterna do deposito
    }
    public void getInformacaoCamiao()
    {
       System.out.println( deposito.getInformacaoCamiao());//da nos a informaçao do camiao ja criada no deposito
    }
    public double retirarCombustivel(double combustivelARetirar)//metodo que retira combustivel
    {
        deposito.bloquear();
        double quantidadeRetirada = deposito.retirarCombustivel(combustivelARetirar);
        deposito.bloquear();
        return quantidadeRetirada;
    }
    
}
