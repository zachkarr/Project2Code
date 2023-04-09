package disburse.dao;

import disburse.vo.HouseDisburseDetail;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class HouseDisburseDAO
{
    private JdbcTemplate jdbc;
    public HouseDisburseDAO(JdbcTemplate jdbc) {
       this.jdbc = jdbc;
   }
    public List<HouseDisburseDetail> getListOfAllRowsMapper() {
        return jdbc.query("SELECT * FROM T_2013Q4_HOUSE_DISBURSE", new RowMapper<HouseDisburseDetail>()
        {
            @Override
            public HouseDisburseDetail mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                HouseDisburseDetail hdd = new HouseDisburseDetail();
                hdd.setBioGuideID(rs.getString("BIOGUIDE_ID"));
                hdd.setOffice(rs.getString("OFFICE").toLowerCase());
                hdd.setCategory(rs.getString("CATEGORY"));
                hdd.setPayee(rs.getString("PAYEE"));
                hdd.setStartDate(rs.getString("START_DATE"));
                hdd.setEndDate(rs.getString("END_DATE"));
                hdd.setPurpose(rs.getString("PURPOSE"));
                hdd.setAmount(rs.getDouble("AMOUNT"));
                hdd.setYear(rs.getString("YEAR"));
                return hdd;
            }
        });
    }

    public List<HouseDisburseDetail> getListOfHighestAmount() {
        return jdbc.query("SELECT * from T_2013Q4_HOUSE_DISBURSE where AMOUNT = (SELECT MAX(AMOUNT) from T_2013Q4_HOUSE_DISBURSE)", new RowMapper<HouseDisburseDetail>()
        {
            @Override
            public HouseDisburseDetail mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                HouseDisburseDetail hdd = new HouseDisburseDetail();
                hdd.setBioGuideID(rs.getString("BIOGUIDE_ID"));
                hdd.setOffice(rs.getString("OFFICE").toLowerCase());
                hdd.setCategory(rs.getString("CATEGORY"));
                hdd.setPayee(rs.getString("PAYEE"));
                hdd.setStartDate(rs.getString("START_DATE"));
                hdd.setEndDate(rs.getString("END_DATE"));
                hdd.setPurpose(rs.getString("PURPOSE"));
                hdd.setAmount(rs.getDouble("AMOUNT"));
                hdd.setYear(rs.getString("YEAR"));
                return hdd;
            }
        });
    }

    public List<Map<String, Object>> getListOfHighestAmountByBioGuideID() {
        return jdbc.queryForList("SELECT BIOGUIDE_ID, MAX(AMOUNT) as amount from T_2013Q4_HOUSE_DISBURSE GROUP BY BIOGUIDE_ID");

    }
    public int saveHDToDB(HouseDisburseDetail hdd) {
        System.out.println(hdd);
        return jdbc.update("INSERT INTO T_2013Q4_HOUSE_DISBURSE (BIOGUIDE_ID, OFFICE, CATEGORY, PAYEE, START_DATE, END_DATE, PURPOSE, AMOUNT, YEAR) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", hdd.getBioGuideID(), hdd.getOffice(), hdd.getCategory(), hdd.getPayee(), hdd.getStartDate(), hdd.getEndDate(), hdd.getPurpose(), hdd.getAmount(), hdd.getYear());
    }
    public List<HouseDisburseDetail> getHDByIdJDBC(String bioGuideID) {
        return jdbc.query("SELECT * FROM T_2013Q4_HOUSE_DISBURSE WHERE BIOGUIDE_ID = ?", new Object[]{bioGuideID}, new RowMapper<HouseDisburseDetail>()
        {
            @Override
            public HouseDisburseDetail mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                HouseDisburseDetail hdd = new HouseDisburseDetail();
                hdd.setBioGuideID(rs.getString("BIOGUIDE_ID"));
                hdd.setOffice(rs.getString("OFFICE").toLowerCase());
                hdd.setCategory(rs.getString("CATEGORY"));
                hdd.setPayee(rs.getString("PAYEE"));
                hdd.setStartDate(rs.getString("START_DATE"));
                hdd.setEndDate(rs.getString("END_DATE"));
                hdd.setPurpose(rs.getString("PURPOSE"));
                hdd.setAmount(rs.getDouble("AMOUNT"));
                hdd.setYear(rs.getString("YEAR"));
                return hdd;
            }
        });
    }

    public List<HouseDisburseDetail> changeCategory(HouseDisburseDetail hdd) {

        return jdbc.query("SELECT * FROM T_2013Q4_HOUSE_DISBURSE", new RowMapper<HouseDisburseDetail>()
        {
            @Override
            public HouseDisburseDetail mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                HouseDisburseDetail hdd = new HouseDisburseDetail();

                switch (rs.getString("CATEGORY")) {
                    case "TRAVEL":
                        hdd.setCategory("T");
                        break;
                    case "FRANKED MAIL":
                        hdd.setCategory("FM");
                        break;
                    case "PERSONNEL COMPENSATION":
                        hdd.setCategory("PC");
                        break;
                    case "RENT":
                        hdd.setCategory("R");
                        break;
                    case "RENT, COMMUNICATION, UTILITIES":
                        hdd.setCategory("R, C, U");
                        break;
                    case "EQUIPMENT":
                        hdd.setCategory("E");
                        break;
                    case "OTHER SERVICES":
                        hdd.setCategory("OS");
                        break;
                    case "SUPPLIES AND MATERIALS":
                        hdd.setCategory("SM");
                        break;
                    case "PRINTING AND REPRODUCTION":
                        hdd.setCategory("PR");
                        break;
                }

                hdd.setBioGuideID(rs.getString("BIOGUIDE_ID"));
                hdd.setOffice(rs.getString("OFFICE").toLowerCase());
              //  hdd.setCategory(rs.getString("CATEGORY"));
                hdd.setPayee(rs.getString("PAYEE"));
                hdd.setStartDate(rs.getString("START_DATE"));
                hdd.setEndDate(rs.getString("END_DATE"));
                hdd.setPurpose(rs.getString("PURPOSE"));
                hdd.setAmount(rs.getDouble("AMOUNT"));
                hdd.setYear(rs.getString("YEAR"));
                return hdd;
            }
        });

    }
}

