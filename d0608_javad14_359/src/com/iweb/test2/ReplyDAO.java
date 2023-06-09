package com.iweb.test2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Guan
 * @date 2023/6/8 10:29
 */
public class ReplyDAO {
    public static List<Reply> query(String receive) {
        List<Reply> replies = new ArrayList<>();
        String sql = "select * from reply where receive = ?";
        try (Connection c = DbUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
                ) {
            ps.setString(1,receive);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Reply reply = new Reply();
                reply.setId(rs.getInt("id"));
                reply.setReceive(receive);
                reply.setResponse(rs.getString("response"));
                replies.add(reply);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return replies;
    }
}
