package bns.transactiion.Exception;

public class AlreadyExistingClient extends Exception{

    private static final long serialVersionUID = 1L ;
     public AlreadyExistingClient(int cin){
        super("ce client exist déjà qui a le cin : "+cin);
    }

}
