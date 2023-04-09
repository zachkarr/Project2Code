package disburse.mapper;

import org.apache.ibatis.annotations.*;
import disburse.vo.HouseDisburseDetail;

import java.util.List;

@Mapper
public interface HouseDisburseMapper
{
    @Select("SELECT * FROM T_2013Q4_HOUSE_DISBURSE")
    @Results(id = "hdResultMap", value = {
            @Result(property = "recordId", column = "RECORDID"),
            @Result(property = "bioGudeID", column = "BIOGUDE_ID"),
            @Result(property = "office", column = "OFFICE"),
            @Result(property = "category", column = "CATEGORY"),
            @Result(property = "payee", column = "PAYEE"),
            @Result(property = "startDate", column = "START_DATE"),
            @Result(property = "endDate", column = "END_DATE"),
            @Result(property = "amount", column = "AMOUNT"),
            @Result(property = "year", column = "YEAR")
    })
    public List<HouseDisburseDetail> getListOfAllHDs();

    @Select("SELECT * from T_2013Q4_HOUSE_DISBURSE where AMOUNT = (SELECT MAX(AMOUNT) from T_2013Q4_HOUSE_DISBURSE)")
    @ResultMap("hdResultMap")
    public List<HouseDisburseDetail> getHDByHighestAmount();


    @Insert("INSERT INTO T_2013Q4_HOUSE_DISBURSE (BIOGUIDE_ID, OFFICE, CATEGORY, PAYEE, START_DATE, END_DATE, PURPOSE, AMOUNT, YEAR) VALUES (#{bioGuideID}, #{office}, #{category}, #{payee}, #{startDate}, #{endDate}, #{purpose}, #{amount}, #{year})")
    @ResultMap("hdResultMap")
    public void saveHDToDB(HouseDisburseDetail hdd);

    @Select("SELECT * FROM T_2013Q4_HOUSE_DISBURSE WHERE BIOGUIDE_ID = #{bioGuideID}")
    @ResultMap("hdResultMap")
    public List<HouseDisburseDetail> getHDById(String bioGuideID);
}