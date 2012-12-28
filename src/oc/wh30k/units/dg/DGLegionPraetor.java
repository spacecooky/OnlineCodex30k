package oc.wh30k.units.dg;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DGLegionPraetor extends Eintrag {

	RuestkammerStarter Waffen;

	public DGLegionPraetor() {
		name = "Legion Praetor";
		grundkosten = 100;

		BuildaHQ.addToInformationVector("DGPraetor", 1);

		seperator();

		Waffen = new RuestkammerStarter(ID, randAbstand, cnt, "DGPraetorKammer", "");
		Waffen.initKammer();
		Waffen.setButtonText(BuildaHQ.translate("Weapons & Equipment"));
		add(Waffen);
		Waffen.setAbwaehlbar(false);
		
		
		complete();
	}

	@Override
	public void deleteYourself() {
		
		BuildaHQ.addToInformationVector("DGPraetor", -1);
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
		
	}

}
