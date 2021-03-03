package com.website.common.util.validator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.GenericValidator;
import org.springframework.web.servlet.support.RequestContext;

import com.website.common.util.spring.HttpSessionOrRequestUtils;

/**
 * <p>
 * 共通检查
 * </p>
 *
 * @author gration
 * @version 1.0.0
 */
public class ValidatorCheck {
  /**
   * 必须Key
   */
  private static final String REQUIRED = "required";
  /**
   * 最小长度Key
   */
  private static final String MINLENGTH = "minlength";
  /**
   * 最大长度Key
   */
  private static final String MAXLENGTH = "maxlength";
  /**
   * 邮件Key
   */
  private static final String MAIL = "mail";
  /**
   * 半角英文Key
   */
  private static final String CHAR = "char";
  /**
   * 半角英文Key
   */
  private static final String ALPHA = "alpha";
  /**
   * 半角英文数字Key
   */
  private static final String ALPHANUM = "alphanum";
  /**
   * 数字Key
   */
  private static final String NUM = "num";
  /**
   * 正整数数字Key
   */
  private static final String DIGIT = "digit";
  /**
   * 电话号码Key
   */
  private static final String PHONE = "phone";
  /**
   * 相同项目Key
   */
  private static final String EQUAL = "equal";
  /**
   * 区间Key
   */
  private static final String RANGE = "range";
  /**
   * 日期Key
   */
  private static final String DATE = "date";
  /**
   * Just长度Key
   */
  private static final String JUST = "just";
  /**
   * 邮政编码Key
   */
  private static final String ZIP = "zip";
  /**
   * 浮点型数值Key
   */
  private static final String DECIMAL = "decimal";
  /**
   * 数字长度Key
   */
  private static final String NUMLENGTH = "numlength";
  /**
   * 汉字Key
   */
  private static final String CHINESE = "chinese";
  /**
   * IdCard Key
   */
  private static final String IDCARD = "idcard";
  /**
   * URL
   */
  private static final String URL = "url";
  /**
   * PASSWORD
   */
  private static final String PASSWORD = "password";

  /**
   * 必须输入项目
   *
   * @param mav
   * @param itemname 项目名
   * @param value    项目值
   * @return true:正常 false:错误
   */
  public static boolean isRequired(Map<String, Object> mav, String itemname, String value) {
    if (StringUtils.isEmpty(value)) {
      ValidatorErrors.add(mav, itemname, REQUIRED, getErrorMessage(REQUIRED));
      return false;
    }
    return true;
  }

  /**
   * 检查最小文字数
   *
   * @param mav
   * @param itemname
   * @param value
   * @param minlength
   * @param required
   * @return
   */
  public static boolean minLength(Map<String, Object> mav, String itemname, String value, int minlength, boolean required) {
    // 检查必须
    boolean retValue = isRequired(mav, itemname, value);

    if (retValue) {
      if (value != null) {
        try {
          retValue = GenericValidator.minLength(value, minlength);
          if (!retValue) {
            ValidatorErrors.add(mav, itemname, MINLENGTH, getErrorMessage(MINLENGTH, minlength));
            retValue = false;
          }
        } catch (Exception e) {
          ValidatorErrors.add(mav, itemname, MINLENGTH, getErrorMessage(MINLENGTH, minlength));
          retValue = false;
        }
      }
    }
    return retValue;
  }

  /**
   * 检查最大文字数
   *
   * @param mav
   * @param itemname
   * @param value
   * @param maxlength
   * @param required
   * @return
   */
  public static boolean maxLength(Map<String, Object> mav, String itemname, String value, int maxlength, boolean required) {
    // 检查必须
    boolean retValue = isRequired(mav, itemname, value);

    if (retValue) {
      if (value != null && maxlength > 0) {
        try {
          retValue = GenericValidator.maxLength(value, maxlength);
          if (!retValue) {
            ValidatorErrors.add(mav, itemname, MAXLENGTH, getErrorMessage(MAXLENGTH, maxlength));
            retValue = false;
          }
        } catch (Exception e) {
          ValidatorErrors.add(mav, itemname, MAXLENGTH, getErrorMessage(MAXLENGTH, maxlength));
          retValue = false;
        }
      }
    }
    return retValue;
  }

  /**
   * 检查文字数
   *
   * @param mav
   * @param itemname
   * @param value
   * @param justlength
   * @param required
   * @return
   */
  public static boolean justLength(Map<String, Object> mav, String itemname, String value, int justlength, boolean required) {
    // 检查必须
    boolean retValue = isRequired(mav, itemname, value);

    if (retValue) {
      if (value != null && justlength > 0 && value.length() != justlength) {
        ValidatorErrors.add(mav, itemname, JUST, getErrorMessage(JUST, justlength));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 检查文字数（区间）
   *
   * @param mav
   * @param itemname
   * @param value
   * @param minlength
   * @param maxlength
   * @param required
   * @return
   */
  public static boolean isRange(Map<String, Object> mav, String itemname, String value, int minlength, int maxlength, boolean required) {
    return minLength(mav, itemname, value, minlength, required) && maxLength(mav, itemname, value, maxlength, required);
  }

  /**
   * 检查邮件地址格式
   *
   * @param mav
   * @param itemname
   * @param value
   * @param required
   * @return
   */
  public static boolean isMail(Map<String, Object> mav, String itemname, String value, boolean required) {
    // 检查必须
    boolean retValue = isRequired(mav, itemname, value);

    if (retValue && StringUtils.isNotEmpty(value)) {
      // 从配置文件中取得Patten
      String patten = "([a-zA-Z]|\\d|[!#\\$%&\'\\*\\+\\/=\\?\\^_{\\|}~`])((([a-zA-Z]|\\d|[!#\\$%&\'\\*\\+\\/=\\?\\^_\\-{\\|}~`])*(\\.([a-zA-Z]|\\d|[!#\\$%&\'\\*\\+\\/=\\?\\^_{\\|}~`\\-])+)*))@((([a-zA-Z]|\\d)|(([a-zA-Z]|\\d)([a-zA-Z]|\\d|\\-)*([a-zA-Z]|\\d)))\\.)+(([a-zA-Z]|\\d)|(([a-zA-Z]|\\d)([a-zA-Z]|\\d|\\-)*([a-zA-Z]|\\d)))";
      Pattern _emailAddressPattern = Pattern.compile(patten);
      Matcher matcher = _emailAddressPattern.matcher(value);

      if (!matcher.matches()) {
        ValidatorErrors.add(mav, itemname, MAIL, getErrorMessage(MAIL));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 检查邮件地址格式和最大长度
   *
   * @param mav
   * @param itemname
   * @param value
   * @param maxlength
   * @param required
   * @return
   */
  public static boolean isMail(Map<String, Object> mav, String itemname, String value, int maxlength, boolean required) {
    boolean retValue = maxLength(mav, itemname, value, maxlength, required);

    if (retValue && StringUtils.isNotEmpty(value)) {
      retValue = isMail(mav, itemname, value, required);
    }
    return retValue;
  }

  /**
   * 检查是否字符
   *
   * @param mav
   * @param itemname
   * @param value
   * @param required
   * @return
   */
  public static boolean isChar(Map<String, Object> mav, String itemname, String value, boolean required) {
    boolean retValue = isRequired(mav, itemname, value);

    if (retValue && StringUtils.isNotEmpty(value)) {
      if (!Validator.isChar(value)) {
        ValidatorErrors.add(mav, itemname, CHAR, getErrorMessage(CHAR));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 检查是否字符
   *
   * @param mav
   * @param itemname
   * @param value
   * @param maxlength
   * @param required
   * @return
   */
  public static boolean isChar(Map<String, Object> mav, String itemname, String value, int maxlength, boolean required) {
    boolean retValue = maxLength(mav, itemname, value, maxlength, required);

    if (retValue && StringUtils.isNotEmpty(value)) {
      retValue = isChar(mav, itemname, value, required);
    }
    return retValue;
  }

  /**
   * 检查是否数字
   *
   * @param mav
   * @param itemname
   * @param value
   * @param required
   * @return
   */
  public static boolean isNumber(Map<String, Object> mav, String itemname, String value, boolean required) {
    boolean retValue = isRequired(mav, itemname, value);

    if (retValue && StringUtils.isNotEmpty(value)) {
      if (!Validator.isNumber(value)) {
        ValidatorErrors.add(mav, itemname, NUM, getErrorMessage(NUM));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 检查是否数字
   *
   * @param mav
   * @param itemname
   * @param value
   * @param maxlength
   * @param required
   * @return
   */
  public static boolean isNumber(Map<String, Object> mav, String itemname, String value, int maxlength, boolean required) {
    boolean retValue = maxLength(mav, itemname, value, maxlength, required);

    if (retValue && StringUtils.isNotEmpty(value)) {
      retValue = isNumber(mav, itemname, value, required);
    }
    return retValue;
  }

  /**
   * 检查是否数字
   *
   * @param mav
   * @param itemname
   * @param value
   * @param justlength
   * @param required
   * @return
   */
  public static boolean isJustNumber(Map<String, Object> mav, String itemname, String value, int justlength, boolean required) {
    boolean retValue = justLength(mav, itemname, value, justlength, required);

    if (retValue && StringUtils.isNotEmpty(value)) {
      if (!Validator.isNumber(value)) {
        ValidatorErrors.add(mav, itemname, NUM, getErrorMessage(NUM));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 检查是否半角英文
   *
   * @param mav
   * @param itemname
   * @param value
   * @param required
   * @return
   */
  public static boolean isAlpha(Map<String, Object> mav, String itemname, String value, boolean required) {
    boolean retValue = isRequired(mav, itemname, value);

    if (retValue && StringUtils.isNotEmpty(value)) {
      if (!Validator.isAlpha(value)) {
        ValidatorErrors.add(mav, itemname, ALPHA, getErrorMessage(ALPHA));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 检查是否半角英文
   *
   * @param mav
   * @param itemname
   * @param value
   * @param maxlength
   * @param required
   * @return
   */
  public static boolean isAlpha(Map<String, Object> mav, String itemname, String value, int maxlength, boolean required) {
    boolean retValue = maxLength(mav, itemname, value, maxlength, required);

    if (retValue && StringUtils.isNotEmpty(value)) {
      if (!Validator.isAlpha(value)) {
        ValidatorErrors.add(mav, itemname, ALPHA, getErrorMessage(ALPHA));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 检查是否半角英文数字
   *
   * @param mav
   * @param itemname
   * @param value
   * @param required
   * @return
   */
  public static boolean isAlphaNumberic(Map<String, Object> mav, String itemname, String value, boolean required) {
    boolean retValue = isRequired(mav, itemname, value);

    if (retValue && StringUtils.isNotEmpty(value)) {
      if (!Validator.isAlphaNumeric(value)) {
        ValidatorErrors.add(mav, itemname, ALPHANUM, getErrorMessage(ALPHANUM));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 检查是否半角英文数字
   *
   * @param mav
   * @param itemname
   * @param value
   * @param maxlength
   * @param required
   * @return
   */
  public static boolean isAlphaNumberic(Map<String, Object> mav, String itemname, String value, int maxlength, boolean required) {
    boolean retValue = maxLength(mav, itemname, value, maxlength, required);

    if (retValue && StringUtils.isNotEmpty(value)) {
      if (!Validator.isAlphaNumeric(value)) {
        ValidatorErrors.add(mav, itemname, ALPHANUM, getErrorMessage(ALPHANUM));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 检查是否半角英文数字
   *
   * @param mav
   * @param itemname
   * @param value
   * @param maxlength
   * @param maxlength
   * @param required
   * @return
   */
  public static boolean isAlphaNumeric(Map<String, Object> mav, String itemname, String value, int minlength, int maxlength, boolean required) {
    boolean retValue = isRequired(mav, itemname, value);

    if (retValue && StringUtils.isNotEmpty(value)) {
      retValue = isRange(mav, itemname, value, minlength, maxlength, required);
    }

    if (retValue && StringUtils.isNotEmpty(value)) {
      retValue = isAlphaNumberic(mav, itemname, value, required);
    }
    return retValue;
  }

  /**
   * 检查是否汉字
   *
   * @param mav
   * @param itemname
   * @param value
   * @param required
   * @return
   */
  public static boolean isChinese(Map<String, Object> mav, String itemname, String value, boolean required) {
    boolean retValue = isRequired(mav, itemname, value);

    if (retValue && StringUtils.isNotEmpty(value)) {
      String reg = "^[\u4E00-\u9FA5\uf900-\ufa2d]+$";
      if (StringUtils.isNotEmpty(value) && !value.matches(reg)) {
        ValidatorErrors.add(mav, itemname, CHINESE, getErrorMessage(CHINESE));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 检查是否汉字
   *
   * @param mav
   * @param itemname
   * @param value
   * @param maxlength
   * @param required
   * @return
   */
  public static boolean isChinese(Map<String, Object> mav, String itemname, String value, int maxlength, boolean required) {
    boolean retValue = maxLength(mav, itemname, value, maxlength, required);

    if (retValue && StringUtils.isNotEmpty(value)) {
      String reg = "^[\u4E00-\u9FA5\uf900-\ufa2d]+$";
      if (StringUtils.isNotEmpty(value) && !value.matches(reg)) {
        ValidatorErrors.add(mav, itemname, CHINESE, getErrorMessage(CHINESE));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 检查是否电话号码
   *
   * @param mav
   * @param itemname
   * @param value
   * @param required
   * @return
   */
  public static boolean isPhoneNum(Map<String, Object> mav, String itemname, String value, int maxlength, boolean required) {
    boolean retValue = maxLength(mav, itemname, value, maxlength, required);

    if (retValue && StringUtils.isNotEmpty(value)) {
      String reg = "^[0-9\\-]*$";
      if (StringUtils.isNotEmpty(value) && !value.matches(reg)) {
        ValidatorErrors.add(mav, itemname, PHONE, getErrorMessage(PHONE));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 检查两个值是否相同
   *
   * @param mav
   * @param valueBefore
   * @param valueAfter
   * @return
   */
  public static boolean equal(Map<String, Object> mav, String itemname, String valueBefore, String valueAfter, Object... params) {
    boolean retValue = true;
    if (!valueBefore.equals(valueAfter)) {
      ValidatorErrors.add(mav, itemname, EQUAL, getErrorMessage(EQUAL, params));
      retValue = false;
    }
    return retValue;
  }

  /**
   * 检查日期格式(yyyy-MM-dd)
   *
   * @param mav
   * @param itemname
   * @param value
   * @param required
   * @return
   */
  public static boolean isDate(Map<String, Object> mav, String itemname, String value, boolean required) {
    boolean retValue = isRequired(mav, itemname, value);

    if (retValue && StringUtils.isNotEmpty(value)) {
      try {
        if (value.length() != 10) {
          ValidatorErrors.add(mav, itemname, DATE, getErrorMessage(DATE));
          retValue = false;
        } else {
          SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
          fm.setLenient(false);
          fm.parse(value);
        }
      } catch (Exception e) {
        ValidatorErrors.add(mav, itemname, DATE, getErrorMessage(DATE));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 检查日期格式(yyyy/mm/dd hh24:mi)
   *
   * @param mav
   * @param itemname
   * @param value
   * @param type     <p>
   *                 1: <span>yyyyMMdd</span>
   *                 </p>
   *                 <p>
   *                 2: <span>yyyyMMddHH</span>
   *                 </p>
   *                 <p>
   *                 3: <span>yyyyMMddHHmm</span>
   *                 </p>
   *                 <p>
   *                 4: <span>yyyyMMddHHmmss</span>
   *                 </p>
   *                 <p>
   *                 5: <span>yyyyMMddHHmmsssss</span>
   *                 </p>
   *                 <p>
   *                 6: <span>yyyy-MM-dd</span>
   *                 </p>
   *                 <p>
   *                 7: <span>yyyy-MM-dd HH</span>
   *                 </p>
   *                 <p>
   *                 8: <span>yyyy-MM-dd HH:mm</span>
   *                 </p>
   *                 <p>
   *                 9: <span>yyyy-MM-dd HH:mm:ss</span>
   *                 </p>
   *                 <p>
   *                 10: <span>yyyy-MM-dd HH:mm:ss.sss</span>
   *                 </p>
   *                 <p>
   *                 11: <span>yyyy/MM/dd</span>
   *                 </p>
   *                 <p>
   *                 12: <span>yyyy/MM/dd HH</span>
   *                 </p>
   *                 <p>
   *                 13: <span>yyyy/MM/dd HH:mm</span>
   *                 </p>
   *                 <p>
   *                 14: <span>yyyy/MM/dd HH:mm:ss</span>
   *                 </p>
   *                 <p>
   *                 15: <span>yyyy/MM/dd HH:mm:ss.sss</span>
   *                 </p>
   *                 <p>
   *                 16: <span>yyyy/M/d</span>
   *                 </p>
   *                 <p>
   *                 17: <span>yyyy/M/d H</span>
   *                 </p>
   *                 <p>
   *                 18: <span>yyyy/M/d H:m</span>
   *                 </p>
   *                 <p>
   *                 19: <span>yyyy/M/d H:m:s</span>
   *                 </p>
   *                 <p>
   *                 20: <span>yyyy-M-d H:m:s.sss</span>
   *                 </p>
   *                 <p>
   *                 21: <span>yyyyMM</span>
   *                 </p>
   *                 <p>
   *                 22: <span>yyyy/MM</span>
   *                 </p>
   *                 <p>
   *                 23: <span>yyyy-MM</span>
   *                 </p>
   * @param required
   * @return
   */
  public static boolean isDate(Map<String, Object> mav, String itemname, String value, int type, boolean required) {
    boolean retValue = true;
    if (required) {
      retValue = isRequired(mav, itemname, value);
    }

    if (retValue && StringUtils.isNotEmpty(value)) {
      try {
        String formatPatten = "";
        switch (type) {
          case 1:
            formatPatten = "yyyyMMdd";
            break;
          case 2:
            formatPatten = "yyyyMMddHH";
            break;
          case 3:
            formatPatten = "yyyyMMddHHmm";
            break;
          case 4:
            formatPatten = "yyyyMMddHHmmss";
            break;
          case 5:
            formatPatten = "yyyyMMddHHmmsssss";
            break;
          case 6:
            formatPatten = "yyyy-MM-dd";
            break;
          case 7:
            formatPatten = "yyyy-MM-dd HH";
            break;
          case 8:
            formatPatten = "yyyy-MM-dd HH:mm";
            break;
          case 9:
            formatPatten = "yyyy-MM-dd HH:mm:ss";
            break;
          case 10:
            formatPatten = "yyyy-MM-dd HH:mm:ss.sss";
            break;
          case 11:
            formatPatten = "yyyy/MM/dd";
            break;
          case 12:
            formatPatten = "yyyy/MM/dd HH";
            break;
          case 13:
            formatPatten = "yyyy/MM/dd HH:mm";
            break;
          case 14:
            formatPatten = "yyyy/MM/dd HH:mm:ss";
            break;
          case 15:
            formatPatten = "yyyy/MM/dd HH:mm:ss.sss";
          case 16:
            formatPatten = "yyyy/M/d";
            break;
          case 17:
            formatPatten = "yyyy/M/d H";
            break;
          case 18:
            formatPatten = "yyyy/M/d H:m";
            break;
          case 19:
            formatPatten = "yyyy/M/d H:m:s";
            break;
          case 20:
            formatPatten = "yyyy/M/d H:m:s.sss";
            break;
          case 21:
            formatPatten = "yyyyMMdd";
            value = value + "01";
            break;
          case 22:
            formatPatten = "yyyy/MM/dd";
            value = value + "01";
            break;
          case 23:
            formatPatten = "yyyy-MM-dd";
            value = value + "01";
            break;
          default:
            formatPatten = "yyyy/MM/dd";
            break;
        }

        SimpleDateFormat fm = new SimpleDateFormat(formatPatten);
        fm.setLenient(false);
        fm.parse(value);
      } catch (Exception e) {
        ValidatorErrors.add(mav, itemname, DATE, getErrorMessage(DATE));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 检查邮政编码
   *
   * @param mav
   * @param itemname
   * @param value
   * @param required
   * @return
   */
  public static boolean isZip(Map<String, Object> mav, String itemname, String value, boolean required) {
    boolean retValue = isRequired(mav, itemname, value);

    if (retValue && StringUtils.isNotEmpty(value)) {
      String reg = "\\d{6}";
      if (!value.matches(reg)) {
        ValidatorErrors.add(mav, itemname, ZIP, getErrorMessage(ZIP));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 检查半角数字最大长度（无小数点）正整数
   *
   * @param mav
   * @param itemname
   * @param value
   * @param required
   * @return
   */
  public static boolean isDegit(Map<String, Object> mav, String itemname, String value, int maxLength, boolean required) {
    boolean retValue = maxLength(mav, itemname, value, maxLength, required);

    if (retValue && StringUtils.isNotEmpty(value)) {
      if (!Validator.isDigit(value)) {
        ValidatorErrors.add(mav, itemname, DIGIT, getErrorMessage(DIGIT, maxLength));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 检查半角数字最大长度（有小数点）
   *
   * @param mav
   * @param itemname
   * @param value
   * @param required
   * @return
   */
  public static boolean isDecimal(Map<String, Object> mav, String itemname, String value, int maxLength, boolean required) {
    boolean retValue = true;
    if (required) {
      retValue = isRequired(mav, itemname, value);
    }

    if (retValue && StringUtils.isNotEmpty(value)) {
      if (!GenericValidator.isDouble(value)) {
        ValidatorErrors.add(mav, itemname, DECIMAL, getErrorMessage(DECIMAL));
        retValue = false;
      }
    }

    if (retValue && StringUtils.isNotEmpty(value)) {
      if (value.replaceFirst(".", "").length() > maxLength) {
        ValidatorErrors.add(mav, itemname, MAXLENGTH, getErrorMessage(MAXLENGTH, maxLength));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 密码验证
   *
   * @param mav
   * @param itemname
   * @param value
   * @return
   */
  public static boolean checkPassword(Map<String, Object> mav, String itemname, String value) {
    boolean retValue = true;
    retValue = isRequired(mav, itemname, value);

    String reg = "^[0-9a-zA-Z]{6,16}$";
    if (retValue && !value.matches(reg)) {
      ValidatorErrors.add(mav, itemname, PASSWORD, getErrorMessage(PASSWORD));
      retValue = false;
    }

    return retValue;
  }

  /**
   * 检查半角数字最大长度（有小数点，整数部和小数部分开）
   *
   * @param mav
   * @param itemname
   * @param value
   * @param integerMaxLength
   * @param decimalsMaxLength
   * @param required
   * @return
   */
  public static boolean isDecimal(Map<String, Object> mav, String itemname, String value, int integerMaxLength, int decimalsMaxLength, boolean required) {
    boolean retValue = true;
    if (required) {
      retValue = isRequired(mav, itemname, value);
    }

    if (retValue && StringUtils.isNotEmpty(value)) {
      if (!GenericValidator.isDouble(value)) {
        ValidatorErrors.add(mav, itemname, NUMLENGTH, getErrorMessage(NUMLENGTH, integerMaxLength, decimalsMaxLength));
        retValue = false;
      }
    }

    if (retValue && StringUtils.isNotEmpty(value)) {
      String[] data = value.split("\\.");
      if (data[0].length() > integerMaxLength || data[0].length() == 0) {
        ValidatorErrors.add(mav, itemname, NUMLENGTH, getErrorMessage(NUMLENGTH, integerMaxLength, decimalsMaxLength));
        retValue = false;
      }
      if (retValue && data.length > 1) {
        if (data[1].length() > decimalsMaxLength || data[1].length() == 0) {
          ValidatorErrors.add(mav, itemname, NUMLENGTH, getErrorMessage(NUMLENGTH, integerMaxLength, decimalsMaxLength));
          retValue = false;
        }
      }
    }
    return retValue;
  }

  /**
   * 检查是否身份证号
   *
   * @param mav
   * @param itemname
   * @param value
   * @param maxlength
   * @param required
   * @return
   */
  public static boolean isIdCard(Map<String, Object> mav, String itemname, String value, int minlength, int maxlength, boolean required) {

    boolean retValue = true;
    // 判断是否为空
    if (required) {
      retValue = isRequired(mav, itemname, value);
    }
    // 判断idcard范围
    if (retValue && StringUtils.isNotEmpty(value)) {
      try {
        retValue = GenericValidator.isInRange(value.length(), minlength, maxlength);
        if (!retValue) {
          ValidatorErrors.add(mav, itemname, RANGE, getErrorMessage(RANGE, minlength, maxlength));
          retValue = false;
        }
      } catch (Exception e) {
      }
    }
    // 判断是否只是数字和字母
    if (retValue && StringUtils.isNotEmpty(value)) {
      if (!Validator.isAlphaNumeric(value)) {
        ValidatorErrors.add(mav, itemname, ALPHANUM, getErrorMessage(ALPHANUM));
        retValue = false;
      }
    }
    // 判断是否身份证
    if (retValue && StringUtils.isNotEmpty(value)) {
      if (!isIDCard(value)) {
        ValidatorErrors.add(mav, itemname, IDCARD, getErrorMessage(IDCARD));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 身份证验证的工具（支持18位省份证） 身份证号码结构： 17位数字和1位校验码：6位地址码数字，8位生日数字，3位出生时间顺序号，1位校验码。 地址码（前6位）：表示对象常住户口所在县（市、镇、区）的行政区划代码，按GB/T2260的规定执行。 出生日期码，（第七位 至十四位）：表示编码对象出生年、月、日，按GB按GB/T7408的规定执行，年、月、日代码之间不用分隔符。 顺序码（第十五位至十七位）：表示在同一地址码所标示的区域范围内，对同年、同月、同日出生的人编订的顺序号，
   * 顺序码的奇数分配给男性，偶数分配给女性。 校验码（第十八位数）： 十七位数字本体码加权求和公式 s = sum(Ai*Wi), i = 0,,16，先对前17位数字的权求和； Ai:表示第i位置上的身份证号码数字值.Wi:表示第i位置上的加权因.Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2； 计算模 Y = mod(S, 11) 通过模得到对应的校验码 Y: 0 1 2 3 4 5 6 7 8 9 10 校验码: 1 0 X 9 8 7 6 5 4
   * 3 2
   */

  /**
   * 身份证验证
   *
   * @param certNo 号码内容
   * @return 是否有效 null和"" 都是false
   */
  public static boolean isIDCard(String certNo) {
    Map<Integer, String> zoneNum = new HashMap<Integer, String>();
    zoneNum.put(11, "北京");
    zoneNum.put(12, "天津");
    zoneNum.put(13, "河北");
    zoneNum.put(14, "山西");
    zoneNum.put(15, "内蒙古");
    zoneNum.put(21, "辽宁");
    zoneNum.put(22, "吉林");
    zoneNum.put(23, "黑龙江");
    zoneNum.put(31, "上海");
    zoneNum.put(32, "江苏");
    zoneNum.put(33, "浙江");
    zoneNum.put(34, "安徽");
    zoneNum.put(35, "福建");
    zoneNum.put(36, "江西");
    zoneNum.put(37, "山东");
    zoneNum.put(41, "河南");
    zoneNum.put(42, "湖北");
    zoneNum.put(43, "湖南");
    zoneNum.put(44, "广东");
    zoneNum.put(45, "广西");
    zoneNum.put(46, "海南");
    zoneNum.put(50, "重庆");
    zoneNum.put(51, "四川");
    zoneNum.put(52, "贵州");
    zoneNum.put(53, "云南");
    zoneNum.put(54, "西藏");
    zoneNum.put(61, "陕西");
    zoneNum.put(62, "甘肃");
    zoneNum.put(63, "青海");
    zoneNum.put(64, "新疆");
    zoneNum.put(71, "台湾");
    zoneNum.put(81, "香港");
    zoneNum.put(82, "澳门");
    zoneNum.put(91, "外国");
    char[] PARITYBIT = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
    int[] POWER_LIST = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    if (certNo == null || certNo.length() != 18)
      return false;
    final char[] cs = certNo.toUpperCase().toCharArray();
    // 校验位数
    int power = 0;
    for (int i = 0; i < cs.length; i++) {
      if (i == cs.length - 1 && cs[i] == 'X')
        break;// 最后一位可以 是X或x
      if (cs[i] < '0' || cs[i] > '9')
        return false;
      if (i < cs.length - 1) {
        power += (cs[i] - '0') * POWER_LIST[i];
      }
    }

    // 校验区位码
    if (!zoneNum.containsKey(Integer.valueOf(certNo.substring(0, 2)))) {
      return false;
    }

    // 校验年份
    String year = certNo.substring(6, 10);

    final int iyear = Integer.parseInt(year);
    if (iyear < 1800 || iyear > Calendar.getInstance().get(Calendar.YEAR))
      return false;// 1900年的PASS，超过今年的PASS

    // 校验月份
    String month = certNo.length() == 15 ? certNo.substring(8, 10) : certNo.substring(10, 12);
    final int imonth = Integer.parseInt(month);
    if (imonth < 1 || imonth > 12) {
      return false;
    }

    // 校验天数
    String day = certNo.length() == 15 ? certNo.substring(10, 12) : certNo.substring(12, 14);
    final int iday = Integer.parseInt(day);
    if (iday < 1 || iday > 31)
      return false;

    // 校验"校验码"
    if (certNo.length() == 15)
      return true;
    return cs[cs.length - 1] == PARITYBIT[power % 11];
  }

  /**
   * 取得错误信息
   *
   * @param errKey
   * @param param
   * @return
   */
  public static String getErrorMessage(String errKey, Object... params) {
    HttpServletRequest request = HttpSessionOrRequestUtils.getRequest();

    RequestContext requestContext = new RequestContext(request);
    String prefix = requestContext.getMessage("message.error.prefix");
    String message = requestContext.getMessage(prefix + errKey);

    if (Validator.isNotNull(message)) {
      if (message.contains("{0}")) {
        if (Validator.isNotNull(params)) {
          int i = 0;
          for (Object p : params) {
            message = message.replace("{" + i + "}", p == null ? "" : String.valueOf(p));
            i++;
          }
        }
      }
    }

    return message;
  }

  /**
   * 检查是否正确的URL
   *
   * @param mav
   * @param itemname
   * @param value
   * @param required
   * @return
   */
  public static boolean isUrl(Map<String, Object> mav, String itemname, String value, boolean required) {
    boolean retValue = isRequired(mav, itemname, value);

    if (retValue && StringUtils.isNotEmpty(value)) {
      if (!Validator.isUrl(value)) {
        ValidatorErrors.add(mav, itemname, URL, getErrorMessage(URL));
        retValue = false;
      }
    }
    return retValue;
  }

  /**
   * 自定义错误
   *
   * @param mav
   * @param itemname
   * @param errorId
   */
  public static void customError(Map<String, Object> mav, String itemname, String errorId) {
    customError(mav, itemname, errorId, "");
  }

  /**
   * 自定义错误
   *
   * @param mav
   * @param itemname
   * @param errorId
   */
  public static void customError(Map<String, Object> mav, String itemname, String errorId, String message) {
    if (Validator.isNull(message)) {
      message = getErrorMessage(errorId);
    }
    ValidatorErrors.add(mav, itemname, errorId, message);
  }

  /**
   * 判断是否有错误
   *
   * @param mav
   * @return
   */
  public static boolean hasValidateError(Map<String, Object> mav) {
    return !ValidatorErrors.isEmpty(mav);
  }

}
