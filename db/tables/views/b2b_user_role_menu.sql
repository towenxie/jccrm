            "select * from b2b_menu",
            "where code in (",
            "select menu_code from b2b_role_menu where role_code in (",
            "select ur.role_id from tbl_user_role ur, tbl_role r where ur.role_id=r.id and ur.user_id=#{userId} and (r.`status`!=0 or r.`status` is null)",
            ")) and status=0 order by sort"