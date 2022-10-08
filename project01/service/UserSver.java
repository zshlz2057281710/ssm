package project01.service;

import project01.dto.EmpDto;
import project01.entriy.Emp;
import project01.entriy.User;

import java.util.List;

public interface UserSver {
    boolean islogin(User user);
    List reAllemp(Integer page,Integer limit);
    void deleteList(String empno);
    public Integer count(EmpDto empDto);
    void add(Emp emp);
}
