package application.model.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import application.model.dao.CardDAO;
import application.model.entity.Bike;
import application.model.entity.CreditCard;

public class CardService {
	CardDAO cardDAO;
	
	public CardService() {
		cardDAO = new CardDAO();
	}
	
	public List<CreditCard> getCardList(int accountId) {
		List<CreditCard> cardList = new ArrayList<CreditCard>();
		ResultSet rs = cardDAO.getAllCard(accountId);
		try {
			while (rs.next()) {
//				Map<String, Object> m = bikeTypeService.getBikeTypeById(rs.getInt(4));
//				Bike bike = new Bike(rs.getString(1), (String) m.get("typename"), (double) m.get("typevalue"), rs.getString(5));
//				bikeList.add(bike);
//				System.out.println(bike.getDepositValue());
				
				CreditCard card = new CreditCard(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				cardList.add(card);
			}
			return cardList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public CreditCard getCardById(String id) {
		ResultSet rs = cardDAO.getCardById(id);
		CreditCard card;
		try {
			while (rs.next()) {
//				Map<String, Object> m = bikeTypeService.getBikeTypeById(rs.getInt(4));
//				if (m != null) {
//					bike = new Bike(rs.getString(1), (String) m.get("typename"), (double) m.get("typevalue"), rs.getInt(2),
//							rs.getString(5), (double) m.get("typepayfactor"));
//					System.out.println(bike.getTypeName());
//					return bike;
//				}
				card = new CreditCard(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				return card;
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
