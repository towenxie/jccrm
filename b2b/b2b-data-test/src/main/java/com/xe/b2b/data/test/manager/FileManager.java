package com.xe.b2b.data.test.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xe.b2b.data.business.service.ILocationService;
import com.xe.b2b.data.business.service.impl.LocationService;
import com.xe.b2b.data.business.service.model.LocationCityModel;
import com.xe.b2b.data.business.service.model.LocationRegionModel;
import com.xe.b2b.data.business.service.model.LocationStateModel;
import com.xe.b2b.data.common.util.SpringUtils;

@Service
public class FileManager {

    public void startUp() {

//        this.toTypeText();
        this.toLocationText();
    }
    
    public void toLocationText(){
        ILocationService service = SpringUtils.getBean(LocationService.class);
        List<LocationStateModel> states = service.getMetaLocations();
        String result="{0:{";
        
        for (int i = 0; i < states.size(); i++) {
            
            if (i==0) {
                result+=states.get(0).getLocationId()+":'"+states.get(0).getName()+"'";
            }else{
                result+=","+states.get(i).getLocationId()+":'"+states.get(i).getName()+"'";
            }
        }
        for (LocationStateModel state : states) {
            List<LocationCityModel> cityModels =state.getChildren();
            if (cityModels.size()==0) {
                continue;
            }
            result+="},"+state.getLocationId()+":{";
            for (int i = 0; i < cityModels.size(); i++) {
                
                if (i==0) {
                    result+=cityModels.get(0).getLocationId()+":'"+cityModels.get(0).getName()+"'";
                }else{
                    result+=","+cityModels.get(i).getLocationId()+":'"+cityModels.get(i).getName()+"'";
                }
            }
        }
        for (LocationStateModel state : states) {
            for (LocationCityModel cityModels : state.getChildren()) {

                
                if (cityModels.getChildren().size()==0) {
                    continue;
                }
                result+="},"+cityModels.getLocationId()+":{";
                List<LocationRegionModel> regionModels =cityModels.getChildren();
                for (int i = 0; i < regionModels.size(); i++) {
                    
                    if (i==0) {
                        result+=regionModels.get(0).getLocationId()+":'"+regionModels.get(0).getName()+"'";
                    }else{
                        result+=","+regionModels.get(i).getLocationId()+":'"+regionModels.get(i).getName()+"'";
                    }
                }
            }
        }
        result+="}  }";
        
        System.out.println(result);
    }
}
