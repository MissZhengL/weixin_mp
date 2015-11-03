package cn.hofan.commonTiming.dataconvert;

import java.util.List;

import com.hofan.erpsystem.model.OverseasDelivery.InverntoryDetail;
import com.hofan.erpsystem.model.OverseasDelivery.OrderTrack;
import com.hofan.erpsystem.model.OverseasDelivery.ThirdPartyOrderInfo;
import com.hofan.erpsystem.model.OverseasDelivery.UploadInfo;
import com.hofan.erpsystem.utils.JsonUtils;

public class ThirdPartyDataConvert {

	public static InverntoryDetail convert(
			com.hofan.erp.warehouse.cewh.model.InverntoryDetail detail) {
		String detailStr = JsonUtils.toJsonString(detail);
		return JsonUtils.json2Object(detailStr, InverntoryDetail.class);
	}

	public static List<InverntoryDetail> convert(
			List<com.hofan.erp.warehouse.cewh.model.InverntoryDetail> detail) {
		String detailStr = JsonUtils.toJsonString(detail);
		return JsonUtils.json2List(detailStr, InverntoryDetail.class);
	}

	public static com.hofan.erp.warehouse.cewh.model.ThirdPartyOrderInfo convert(
			ThirdPartyOrderInfo info) {
		String infoStr = JsonUtils.toJsonString(info);
		return JsonUtils.json2Object(infoStr,
				com.hofan.erp.warehouse.cewh.model.ThirdPartyOrderInfo.class);
	}

	public static List<com.hofan.erp.warehouse.cewh.model.ThirdPartyOrderInfo> convertInfos(
			List<ThirdPartyOrderInfo> infos) {
		String infoStr = JsonUtils.toJsonString(infos);
		return JsonUtils.json2List(infoStr,
				com.hofan.erp.warehouse.cewh.model.ThirdPartyOrderInfo.class);
	}

	public static UploadInfo convert(
			com.hofan.erp.warehouse.cewh.model.UploadInfo info) {
		String infoStr = JsonUtils.toJsonString(info);
		return JsonUtils.json2Object(infoStr, UploadInfo.class);
	}

	public static List<UploadInfo> convertUploadInfos(
			List<com.hofan.erp.warehouse.cewh.model.UploadInfo> infos) {
		String infoStr = JsonUtils.toJsonString(infos);
		return JsonUtils.json2List(infoStr, UploadInfo.class);
	}

	public static List<OrderTrack> convertOrderTrack(
			List<com.hofan.erp.warehouse.cewh.model.OrderTrackAPI> list) {
		String infoStr = JsonUtils.toJsonString(list);
		return JsonUtils.json2List(infoStr, OrderTrack.class);
	}
}
