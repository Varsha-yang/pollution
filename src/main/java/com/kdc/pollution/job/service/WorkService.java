package com.kdc.pollution.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class WorkService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> execute() throws SQLException {

      /*   List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);

     List<Object> list =   mapList.stream().map(map->map.get("plt")).collect(Collectors.toList());
     list.forEach(obj-> System.out.println(obj));
     list.stream().distinct().forEach(obj-> System.out.println(obj));
      list.stream().filter(obj->!obj.equals("合计")).distinct().forEach(obj-> System.out.println(obj));*/

        String sql = "select * from temp_garage_renovation";
        Connection conn = jdbcTemplate.getDataSource().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setFetchSize(1000);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int cnt = metaData.getColumnCount();
        List<String> list = new ArrayList<>();
        for (int i = 1; i < cnt; i++) {
            list.add(metaData.getColumnName(i));
        }
        return list;
    }

}
