package com.kdt.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.Realtime_NotificationsDAO;
import com.kdt.dto.Realtime_NotificationsDTO;

import jakarta.servlet.http.HttpSession;

@Service
public class Realtime_NotificationsService {
	@Autowired
	private Realtime_NotificationsDAO rdao;
	
	public int insert(String message, String recipient, int parent_seq) {
		Realtime_NotificationsDTO dto = new Realtime_NotificationsDTO();
		Timestamp date = new Timestamp(System.currentTimeMillis());
		dto.setWrite_date(date);
		dto.setContents(message);
		dto.setRecipient(recipient);
		dto.setParent_seq(parent_seq);
		return rdao.insert(dto);
	}
	
	public List<Realtime_NotificationsDTO> selectUnreadNotifications(String id){
		return rdao.selectUnreadNotifications(id);
	}
	
	public int updateReadStatus(Realtime_NotificationsDTO dto) {
		return rdao.updateReadStatus(dto);
	}
	
}
