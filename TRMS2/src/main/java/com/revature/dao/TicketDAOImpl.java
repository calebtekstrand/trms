package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.model.Ticket;
import com.revature.model.User;
import com.revature.util.ConnFactory;

public class TicketDAOImpl implements TicketDAO {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void insertTicket(Ticket ticket) {
		Connection conn = cf.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(
					"INSERT INTO ticket_db(event_date, event_time, "
					+ "event_loc, event_desc, event, event_cost, gf_id, gf_passing, "
					+ "justification, user_id) VALUES(?,?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, ticket.getDate());
			ps.setString(2, ticket.getTime());
			ps.setString(3, ticket.getLocation());
			ps.setString(4, ticket.getDescription());
			ps.setString(5, ticket.getEvent());
			ps.setInt(6, ticket.getCost());
			ps.setInt(7, ticket.getGfId());
			ps.setString(8, ticket.getGfPassing());
			ps.setString(9, ticket.getJustification());
			ps.setInt(10, ticket.getUserId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Ticket> selectTicketsByUserId(int userId) {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		Connection conn = cf.getConnection();
		PreparedStatement ps;
		
			try {
				ps = conn.prepareStatement("SELECT * FROM ticket_db WHERE user_id = ?");
				ps.setInt(1, userId);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Ticket ticket = new Ticket(rs.getInt("ticket_id"), rs.getString("event_date"), rs.getString("event_time"), rs.getString("event_loc"),
							rs.getString("event_desc"), rs.getString("event"), rs.getInt("event_cost"), rs.getInt("gf_id"), rs.getString("gf_passing"), 
							rs.getString("justification"), rs.getInt("user_id"), rs.getString("status"), rs.getString("stage"));
					tickets.add(ticket);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return tickets;
	}
	

}
