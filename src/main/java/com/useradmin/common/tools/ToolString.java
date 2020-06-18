package com.useradmin.common.tools;

import com.jfinal.kit.PropKit;
import com.useradmin.common.constant.ConstantInit;
import com.useradmin.common.constant.RexExp;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理常用方法
 */
public abstract class ToolString {

    @SuppressWarnings("unused")
    private static Logger log = Logger.getLogger(ToolString.class);

    /**
     * 非空处理 （null）
     *
     * @param s
     * @return
     */
    public static String parseOfNull(String s) {
        if (s == null) {
            return "";
        }

        return s;
    }

    /**
     * 首字母转小写
     *
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * 首字母转大写
     *
     * @param s
     * @return
     */
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile(RexExp.regExp_integer_1);
        return pattern.matcher(str).matches();
    }

    /**
     * list转字符串
     *
     * @param list
     * @return
     */
    public static String listToString1(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() - 1) {
                    sb.append("\"" + list.get(i) + "\",");
                } else {
                    sb.append("\"" + list.get(i) + "\"");
                }
            }
        }
        String s = sb.toString();
        s = s.substring(1, s.length() - 1);

        return s;
    }

    /**
     * 验证字符串是否匹配指定正则表达式
     *
     * @param content
     * @param regExp
     * @return
     */
    public static boolean regExpValida(String content, String regExp) {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(content);
        return matcher.matches();
    }

    /**
     * double精度调整
     *
     * @param doubleValue 需要调整的值123.454
     * @param format      目标样式".##"
     * @return
     */
    public static String decimalFormat(double doubleValue, String format) {
        DecimalFormat myFormatter = new DecimalFormat(format);
        String formatValue = myFormatter.format(doubleValue);
        return formatValue;
    }

    /**
     * URL编码（utf-8）
     *
     * @param source
     * @return
     */
    public static String urlEncode(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, PropKit.get(ConstantInit.config_constants_encoding));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据内容类型判断文件扩展名
     *
     * @param contentType 内容类型
     * @return
     */
    public static String getFileExt(String contentType) {
        String fileExt = "";
        if ("image/jpeg".equals(contentType)) {
            fileExt = ".jpg";

        } else if ("audio/mpeg".equals(contentType)) {
            fileExt = ".mp3";

        } else if ("audio/amr".equals(contentType)) {
            fileExt = ".amr";

        } else if ("video/mp4".equals(contentType)) {
            fileExt = ".mp4";

        } else if ("video/mpeg4".equals(contentType)) {
            fileExt = ".mp4";
        }

        return fileExt;
    }

    /**
     * 获取bean名称
     *
     * @param bean
     * @return
     */
    public static String beanName(Object bean) {
        String fullClassName = bean.getClass().getName();
        String classNameTemp = fullClassName.substring(fullClassName.lastIndexOf(".") + 1, fullClassName.length());

        return classNameTemp.substring(0, 1) + classNameTemp.substring(1);
    }

    /**
     * 获取环境配置文件
     *
     * @param active
     * @return
     */
    public static String ProfilesActive(String active) {
        if (active == null) {
            return "";
        }

        StringBuilder strBuild = new StringBuilder("jfinal-");
        strBuild.append(PropKit.get(active).toLowerCase());
        strBuild.append(".properties");

        return strBuild.toString();
    }

}
