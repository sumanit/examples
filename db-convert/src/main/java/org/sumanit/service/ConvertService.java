package org.sumanit.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 苏曼 on 2019/11/26.
 */
@Service
public class ConvertService {
    @Resource
    private JdbcTemplate jdbcTemplate;


    public void convert() throws SQLException {
        DatabaseMetaData metaData = jdbcTemplate.getDataSource().getConnection().getMetaData();
        ResultSet tables = metaData.getTables(null, "%", "%", new String[]{"TABLE"});
        while(tables.next()){
            StringBuilder sb = new StringBuilder();
            String tableName = tables.getString("TABLE_NAME");
            String[] s = tableName.split("_");
            try {
                Integer.parseInt(s[s.length - 1]);
                continue;
            }catch (Exception e){

            }
            if(tableName.startsWith("batch")){
                continue;
            }
            if(tableName.startsWith("pathman")){
                continue;
            }
            sb.append("CREATE TABLE ").append(tableName).append("(");
            ResultSet columns = metaData.getColumns(null, "%", tableName, "%");
            String pkColumn = null;
            while(columns.next()){
                String columnName = columns.getString("COLUMN_NAME");
                String columnType = columns.getString("TYPE_NAME");
                int columnSize = columns.getInt("COLUMN_SIZE");
                String newColumnType = converColumnType(columnType);
                if(columnSize>1000){
                    columnSize=255;
                }
                if(newColumnType ==null || newColumnType.equals("varchar")){
                    newColumnType = "varchar("+columnSize+")";
                }


                sb.append("`").append(columnName).append("`").append(" ").append(newColumnType);


                int nullable = columns.getInt("NULLABLE");
                if(nullable==0){
                    sb.append(" NOT NULL ");
                }

                if(columnType.equals("bigserial")){
                    pkColumn = columnName;
                    sb.append(" PRIMARY KEY auto_increment");
                }
                String columnDef = columns.getString("COLUMN_DEF");
                if(columnType.equals("timestamp")&&columnDef==null){
                    columnDef = "now()";
                }
                if(columnDef!=null){
                    if(columnDef.equals("uuid_generate_v1()")){
                        columnDef = "'UUID()'";
                    }
                    if(columnName.equals("modify_time")){
                        columnDef+=" ON UPDATE now()";
                    }
                    if(columnDef.contains("::")){
                        columnDef= columnDef.split("::")[0];
                    }
                    if(columnDef.startsWith("nextval")){

                    }else {
                        sb.append(" default ").append(columnDef);
                    }
                }



                int digits = columns.getInt("DECIMAL_DIGITS");
                String remarks = columns.getString("REMARKS");


                sb.append(", ");

            }
            sb.setLength(sb.length()-2);
            sb.append(");");
            System.out.println(sb.toString());
            ResultSet indexInfos = metaData.getIndexInfo(null, tables.getString("TABLE_SCHEM"), tableName, false, false);


            Map<String, List<String>> indexMap = new HashMap<>();
            while(indexInfos.next()){
                String indexName = indexInfos.getString("INDEX_NAME");
                String columnName = indexInfos.getString("COLUMN_NAME");
                if(columnName.equals(pkColumn)){
                    continue;
                }
                List<String> columnNames = indexMap.get(indexName);
                if(columnNames == null){
                    columnNames = new ArrayList<>();
                    indexMap.put(indexName,columnNames);
                }
                columnNames.add(columnName);
            }
            indexMap.forEach((indexName,columnNames)->{
                sb.setLength(0);
                sb.append("alter table ").append(tableName).append(" add INDEX ");
                sb.append("`").append(indexName).append("`(");
                columnNames.forEach(columnName->{
                    sb.append(columnName).append(",");
                });
                sb.setLength(sb.length()-1);
                sb.append(");");
                System.out.println(sb.toString());
            });
        }


    }

    public String converColumnType(String srcType){
        switch (srcType){
            case "bigserial":
                return "BIGINT";
            case "int2":
                return "SMALLINT";
            case "int4":
                return "INT";
            case "int8":
                return "BIGINT";
            case "timestamp":
                return "timestamp";
            case "varchar":
                return "varchar";
            case "bool":
                return "TINYINT";
            case "float8":
                return "DOUBLE";
            case "float4":
                return "FLOAT";
            case "date":
                return "DATE";
            case "time":
                return "TIME";
        }
        //System.out.println(srcType);
        return null;

    }

}
