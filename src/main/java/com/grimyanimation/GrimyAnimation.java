package com.grimyanimation;

import lombok.extern.slf4j.Slf4j;

import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import java.util.Arrays;

@Slf4j
@PluginDescriptor(
		name = "grimy animation",
		description = "adds animation to cleaning grimy herbs, inspired by Vial Smasher plugin"
)
public class GrimyAnimation extends Plugin
{
	//code inspired by "vial smasher" plugin
	private static final int GRIMY_ANIMATION = 889;
	private static final String [] GRIMY_MESSAGE =
			{       "You clean the Grimy avantoe.",
					"You clean the Grimy guam leaf.",
					"You clean the Grimy marrentill.",
					"You clean the Grimy tarromin.",
					"You clean the Grimy harralander.",
					"You clean the Grimy ranarr weed.",
					"You clean the Grimy toadflax.",
					"You clean the Grimy irit leaf.",
					"You clean the Grimy kwuarm.",
					"You clean the Grimy snapdragon.",
					"You clean the Grimy cadantine.",
					"You clean the Grimy lantadyme.",
					"You clean the Grimy dwarf weed.",
					"You clean the Grimy torstol.",
			};

	private Boolean doAnimation = false;

	@Inject
	private Client client;

	@Override
	protected void startUp()
	{
	}

	@Override
	protected void shutDown()
	{
	}

	@Subscribe
	private void onChatMessage(final ChatMessage event)
	{
		if (event.getType() != ChatMessageType.SPAM)
		{
			return;
		}

		final String message = event.getMessage();


		if (!(Arrays.asList(GRIMY_MESSAGE).contains(message)))
		{
			return;
		}

		doAnimation = true;
	}

	@Subscribe
	public void onClientTick(ClientTick e)
	{
		if (doAnimation)
		{
			Player local = client.getLocalPlayer();
			local.setAnimation(GRIMY_ANIMATION);
			local.setAnimationFrame(0);
			doAnimation = false;
		}
	}
}
