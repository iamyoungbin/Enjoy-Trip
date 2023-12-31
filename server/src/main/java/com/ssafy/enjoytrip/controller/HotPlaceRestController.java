package com.ssafy.enjoytrip.controller;

import com.ssafy.enjoytrip.dto.HotPlaceDto;
import com.ssafy.enjoytrip.model.service.HotPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/enjoytripapi/hotplaceapi")
@RequiredArgsConstructor
public class HotPlaceRestController {

	private final HotPlaceService hotPlaceService;

	@GetMapping("/list")
	private ResponseEntity<?> list(@RequestParam String pgno, @RequestParam String sort) throws Exception {
		Map<String, String> map = new HashMap<String, String>();

		map.put("pgno", pgno + "");
		map.put("sort", sort);
		List<HotPlaceDto> list = hotPlaceService.listHotPlace(map);
		return new ResponseEntity<List<HotPlaceDto>>(list, HttpStatus.OK);
	}

	@PostMapping("/write")
	private ResponseEntity<?> createHotPlace(@RequestBody HotPlaceDto hotPlaceDto) throws Exception {
		int result = hotPlaceService.createHotPlace(hotPlaceDto);
		if (result == 1) return new ResponseEntity<Integer>(1, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/readFavorite/{hotPlaceId}")
	private ResponseEntity<?> getFavHotPlace(@PathVariable int hotPlaceId) throws Exception {
		HotPlaceDto favPlace = hotPlaceService.getFavHotPlace(hotPlaceId);
		if (favPlace != null) return new ResponseEntity<HotPlaceDto>(favPlace, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/myHotplace/{userId}")
	private ResponseEntity<?> getMyHotPlace(@PathVariable("userId") String userId) throws Exception {
		List<HotPlaceDto> list = hotPlaceService.getMyHotPlace(userId);

		if (list != null) return new ResponseEntity<List<HotPlaceDto>>(list, HttpStatus.OK);

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/updateVisited")
	private ResponseEntity<?> updateVisitedCount(@RequestBody HotPlaceDto hotPlaceDto) throws Exception {

		int result = hotPlaceService.updateVisitedCount(hotPlaceDto.getHotplaceId());

		if (result == 1) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}

	@PostMapping("/addHitCount")
	private ResponseEntity<?> addHitCount(@RequestBody HotPlaceDto hotPlaceDto) throws Exception {

		int result = hotPlaceService.addHitCount(hotPlaceDto.getHotplaceId());

		if (result == 1) {
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/minHitCount")
	private ResponseEntity<?> minHitCount(@RequestBody HotPlaceDto hotPlaceDto) throws Exception {
		int result = hotPlaceService.minHitCount(hotPlaceDto.getHotplaceId());

		if (result == 1) {
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/update")
	private ResponseEntity<?> updateHotPlace(@RequestBody HotPlaceDto hotPlaceDto) throws Exception {
		
		int result = hotPlaceService.updateHotPlace(hotPlaceDto);

		if (result == 1){
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/delete/{hotPlaceId}")
	private ResponseEntity<?> deleteHotPlace(@PathVariable("hotPlaceId") int hotPlaceId) throws Exception {

		int result = hotPlaceService.deleteHotPlace(hotPlaceId);

		if (result == 1){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getOne")
	private ResponseEntity<?> getOne(@RequestParam String sortType) throws Exception {
		HotPlaceDto hotPlaceDto = hotPlaceService.getOne(sortType);
		if(hotPlaceDto != null) {
			return new ResponseEntity<HotPlaceDto>(hotPlaceDto, HttpStatus.OK);
		} else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}