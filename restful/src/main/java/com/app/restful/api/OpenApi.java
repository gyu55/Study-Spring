package com.app.restful.api;


import com.app.restful.domain.dto.ApiResponseDTO;
import com.app.restful.domain.dto.CongestionDTO;
import com.app.restful.domain.dto.PetTourDTO;
import com.app.restful.service.OpenApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/open-apis")
@RequiredArgsConstructor
public class OpenApi {

    private final OpenApiService openApiService;

    @GetMapping("/pet-tour-list")
    public ResponseEntity<ApiResponseDTO<List<PetTourDTO>>> getPetTourList() throws IOException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponseDTO
                        .of("펫투어 리스트 조회완료", openApiService.fetchData()));
    }

    @GetMapping("/metro-list")
    public ResponseEntity<ApiResponseDTO<CongestionDTO>> getMetroList() throws IOException, URISyntaxException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponseDTO
                        .of("지하철 복잡도 조회완료", openApiService.fetchData2()));
    }
}
