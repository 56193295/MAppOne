package mnls.com.mappone.po;

import java.util.List;

/**
 * Created by Administrator on 2018/3/21.
 */

public class Kh91Info {
    private String khhm;
    private String khmc;
    private boolean ischeck;
    private List<Cp1pInfo> list;

    public List<Cp1pInfo> getList() {
        return list;
    }

    public Kh91Info setList(List<Cp1pInfo> list) {
        this.list = list;
        return this;
    }

    public Kh91Info(String khhm, String khmc) {
        this.khhm = khhm;
        this.khmc = khmc;
    }
    public Kh91Info() {
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Kh91Info)) return false;
        Kh91Info kh91Info = (Kh91Info) o;
        System.out.println("equals>>" +getKhhm().equalsIgnoreCase(((Kh91Info) o).getKhhm()));
        return this.getKhhm().equalsIgnoreCase(((Kh91Info) o).getKhhm());
    }

    @Override
    public int hashCode() {
        if(getKhhm() != null || !getKhhm().isEmpty()){
            System.out.println("hashCODE>>" + getKhhm().hashCode());
            return getKhhm().hashCode();
        }
    return 0;
    }

    public String getKhhm() {
        return khhm;
    }

    public Kh91Info setKhhm(String khhm) {
        this.khhm = khhm;
        return this;
    }

    public String getKhmc() {
        return khmc;
    }

    public Kh91Info setKhmc(String khmc) {
        this.khmc = khmc;
        return this;
    }



    public boolean ischeck() {
        return ischeck;
    }

    public Kh91Info setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
        return this;
    }
}
