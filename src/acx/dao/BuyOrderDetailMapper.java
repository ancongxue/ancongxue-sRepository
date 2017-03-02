package acx.dao;

import java.util.List;
import acx.entity.BuyOrderDetail;

public interface BuyOrderDetailMapper extends BaseMapper<BuyOrderDetail> {
	public int insertList(List<BuyOrderDetail> buyOrderDetails);
}
