package mnls.com.mappone.po;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2018/3/21.
 */

public class Cp1pInfo {
    private String pzhm,rq,khhm,khmc,pjhm,shr,cppz,cpgg,cpxh,cpcm, dw,carno;
    private Double sl,ggs;
    private boolean ischeck;

    public boolean ischeck() {
        return ischeck;
    }

    public Cp1pInfo setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
        return this;
    }

    public String getPzhm() {
        return pzhm;
    }

    public Cp1pInfo setPzhm(String pzhm) {
        this.pzhm = pzhm;
        return this;
    }

    public String getRq() {
        return rq;
    }

    public Cp1pInfo setRq(String rq) {
        this.rq = rq;
        return this;
    }

    public String getKhhm() {
        return khhm;
    }

    public Cp1pInfo setKhhm(String khhm) {
        this.khhm = khhm;
        return this;
    }

    public String getKhmc() {
        return khmc;
    }

    public Cp1pInfo setKhmc(String khmc) {
        this.khmc = khmc;
        return this;
    }

    public String getPjhm() {
        return pjhm;
    }

    public Cp1pInfo setPjhm(String pjhm) {
        this.pjhm = pjhm;
        return this;
    }

    public String getShr() {
        return shr;
    }

    public Cp1pInfo setShr(String shr) {
        this.shr = shr;
        return this;
    }

    public String getCppz() {
        return cppz;
    }

    public Cp1pInfo setCppz(String cppz) {
        this.cppz = cppz;
        return this;
    }

    public String getCpgg() {
        return cpgg;
    }

    public Cp1pInfo setCpgg(String cpgg) {
        this.cpgg = cpgg;
        return this;
    }

    public String getCpxh() {
        return cpxh;
    }

    public Cp1pInfo setCpxh(String cpxh) {
        this.cpxh = cpxh;
        return this;
    }

    public String getCpcm() {
        return cpcm;
    }

    public Cp1pInfo setCpcm(String cpcm) {
        this.cpcm = cpcm;
        return this;
    }

    public String getDw() {
        return dw;
    }

    public Cp1pInfo setDw(String dw) {
        this.dw = dw;
        return this;
    }

    public String getCarno() {
        return carno;
    }

    public Cp1pInfo setCarno(String carno) {
        this.carno = carno;
        return this;
    }

    public Double getSl() {
        return sl;
    }

    public Cp1pInfo setSl(Double sl) {
        this.sl = sl;
        return this;
    }

    public Double getGgs() {
        return ggs;
    }

    public Cp1pInfo setGgs(Double ggs) {
        this.ggs = ggs;
        return this;
    }

    public int getAutoid() {
        return autoid;
    }

    public Cp1pInfo setAutoid(int autoid) {
        this.autoid = autoid;
        return this;
    }

    private int autoid;

    public List getCp1pInfoByPhoneCode(UserInfo userInfo){
        //todo 编写根据userif的手机号码去获取发运信息，根据发运资料里面的手机号码来匹配，所有未关闭的发运资料
        List<Cp1pInfo> cp1pInfoList = new ArrayList<Cp1pInfo>();
        Set<Kh91Info> kh91Infos = new HashSet<Kh91Info>();
        List l = new ArrayList();
//虚拟赋值
        for(int i = 0 ;i < 20 ; i++ ){
            Cp1pInfo c = new Cp1pInfo();
            c.setAutoid(i);
            c.setPzhm("发运计划单号：" +  i);
            c.setCarno("车牌号码"+i+"手机号码;13928600040");
            if(i<6){
                c.setCpcm("  101 ");
            }else{
                c.setCpcm("  201 ");
            }
            if(i<8){
                c.setCpgg("600*600");
            }else{
                c.setCpgg("800*800");
            }
            c.setCpxh("FMB1075PMCM");
            c.setDw("箱");
            c.setGgs(90.23);

            if(i<4){
                c.setKhhm("30000S");
                c.setKhmc("散客户S");
            }else{
                c.setKhhm("30000B");
                c.setKhmc("散客户B");
            }
         c.setPjhm("AAAAAAAAA");
            c.setRq("2018/01/01");
            c.setSl(200.0);
            cp1pInfoList.add(c);
            System.out.println("kh91Infos.add>> " + i +"  " +  c);
            kh91Infos.add(new Kh91Info(c.getKhhm(),c.getKhmc()));
        }
        l.add(cp1pInfoList);
        l.add(kh91Infos);
        return l;
    }
}
