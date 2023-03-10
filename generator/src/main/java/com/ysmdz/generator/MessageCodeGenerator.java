package com.ysmdz.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Arrays;

import static com.ysmdz.constant.Constant.*;
import static com.ysmdz.constant.Constant.DATA_SOURCE_PASSWORD;

/**
 * MyBatis-Plus 代码生成类
 */
public class MessageCodeGenerator {
	//生成的表
	private static final String[] TABLE_NAMES = new String[]{
			"mq_message",
			"mq_message_history"
//			 "course_base",
//			 "course_market",
//			 "teachplan",
//			 "teachplan_media",
//			 "course_teacher",
//			 "course_pub",
//			 "course_pub_pre"
//			"course_category"
	};

	// TODO 默认生成entity，需要生成DTO修改此变量
	// 一般情况下要先生成 DTO类 然后修改此参数再生成 PO 类。
	private static final Boolean IS_DTO = false;

	public static void main(String[] args) {
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();
		// 选择 freemarker 引擎，默认 Velocity
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setFileOverride(true);
		//生成路径 "/generator/src/main/java
		gc.setOutputDir(System.getProperty("user.dir"));
		gc.setAuthor("itcast");
		gc.setOpen(false);
		gc.setSwagger2(false);
		gc.setServiceName("%sService");
		gc.setBaseResultMap(true);
		gc.setBaseColumnList(true);

		if (IS_DTO) {
			gc.setSwagger2(true);
			gc.setEntityName("%sDTO");
		}
		mpg.setGlobalConfig(gc);

		// 数据库配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setUrl("jdbc:mysql://"+ DATA_SOURCE_URL.name+"/" + content.name
				+ "?serverTimezone=UTC&useUnicode=true&useSSL=false&characterEncoding=utf8");
//		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setDriverName("com.mysql.cj.jdbc.Driver");
		dsc.setUsername(DATA_SOURCE_USER_NAME.name);
		dsc.setPassword(DATA_SOURCE_PASSWORD.name);
		mpg.setDataSource(dsc);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setModuleName("content");
		pc.setParent("com.xuecheng");

		pc.setServiceImpl("service.impl");
		pc.setXml("mapper");
		pc.setEntity("model.po");
		mpg.setPackageInfo(pc);


		// 设置模板
		TemplateConfig tc = new TemplateConfig();
		mpg.setTemplate(tc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setEntityLombokModel(true);
		strategy.setRestControllerStyle(true);
		strategy.setInclude(TABLE_NAMES);
		strategy.setControllerMappingHyphenStyle(true);
		strategy.setTablePrefix(pc.getModuleName() + "_");
		// Boolean类型字段是否移除is前缀处理
		strategy.setEntityBooleanColumnRemoveIsPrefix(true);
		strategy.setRestControllerStyle(true);

		// 自动填充字段配置
		strategy.setTableFillList(Arrays.asList(
				new TableFill("create_date", FieldFill.INSERT),
				new TableFill("change_date", FieldFill.INSERT_UPDATE),
				new TableFill("modify_date", FieldFill.UPDATE)
		));
		mpg.setStrategy(strategy);

		mpg.execute();
	}

}
