package persistencia;

public class ConsultaDAOSQL {

    private static final String INSERT_ROTA = "INSERT INTO ROTA (id_rota, tempoDias, custoGrama, capacidadeTotal,"
                                                                +" id_local, origem, destino)"
                                                                +" values (?, ?, ?, ?, ?, ?, ?); ";
    
    private static final String INSERT_LOCALIDADE = "INSERT INTO Localidade (id_local, nome) values (?, ?) ";
    
    private static final String INSERT_FRACIONADAS = "INSERT INTO Fracionadas (id_fracionada, id_origem, id_destino)"
                                                    + " values (?, ?, ?) ";
  
    private static final String SELECT_ROTAS_ORIGEM = "SELECT r.origem "
                                                    +" FROM Rota r inner join Localidade l "
                                                    +" ON(r.id_local = l.id_local)";

    private static final String SELECT_ROTAS_DESTINO = "SELECT r.destino "
                                                     +" FROM Rota r inner join Localidade l "
                                                     +" ON(r.id_local = l.id_local)";	
	
}
