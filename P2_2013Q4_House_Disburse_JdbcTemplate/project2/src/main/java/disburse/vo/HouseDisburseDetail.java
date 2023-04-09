package disburse.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
@Entity
@Table(name = "T_2013Q4_HOUSE_DISBURSE")
public class HouseDisburseDetail
{
    @Id
    @Column(nullable = false, name = "RECORDID")
    private int recordId;
    @Column(nullable = true, name = "BIOGUIDE_ID")
    private String bioGuideID;
    @Column(nullable = true, name = "OFFICE")
    private String office;
    @Column(nullable = true, name = "CATEGORY")
    private String category;
    @Column(nullable = true, name = "PAYEE")
    private String payee;
    @Column(nullable = true, name = "START_DATE")
    private String startDate;
    @Column(nullable = true, name = "END_DATE")
    private String endDate;
    @Column(nullable = true, name = "PURPOSE")
    private String purpose;
    @Column(nullable = true, name = "AMOUNT")
    private double amount;
    @Column(nullable = true, name = "YEAR")
    private String year;

    public int getRecordId()
    {
        return recordId;
    }

    public void setRecordId(int recordId)
    {
        this.recordId = recordId;
    }

    public String getBioGuideID()
    {
        return bioGuideID;
    }

    public void setBioGuideID(String bioGuideID)
    {
        this.bioGuideID = bioGuideID;
    }

    public String getOffice()
    {
        return office;
    }

    public void setOffice(String office)
    {
        this.office = office;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getPayee()
    {
        return payee;
    }

    public void setPayee(String payee)
    {
        this.payee = payee;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public String getPurpose()
    {
        return purpose;
    }

    public void setPurpose(String purpose)
    {
        this.purpose = purpose;
    }

    @JsonProperty("AMOUNT")
    public double getAmount()
    {
        return amount;
    }
    @JsonProperty("AMOUNT")
    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    @JsonProperty("YEAR")
    public String getYear()
    {
        return year;
    }
    @JsonProperty("YEAR")
    public void setYear(String year)
    {
        this.year = year;
    }
    @Override
    public String toString() {
        return "T_2013Q4_HOUSE_DISBURSE [recordId=" + recordId + ", bioGuideID=" + bioGuideID + ", office=" + office + ", category="
                + category + ", payee=" + payee + ", startDate=" + startDate + ", endDate=" + endDate
                + ", purpose=" + purpose + ", amount=" + amount + ", year="
                + year + "]";
    }
}
