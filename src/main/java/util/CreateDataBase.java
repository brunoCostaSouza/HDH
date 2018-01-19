package util;

import dao.GenericDAO;
import model.LoginBean;

public class CreateDataBase {
	
	public static void createDataBaseSeNecessario(Result r){
		if(GenericDAO.getInstance().conn != null){
			
			if(!GenericDAO.getInstance().verificarSeExisteTabela(r)){
				r.setMsg("Não existe a tablea login");
				try {
					GenericDAO.getInstance().criarTabelaLogin(r);
					GenericDAO.getInstance().criarTabelaJogador();
					GenericDAO.getInstance().criarTabelaNoticia();
					GenericDAO.getInstance().criarTabelaRankingArco();
					GenericDAO.getInstance().criarTabelaRankingFuzil();
					GenericDAO.getInstance().criarTabelaRankingPistola();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else{
				LoginBean login = new LoginBean();
				login.setLogin("brunocosta");
				login.setSenha("brunoinfo2");
				GenericDAO.getInstance().persist(login);
			}
			
		}
	}
	
}
