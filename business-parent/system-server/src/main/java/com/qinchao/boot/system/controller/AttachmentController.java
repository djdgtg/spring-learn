package com.qinchao.boot.system.controller;

import com.qinchao.common.minio.MinioProperties;
import com.qinchao.common.minio.MinioUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/28 10:56
 */
@RestController
@RequestMapping("attachment")
@AllArgsConstructor
public class AttachmentController {

    private final static String BUCKET_NAME = "learn";

    private final MinioUtils minioUtils;
    private final MinioProperties minioProperties;

    @PostMapping("upload")
    public String upload(MultipartFile file) throws Exception {
        minioUtils.uploadInputStream(BUCKET_NAME, file.getOriginalFilename(), file.getInputStream(), file.getContentType());
        return minioProperties.getEndpoint() + "/" + BUCKET_NAME + "/" + file.getOriginalFilename();
    }

    @GetMapping("download/{object}")
    public void download(@PathVariable String object, HttpServletResponse response) throws Exception {
        // 设置response的Header
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(object.getBytes()));
        response.setContentType("application/octet-stream");
        minioUtils.download(BUCKET_NAME, object, response.getOutputStream());
    }
}
