package com.revature.dao;

import java.util.ArrayList;

import com.revature.model.Ticket;

public interface TicketDAO {
	public void insertTicket(Ticket ticket);
	public ArrayList<Ticket> selectTicketsByUserId(int userId);
}
