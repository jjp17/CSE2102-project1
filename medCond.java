public class medCond 
{
    private String mdContact;
    private String mdPhone;
    private String algType;
    private String illType;

    public medCond(String mdContact, String mdPhone, String algType, String illType)
    {
        this.mdContact = mdContact;
        this.mdPhone = mdPhone;
        this.algType = algType;
        this.illType = illType;
    }

    public String getMdContact() {
        return this.mdContact;
    }

    public void updateMdContact(String mdContact) {
        this.mdContact = mdContact;
    }

    public String getMdPhone() {
        return this.mdPhone;
    }

    public void updateMdPhone(String mdPhone) {
        this.mdPhone = mdPhone;
    }

    public String getAlgType() {
        return this.algType;
    }

    public void updateAlgType(String algType) {
        this.algType = algType;
    }

    public String getIllType() {
        return this.illType;
    }

    public void updateIllType(String illType) {
        this.illType = illType;
    }





    
}
