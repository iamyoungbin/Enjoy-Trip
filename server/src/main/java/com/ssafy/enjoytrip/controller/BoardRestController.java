package com.ssafy.enjoytrip.controller;

import com.ssafy.enjoytrip.dto.BoardDto;
import com.ssafy.enjoytrip.model.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/enjoytripapi/articleapi")
@RequiredArgsConstructor
public class BoardRestController {

	private final BoardService boardService;

	@GetMapping("/list")
	private ResponseEntity<?> list(@RequestParam String pgno, @RequestParam String key, @RequestParam String word, @RequestParam String spp, @RequestParam String sort) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("pgno", pgno + "");
		map.put("key", key);
		map.put("word", word);
		map.put("spp", spp);
		map.put("sort", sort);
		List<BoardDto> list = boardService.listArticle(map);
		return new ResponseEntity<List<BoardDto>>(list, HttpStatus.OK);
	}

	@GetMapping("/articleCount")
	private ResponseEntity<?> listSize(@RequestParam String key, @RequestParam String word) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("key", key);
		map.put("word", word);

		int size = boardService.getArticleCount(map);
		return new ResponseEntity<Integer>(size, HttpStatus.OK);
	}

	@GetMapping("/view/{articleNo}")
	private ResponseEntity<?> view(@PathVariable("articleNo") String articleNo) throws Exception {
		int an = Integer.parseInt(articleNo);
		int result = boardService.updateHit(an);
		BoardDto boardDto = boardService.getArticle(an);
		return new ResponseEntity<>(boardDto, HttpStatus.OK);
	}

	@PostMapping("/write")
	private ResponseEntity<?> write(@RequestBody BoardDto boardDto) throws Exception {

		int result = boardService.writeArticle(boardDto);
		if (result == 1) {
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		}

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/modify")
	private ResponseEntity<?> modify(@RequestBody BoardDto boardDto) throws Exception {

		int result = boardService.modifyArticle(boardDto);
		if (result == 1)
			return new ResponseEntity<Integer>(result, HttpStatus.OK);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/delete/{articleNo}")
	private ResponseEntity<?> delete(@PathVariable("articleNo") String articleNo) throws Exception {

		int an = Integer.parseInt(articleNo);
		int result = boardService.deleteArticle(an);

		if (result == 1) {
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
