
package com.sso.dao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户部门关系实体类
 *
 * @author 聂建强1
 */
@Data
public class SsoUserDept implements Serializable {

    private static final long serialVersionUID = -8391256763118936557L;

    /**
     * 系统编码
     */
    private String sysCode;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;


}
