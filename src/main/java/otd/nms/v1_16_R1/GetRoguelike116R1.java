package otd.nms.v1_16_R1;

import forge_sandbox.greymerk.roguelike.worldgen.spawners.SpawnPotential;
import otd.config.WorldConfig;
import otd.nms.GetRoguelike;

public class GetRoguelike116R1 implements GetRoguelike {
	public Object get(int level, String type, Object otag, SpawnPotential sp) {
		net.minecraft.server.v1_16_R1.NBTTagCompound tag = (net.minecraft.server.v1_16_R1.NBTTagCompound) otag;
		tag.setString("id", type);

		if (!(WorldConfig.wc.rogueSpawners && sp.equip))
			return tag;

		net.minecraft.server.v1_16_R1.NBTTagList activeEffects = new net.minecraft.server.v1_16_R1.NBTTagList();
		tag.set("ActiveEffects", activeEffects);

		net.minecraft.server.v1_16_R1.NBTTagCompound buff = new net.minecraft.server.v1_16_R1.NBTTagCompound();
		activeEffects.add(buff);

		buff.setByte("Id", (byte) 4);
		buff.setByte("Amplifier", (byte) level);
		buff.setInt("Duration", 10);
		buff.setByte("Ambient", (byte) 0);

		return tag;
	}
}
