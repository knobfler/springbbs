package com.dongho.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.dongho.board.domain.BoardVO;
import com.dongho.board.persistance.BoardDAOImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
@ControllerAdvice
public class BoardController {
	
	@Inject
	BoardDAOImpl boardDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<BoardVO> boards;
		
		try {
			boards = boardDAO.GetAllBoardList();
			model.addAttribute("AllList", boards);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handle(Exception e) {
		return "/common/404";
	}
	
}
