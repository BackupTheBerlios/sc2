package net.vasterling.sc2.util;

import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;

public final class Resources {

	public static final Image getImage(Device device, String name) {
		return new Image(device, Resources.class.getClassLoader().getResourceAsStream("icon.png"));
	}
}
