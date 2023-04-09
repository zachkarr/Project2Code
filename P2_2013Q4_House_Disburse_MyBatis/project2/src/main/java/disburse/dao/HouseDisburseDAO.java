package disburse.dao;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import disburse.mapper.HouseDisburseMapper;
import disburse.vo.HouseDisburseDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseDisburseDAO
{
    @Autowired
    HouseDisburseMapper hdList;

    public List<HouseDisburseDetail> getListOfAllRowsMapper() {
        List<HouseDisburseDetail> resultList = hdList.getListOfAllHDs();

        for (HouseDisburseDetail detail : resultList) {
            String office = detail.getOffice();
            if (office != null) {
                detail.setOffice(office.toLowerCase());
            }
        }

        System.out.println(resultList);
        return resultList;
    }

    public List<HouseDisburseDetail> getListOfHighestAmount() {
        List<HouseDisburseDetail> resultList = hdList.getHDByHighestAmount();

        for (HouseDisburseDetail detail : resultList) {
            String office = detail.getOffice();
            if (office != null) {
                detail.setOffice(office.toLowerCase());
            }
        }

        System.out.println(resultList);
        return resultList;
    }
    public void saveHDToDB(HouseDisburseDetail hdd) {
        hdList.saveHDToDB(hdd);
        System.out.println(hdd);
    }

    public List<HouseDisburseDetail> getHDByIdMyBatis(String bioGuideID) {
        List<HouseDisburseDetail> resultList = hdList.getHDById(bioGuideID);

        for (HouseDisburseDetail detail : resultList) {
            String office = detail.getOffice();
            if (office != null) {
                detail.setOffice(office.toLowerCase());
            }
        }

        System.out.println(resultList);
        return resultList;
    }
}

