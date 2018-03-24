package mnls.com.mappone.po;

/**
 * Created by Administrator on 2018/3/21.
 */

public class UserInfo {

    private String Phone;
    private String UserName;
    private String IdentifyId;
    private String CompanyName;
    private String UserPwd;
    private String CUserMUser;
    private String RegeditDate;
    private String CDate;
    private String MDate;
     private int  Flag;
    private int  FID;

    public int getFID() {
        return FID;
    }

    public UserInfo setFID(int FID) {
        this.FID = FID;
        return this;
    }

    public String getPhone() {
        return Phone;
    }

    public UserInfo setPhone(String phone) {
        Phone = phone;
        return this;
    }

    public String getUserName() {
        return UserName;
    }

    public UserInfo setUserName(String userName) {
        UserName = userName;
        return this;
    }

    public String getIdentifyId() {
        return IdentifyId;
    }

    public UserInfo setIdentifyId(String identifyId) {
        IdentifyId = identifyId;
        return this;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public UserInfo setCompanyName(String companyName) {
        CompanyName = companyName;
        return this;
    }

    public String getUserPwd() {
        return UserPwd;
    }

    public UserInfo setUserPwd(String userPwd) {
        UserPwd = userPwd;
        return this;
    }

    public String getCUserMUser() {
        return CUserMUser;
    }

    public UserInfo setCUserMUser(String CUserMUser) {
        this.CUserMUser = CUserMUser;
        return this;
    }

    public String getRegeditDate() {
        return RegeditDate;
    }

    public UserInfo setRegeditDate(String regeditDate) {
        RegeditDate = regeditDate;
        return this;
    }

    public String getCDate() {
        return CDate;
    }

    public UserInfo setCDate(String CDate) {
        this.CDate = CDate;
        return this;
    }

    public String getMDate() {
        return MDate;
    }

    public UserInfo setMDate(String MDate) {
        this.MDate = MDate;
        return this;
    }

    public int getFlag() {
        return Flag;
    }

    public UserInfo setFlag(int flag) {
        Flag = flag;
        return this;
    }
}
