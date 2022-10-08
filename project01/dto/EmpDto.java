package project01.dto;

public class EmpDto {
   private Integer empno;
   private String ename;
   private String job;
   private  Integer sal;

    public EmpDto() {
    }

    public EmpDto(Integer empno, String ename, String job, Integer sal) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.sal = sal;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getSal() {
        return sal;
    }

    public void setSal(Integer sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "EmpDto{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                '}';
    }
}
