package org.jhonrain.common.validator;

import org.jhonrain.common.exception.RainbowException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;


/**
 * <p>功能描述</br>hibernate-validator校验工具类</br>
 * 参考文档：http://docs.jboss.org/hibernate/validator/5.4/reference/en-US/html_single/
 * </p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 14:47
 */
public class ValidatorUtils {

  private static Validator validator;

  static {
    validator = Validation.buildDefaultValidatorFactory().getValidator();
  }

  /**
   * 校验对象
   *
   * @param object 待校验对象
   * @param groups 待校验的组
   * @throws RainbowException 校验不通过，则报RRException异常
   */
  public static void validateEntity(Object object, Class<?>... groups)
          throws RainbowException {
    Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
    if (!constraintViolations.isEmpty()) {
      ConstraintViolation<Object> constraint = (ConstraintViolation<Object>) constraintViolations.iterator().next();
      throw new RainbowException(constraint.getMessage());
    }
  }
}
