package com.chen.springbootdemo.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: chen
 * @Date: 2018/12/10 17:42
 * @Description:二维码工具类
 */
public class QRCodeUtil {
    /**
     *
     * @Title: testEncode
     * @Description:
     * @throws WriterException
     * @throws IOException
     *
     *             com.google.zxing.MultiFormatWriter 根据内容以及图像编码参数生成图像2D矩阵。
     *             com.google.zxing.client.j2se.MatrixToImageWriter
     *             根据图像矩阵生成图片文件或图片缓存 BufferedImage 。
     */
    public static void testEncode() throws WriterException, IOException {
        String filePath = "D://";
        String fileName = "zxing.png";
        JSONObject json = new JSONObject();
        json.put("zxing", "https://github.com/zxing/zxing/tree/zxing-3.0.0/javase/src/main/java/com/google/zxing");
        json.put("author", "shihy");
        String content = json.toJSONString();// 内容
        int width = 200; // 图像宽度
        int height = 200; // 图像高度
        String format = "png";// 图像类型
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
        Path path = FileSystems.getDefault().getPath(filePath, fileName);
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像
        System.out.println("输出成功.");
    }

    /**
     *
     * @Title: testDecode
     * @Description:
     *
     *              使用 javax.imageio.ImageIO 读取图片文件，并存为一个
     *               java.awt.image.BufferedImage 对象。
     *
     *               将 java.awt.image.BufferedImage 转换为 ZXing 能识别的
     *               com.google.zxing.BinaryBitmap 对象。
     *
     *               com.google.zxing.MultiFormatReader 根据图像解码参数来解析
     *               com.google.zxing.BinaryBitmap 。
     */
    public static void testDecode() {
        //String filePath = "D://zxing.png";
        String filePath = "D://QQ图片20181211113505.png";
        BufferedImage image;
        try {
            image = ImageIO.read(new File(filePath));
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
            JSONObject content = JSONObject.parseObject(result.getText());
            System.out.println(content);
            System.out.println("图片中内容：  ");
            System.out.println("author： " + content.getString("author"));
            System.out.println("chen：  " + content.getString("chen"));
            System.out.println("图片中格式：  ");
            System.out.println("encode： " + result.getBarcodeFormat());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }


}
