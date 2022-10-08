package project01.dao;

import project01.dto.EmpDto;
import project01.entriy.User;
import project01.entriy.Emp;
import project01.entriy.User;

import java.util.List;

public interface DbDao {
    User queryAll(String username);
    List<Emp> allEmp(Integer page,Integer limit);
      void delete(int empno);
      public Integer count(EmpDto empDto);
      void save(Emp emp);
      void update(Emp emp);

}
