package com.qinchao.common.web.util;

import com.qinchao.common.base.bean.CustomException;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/5/6 11:36
 */
public class WebUtils {

    private void checkFile(MultipartFile file) {
        if (file == null || file.getOriginalFilename() == null) {
            throw new CustomException("文件或文件名不能为空！");
        }
    }

    public static void checkFileExtension(MultipartFile file, List<String> includeExtensions) {
        if (file == null || file.getOriginalFilename() == null) {
            throw new CustomException("文件或文件名不能为空！");
        }
        String filename = file.getOriginalFilename();
        String extension = filename.substring(filename.lastIndexOf("."));
        if (!CollectionUtils.isEmpty(includeExtensions) && !includeExtensions.contains(extension)) {
            throw new CustomException(String.format("仅支持%s后缀名", includeExtensions));
        }
    }
}
