DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`
(
    `id`          bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `user_id`     bigint unsigned NOT NULL DEFAULT '0' COMMENT '用户ID',
    `title`       varchar(120)    NOT NULL DEFAULT '' COMMENT '文章标题',
    `short_title` varchar(120)    NOT NULL DEFAULT '' COMMENT '短标题',
    `summary`     varchar(300)    NOT NULL DEFAULT '' COMMENT '文章摘要',
    `status`      int             NOT NULL DEFAULT '1' COMMENT '状态：0-未发布，1-已发布',
    `deleted`     int             NOT NULL DEFAULT '0' COMMENT '是否删除',
    `create_time` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`),
    KEY `idx_title` (`title`),
    KEY `idx_short_title` (`short_title`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 108
  DEFAULT CHARSET = utf8mb4 COMMENT ='文章表';

DROP TABLE IF EXISTS `article_detail`;
CREATE TABLE `article_detail`
(
    `id`          bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `article_id`  bigint unsigned NOT NULL DEFAULT '0' COMMENT '文章ID',
    `version`     int unsigned    NOT NULL DEFAULT '0' COMMENT '版本号',
    `content`     longtext COMMENT '文章内容',
    `deleted`     int             NOT NULL DEFAULT '0' COMMENT '是否删除',
    `create_time` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_article_version` (`article_id`, `version`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 12
  DEFAULT CHARSET = utf8mb4 COMMENT ='文章详情表';