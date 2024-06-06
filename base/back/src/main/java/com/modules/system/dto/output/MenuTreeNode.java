package com.modules.system.dto.output;

import com.google.common.collect.Lists;
import com.modules.system.entity.Menu;
import lombok.Data;

import java.util.List;

/**
 *  <p> 菜单树节点 </p>
 */
@Data
public class MenuTreeNode extends Menu {

    List<MenuTreeNode> children = Lists.newArrayList();

}
