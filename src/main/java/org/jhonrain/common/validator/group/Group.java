package org.jhonrain.common.validator.group;

import javax.validation.GroupSequence;

/**
 * <p>功能描述</br>定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 15:01
 */
@GroupSequence({AddGroup.class, UpdateGroup.class})
public interface Group {

}
