package dao;

import java.util.List;

import metier.Sort;

public interface IDAOSort extends IDAO<Sort,Integer> {
	
	List<Sort> findUntil(int level);

}
