package com.ssafy.enjoytrip.model.repo;


import com.ssafy.enjoytrip.dto.AttractionInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface AttractionRepo {
	List<AttractionInfoDto> searchByTitle(String title, int sidoCode, int searchContent);

}