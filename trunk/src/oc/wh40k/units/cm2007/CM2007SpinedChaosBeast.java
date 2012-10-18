package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CM2007SpinedChaosBeast extends Eintrag {

	public CM2007SpinedChaosBeast() {
		name = "Spined Chaos Beast";
		grundkosten = 140;

		add(ico = new oc.Picture("oc/wh40k/images/SpinedChaosBeast.gif"));
		

                ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 10));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 15));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 20));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
