package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;

public class ELKuanorJagdtitan extends Eintrag {

	public ELKuanorJagdtitan() {
		name = "Kuanor-Jagdtitan";
		grundkosten = 800;


		add(ico = new oc.Picture("oc/wh40k/images/KuanorJagdtitan.gif"));
		

		complete();

	}

	public void refreshen() {
	}
}
