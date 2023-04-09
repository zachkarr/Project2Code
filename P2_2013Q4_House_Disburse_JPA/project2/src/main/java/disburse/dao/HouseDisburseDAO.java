package disburse.dao;

import disburse.repository.HouseDisburseRepository;
import disburse.vo.HouseDisburseDetail;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseDisburseDAO
{
private HouseDisburseRepository hdr;

@Autowired
    public HouseDisburseDAO (HouseDisburseRepository hdr)
    {
        this.hdr = hdr;
    }
    public List<HouseDisburseDetail> getListOfAllRowsMapper() {
        List<HouseDisburseDetail> resultList = hdr.getListOfAllHDs();

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
        List<HouseDisburseDetail> resultList = hdr.getHDByHighestAmount();

        for (HouseDisburseDetail detail : resultList) {
            String office = detail.getOffice();
            if (office != null) {
                detail.setOffice(office.toLowerCase());
            }
        }

        System.out.println(resultList);
        return resultList;
    }
//    public void saveHDToDB(HouseDisburseDetail hdd) {
//        hdr.saveHDToDB(hdd);
//        System.out.println(hdd);
//    }

    public List<HouseDisburseDetail> getHDByIdJPA(String bioGuideID) {
        List<HouseDisburseDetail> resultList = (List<HouseDisburseDetail>) hdr.getHDByIDJPA(bioGuideID);

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

