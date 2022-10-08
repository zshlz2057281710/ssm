package project01.service.UserImpl;

import project01.dao.DbDao;
import project01.dto.EmpDto;
import project01.entriy.Emp;
import project01.entriy.User;
import project01.dao.DaoImpl.MyDaoImpl;
import project01.service.UserSver;

import java.util.List;

public class uerImp implements UserSver {

    @Override
    public boolean islogin(User user) {
        User as=user;
        String name=as.getUsername();
        String opas=as.getPassword();
        MyDaoImpl mp=new MyDaoImpl();
        User ps=mp.queryAll(name);
       String ols= ps.getPassword();
        if(opas.equals(ols)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List reAllemp(Integer page, Integer limit) {
        DbDao dao=new MyDaoImpl();
        List<Emp> emps = dao.allEmp(page, limit);
        return emps;
    }


    @Override
    public void deleteList(String empno) {
        int i = Integer.parseInt(empno);
        MyDaoImpl mm=new MyDaoImpl();
        mm.delete(i);
    }

    @Override
    public Integer count(EmpDto empDto) {
        DbDao dao=new MyDaoImpl();
        Integer count = dao.count(empDto);
        return count;
    }

    @Override
    public void add(Emp emp) {
        DbDao dao=new MyDaoImpl();
        dao.save(emp);
    }
}
