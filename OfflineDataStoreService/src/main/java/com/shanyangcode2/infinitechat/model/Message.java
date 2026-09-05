package com.shanyangcode2.infinitechat.model;



import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @TableName message
 */
@TableName(value ="message")    //指定当前实体类映射的数据库表名。
@Data
public class Message implements Serializable {

    /**
     * 消息id
     */
    private Long messageId;

    /**
     * 回复消息的 id
     */
    private Long replyId;
    /**
     * 发送者id
     */
    private Long senderId;

    /**
     * 会话id
     */
    private Long sessionId;

    /**
     * 消息类型
     */
    private Integer type;

    /**
     * 消息内容
     */
    private String content;


    /**
     * 会话类型
     */
    private Integer sessionType;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 修改时间
     */
    private Date updatedAt;

    @TableField(exist = false)
    private RedPacket redPacket;

    @TableField(exist = false)  //exist = false：该字段在数据库表中不存在
    private User user;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}