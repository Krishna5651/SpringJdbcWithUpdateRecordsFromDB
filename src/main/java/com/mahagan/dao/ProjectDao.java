/**
 * Created By Krishna Shinde
 * Date : 21-08-2023
 * Time : 10:33
 * Project: SpringJdbcWithUpdateRecordsFromDB
 **/

package com.mahagan.dao;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class ProjectDao {
    private DataSource dataSource;
    private ProjectSqlUpdate projectSqlUpdate;
    private final String SQL_FOR_PROJECT="Update project set title=? where projectNo=?";

    public ProjectDao(DataSource dataSource) {
        this.dataSource = dataSource;
        projectSqlUpdate=new ProjectSqlUpdate(dataSource,SQL_FOR_PROJECT);
    }
    public int updateProjects(int projectNo,String title){
        return projectSqlUpdate.update(new Object[]{title,projectNo});
    }

    private final class ProjectSqlUpdate extends SqlUpdate{
        public ProjectSqlUpdate(DataSource dataSource,String sqlQuery){
             super(dataSource,sqlQuery);
             declareParameter(new SqlParameter(java.sql.Types.VARCHAR));
             declareParameter(new SqlParameter(java.sql.Types.INTEGER));
             compile();
        }
    }
}
