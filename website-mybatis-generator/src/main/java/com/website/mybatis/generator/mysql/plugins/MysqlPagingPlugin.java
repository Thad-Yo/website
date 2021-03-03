package com.website.mybatis.generator.mysql.plugins;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MysqlPagingPlugin extends PluginAdapter {

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        addFeild(topLevelClass, introspectedTable, "limitStart");
        addFeild(topLevelClass, introspectedTable, "limitEnd");

        FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getCriteriaInstance();
        List<InnerClass> listInnerClass = topLevelClass.getInnerClasses();
        if (listInnerClass != null && listInnerClass.size() > 0) {
            for (InnerClass innerClass : listInnerClass) {

                List<Method> methods = innerClass.getMethods();
                for (int i = 0; i < methods.size(); i++) {
                    Method method = methods.get(i);
                    String methodName = method.getName();
                    if (methodName.contains("_back")) {
                        continue;
                    }

                    List<Parameter> parameters = method.getParameters();

                    boolean isTinyInt = false;
                    List<Parameter> tempParameters = new ArrayList<Parameter>();
                    if (parameters != null && parameters.size() > 0) {
                        for (Parameter p : parameters) {
                            String type = p.getType().toString();
                            if (type.equals("java.lang.Boolean") || type.equals("java.lang.Byte")) {
                                isTinyInt = true;

                                tempParameters.add(new Parameter(FullyQualifiedJavaType.getIntInstance(), p.getName()));
                            } else {
                                tempParameters.add(p);
                            }
                        }
                    }

                    if (isTinyInt) {
                        Method m = new Method();
                        m.setVisibility(method.getVisibility());
                        m.setReturnType(method.getReturnType());
                        m.setName(method.getName());
                        m.addBodyLines(method.getBodyLines());

                        if (tempParameters != null && tempParameters.size() > 0) {
                            for (Parameter p : tempParameters) {
                                m.addParameter(p);
                            }
                        }
                        innerClass.addMethod(m);

                        method.setName(methodName + "_back");
                        method.setVisibility(JavaVisibility.PRIVATE);
                    }
                }
            }
        }

        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
                                                                     IntrospectedTable introspectedTable) {
        XmlElement pagingElement = new XmlElement("if");
        pagingElement.addAttribute(new Attribute("test", "limitStart >= 0"));
        pagingElement.addElement(new TextElement("limit #{limitStart} , #{limitEnd}"));
        element.addElement(element.getElements().size(), pagingElement);

        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement pagingElement = new XmlElement("if");
        pagingElement.addAttribute(new Attribute("test", "limitStart >= 0"));
        pagingElement.addElement(new TextElement("limit #{limitStart} , #{limitEnd}"));
        element.addElement(element.getElements().size(), pagingElement);

        return super.sqlMapSelectByExampleWithBLOBsElementGenerated(element, introspectedTable);
    }

    private void addFeild(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {
        CommentGenerator commentGenerator = context.getCommentGenerator();

//		FullyQualifiedJavaType type = FullyQualifiedJavaType.getIntInstance();
//		if (type.equals(FullyQualifiedJavaType.getBooleanPrimitiveInstance())) {
//			type = FullyQualifiedJavaType.getIntInstance();
//		}

        //generate filed
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(FullyQualifiedJavaType.getIntInstance());
        field.setName(name);
        field.setInitializationString("-1");
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);

        //generate setter
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);

        //generate getter
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }

    public boolean validate(List<String> arg0) {
        return true;
    }

    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        if (Types.BIT == introspectedColumn.getJdbcType() || Types.TINYINT == introspectedColumn.getJdbcType()) {
            field.setType(new FullyQualifiedJavaType(Integer.class.getName()));
            introspectedColumn.setFullyQualifiedJavaType(new FullyQualifiedJavaType(Integer.class.getName()));
            introspectedColumn.setJdbcType(Types.INTEGER);
        }
        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }

    @Override
    public boolean providerApplyWhereMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return super.providerApplyWhereMethodGenerated(method, topLevelClass, introspectedTable);
    }

    private boolean isMergeable = false;

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        isMergeable = Boolean.valueOf(properties.getProperty("isMergeable", String.valueOf(isMergeable)));
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        if(!isMergeable){
            try {
                java.lang.reflect.Field mergedField = GeneratedXmlFile.class.getDeclaredField("isMergeable");
                mergedField.setAccessible(true);
                mergedField.setBoolean(sqlMap, isMergeable);
                return true;
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return super.sqlMapGenerated(sqlMap, introspectedTable);
    }
}
