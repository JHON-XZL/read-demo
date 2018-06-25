-- 菜单
CREATE TABLE `t_sys_menu` (
  `menu_id` BIGINT NOT NULL AUTO_INCREMENT,
  `parent_id` BIGINT COMMENT '父菜单ID，一级菜单为0',
  `name` VARCHAR(50) COMMENT '菜单名称',
  `url` VARCHAR(200) COMMENT '菜单URL',
  `perms` VARCHAR(500) COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` INT COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` VARCHAR(50) COMMENT '菜单图标',
  `order_num` INT COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- 系统用户
CREATE TABLE `t_sys_user` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) COMMENT '密码',
  `salt` VARCHAR(20) COMMENT '盐',
  `email` VARCHAR(100) COMMENT '邮箱',
  `mobile` VARCHAR(100) COMMENT '手机号',
  `status` TINYINT COMMENT '状态  0：禁用   1：正常',
  `create_user_id` BIGINT(20) COMMENT '创建者ID',
  `create_time` DATETIME COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX (`username`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- 系统用户Token
CREATE TABLE `t_sys_user_token` (
  `user_id` BIGINT(20) NOT NULL,
  `token` VARCHAR(100) NOT NULL COMMENT 'token',
  `expire_time` DATETIME DEFAULT NULL COMMENT '过期时间',
  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户Token';

-- 角色
CREATE TABLE `t_sys_role` (
  `role_id` BIGINT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(100) COMMENT '角色名称',
  `remark` VARCHAR(100) COMMENT '备注',
  `create_user_id` BIGINT(20) COMMENT '创建者ID',
  `create_time` DATETIME COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='角色';

-- 用户与角色对应关系
CREATE TABLE `t_sys_user_role` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT COMMENT '用户ID',
  `role_id` BIGINT COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- 角色与菜单对应关系
CREATE TABLE `t_sys_role_menu` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `role_id` BIGINT COMMENT '角色ID',
  `menu_id` BIGINT COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- 系统配置信息
CREATE TABLE `t_sys_config` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `key` VARCHAR(50) COMMENT 'key',
  `value` VARCHAR(2000) COMMENT 'value',
  `status` TINYINT DEFAULT 1 COMMENT '状态   0：隐藏   1：显示',
  `remark` VARCHAR(500) COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE INDEX (`key`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COMMENT='系统配置信息表';

-- 系统日志
CREATE TABLE `t_sys_log` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) COMMENT '用户名',
  `operation` VARCHAR(50) COMMENT '用户操作',
  `method` VARCHAR(200) COMMENT '请求方法',
  `params` VARCHAR(5000) COMMENT '请求参数',
  `ip` VARCHAR(64) COMMENT 'IP地址',
  `create_date` DATETIME COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COMMENT='系统日志';

-- 初始数据
INSERT INTO `t_sys_user` (`user_id`, `username`, `password`, `salt`, `email`, `mobile`, `status`, `create_user_id`, `create_time`) VALUES ('1', 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', 'root@renren.io', '13612345678', '1', '1', '2016-11-11 11:11:11');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('1', '0', '系统管理', NULL, NULL, '0', 'fa fa-cog', '0');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('2', '1', '管理员列表', 'modules/sys/user.html', NULL, '1', 'fa fa-user', '1');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('3', '1', '角色管理', 'modules/sys/role.html', NULL, '1', 'fa fa-user-secret', '2');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('4', '1', '菜单管理', 'modules/sys/menu.html', NULL, '1', 'fa fa-th-list', '3');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('5', '1', 'SQL监控', 'druid/sql.html', NULL, '1', 'fa fa-bug', '4');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('15', '2', '查看', NULL, 'sys:user:list,sys:user:info', '2', NULL, '0');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('16', '2', '新增', NULL, 'sys:user:save,sys:role:select', '2', NULL, '0');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('17', '2', '修改', NULL, 'sys:user:update,sys:role:select', '2', NULL, '0');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('18', '2', '删除', NULL, 'sys:user:delete', '2', NULL, '0');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('19', '3', '查看', NULL, 'sys:role:list,sys:role:info', '2', NULL, '0');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('20', '3', '新增', NULL, 'sys:role:save,sys:menu:perms', '2', NULL, '0');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('21', '3', '修改', NULL, 'sys:role:update,sys:menu:perms', '2', NULL, '0');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('22', '3', '删除', NULL, 'sys:role:delete', '2', NULL, '0');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('23', '4', '查看', NULL, 'sys:menu:list,sys:menu:info', '2', NULL, '0');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('24', '4', '新增', NULL, 'sys:menu:save,sys:menu:select', '2', NULL, '0');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('25', '4', '修改', NULL, 'sys:menu:update,sys:menu:select', '2', NULL, '0');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('26', '4', '删除', NULL, 'sys:menu:delete', '2', NULL, '0');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('27', '1', '参数管理', 'modules/sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-sun-o', '6');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('29', '1', '系统日志', 'modules/sys/log.html', 'sys:log:list', '1', 'fa fa-file-text-o', '7');



-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- 云存储服务相关SQL，如果不使用该功能，则不用执行下面SQL -------------------------------------------------------------------------------------------------------------
-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 文件上传
CREATE TABLE `t_sys_oss` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(200) COMMENT 'URL地址',
  `create_date` DATETIME COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COMMENT='文件上传';

INSERT INTO `t_sys_config` (`key`, `value`, `status`, `remark`) VALUES ('CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', '0', '云存储配置信息');
INSERT INTO `t_sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES ('30', '1', '文件上传', 'modules/oss/oss.html', 'sys:oss:all', '1', 'fa fa-file-image-o', '6');
