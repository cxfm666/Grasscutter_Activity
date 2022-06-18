package emu.grasscutter.server.packet.send;

import java.util.ArrayList;
import java.util.Map;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ActivityScheduleInfoNotifyOuterClass.ActivityScheduleInfoNotify;
import emu.grasscutter.net.proto.ActivityScheduleInfoOuterClass.ActivityScheduleInfo;

public class PacketActivityScheduleInfoNotify extends BasePacket {
	
	public PacketActivityScheduleInfoNotify() {
		super(PacketOpcodes.ActivityScheduleInfoNotify);
		
		var infos = new ArrayList<ActivityScheduleInfo>();
		for (int i = 5000; i < 5100; i++) {
			ActivityScheduleInfo info = ActivityScheduleInfo.newBuilder()
				.setActivityId(i)
				.setIsOpen(true)
				.setScheduleId(i * 1000 + 1)
				.setBeginTime(	1653382919)
				.setEndTime(1656061319)
				.build();

			infos.add(info);
		}

		ActivityScheduleInfoNotify proto = ActivityScheduleInfoNotify.newBuilder()
				.addAllActivityScheduleList(infos)
				.build();
		
		this.setData(proto);
	}
}
