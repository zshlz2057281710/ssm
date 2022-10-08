package project01.dao.DaoImpl;


import project01.dao.DbDao;
import project01.dto.EmpDto;
import project01.entriy.Emp;
import project01.entriy.User;
import project01.utils.Connectutils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyDaoImpl implements DbDao {


    @Override
    public User queryAll(String username) {
        String password = null;
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        User user=null;
        try {
             connection = Connectutils.getConnection();
            String sql="SELECT password FROM user WHERE username=?";
             ps = connection.prepareStatement(sql);
            ps.setString(1,username);

             rs = ps.executeQuery();
             if(rs.next()){
                 password = rs.getString("password");
                 user=new User(username,password);
             }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           Connectutils.closeff(rs,ps,connection);
        }

        return user;
    }

    @Override
    public List<Emp> allEmp(Integer page, Integer limit) {
        List<Emp> emps = new ArrayList<>();
        Connection connection = Connectutils.getConnection();
        String sql = "SELECT e.empno,e.ename,e.job,e.SAL FROM emp e LIMIT ?,?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);

            ps.setInt(1,(page -1 )* limit);
            ps.setInt(2,limit);

            rs = ps.executeQuery();
            while(rs.next()) {
                int empno = rs.getInt("empno");
                Integer no = Integer.valueOf(empno);
                String ename = rs.getString("ename");
                String job = rs.getString("job");



                Double sal = rs.getDouble("sal");
                int i = sal.intValue();
                Integer ssa = Integer.valueOf(i);

                Emp emp = new Emp(no,ename,job,ssa);

                emps.add(emp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connectutils.closeff(rs,ps,connection);
        }
        return emps;

    }


    @Override
    public void delete(int empno) {
        Connection connection = Connectutils.getConnection();
        String sql="DELETE FROM emp WHERE empno=?";
        PreparedStatement ps=null;
        try {
             ps = connection.prepareStatement(sql);
            ps.setInt(1,empno);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Integer count(EmpDto empDto) {
        Connection connection = Connectutils.getConnection();
        StringBuilder sql=new StringBuilder("SELECT count(e.empno) as total FROM emp e");
        if(empDto != null){//带有条件
            if(empDto.getEmpno() != null) {
                sql.append("  and e.empno=?");
            }
            if(empDto.getEname()  != null && !"".equals(empDto.getEname())){
                sql.append(" and e.ename=?");
            }
            if(empDto.getJob() != null && !"".equals(empDto.getJob())){
                sql.append(" and e.job=?");
            }
            if(empDto.getSal() != null && empDto.getSal() != null){
                sql.append(" and e.sal=?");
            }

        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            int index = 1;
            if(empDto != null){//带有条件
                if(empDto.getEmpno() != null) {
                    ps.setInt(index,empDto.getEmpno());
                    index++;
                }
                if(empDto.getEname()  != null && !"".equals(empDto.getEname())){
                    ps.setString(index,empDto.getEname());
                    index++;
                }
                if(empDto.getJob() != null && !"".equals(empDto.getJob())){
                    ps.setString(index,empDto.getJob());
                    index++;
                }
                if(empDto.getSal() != null && empDto.getSal() != null){
                    ps.setInt(index,empDto.getSal());
                    index++;
                }

            }

            rs = ps.executeQuery();
            if(rs.next()) {
                int total = rs.getInt("total");
                return total;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connectutils.closeff(rs,ps,connection);
        }

        return 0;

    }

    @Override
    public void save(Emp emp) {
        Connection connection = Connectutils.getConnection();
        String sql = "INSERT INTO emp(empno,ename,job,sal) VALUES(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,emp.getEmpno());
            ps.setString(2,emp.getEname());
            ps.setString(3,emp.getJob());
            ps.setInt(4,emp.getSal());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connectutils.closeff(ps,connection);
        }
    }

    @Override
    public void update(Emp emp) {
        Connection connection =Connectutils.getConnection();
        String sql = "UPDATE emp SET ename=?,job=?,sal=? WHERE empno=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,emp.getEname());
            ps.setString(2,emp.getJob());

            //将java.util.Date 转换为 java.sql.Date



            ps.setDouble(3,emp.getSal());

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           Connectutils.closeff(ps,connection);
        }
    }

}
