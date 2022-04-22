package bns.transactiion.Exception;

public class AlreadyExistingEmetteur extends Exception{

    private static final long serialVersionUID = 156546L;

    public AlreadyExistingEmetteur(String idemetteur){
        super("cet emetteur exist déjà qui a le id : "+idemetteur);
    }

}
