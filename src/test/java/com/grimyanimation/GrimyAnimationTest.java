package com.grimyanimation;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class GrimyAnimationTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(GrimyAnimation.class);
		RuneLite.main(args);
	}
}