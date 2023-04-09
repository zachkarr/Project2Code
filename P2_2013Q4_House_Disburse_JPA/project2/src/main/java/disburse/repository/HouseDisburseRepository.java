package disburse.repository;

import disburse.HouseDisburseDetailApp;
import disburse.controller.HouseDisburseController;
import disburse.vo.HouseDisburseDetail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HouseDisburseRepository extends JpaRepository<HouseDisburseDetail, Integer>
{

    @Query(value = "SELECT * from T_2013Q4_HOUSE_DISBURSE where AMOUNT = (SELECT MAX(AMOUNT) from T_2013Q4_HOUSE_DISBURSE)", nativeQuery = true)
    List<HouseDisburseDetail> getHDByHighestAmount();
//    @Modifying
//    @Query(value ="INSERT INTO T_2013Q4_HOUSE_DISBURSE (BIOGUIDE_ID, OFFICE, CATEGORY, PAYEE, START_DATE, END_DATE, PURPOSE, AMOUNT, YEAR) VALUES (:bioGuideID, :office, :category, :payee, :startDate, :endDate, :purpose:, :amount, :year)", nativeQuery = true)
//    int saveHDToDB(HouseDisburseDetail hdd);
    @Query(value = "SELECT * FROM T_2013Q4_HOUSE_DISBURSE", nativeQuery = true)
    List<HouseDisburseDetail> getListOfAllHDs();

    @Query(value = "SELECT * FROM T_2013Q4_HOUSE_DISBURSE WHERE BIOGUIDE_ID = ?", nativeQuery = true)
    List<HouseDisburseDetail> getHDByIDJPA(String bioGuideID);
}
