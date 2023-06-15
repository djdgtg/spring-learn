package com.qinchao.boot.system.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qinchao.boot.system.entity.SysUser;
import com.qinchao.boot.system.mapper.SysUserMapper;
import com.qinchao.common.base.bean.CustomException;
import com.qinchao.common.base.util.SystemClock;
import com.qinchao.common.easyexcel.ExcelCheckMessage;
import com.qinchao.common.easyexcel.ExcelUtils;
import com.qinchao.common.minio.MinioUtils;
import com.qinchao.common.web.util.WebUtils;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/3/28 10:56
 */
@RestController
@RequestMapping("user")
@AllArgsConstructor
public class SysUserController {

    private final SysUserMapper userMapper;
    private final MinioUtils minioUtils;

    @GetMapping("{id}")
    public SysUser getById(@PathVariable Integer id) {
        if (id > 100 || id < 1) {
            throw new CustomException("请输入合适用户id");
        }
        return userMapper.selectById(id);
    }

    @GetMapping("list")
    public List<SysUser> list() {
        return userMapper.selectList(null);
    }

    @PostMapping("login")
    public SysUser login(@RequestBody @Validated SysUser sysUser) {
        return userMapper.selectOne(new QueryWrapper<SysUser>().lambda()
                .eq(SysUser::getUsername, sysUser.getUsername()).eq(SysUser::getPassword, sysUser.getPassword()));
    }

    @PostMapping("uploadAvatar")
    public void uploadAvatar(MultipartFile file) throws Exception {
        WebUtils.checkFileExtension(file, Arrays.asList(".jpg", ".png"));
        minioUtils.uploadInputStream("learn", file.getOriginalFilename(), file.getInputStream(), file.getContentType());
    }

    @PostMapping("import")
    public void excelImport(MultipartFile file) throws IOException {
        ExcelUtils.importData(file.getInputStream(),
                userMapper::insertBatchSomeColumn,
                errors -> {
                    File tmepFile = new File("C:\\data\\" + SystemClock.now() + ExcelTypeEnum.XLSX.getValue());
                    ExcelUtils.exportData(tmepFile, errors, ExcelCheckMessage.class);
                    minioUtils.uploadFile("learn", tmepFile);
                },
                SysUser.class);
    }

    @PostMapping("export")
    public void excelImport(HttpServletResponse response) throws IOException {
        List<SysUser> users = userMapper.selectList(null);
        // 设置response的Header
        response.addHeader("Content-Disposition", "attachment;filename=" + SystemClock.now() + ExcelTypeEnum.XLSX.getValue());
        response.setContentType("application/octet-stream");
        EasyExcel.write(response.getOutputStream(), SysUser.class).sheet().doWrite(users);
    }
}
