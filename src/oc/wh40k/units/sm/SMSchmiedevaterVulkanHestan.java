package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMSchmiedevaterVulkanHestan extends Eintrag {

	public SMSchmiedevaterVulkanHestan() {
		name = "Schmiedevater Vulkan He'stan";
		grundkosten = 190;

		add(ico = new oc.Picture("oc/wh40k/images/SMSchmiedevaterVulkanHestan.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
	}

}
