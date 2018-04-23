/**
 * @ProjectName b2b-data-common
 * @FileName QRCodeUtil.java
 * @PackageName com.xe.b2b.data.common.util
 * @Date 2017年1月9日下午4:47:48
 * @Copyright (c) 2017, xhra All Rights Reserved.
 *
 */

package com.xe.b2b.data.common.util;

/**
 * @ClassName QRCodeUtil 
 * @Description TODO
 * @Date     2017年1月9日 下午4:47:48
 * @author   Tom.Xie
 * @version  v1.0	 
 */

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QRCodeUtil {

    public static void main(String[] args) {

        encoderQRCode("xwt", "C://xwt.PNG");

        decoderQRCode("C://xwt.PNG", String.class);
    }

    public static String encoderQRCode(Object obj, String imgPath) {
        if (obj == null) {
            return null;
        }

        String content = JsonUtils.toJson(obj);
        ByteArrayOutputStream stream = QRCode.from(content).to(ImageType.PNG).withSize(250, 250).stream();

        try {
            FileOutputStream fout = new FileOutputStream(new File(imgPath));
            fout.write(stream.toByteArray());

            fout.flush();
            fout.close();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return null;
    }

    /**
     * 解码二维码
     * 
     * @param imgPath
     * @return String
     */
    @SuppressWarnings("unchecked")
    public static <T> T decoderQRCode(String imgPath, Class<T> targetType) {
        String json = null;
        try {
            File file = new File(imgPath);
            MultiFormatReader formatReader = new MultiFormatReader();

            if (!file.exists()) {
                return null;
            }

            BufferedImage image = ImageIO.read(file);

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);

            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            Result result = formatReader.decode(binaryBitmap, hints);
            json = result.getText();
            System.out.println("解析结果 = " + result.toString());
            System.out.println("二维码格式类型 = " + result.getBarcodeFormat());
            System.out.println("二维码文本内容 = " + result.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JsonUtils.toObject(json, targetType);
    }
}
