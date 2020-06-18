package com.useradmin.common.constant;

import java.util.regex.Pattern;

public interface RexExp {

    /**
     * 常用正则表达式：匹配非负整数（正整数 + 0）
     */
    String regExp_integer_1 = "^\\d+$";

    /**
     * 常用正则表达式：匹配由数字、26个英文字母、下划线、中划线、点组成的字符串
     */
    String regExp_letter_6 = "^([a-z_A-Z-.+0-9]+)$";

    /**
     * 常用正则表达式：匹配正整数
     */
    String regExp_integer_2 = "^[0-9]*[1-9][0-9]*$";

    /**
     * 常用正则表达式：匹配非正整数（负整数  + 0）
     */
    String regExp_integer_3 = "^((-\\d+) ?(0+))$";

    /**
     * 常用正则表达式：匹配负整数
     */
    String regExp_integer_4 = "^-[0-9]*[1-9][0-9]*$";

    /**
     * 常用正则表达式：匹配整数
     */
    String regExp_integer_5 = "^-?\\d+$";

    /**
     * 常用正则表达式：匹配非负浮点数（正浮点数 + 0）
     */
    String regExp_float_1 = "^\\d+(\\.\\d+)?$";

    /**
     * 常用正则表达式：匹配正浮点数
     */
    String regExp_float_2 = "^(([0-9]+\\.[0-9]*[1-9][0-9]*) ?([0-9]*[1-9][0-9]*\\.[0-9]+) ?([0-9]*[1-9][0-9]*))$";

    /**
     * 常用正则表达式：匹配非正浮点数（负浮点数 + 0）
     */
    String regExp_float_3 = "^((-\\d+(\\.\\d+)?) ?(0+(\\.0+)?))$";

    /**
     * 常用正则表达式：匹配负浮点数
     */
    String regExp_float_4 = "^(-(([0-9]+\\.[0-9]*[1-9][0-9]*) ?([0-9]*[1-9][0-9]*\\.[0-9]+) ?([0-9]*[1-9][0-9]*)))$";

    /**
     * 常用正则表达式：匹配浮点数
     */
    String regExp_float_5 = "^(-?\\d+)(\\.\\d+)?$";

    /**
     * 常用正则表达式：匹配由26个英文字母组成的字符串
     */
    String regExp_letter_1 = "^[A-Za-z]+$";

    /**
     * 常用正则表达式：匹配由26个英文字母的大写组成的字符串
     */
    String regExp_letter_2 = "^[A-Z]+$";

    /**
     * 常用正则表达式：匹配由26个英文字母的小写组成的字符串
     */
    String regExp_letter_3 = "^[a-z]+$";

    /**
     * 常用正则表达式：匹配由数字和26个英文字母组成的字符串
     */
    String regExp_letter_4 = "^[A-Za-z0-9]+$";

    /**
     * 常用正则表达式：匹配由数字、26个英文字母或者下划线组成的字符串
     */
    String regExp_letter_5 = "^\\w+$";

    /**
     * 常用正则表达式：匹配email地址
     */
    String regExp_email = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";

    /**
     * 常用正则表达式：匹配url
     */
    String regExp_url_1 = "^[a-zA-z]+://(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\S*)?$";

    /**
     * 常用正则表达式：匹配url
     */
    String regExp_url_2 = "[a-zA-z]+://[^\\s]*";

    /**
     * 常用正则表达式：匹配中文字符
     */
    String regExp_chinese_1 = "[\\u4e00-\\u9fa5]";

    /**
     * 常用正则表达式：匹配双字节字符(包括汉字在内)
     */
    String regExp_chinese_2 = "[^\\x00-\\xff]";

    /**
     * 常用正则表达式：匹配空行
     */
    String regExp_line = "\\n[\\s ? ]*\\r";

    /**
     * 常用正则表达式：匹配HTML标记
     */
    String regExp_html_1 = "/ <(.*)>.* <\\/\\1> ? <(.*) \\/>/";

    /**
     * 常用正则表达式：匹配首尾空格
     */
    String regExp_startEndEmpty = "(^\\s*) ?(\\s*$)";

    /**
     * 常用正则表达式：匹配帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)
     */
    String regExp_accountNumber = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";

    /**
     * 常用正则表达式：匹配国内电话号码，匹配形式如 0511-4405222 或 021-87888822
     */
    String regExp_telephone = "\\d{3}-\\d{8} ?\\d{4}-\\d{7}";

    /**
     * 常用正则表达式：腾讯QQ号, 腾讯QQ号从10000开始
     */
    String regExp_qq = "[1-9][0-9]{4,}";

    /**
     * 常用正则表达式：匹配中国邮政编码
     */
    String regExp_postbody = "[1-9]\\d{5}(?!\\d)";

    /**
     * 常用正则表达式：匹配身份证, 中国的身份证为15位或18位
     */
    String regExp_idCard = "\\d{15} ?\\d{18}";

    /**
     * 常用正则表达式：IP
     */
    String regExp_ip = "\\d+\\.\\d+\\.\\d+\\.\\d+";

    /**
     * 处理提到某人 @xxxx
     */
    Pattern referer_pattern = Pattern.compile("@([^@^\\s^:]{1,})([\\s\\:\\,\\;]{0,1})");
}
