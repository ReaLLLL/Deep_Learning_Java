package com.maowei.learning.orm;


import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class MyPageInterceptor implements Interceptor{

    //每页显示的条目数
    private int pageSize;
    //当前现实的页数
    private int currPage;

    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        MetaObject metaObjectHandler = SystemMetaObject.forObject(statementHandler);

        while(metaObjectHandler.hasGetter("h")){
            Object o = metaObjectHandler.getValue("h");
            metaObjectHandler = SystemMetaObject.forObject(o);
        }

        while (metaObjectHandler.hasGetter("target")){
            Object o = metaObjectHandler.getValue("target");
            metaObjectHandler = SystemMetaObject.forObject(o);
        }

        MappedStatement mappedStatement = (MappedStatement)metaObjectHandler.getValue("delegate.mappedStatement");
        String mapId = mappedStatement.getId();

        if(mapId.matches(".+ByPage$")){
            ParameterHandler parameterHandler = (ParameterHandler)metaObjectHandler.getValue("delegate.parameterHandler");
            Map<String, Object> paraObject = (Map<String, Object>) parameterHandler.getParameterObject();

            this.pageSize = paraObject.get("pageSize") == null?this.pageSize:(Integer)paraObject.get("pageSize");
            this.currPage = (Integer) paraObject.get("currPage");

            String sql = (String) metaObjectHandler.getValue("delegate.boundSql.sql");

            String limitSql = sql.trim() + " limit " + (currPage - 1) * pageSize + "," + pageSize;

            metaObjectHandler.setValue("delegate.boundSql.sql", limitSql);
        }

        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    public void setProperties(Properties properties) {
        String limit1 = properties.getProperty("limit", "10");
        this.pageSize = Integer.valueOf(limit1);
    }
}
