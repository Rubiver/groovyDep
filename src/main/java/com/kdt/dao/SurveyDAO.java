package com.kdt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdt.dto.SurveyDTO;
import com.kdt.dto.SurveyMultiDTO;
import com.kdt.dto.SurveyMultiResponseDTO;
import com.kdt.dto.SurveyShortDTO;
import com.kdt.dto.SurveyShortResponseDTO;

@Repository
public class SurveyDAO {
	
	
	@Autowired
	private SqlSession db;
	
	public List<SurveyDTO> selectList(){
		return db.selectList("Survey.selectAll");
	}
	
	public int insertSurvey(SurveyDTO dto) {
		db.insert("Survey.insertSurvey",dto);
		return dto.getSurseq();
	}
	
	public int insertShort(SurveyShortDTO dto) {
		return db.insert("Survey.insertShort",dto);
	}
	
	public int insertMulti(SurveyMultiDTO dto) {
		return db.insert("Survey.insertMulti",dto);
	}
	
	public SurveyDTO selectSurvey(int seq) {
		return db.selectOne("Survey.selectOne",seq);
	}
	
	public List<SurveyShortDTO> selectShort(int seq){
		return db.selectList("Survey.selectShort",seq);
	}
	
	public List<SurveyMultiDTO> selectMulti(int seq){
		return db.selectList("Survey.selectMulti",seq);
	}
	
	public int insertShortRes(SurveyShortResponseDTO dto) {
		return db.insert("Survey.insertShortRes",dto);
	}
	
	public int insertMultiRes(SurveyMultiResponseDTO dto){
		return db.insert("Survey.insertMultiRes",dto);
	}

}