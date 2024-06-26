package com.sse.app.locations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sse.app.departments.DepartmentDTO;

@Service
public class LocationService {

	@Autowired
	private LocationDAO locationDAO;

	public List<LocationDTO> getList() throws Exception {
		return locationDAO.getList();
	}

	public LocationDTO getDetail(int num) throws Exception {
		LocationDTO locationDTO = locationDAO.getDetail(num);
		return locationDTO;
	}

	public int add(LocationDTO locationDTO) throws Exception {

		return locationDAO.add(locationDTO);

	}
	
	public int delete(LocationDTO locationDTO) throws Exception {
		return locationDAO.delete(locationDTO);
	}
	
	public int update(LocationDTO locationDTO) throws Exception {
		return locationDAO.update(locationDTO);
			
	}

}
