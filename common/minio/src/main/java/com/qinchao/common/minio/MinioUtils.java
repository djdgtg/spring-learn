package com.qinchao.common.minio;

import com.qinchao.common.base.bean.CustomException;
import io.minio.*;
import io.minio.http.Method;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * description
 *
 * @author qinchao
 * @since 2020/12/2 18:06
 */
@Component
@AllArgsConstructor
public class MinioUtils {

    private final MinioClient minioClient;

    /**
     * 判断桶是否存在
     *
     * @param bucket 桶
     */
    public boolean bucketExists(String bucket) throws Exception {
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
    }

    /**
     * 创建桶
     *
     * @param bucket 桶
     */
    public void makeBucket(String bucket) throws Exception {
        if (!bucketExists(bucket)) {
            // 新建桶
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
        }
    }

    /**
     * 上传本地文件
     *
     * @param bucket    桶
     * @param objectKey 文件key
     * @param filePath  文件路径
     */
    @SneakyThrows
    public void uploadFile(String bucket, String objectKey, String filePath) {
        minioClient.uploadObject(UploadObjectArgs.builder().bucket(bucket).object(objectKey).filename(filePath).build());
    }

    @SneakyThrows
    public void uploadFile(String bucket, File file) {
        uploadFile(bucket, file.getName(), file.getPath());
    }

    /**
     * 流式上传文件
     *
     * @param bucket      桶
     * @param objectKey   文件key
     * @param inputStream 文件输入流
     */
    public void uploadInputStream(String bucket, String objectKey, InputStream inputStream, String contentType) throws Exception {
        if (!StringUtils.hasLength(contentType)) {
            throw new CustomException("ContentType couldn't be empty when minio uploaded by inputStream");
        }
        minioClient.putObject(PutObjectArgs.builder().bucket(bucket).object(objectKey).stream(inputStream, inputStream.available(), -1).contentType(contentType).build());
    }

    /**
     * 下载文件
     *
     * @param bucket    桶
     * @param objectKey 文件key
     * @return 文件流
     */
    public InputStream download(String bucket, String objectKey) throws Exception {
        return minioClient.getObject(GetObjectArgs.builder().bucket(bucket).object(objectKey).build());
    }

    /**
     * 下载文件
     *
     * @param bucket    桶
     * @param objectKey 文件key
     */
    public void download(String bucket, String objectKey, OutputStream outputStream) throws Exception {
        InputStream in = download(bucket, objectKey);
        int count = 0;
        byte[] by = new byte[1024];
        // 通过response对象获取OutputStream流
        while ((count = in.read(by)) != -1) {
            // 将缓冲区的数据输出到浏览器
            outputStream.write(by, 0, count);
        }
        in.close();
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 文件复制
     *
     * @param sourceBucket    源桶
     * @param sourceObjectKey 源文件key
     * @param bucket          桶
     * @param objectKey       文件key
     */
    public void copyFile(String sourceBucket, String sourceObjectKey, String bucket, String objectKey) throws Exception {
        CopySource source = CopySource.builder().bucket(sourceBucket).object(sourceObjectKey).build();
        minioClient.copyObject(CopyObjectArgs.builder().bucket(bucket).object(objectKey).source(source).build());
    }

    /**
     * 删除文件
     *
     * @param bucket    桶
     * @param objectKey 文件key
     */
    public void deleteFile(String bucket, String objectKey) throws Exception {
        minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucket).object(objectKey).build());
    }

    /**
     * 获取文件签名url
     *
     * @param bucket    桶
     * @param objectKey 文件key
     * @param expires   签名有效时间  单位秒
     * @return 文件签名地址
     */
    public String getSignedUrl(String bucket, String objectKey, int expires) throws Exception {
        return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().method(Method.GET).bucket(bucket).object(objectKey).expiry(expires).build());
    }

}
