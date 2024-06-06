package com.modules.system.dto.output;

import com.google.common.collect.Lists;
import com.modules.system.entity.User;
import lombok.Data;

import java.util.List;

/**
 *  <p> 用户树节点 </p>
 */
@Data
public class UserTreeNode extends User {

    List<UserTreeNode> children = Lists.newArrayList();

}
