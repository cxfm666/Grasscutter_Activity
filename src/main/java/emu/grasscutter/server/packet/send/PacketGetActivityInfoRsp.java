package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfo;
import emu.grasscutter.net.proto.GetActivityInfoReqOuterClass.GetActivityInfoReq;
import emu.grasscutter.net.proto.GetActivityInfoRspOuterClass.GetActivityInfoRsp;

public class PacketGetActivityInfoRsp extends BasePacket {
	public PacketGetActivityInfoRsp(GetActivityInfoReq req) {
		super(PacketOpcodes.GetActivityInfoRsp);
		
		GetActivityInfoRsp.Builder proto = GetActivityInfoRsp.newBuilder();
		
		for (int activityId : req.getActivityIdListList()) {
			ActivityInfo info = ActivityInfo.newBuilder()
				.setActivityId(activityId)
				.setScheduleId(activityId * 1000 + 1)
				.setIsFinished(false)
				.setBeginTime(	1653382919)
				.setEndTime(1656061319)
				.build();

			proto.addActivityInfoList(info);
		}

		this.setData(proto);
	}
}
