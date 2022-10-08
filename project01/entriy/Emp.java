package project01.entriy;

public class Emp {
    Integer empno;
    String ename;
    String job;
    Integer sal;
    public Emp(int empno, String ename, String job, double sal) {
    }

    public Emp(int empno, String ename, String job) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
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

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public Integer getSal() {
        return sal;
    }

    public void setSal(Integer sal) {
        this.sal = sal;
    }
}
