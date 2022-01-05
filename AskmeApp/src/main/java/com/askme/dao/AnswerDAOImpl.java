package com.askme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.askme.model.Answer;
import com.askme.model.Question;
import com.askme.util.ConnectionUtil;

public class AnswerDAOImpl {
	public void insertAnswer(Answer answer) {
		//Query-insert 
		String insertQuery ="insert into answer(answers,question_id) values(?,?)";
	   //DB connection 
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pst = null;
		//Get all values
		try {
			pst = con.prepareStatement(insertQuery);
			pst.setString(1,answer.getAnswer());
			pst.setInt(2,answer.getQuestion_id());	
			pst.executeUpdate();
			System.out.println("Answer inserted");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Value not inserted ");
		}
		
	}
	
	//Update 
		public void update(String update,int id){
			String updateQuery="update answer set answers=? where question_id=?";
			//get connection
			Connection con=ConnectionUtil.getDbConnection();
			System.out.println("Connection successfully");		
			PreparedStatement pstmt=null;
			try {
				pstmt = con.prepareStatement(updateQuery);
				pstmt.setString(1, update);
				pstmt.setInt(2, id);		
				int i=pstmt.executeUpdate();
				System.out.println("Updated sucessfully");
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//Delete 
		public void deletedetails(String delete) {
			String deleteQuery="delete from answer where question_id=?";
			//get connection
			Connection con=ConnectionUtil.getDbConnection();
			System.out.println("Connection successfully");
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(deleteQuery);
				pstmt.setString(1,delete);
				pstmt.executeUpdate();
				System.out.println("Your answer deleted");
				pstmt.close();
				con.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	public  static ResultSet showAllAnswer()
	{
		
		String query = "select * from answer";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		ResultSet rs=null;
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(query);
			 rs=stmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return rs;
	}
	//Show Answer by quesId
	public  ResultSet showAnswer(int quesId)
	{
		String query = "select * from answer where question_id=?";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		ResultSet rs=null;
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, quesId);
			 rs=stmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return rs;
	}
	//Find 
		public static int findQuestionId(String answers)
		{
			String findUserId="select question_id from answer where answers='"+answers+"'";
			Connection con=ConnectionUtil.getDbConnection();
			Statement stmt;
			int questionId=0;
			try {
				stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(findUserId);
				if(rs.next())
				{
				questionId=rs.getInt(1);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return questionId;
			
		}
		
	}



