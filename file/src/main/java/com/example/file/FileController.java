package com.example.file;

import com.example.file.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

@Slf4j
@RestController
public class FileController {
    @PostMapping(
            value = "/multipart",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseDto multipart(
            @RequestParam("name") String name,
            @RequestParam("photo") MultipartFile multipartFile
    ) throws IOException {
        // 저장할 경로를 생성한다.
        Files.createDirectories(Path.of("media"));
        // 저장할 파일이름을 포함한 경로를 작성한다.
        // Screenshot From 2023-06-23 10:39:00.png 처럼 시간으로 겹치지않게 네이밍
        LocalDateTime now = LocalDateTime.now(); // 현재 시각을 돌려받는 코드
        log.info(now.toString());
        String filename = now.toString().replace(":", "");
        Path uploadTO = Path.of(String.format("media/%s.jpg", filename));

//        Path uploadTO = Path.of("media/filename.png");
        // 저장한다
        multipartFile.transferTo(uploadTO);

//        File file = new File("./filename.png");
//        try (OutputStream outputStream = new FileOutputStream(file)){
//            byte[] fileBytes = multipartFile.getBytes();
//            // 여기에서 byte[]를 활용
//
//            outputStream.write(fileBytes);
//        }

        ResponseDto response = new ResponseDto();
        response.setMessage(String.format("/static/%s.jpg", filename));
        return response;
    }
}
