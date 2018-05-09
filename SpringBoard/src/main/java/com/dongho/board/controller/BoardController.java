package com.dongho.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.dongho.board.domain.BoardVO;
import com.dongho.board.persistance.BoardDAOImpl;
import com.dongho.board.service.BoardServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
@ControllerAdvice
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardServiceImpl service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<BoardVO> boards;

		try {
			boards = service.GetAllBoardList();
			model.addAttribute("AllList", boards);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeForm(@RequestParam String bno, Model model, BoardVO vo) {
		String actionState = "";
		// update
		if (Integer.parseInt(bno) > -1) {
			vo = service.ReadBoard(Integer.parseInt(bno));
			model.addAttribute("detail", vo);
			actionState = "write?ver=update";
			model.addAttribute("action", actionState);
			return "board/writeForm";
		}
		// initial Write
		else {

			actionState = "writeInitial";
			model.addAttribute("action", actionState);
			return "board/writeForm";
		}

	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writeAction(BoardVO vo, Model model, @RequestParam String ver) {
		try {

			if (ver.equals("update")) {
				// update
				service.UpdateBoard(vo);
				model.addAttribute("successMessage", "수정이 완료되었습니다!");
				return "board/writeSuccess";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/error";
	}

	@RequestMapping(value = "/writeInitial", method = RequestMethod.POST)
	public String writeInitial(BoardVO vo, Model model) {
		try {
			service.CreateBoard(vo);
			model.addAttribute("successMessage", "글이 등록되었습니다!");
			return "board/writeSuccess";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/error";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String deleteAction(Model model,
			@RequestParam(value = "bno", defaultValue = "0", required = false) int bno) {
		try {
			model.addAttribute("successMessage", "삭제가 완료되었습니다!");
			service.DeleteBoard(bno);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "board/writeSuccess";
	}

	@RequestMapping(value = "/detail/{bno}", method = RequestMethod.GET)
	public String read(@PathVariable int bno, BoardVO vo, Model model) {
		try {
			vo = service.ReadBoard(bno);
			model.addAttribute("detail", vo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/detail";
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public String handle(Exception e) {
		return "/common/404";
	}

}
