package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetActivityInfoReqOuterClass.GetActivityInfoReq;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetActivityInfoRsp;

@Opcodes(PacketOpcodes.GetActivityInfoReq)
public class HandlerGetActivityInfoReq extends PacketHandler {
	@Override
	public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
		GetActivityInfoReq req = GetActivityInfoReq.parseFrom(payload);

		session.send(new PacketGetActivityInfoRsp(req));
	}
}
